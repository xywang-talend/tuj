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

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.junit.Assert;

/**
 * 
 */
public class TestSelectFeatureFromArchiva extends ESBConductorUtils {

    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository", "group", "artifact", "version", "name"
    })
    public void testSelectFeature(String label, String des, String repository, String group, String artifact,
                                  String version, String name) {
        this.testSelectFeatureFromServer(label, des, repository, group, artifact, version, name);
        Assert.assertTrue(selenium.getValue("//input[@name='repositoryName']").equals(repository));
        Assert.assertTrue(selenium.getValue("//input[@id='idESBConductorTaskFeatureUrlInput']")
            .equals("mvn:org.example/" + name + "/0.1.0/xml"));
        Assert.assertTrue(selenium.getValue("//input[@id='idTaskProjectListBox']").equals(name));
        Assert.assertTrue(selenium.getValue("//input[@id='idESBConductorTaskVersionInput']").equals(version));
    }

    @Test
    @Parameters({
        "labelOfService", "desOfService", "warning_Num"
    })
    public void uncheckRepositoryFromArchiva(String label, String des, int error_Num) {
        this.testSelectFeatureWithUncheckRepository(label, des);
        this.waitForCheckInputStatus("//img[@class='gwt-Image x-component ']", error_Num);

    }

    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository", "name"
    })
    public void uncheckGroupFromArchiva(String label, String des, String repository, String name) {
        this.testSelectFeatureWithUncheckGroup(label, des, repository, name);
        Assert.assertTrue(selenium.getValue("//input[@name='repositoryName']").equals(repository));
        Assert.assertTrue(selenium.getValue("//input[@id='idESBConductorTaskFeatureUrlInput']")
            .equals("mvn:null/null/null/xml"));
        this.waitForTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage"), WAIT_TIME);
        Assert
            .assertTrue(selenium.isTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage")));
    }

    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository", "group", "name"
    })
    public void uncheckArtifactFromArchiva(String label, String des, String repository, String group,
                                           String name) {
        this.testSelectFeatureWithUncheckArtifact(label, des, repository, group, name);
        this.waitForTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage"), WAIT_TIME);
        Assert
            .assertTrue(selenium.isTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage")));
    }

    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository", "group", "artifact", "name"
    })
    public void uncheckVersionFromArchiva(String label, String des, String repository, String group,
                                          String artifact, String name) {
        this.testSelectFeatureWithUncheckVersion(label, des, repository, group, artifact, name);
        this.waitForTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage"), WAIT_TIME);
        Assert
            .assertTrue(selenium.isTextPresent(other.getString("ESBConductor.SelectorFeature.ErrorMessage")));
    }
}
