package org.talend.designer.publish.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.talend.designer.publish.core.SaveAction;
import org.talend.designer.publish.core.models.BundleModel;
import org.talend.designer.publish.core.models.FeaturesModel;
import org.talend.repository.services.service.IGeneratorService;
import org.talend.repository.services.ui.scriptmanager.ServiceExportManager;

public class FeatureGenerateService implements IGeneratorService {

	public String generateFeature(String serviceName, String serviceVersion,
			String groupId, Map<String, String> bundles,
			ServiceExportManager serviceManager) throws IOException {
		FeaturesModel feature = new FeaturesModel(groupId, serviceName,
				serviceVersion);
		for (Map.Entry<String, String> entry : bundles.entrySet()) {
			File jarFile = new File(entry.getValue());
			BundleModel model = new BundleModel(jarFile, groupId,
					entry.getKey(), serviceVersion);
			feature.addSubBundle(model);
		}
		String artefactName = serviceName + "-feature";
		File filePath = serviceManager.getFilePath(groupId, artefactName,
				serviceVersion);
		String fileName = artefactName + "-" + serviceVersion + "-feature.xml";
		String featureFilePath = new File(filePath, fileName).getAbsolutePath();
		SaveAction.saveFeature(featureFilePath, feature);
		return featureFilePath;
	}
}
