package com.talend.tac.cases.projects;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;

public class TestModification extends Projects {

	@Test
	public void testIsModifyenable() {
		
		this.openMenuProject();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label']", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue((!selenium.isEditable("idLabelInput")), "idLableInput is editable!");
		selenium.setSpeed(MIN_SPEED);
		
	}
}
