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

package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.RedefineContext;

/**
 * 
 */
public class RedefineContextImpl extends RedefineContext {
       public RedefineContextImpl(WebDriver driver) {
           super(driver);
           this.driver = driver;
       }
       
       public void redefineContext(String label, String des, String repository,
               String group, String artifact, String version, String name, String type, 
               String context, String server,String variableName,String variableValue) {
           this.intoESBConductorPage();
           this.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server); 
           this.defineContext(label,variableName,variableValue);         
       }
       
       public void deployConductor(String label,String name) {
    	   this.deployEsbConductor(label, name);   
       }
       
       public void deleteContextProperties(String label) {
    	   this.intoESBConductorPage();
    	   this.deleteContextPropertiesOk(label);
       }
       
       public void deleteContextPropertiesCancel(String label) {
    	   this.deleteContextPropertyCancel(label);
       }
       
       public void undeployConductor(String label) {
    	   this.undeployEsbConductorOk(label);
       }
       
       public void deleteUndeployedConductor(String label,String name) {
    	   this.deleteUndeployedConductorOk(label, name);
       }
       
       public void resetContextParameters(String label, String des, String repository,
               String group, String artifact, String version, String name, String type, 
               String context, String server,String variableName,String variableValue) {
    	   this.intoESBConductorPage();
    	   this.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server);
    	   this.defineContext(label, variableName, variableValue);
    	   this.resetContextPara(label);
       }
       
       public void controlDisplayMenu(String label) {
    	   this.intoESBConductorPage();
    	   this.controlDisplay(label);
       }
       
       public void intoEsbpage() {
    	   this.intoESBConductorPage();
       }
       
       public void addContextParas(String label,String variableName,String variableValue) {
    	   this.defineContext(label, variableName, variableValue);
       }
       
       public void addContextParasForSort(String label,String variableName,String variableValue) {
    	   this.defineContextForSort(label, variableName, variableValue);
       }
       
       public void sortConetextParas(String value,String value1) {
    	   this.SortAscendingSortDescendingOfContextPara(value, value1);
       }

}
