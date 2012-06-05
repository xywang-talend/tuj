package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.SamInformation;

public class SamInformationImpl extends SamInformation{
    public SamInformationImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkSamInfo(String karafURL, String providerName, String consumerName) {
        this.installServiceAndConsumer(karafURL, providerName, consumerName);
        this.intoSamPage();
        this.locatorEvents();
    }
}
