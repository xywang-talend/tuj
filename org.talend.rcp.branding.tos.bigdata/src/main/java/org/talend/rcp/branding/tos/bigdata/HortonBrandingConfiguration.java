// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.rcp.branding.tos.bigdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.ui.PlatformUI;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.ui.branding.DefaultBrandingConfiguration;
import org.talend.core.ui.branding.IBrandingConfiguration;
import org.talend.repository.model.IRepositoryNode;
import org.talend.repository.model.IRepositoryNode.ENodeType;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC hwang class global comment. Detailled comment
 */
public class HortonBrandingConfiguration extends DefaultBrandingConfiguration {

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IActionBarHelper#fillMenuBar(org.eclipse.jface.action.IMenuManager)
     */
    public void fillMenuBar(IMenuManager menuBar) {
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IActionBarHelper#fillCoolBar(org.eclipse.jface.action.ICoolBarManager)
     */
    public void fillCoolBar(ICoolBarManager coolBar) {
        coolBar.removeAll();
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#getAvailableComponents()
     */
    public String[] getAvailableComponents() {
        return null;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#getAvailableLanguages()
     */
    public String[] getAvailableLanguages() {
        return new String[] { ECodeLanguage.JAVA.getName() };
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#getJobEditorSettings()
     */
    public Map<String, Object> getJobEditorSettings() {
        return new HashMap<String, Object>();
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#isUseMailLoginCheck()
     */
    public boolean isUseMailLoginCheck() {
        return true;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#isUseProductRegistration()
     */
    public boolean isUseProductRegistration() {
        return true;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#isAllowDebugMode()
     */
    public boolean isAllowDebugMode() {
        return true;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#isUseDemoProjects()
     */
    public boolean isUseDemoProjects() {
        return false;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#getAdditionalTitle()
     */
    public String getAdditionalTitle() {
        return "";
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#setAdditionalTitle(java.lang.String)
     */
    public void setAdditionalTitle(String title) {

    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#getInitialWindowPerspectiveId()
     */
    public String getInitialWindowPerspectiveId() {
        PreferenceManager pm = PlatformUI.getWorkbench().getPreferenceManager();
        pm.find("org.talend.core.prefs").remove("org.talend.repository.prefs.documentation");
        pm.find("org.talend.core.prefs").findSubNode("org.talend.designer.core.ui.preferences.SpecificSettingPreferencePage")
                .remove("org.talend.sqlbuilder.ui.prefs.sqlbuilder");
        pm.find("org.talend.core.prefs").remove("org.talend.designer.core.ui.preferences.PerformancePreferencePage");
        return IBrandingConfiguration.PERSPECTIVE_DI_ID;
    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#setUseMailLoginCheck(boolean)
     */
    public void setUseMailLoginCheck(boolean useMainLoginCheck) {

    }

    /*
     * (non-Jsdoc)
     * 
     * @see org.talend.core.ui.branding.IBrandingConfiguration#setUseProductRegistration(boolean)
     */
    public void setUseProductRegistration(boolean useProductRegistration) {

    }

    @Override
    public List<IRepositoryNode> getHiddenRepositoryCategory(IRepositoryNode nodeParent, String type) {
        RepositoryNode parent = (RepositoryNode) nodeParent;

        List<IRepositoryNode> nodes = super.getHiddenRepositoryCategory(parent, type);

        RepositoryNode businessProcessNode = new RepositoryNode(null, parent, ENodeType.SYSTEM_FOLDER);
        businessProcessNode.setProperties(EProperties.LABEL, ERepositoryObjectType.BUSINESS_PROCESS);
        businessProcessNode.setProperties(EProperties.CONTENT_TYPE, ERepositoryObjectType.BUSINESS_PROCESS);
        nodes.add(businessProcessNode);

        RepositoryNode docNode = new RepositoryNode(null, parent, ENodeType.SYSTEM_FOLDER);
        docNode.setProperties(EProperties.LABEL, ERepositoryObjectType.DOCUMENTATION);
        docNode.setProperties(EProperties.CONTENT_TYPE, ERepositoryObjectType.DOCUMENTATION);
        nodes.add(docNode);

        RepositoryNode metadataNode = new RepositoryNode(null, parent, ENodeType.SYSTEM_FOLDER);
        metadataNode.setProperties(EProperties.LABEL, ERepositoryObjectType.METADATA);
        metadataNode.setProperties(EProperties.CONTENT_TYPE, ERepositoryObjectType.METADATA);
        nodes.add(metadataNode);

        return nodes;
    }

}
