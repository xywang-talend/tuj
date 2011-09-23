package org.talend.designer.publish.core.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class FeaturesModel extends UploadableModel {

	private Set<FeaturesModel> subFeatures = new HashSet<FeaturesModel>();

	private Set<BundleModel> subBundles = new HashSet<BundleModel>();

	private static String nameSuffix = "-feature";

	public FeaturesModel(String groupId, String namePrefix, String version) {
		this(groupId, namePrefix, version, null, null, null);
	}			
	
	public FeaturesModel(String groupId, String namePrefix, String version,
			String repositoryURL, String userName, String password) {
		super(groupId, namePrefix + nameSuffix, version, repositoryURL,
				userName, password);
	}

	@Override
	public void upload() throws Exception {
		uploadFeature();
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
		PomModel pomModel = new PomModel(groupId, artifactId, version, "pom",
				repositoryURL, userName, password);
		for (BundleModel bm : subBundles) {
			DependencyModel dm = new DependencyModel(bm.getGroupId(),
					bm.getArtifactId(), bm.getVersion());
			pomModel.addDenpendency(dm);
		}
		for (FeaturesModel fm : subFeatures) {
			DependencyModel dm = new DependencyModel(fm.getGroupId(),
					fm.getArtifactId(), fm.getVersion(), "pom");
			pomModel.addDenpendency(dm);
		}
		pomModel.upload();
	}

	private void uploadFeature() throws MalformedURLException, IOException {
		// upload feature part
		String artifactPath = getArtifactDestination();
		String versionPath = artifactPath + version + "/";
		String fileName = artifactId + "-" + version + ".xml";
		String filePath = versionPath + fileName;
		URL featureURL = new URL(filePath);
		String featureContent = getFeatureContent();
		uploadContent(featureURL, featureContent);

		// upload md5 and sha1
		uploadMd5AndSha1(filePath, fileName, featureContent);
	}

	public void addSubFeature(FeaturesModel model) {
		if (!subFeatures.contains(model)) {
			subFeatures.add(model);
		}
	}

	public void addSubBundle(BundleModel model) {
		if (!subBundles.contains(model)) {
			subBundles.add(model);
		}
	}

	private String toFeatureString(FeaturesModel model) {
		StringBuilder sb = new StringBuilder();
		sb.append("<feature version='");
		sb.append(model.getVersion());
		sb.append("\'>");
		sb.append(model.getArtifactId());
		sb.append("</feature>");
		return sb.toString();
	}

	private String toBundleString(BundleModel model) {
		StringBuilder sb = new StringBuilder();
		sb.append("<bundle>mvn:");
		sb.append(model.getGroupId());
		sb.append("/");
		sb.append(model.getArtifactId());
		sb.append("/");
		sb.append(model.getVersion());
		sb.append("</bundle>");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<features>\n");
		sb.append("\t<feature name=\"");
		sb.append(artifactId);
		sb.append("\" version=\"");
		sb.append(version);
		sb.append("\">\n");

		for (FeaturesModel s : subFeatures) {
			sb.append("\t\t");
			sb.append(toFeatureString(s));
			sb.append("\n");
		}
		for (BundleModel s : subBundles) {
			sb.append("\t\t");
			sb.append(toBundleString(s));
			sb.append("\n");
		}
		sb.append("\t</feature>\n");
		sb.append("</features>");

		return sb.toString();
	}

	public String getFeatureContent() {
		return toString();
	}

	// public static void main(String[] args) {
	// FeaturesModel featuresModel = new FeaturesModel(
	// "CustomService-feature", "1.0.0");
	// featuresModel.addSubBundle("talend", "job-control-bundle", "1.0");
	// featuresModel.addSubBundle("talend", "ProviderJob", "1.0");
	// featuresModel.addSubBundle("talend", "ESBProvider2", "1.0");
	// featuresModel.addSubFeature("5.0-SNAPSHOT", "talend-job-controller");
	// System.out.println(featuresModel);
	// }

}
