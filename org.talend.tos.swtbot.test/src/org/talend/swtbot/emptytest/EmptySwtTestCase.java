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
package org.talend.swtbot.emptytest;

import org.junit.Test;
import org.talend.swtbot.TalendSwtBotForTos;

/**
 * Empty test, do nothing.<br>
 * This test is needed only for junits, then we can wait for the end of the jet emitters before really start the JUnits.
 */
public class EmptySwtTestCase extends TalendSwtBotForTos {

    @Test
    public void emptyTest() {
        // do nothing
    }
}
