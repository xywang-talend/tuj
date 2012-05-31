// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend 閿燂拷锟�www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later
// version.
//
// This library is distributed in the hope that it will be
// useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty
// of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public
// License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.swtbot;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.matchers.AbstractMatcher;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.model.process.INode;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.properties.tab.TalendTabbedPropertyList;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.designer.core.ui.editor.connections.ConnLabelEditPart;
import org.talend.designer.core.ui.editor.connections.ConnectionLabel;
import org.talend.designer.core.ui.editor.nodes.NodePart;

/**
 * DOC sgandon class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40Z nrousseau $
 * 
 */
public class TalendSwtBotForTos {

    /**
     * 
     */
    private static final String GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS = "Generation Engine Initialization in progress..."; //$NON-NLS-1$

    private static final long ONE_MINUTE_IN_MILLISEC = 60000;

    static public SWTGefBot gefBot = new SWTGefBot();

    protected static boolean isGenerationEngineInitialised = false;

    private static String buildTitle;

    private static String buildType;

    public static List<ERepositoryObjectType> repositories = new ArrayList<ERepositoryObjectType>();

    public static Map<ERepositoryObjectType, List<String>> repositoriesFolders = new Hashtable<ERepositoryObjectType, List<String>>();

    static IWorkspace workspace = ResourcesPlugin.getWorkspace();

    static IProject project = workspace.getRoot().getProject("TEST_NOLOGIN");

    /**
     * wait for the Generation engine to be intialised, and this is done only once during the lifetime of the
     * application.
     */
    @BeforeClass
    public static void before() {
        if (!isGenerationEngineInitialised) {
            try {
                gefBot.waitUntil(Conditions.shellIsActive(GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS), ONE_MINUTE_IN_MILLISEC);
                SWTBotShell shell = gefBot.shell(GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS);
                gefBot.waitUntil(Conditions.shellCloses(shell), ONE_MINUTE_IN_MILLISEC * 10);
            } catch (TimeoutException te) {
                System.out.println("timeout execption when waiting for " + GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS
                        + " shell, we never the less continue hoing it has been closed on purpose.");
            }
            isGenerationEngineInitialised = true;
            gefBot.viewByTitle("Welcome").close();
            gefBot.perspectiveByLabel("Integration").activate();
            try {
                gefBot.cTabItem("Cheat Sheets").close();
            } catch (WidgetNotFoundException wnfe) {
                // ignor this exception, this means there is not Cheat Sheet
            }
            buildTitle = gefBot.activeShell().getText().split("\\(")[0].trim();
            setBuildType(buildTitle);
        }
    }

    /**
     * return the first talend component EditPart (NodePart) that relates to the label componentLabel for a given
     * editor.
     * 
     * @param gefEditor the editor to look in for the component
     * @param componentLabel the displayed label of the component
     * @return the component found with the given label or null if none found
     */
    public SWTBotGefEditPart getTalendComponentPart(SWTBotGefEditor gefEditor, final String componentLabel) {
        List<SWTBotGefEditPart> editParts = gefEditor.editParts(new AbstractMatcher<EditPart>() {

            protected boolean doMatch(Object item) {
                boolean result = false;
                if (item instanceof NodePart) {
                    // get the parent and look for one children of type NodeLabelEditPart that has a figure named
                    // componentName
                    EditPart np = (EditPart) item;
                    INode node = (INode) np.getModel();
                    result = componentLabel.equals(node.getLabel());
                } else if (item instanceof ConnLabelEditPart) {
                    // get the parent and look for one children of type NodeLabelEditPart that has a figure named
                    // componentName
                    EditPart np = (EditPart) item;
                    ConnectionLabel cl = (ConnectionLabel) np.getModel();
                    result = componentLabel.equals(cl.getLabelText());
                }// else return default result that is false
                return result;
            }

            public void describeTo(Description description) {
                description.appendText("NodePart with NodeLabelEditPart figure named (").appendText(componentLabel)
                        .appendText(")");
            }
        });
        return editParts.size() > 0 ? editParts.get(0) : null;
    }

