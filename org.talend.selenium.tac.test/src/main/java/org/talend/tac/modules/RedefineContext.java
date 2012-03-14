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

package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.tac.base.WebDriverBase;

/**
 * 
 */
public class RedefineContext extends WebDriverBase {
       public RedefineContext(WebDriver driver) {
           super.setDriver(driver);
           this.driver = driver;
       }
       
       public void intoESBConductorPage() {
           this.getElementById("!!!menu.esbconductor.element!!!").click();
           this.waitforTextDisplayed("ESB CONDUCTOR", this.WAIT_TIME_MAX);
       }
       
       public void addESBConductor(String label, String des, String repository,
                                   String group, String artifact, String version, String name, String type, 
                                   String context, String server) {
           this.getElementById("idESBConductorTaskGridAddButton").click();
        /*   this.isElementPresent(By.xpath(""), timeout)
           this.w*/
       }
}
