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

import org.talend.core.model.process.IProcess;
import org.talend.core.model.properties.Property;
import org.talend.core.service.IRemoteRunprocessorService;
import org.talend.designer.runprocess.IProcessor;

/**
 * DOC guanglong.du class global comment. Detailled comment
 */
public class RemoteRunprocessorService implements IRemoteRunprocessorService {

    /*
     * (non-Jsdoc)
     * 
     * @see
     * org.talend.core.service.IRemoteRunprocessorService#createRemotePerlProcessor(org.talend.core.model.process.IProcess
     * , org.talend.core.model.properties.Property, boolean)
     */
    public IProcessor createRemotePerlProcessor(IProcess process, Property property, boolean filenameFromLabel) {
        // TODO Auto-generated method stub
        return new RemotePerlProcessor(process, property, true);
    }

}