    /**
     * look for all the widget of type TalendTabbedPropertyList and select the tab at index for all of them
     * 
     * @param index index of the tab to select in aTalendTabbedPropertyList TalendTabbedPropertyList(values start from
     * 0)
     */
    public void selecteAllTalendTabbedPropertyListIndex(final int index) {
        // look for all the widgets of type TalendTabbedPropertyList
        final List<TalendTabbedPropertyList> controls = gefBot.getFinder().findControls(
                new BaseMatcher<TalendTabbedPropertyList>() {

                    // @Override
                    public boolean matches(Object item) {
                        if (item instanceof TalendTabbedPropertyList) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                    // @Override
                    public void describeTo(Description description) {
                        description.appendText("looking for widget of type TalendTabbedPropertyList");
                    }
                });

        // select the desired tab in the UI thread
        UIThreadRunnable.syncExec(new VoidResult() {

            // @Override
            public void run() {
                for (TalendTabbedPropertyList ttpl : controls) {
                    ttpl.select(index);
                }
            }
        });
    }

    @AfterClass
    public static void after() throws PersistenceException, CoreException {
        gefBot.closeAllShells();
        gefBot.saveAllEditors();
        gefBot.closeAllEditors();

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRunnable operation = new IWorkspaceRunnable() {

            public void run(IProgressMonitor monitor) {
                for (ERepositoryObjectType epot : repositories) {
                    System.out.println("ERepositoryObjectType :" + epot.getAlias() + ", " + epot.getType());
                    final ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
                    List<IRepositoryViewObject> ivos = null;
                    try {
                        ivos = factory.getAll(epot);
                    } catch (PersistenceException e1) {
                        e1.printStackTrace();
                    }
                    if (ivos != null) {
                        for (final IRepositoryViewObject ivo : ivos) {
                            if (ivo.getPath().contains("system"))
                                continue;
                            try {
                                factory.deleteObjectPhysical(ivo);
                            } catch (PersistenceException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        workspace.run(operation, workspace.getRoot(), IWorkspace.AVOID_UPDATE, new NullProgressMonitor());

        IWorkspaceRunnable cleanup = new IWorkspaceRunnable() {

            public void run(IProgressMonitor monitor) {
                Iterator<ERepositoryObjectType> it = repositoriesFolders.keySet().iterator();
                List<String> folderPaths;
                while (it.hasNext()) {
                    ERepositoryObjectType key = it.next();
                    folderPaths = repositoriesFolders.get(key);
                    for (String path : folderPaths) {
                        IFolder folder = project.getFolder(key.getFolder() + "/" + path);
                        if (folder.exists()) {
                            try {
                                folder.delete(true, false, null);
                            } catch (CoreException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                try {
                    project.refreshLocal(IResource.DEPTH_INFINITE, null);
                } catch (CoreException e) {
                    e.printStackTrace();
                }
            }
        };
        workspace.run(cleanup, null);

        Utilities.getRepositoryView().toolbarPushButton("refresh").click();
        Utilities.emptyRecycleBin();
        gefBot.resetActivePerspective();

        repositories.clear();
        repositoriesFolders.clear();
    }

    /**
     * Get the testing build title.
     * 
     * @return build title
     */
    public static String getBuildTitle() {
        return buildTitle;
    }

    public static String getBuildType() {
        return buildType;
    }

    public static void setBuildType(String buildTitle) {
        if ("Talend Platform Big Data edition".equals(buildTitle)) {
            buildType = "TIS";
            return;
        }
        if ("Talend Open Studio for Data Integration".equals(buildTitle)) {
            buildType = "TOSDI";
            return;
        }
        if ("Talend Open Studio for Big Data".equals(buildTitle)) {
            buildType = "TOSBD";
            return;
        }
        buildType = "TIS";
    }

}
