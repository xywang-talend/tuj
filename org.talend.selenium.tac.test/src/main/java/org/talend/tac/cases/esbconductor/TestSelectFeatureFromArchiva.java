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

package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.SelectFeatureFromArchivaImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * 
 */
public class TestSelectFeatureFromArchiva extends WebdriverLogin {
	
	SelectFeatureFromArchivaImpl selectFeatureFromArchivaImpl;
    @BeforeMethod
    public void beforeMethod(){
    	selectFeatureFromArchivaImpl = new SelectFeatureFromArchivaImpl(driver);
    }
    
    @Test
    @Parameters({
        "labelOfService", "desOfService", "repository", "group", "artifact", "version", "name"
    })
    public void testSelectFeature(String label, String des, String repository, String group, String artifact,
                                  String version, String name) {
    	selectFeatureFromArchivaImpl.selectFeatureNormally(label, des, repository, group, artifact, version, name);
    }

}
