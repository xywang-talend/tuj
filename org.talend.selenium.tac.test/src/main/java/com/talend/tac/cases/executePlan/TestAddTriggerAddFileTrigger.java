package com.talend.tac.cases.executePlan;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;

public class TestAddTriggerAddFileTrigger extends Plan {
	
	Hashtable properties = new Hashtable();
	
	@Test
	
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.exist.label",
			"plan.filetrigger.exist.forderpath",
			"plan.filetrigger.exist.timeinterval",
			"plan.filetrigger.exist.filemask", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerExist(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		
		AntAction antAction = new AntAction();
		properties.put("file.path", foldpath+"/testFiletrigger.txt");
		antAction.runTarget("File.xml", "create", properties);
		
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);	
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 0);
		triggerExistCheck(filetriggerlabel);
	}
	
	@Test
	
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.exist.label",
			"plan.filetrigger.exist.forderpathFalse",
			"plan.filetrigger.exist.timeinterval",
			"plan.filetrigger.exist.filemask", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerExistFalse(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		filetriggerlabel = filetriggerlabel + "false";
		//*****************************************
		if(this.waitForTextPresent("Running...",15)){
			selenium.mouseDown("//span[text()='" + plantoaddfiletrigger + "']");
			this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
		}
		this.runPlan(plantoaddfiletrigger);
		this.waitForTextPresent("[RUNNING]", MAX_WAIT_TIME);	
//		this.waitForElementPresent("//span[text()='Running...']", WAIT_TIME);
		this.sleep(10000);
		this.waitForElementPresent("//span[text()='Ready to run']",
				MAX_WAIT_TIME);
		//******************************************
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 0);
//		triggerExistCheck(filetriggerlabel);
			triggerCheckFalse(filetriggerlabel);
	}
	
	@Test
	
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.exist.label",
			"plan.filetrigger.exist.forderpath",
			"plan.filetrigger.exist.timeinterval",
			"plan.filetrigger.exist.filemask", "plan.filetrigger.server" })
	public void testDuplicateFileTrigger(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);	
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 0);
		 selenium.refresh();
	        this.waitForElementPresent("//span[text()='" + plantoaddfiletrigger + "']",
					WAIT_TIME);
	        this.sleep(3000);
			selenium.mouseDown("//span[text()='" + plantoaddfiletrigger + "']");
	        this.waitForElementPresent("//span[text()='" + filetriggerlabel + "']",
					WAIT_TIME);
	        this.sleep(3000);
	        selenium.mouseDown("//span[text()='" + filetriggerlabel + "']");
	        this.sleep(3000);
	        selenium.click("idTriggerDuplicate");
	        this.sleep(2000);
	        selenium.click("idFileTriggerSave");
			this.waitForElementPresent("//span[text()='Copy_of_" + filetriggerlabel + "']",
					WAIT_TIME);
			this.deleteTrigger("Copy_of_" + filetriggerlabel);
			this.deleteTrigger(filetriggerlabel);
		
	}

	@Test
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.create.label",
			"plan.filetrigger.create.forderpath",
			"plan.filetrigger.create.timeinterval",
			"plan.filetrigger.create.filemask", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerCreate(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 1);
