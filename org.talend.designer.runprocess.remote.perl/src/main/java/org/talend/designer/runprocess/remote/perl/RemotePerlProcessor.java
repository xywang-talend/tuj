// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.runprocess.remote.perl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ITargetExecutionConfig;
import org.talend.core.model.properties.Property;
import org.talend.core.ui.ICommandlineClientService;
import org.talend.designer.core.perl.runprocess.PerlProcessor;
import org.talend.designer.runprocess.IProcessMessageManager;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.remote.RemoteProcessorHelper;
import org.talend.designer.runprocess.remote.ui.RemoteManager;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id: talend-code-templates.xml 1 2006-09-29 17:06:40Z nrousseau $
 * 
 */
public class RemotePerlProcessor extends PerlProcessor {

    RemoteManager manager = RemoteManager.getInstance();

    /**
     * DOC amaumont RemotePerlProcessor constructor comment.
     * 
     * @param process
     * @param filenameFromLabel
     */
    public RemotePerlProcessor(IProcess process, Property property, boolean filenameFromLabel) {
        super(process, property, filenameFromLabel);
    }

    public Process run(int statisticsPort, int tracePort, String watchParam, IProgressMonitor monitor,
            IProcessMessageManager processMessageManager) throws ProcessorException {
        ITargetExecutionConfig jobserverConfig = manager.getTargetExecutionconfigureation();
        if (jobserverConfig.isRemote()) {
            ICommandlineClientService cmdLineService = getCommandlineClientService();
            if (cmdLineService != null && jobserverConfig.getCommandlineServerConfig() != null) {
                Process p = cmdLineService.deployAndRunByCommandline(jobserverConfig, getProcess()
                        .getName(), getProcess().getVersion(), this.getContext().getName(), statisticsPort, tracePort,
                        watchParam, true);
                if (p != null) {
                    return p;
                }
            }

            RemoteProcessorHelper remoteProcessorHelper = new RemoteProcessorHelper();
            return remoteProcessorHelper.run(this, statisticsPort, tracePort, watchParam, monitor, processMessageManager);
        } else {
            return super.run(statisticsPort, tracePort, watchParam, monitor, processMessageManager);
        }
    }

    private ICommandlineClientService getCommandlineClientService() {
        ICommandlineClientService cmdLineServic = null;
        try {
            cmdLineServic = (ICommandlineClientService) GlobalServiceRegister.getDefault().getService(
                    ICommandlineClientService.class);
        } catch (RuntimeException e) {
            // nothing to do
        }
        return cmdLineServic;
    }
}
