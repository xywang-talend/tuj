package org.talend.designer.publish.core.models;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BundleModel extends UploadableModel {

	private File jarFile;

//	private Set<DependencyModel> dependencies = new HashSet<DependencyModel>();
	
	public BundleModel(File jarFile, String groupId, String artifactId,
			String version, String repositoryURL, String userName,
			String password) {
		super(groupId, artifactId, version, repositoryURL, userName, password);
		this.jarFile = jarFile;
	}

	public BundleModel(File jarFile, String groupId, String artifactId,
			String version) {
		this(jarFile, groupId, artifactId, version, null, null, null);
	}

	@Override
	public void upload() throws Exception {
		uploadBundle();
		uploadPom();
		uploadMetadata();
	}

	private void uploadMetadata() throws Exception {
		MetadataModel metadataModel = new MetadataModel(groupId, artifactId,
				version, repositoryURL, userName, password);
		metadataModel.addVersion(version);
		metadataModel.upload();
	}

	private void uploadPom() throws IOException {
		// upload pom part
		PomModel pomModel = new PomModel(groupId, artifactId, version, "bundle",
				repositoryURL, userName, password);
//		if(dependencies.size()>0){
//			for(DependencyModel dm:dependencies){
//				pomModel.addDenpendency(dm);
//			}
//		}
		pomModel.upload();
	}

	private void uploadBundle() throws IOException {
		String artifactPath = getArtifactDestination();
		String versionPath = artifactPath + version + "/";
		// upload jar file
		String fileName = computeBundleName(artifactId, version);
		String filePath = versionPath + fileName;
		URL bundleUrl = new URL(filePath);
		uploadContent(bundleUrl, jarFile);

		// upload md5 and sha1
		uploadMd5AndSha1(filePath, fileName, jarFile);
	}

//	public void addDependency(DependencyModel dm) {
//		if (dm == null) {
//			return;
//		}
//		if (!dependencies.contains(dm)) {
//			dependencies.add(dm);
//		}
//	}
//
//	public void addAllDependencies(Set<DependencyModel> dependencyModels) {
//		if (dependencyModels == null) {
//			return;
//		}
//		dependencies.addAll(dependencyModels);
//	}
	
	private String computeBundleName(String artifactId, String version)
			throws MalformedURLException {
		StringBuilder sb = new StringBuilder();
		sb.append(artifactId);
		sb.append("-");
		sb.append(version);
		sb.append(".jar");
		return sb.toString();
	}
}
