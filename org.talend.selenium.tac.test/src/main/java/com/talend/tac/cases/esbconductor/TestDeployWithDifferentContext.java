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

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 */
public class TestDeployWithDifferentContext extends ESBConductorUtils {
    @Test
    @Parameters({
        "labelOfServiceWithDifferentContext", "desOfService", "repositoryForContext", "group", "artifactForContext", "versionForContext",
        "featureName", "typeForContext", "addedContext", "serverOfRuntime", "contextVariableName", "contextVariableValue"
    })
    public void testDeployWithDefinedContext(String label, String des, String repository, String group,
                                             String artifact, String version, String name, String type,
                                             String context, String server, String VariableName,
                                             String VariableValue) throws InterruptedException {
        String deployId = "idESBConductorTaskGridDeployButton";
        String status = "Deployed and started";
        String promptInfo = "Feature '" + name + "' deployed.";
        this.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server);
        this.waitForElementPresent("//div[text()='" + label + "']", WAIT_TIME);
        selenium.mouseDown("//div[text()='" + label + "']");
        this.waitForElementPresent("//button[@id='idESBConductorPropertyAddButton']", WAIT_TIME);
        selenium.setSpeed("2000");
        selenium.click("idESBConductorPropertyAddButton");
        this.clickWaitForElementPresent(other.getString("ESBConductor.ConfigProperties.Name"));
        this.typeString("//span[text()='Name']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input", VariableName);
        selenium.click(other.getString("ESBConductor.ConfigProperties.Value"));
        this.typeString("//span[text()='Value']//ancestor::div[@class='x-grid3-header']//following-sibling::div//input", VariableValue);
       
        selenium.keyPressNative(""+KeyEvent.VK_ENTER);
        selenium.mouseDown(other.getString("ESBConductor.ConfigProperties.Value"));
        
        
        selenium.click("//button[@id='idESBConductorPropertySaveButton']");
        selenium.mouseDown("//div[text()='" + label + "']");
        selenium.click(deployId);
        this.waitForTextPresent(promptInfo, WAIT_TIME);
        selenium.setSpeed(MID_SPEED);
        selenium.click("idESBConductorTaskGridRefreshButton");
        selenium.setSpeed(MIN_SPEED);
        this.waitForElementPresent("//div[text()='" + label + "']"      
                                   + "//ancestor::table[@class='x-grid3-row-table']//span[text()='" + status
                                   + "']", WAIT_TIME);
        Assert.assertTrue(selenium
            .isElementPresent("//div[text()='" + label + "']"
                              + "//ancestor::table[@class='x-grid3-row-table']//span[text()='" + status
                              + "']"));

    }

}