//		System.out.println("THE FIRST TIME:");	
//		this.waitForElementPresent("//span[text()='Running...']",
//				Base.MAX_WAIT_TIME);
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and contains(text(),'[OK]')]", Base.MAX_WAIT_TIME);
//		System.out.println("THE FIRST TIME ENDED:");
		File file =new FileTrigger().createNewFile(foldpath);
		if (file!=null) {
			System.out.println("fiLE CREATED!");
		} else {
			System.out.println("fiLE CREATED  failed!");
		}
		triggerCreateCheck(filetriggerlabel);
		file.delete();

	}
	
	@Test
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.create.label",
			"plan.filetrigger.create.forderpath",
			"plan.filetrigger.create.timeinterval", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerCreateFalse(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		filetriggerlabel = filetriggerlabel + "false";
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, "*.cvs", serverName, 1);
//		System.out.println("THE FIRST TIME:");	
//		this.waitForElementPresent("//span[text()='Running...']",
//				Base.MAX_WAIT_TIME);
		
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and contains(text(),': [OK]')]", MAX_WAIT_TIME);
//		Assert.assertTrue(this.waitElement("//span[text()='Ended...']",
//				TriggerCheckTime)||this.waitElement("//span[text()='Ready to run']",
//						TriggerCheckTime), "test failed! ");
		
		triggerCheckFalse(filetriggerlabel);	
	}

	@Test
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.modify.label",
			"plan.filetrigger.modify.forderpath",
			"plan.filetrigger.modify.timeinterval",
			"plan.filetrigger.modify.filemask", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerModify(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 2);
		selenium.mouseDown("//span[text()='" + plantoaddfiletrigger + "']");
		Thread.sleep(2000);
		selenium.click("idJobConductorTaskRunButton");
		this.waitForElementPresent("//span[text()='Running...']",
				Base.WAIT_TIME);
		this.waitForElementPresent("//span[text()='Ready to run']",
				Base.MAX_WAIT_TIME);
		
		//modify a file exist
		if(new FileTrigger().modifyFile(foldpath, mask.substring((mask.indexOf(".")) + 1))){
		//check the file trigger modify 
			System.out.println("file modified!");
		triggerCreateCheck(filetriggerlabel);
		}
		else{
			System.out.println("file modified failed!");
		}
        
	}
	
	@Test
	@Parameters({ "plan.toaddfiletrigger.label",
			"plan.filetrigger.modify.label",
			"plan.filetrigger.modify.forderpath",
			"plan.filetrigger.modify.timeinterval",	
			"plan.filetrigger.modify.filemask", "plan.filetrigger.server" })
	public void testAddTriggerAddFileTriggerModifyFalse(String plantoaddfiletrigger,
			String filetriggerlabel, String foldpath, String interval,
			String mask, String serverName) throws InterruptedException {
		foldpath = this.getAbsolutePath(foldpath);
		this.clickWaitForElementPresent("!!!menu.executionPlan.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Execution Plan']",
				WAIT_TIME);
		Assert.assertTrue(selenium
				.isElementPresent("//div[@class='header-title' and text()='Execution Plan']"));
		filetriggerlabel = filetriggerlabel + "false";
		//*****************************************
		this.runPlan(plantoaddfiletrigger);
		this.waitForElementPresent("//span[text()='Running...']", WAIT_TIME);
		this.sleep(10000);
		this.waitForElementPresent("//span[text()='Ready to run']",
				MAX_WAIT_TIME);
		//******************************************	
		
		addFileTrigger(plantoaddfiletrigger, filetriggerlabel, foldpath,
				interval, mask, serverName, 2);
		triggerCheckFalse(filetriggerlabel);
		
        
	}

	public void addFileTrigger(String planLabel, String fileTriggerLabel,
			String filePath, String seconds, String fileMarks,
			String serverName, int triggerType) throws InterruptedException {
		String checkboxid = null;
		if (triggerType == 0) {
			checkboxid = "idJobConductorFileTriggerFtExitCheckBox";
		}
		if (triggerType == 1) {
			checkboxid = "idJobConductorFileTriggerFtCreateCheckBox";
		}
		if (triggerType == 2) {
			checkboxid = "idJobConductorFileTriggerFtModifiedCheckBox";
		}
		this.waitForElementPresent("//span[text()='" + planLabel + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + planLabel + "']");
		selenium.click("//button[text()='Add trigger...']");// add a trigger
		selenium.click("//a[text()='Add file trigger']");// add a SimpleTrigger
		this.typeString("idJobConductorFileTriggerLabelInput", fileTriggerLabel);
		this.typeString("idJobConductorFileTriggerCheckTimeIntervalInput",
				seconds);
		this.typeString("idJobConductorFileTriggerFolderPathInput", filePath);
		this.typeString("idJobConductorFileTriggerFileMaskInput", fileMarks);
		inputCheckBoxChecked(checkboxid);
		this.selectDropDownList("idJobConductorFileTriggerFileServerListBox",
				serverName);
		selenium.click("idFileTriggerSave");
		this.waitForElementPresent("//span[text()='" + fileTriggerLabel + "']",
				WAIT_TIME);
		
	}

	public void triggerCreateCheck(String fileTriggerLabel) {
//		this.waitForElementPresent("//span[text()='Running...']",
//				Base.MAX_WAIT_TIME);
		this.waitForElementPresent("[RUNNING]", MAX_WAIT_TIME);
		
//		this.waitForElementPresent("//span[@class='x-tree3-node-text' and contains(text(),'[OK]')]",
//				Base.MAX_WAIT_TIME);
	
		selenium.mouseDown("//span[text()='" + fileTriggerLabel + "']");
		selenium.chooseOkOnNextConfirmation();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("idTriggerDelete");
		selenium.getConfirmation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='" + fileTriggerLabel
						+ "']"), "trigger delete failed!");
		Assert.assertTrue(this.waitElement("//span[text()='Ended...']",
				TriggerCheckTime)||this.waitElement("//span[text()='Ready to run']",
						TriggerCheckTime), "test failed! ");
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
	}

	public void triggerExistCheck(String fileTriggerLabel) {
		this.waitForElementPresent("[RUNNING]", MAX_WAIT_TIME);
		
//		this.waitForElementPresent("//span[text()='Running...']",
//				Base.MAX_WAIT_TIME);
//		this.waitForElementPresent("//span[text()='Ended...']", Base.MAX_WAIT_TIME);
		selenium.mouseDown("//span[text()='" + fileTriggerLabel + "']");
		selenium.chooseOkOnNextConfirmation();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("idTriggerDelete");
		selenium.getConfirmation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='" + fileTriggerLabel
						+ "']"), "trigger delete failed!");
		this.waitForElementPresent("[OK]", MAX_WAIT_TIME);
	}
	
	public void triggerCheckFalse(String filetriggerlabel){
		Assert.assertFalse(this.waitForTextPresent("[RUNNING]",TriggerCheckTime),"testAddTriggerAddFileTriggerExistFalse failed!");
		selenium.mouseDown("//span[text()='" + filetriggerlabel + "']");
		selenium.chooseOkOnNextConfirmation();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("idTriggerDelete");
		selenium.getConfirmation();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(
				selenium.isElementPresent("//span[text()='" + filetriggerlabel
						+ "']"), "trigger delete failed!");
		
	}

	public void inputCheckBoxChecked(String xpathinputBox) {
		if (!selenium.getValue(xpathinputBox).equals("on")) {
			selenium.click(xpathinputBox);
		}
	}

	public void inputCheckBoxUncheck(String xpathinputBox) {
		if (selenium.getValue(xpathinputBox).equals("on")) {
			selenium.click(xpathinputBox);
		}
	}

	class FileTrigger {
		public File createNewFile(String path) {
			boolean createSuccess = false;
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
			String s = df.format(date);// system date
			String filename = s.replaceAll(":", "-").replaceAll(" ", "-");
			filename = filename + ".txt";
			File newFile = new File(path, filename);
			if ((new File(path)).isDirectory()) {
				if (newFile.exists()) {
					System.out.println("file already exist!");
				} else {
					try {
						newFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else {
				System.out.println("the path is not a directory!");
			}
			if (newFile.exists()) {
				createSuccess = true;
			}

			
				return newFile;
			
		
		}

		public boolean modifyFile(String path, String extensionStr) {
			boolean modifySuccess = true;
			ExtensionFileFilter fileter = new ExtensionFileFilter(extensionStr);
			File newFile = new File(path);
//			for (int i = 0; i < newFile.listFiles(fileter).length; i++) {
//				System.out.println(newFile.listFiles(fileter)[i]);
//			}
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
			String s = df.format(date);// system date
			FileWriter fw;
			try {
				fw = new FileWriter(newFile.listFiles(fileter)[0],true);
				fw.write("testModify:"+s);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("file modified failed!");
				modifySuccess = false;
			}
			
			return modifySuccess;
		}
	}

	class ExtensionFileFilter implements FileFilter {
		private String extension;

		public ExtensionFileFilter(String extension) {
			this.extension = extension;
		}

		public boolean accept(File file) {
			if (file.isDirectory()) {
				return false;
			}
			String name = file.getName();
			// find the last
			int index = name.lastIndexOf(".");
			if (index == -1) {
				return false;
			} else if (index == name.length() - 1) {
				return false;
			} else {
				return this.extension.equals(name.substring((index + 1)));
			}

		}
	}

}
