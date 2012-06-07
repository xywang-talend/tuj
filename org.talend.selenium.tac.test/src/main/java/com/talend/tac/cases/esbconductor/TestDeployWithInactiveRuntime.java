/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 */
public class TestDeployWithInactiveRuntime extends ESBConductorUtils {

    @Test
    @Parameters({
        "labelOfServiceWithInactiveServer", "desOfService", "repository", "group", "artifact", "version",
        "name", "type", "context", "InactiveServerOfRuntime"
    })
    public void testDeployConductorWithInactiveRuntime(String label, String des, String repository,
                                                       String group, String artifact, String version,
                                                       String name, String type, String context, String server) {
        String deployId = "idESBConductorTaskGridDeployButton";
        String status = "Ready to deploy";
        String promptInfo = "Error: deployment of feature '"
                            + name
                            + "' might have failed: JobServer is inactive -- For more information see your log file.";

        this.addESBConductor(label, des, repository, group, artifact, version, name, type,
                                               context, server);
        selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='" + label + "']"));
        selenium.setSpeed(MIN_SPEED);
        this.deployStartConductor(label, name, promptInfo, deployId, status);
    }

}
