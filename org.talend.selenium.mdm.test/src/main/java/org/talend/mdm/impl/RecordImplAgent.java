package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplAgent extends Record{
	 String OperationType,key,source;
	
	 boolean result;
  
	public RecordImplAgent(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
    
	
	public void selectAgentRecordBySearch(String entity,String fieldName,String agentID){
		this.searchCondition("Identifier", "is equal to", agentID);
		this.chooseRcord(entity, fieldName, agentID);
	}

	public void deleteRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		this.sleepCertainTime(3000);
		chooseRcord(entity,Identifie,IdentifieValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,IdentifieValue,OperationType,source);
	    JournalResultCount();
	}
public void createRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue ) {
	String[] parametersFirstname={entity,Firstname};
	String[] parametersLastname={entity,Lastname};
	String[] parametersID={entity,Identifie};
	String[] parametersStartDate={entity,StartDate};
	String[] IdAssert={Identifie,IdentifieValue};
    String[] FirstnameAssert={Firstname,FirstnameValue};
    String[] LastnameAssert={Lastname,LastnameValue};
    String[] CommissionCodeAssert={CommissionCode,CommissionCodeValue};
    String[] StartDateAssert={StartDate,StartDateValue};
    OperationType="CREATE";
    source="genericUI";
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);				
	this.sleepCertainTime(3000);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 				
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersID), IdentifieValue);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFirstname), FirstnameValue);	
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersLastname), LastnameValue);
	this.clickElementByXpath("//input[@name='Agent/CommissionCode']//following-sibling::img");
	this.clickElementByXpath(this.getString(locator, "xpath.record.click.CommissionCode", CommissionCodeValue));
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersStartDate), StartDateValue);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
	chooseRcord(entity,Identifie,IdentifieValue);
	this.sleepCertainTime(3000);
	openJournal(entity,IdentifieValue,OperationType,source);
    this.sleepCertainTime(5000);
    JournalCheckResult(IdentifieValue,OperationType);
	this.sleepCertainTime(5000); 
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",IdAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",FirstnameAssert)), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",LastnameAssert)), WAIT_TIME_MIN));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",CommissionCodeAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",StartDateAssert)), WAIT_TIME_MIN));	
}

public void DuplicateRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String IdentifieValueDup,String Firstname,String FirstnameValue) {
	String[] parametersIDclose={entity,IdentifieValue};	
	String[] parametersFirstname={entity,Firstname};
	String[] parametersID={entity,Identifie};
	String[] IdAssert={Identifie,IdentifieValueDup};
    String[] FirstnameAssert={Firstname,FirstnameValue};
    OperationType="CREATE";
    source="genericUI";
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
	chooseRcord(entity,Identifie,IdentifieValue);	
	this.sleepCertainTime(3000);	
	this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));	
	this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersIDclose));
	this.sleepCertainTime(3000);
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersID)), IdentifieValueDup);
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFirstname)), FirstnameValue);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	//this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
	this.sleepCertainTime(5000); 
	chooseRcord(entity,Identifie,IdentifieValueDup);
	this.sleepCertainTime(3000);
	openJournal(entity,IdentifieValueDup,OperationType,source);
    this.sleepCertainTime(5000);
    JournalCheckResult(IdentifieValueDup,OperationType);
	this.sleepCertainTime(5000); 
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",IdAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",FirstnameAssert)), WAIT_TIME_MIN));

}


public void UpdateRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String CommissionCode,String CommissionCodeValue,String CommissionCodeValueUpdate) {
	String[] CommissionCodeAssert={CommissionCode,CommissionCodeValue};
    String[] CommissionCodeUpdateAssert={CommissionCode,CommissionCodeValueUpdate};
    OperationType="UPDATE";	
	source="genericUI";	
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);			
	this.sleepCertainTime(3000);
	this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
	chooseRcord(entity,Identifie,IdentifieValue);	
	this.sleepCertainTime(3000);
	//update the CommissionCodeValue
	this.clickElementByXpath("//input[@name='Agent/CommissionCode']//following-sibling::img");
	this.clickElementByXpath(this.getString(locator, "xpath.record.click.CommissionCode", CommissionCodeValueUpdate));
	this.sleepCertainTime(3000);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
	openJournal(entity,IdentifieValue,OperationType,source);
	this.sleepCertainTime(5000); 
	JournalCheckResult(IdentifieValue,OperationType);
	this.sleepCertainTime(5000); 
	//assert the old and new value
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",CommissionCodeAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",CommissionCodeUpdateAssert )), WAIT_TIME_MIN));
}


public void createRecordWrongRuleImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue ) {
	String[] parametersFirstname={entity,Firstname};
	String[] parametersLastname={entity,Lastname};
	String[] parametersID={entity,Identifie};
	String[] parametersStartDate={entity,StartDate};
    OperationType="CREATE";
    source="genericUI";
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);				
	this.sleepCertainTime(3000);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 				
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersID), IdentifieValue);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFirstname), FirstnameValue);	
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersLastname), LastnameValue);
	this.clickElementByXpath("//input[@name='Agent/CommissionCode']//following-sibling::img");
	this.clickElementByXpath(this.getString(locator, "xpath.record.click.CommissionCode", CommissionCodeValue));
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersStartDate), StartDateValue);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	if (this.isElementPresent(By.xpath("//span[contains(text(),'Unable to save item Agent., validation rule')]"), WAIT_TIME_MIN))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}

public void changeCommissionCodeApprovedWorkflow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String Identifie,String agentID,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue){
	LogonImpl log = new LogonImpl(this.driver);
	log.logout();
	log.loginUserForce(userFrank, frankPass);
	String[] parametersID={entity,Identifie};
	chooseContainer(container);	
	chooseModle(model);
	clickSave();
	chooseEntity(entity);
	this.sleepCertainTime(3000);
	this.maxDataBrowserBoard();
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.sleepCertainTime(3000);
	
	//verify that frank can not modify agent properties directly
	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.commissioncode.input")).isEnabled(), "frank can not modify commission code test failed!");
	
	//get the initial agent properties.commissionCode
	String initialCode = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input")));
	String initialStatus = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input")));
	logger.info("for agent :"+agentID+"The initial commission code is:"+initialCode+",the initial status is:"+initialStatus);
	this.maxARecordPanel();
	
	//open journal to verify number of action entry for frank ,and update entry for administrator ,then close journal
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int beforeProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
	int beforeProcessUpdateAdministrator = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("beforeProcess action entry for frank is:"+beforeProcess);
	logger.info("beforeProcess update entry for administrator is:"+beforeProcessUpdateAdministrator);
	this.closeJournal();
	
	//frank launch com code change request process
	this.launchProcess("Com Change Request");
	this.checkProcessDoneAndClickOK();
	this.sleepCertainTime(3000);
	
	//click the refresh button ,and check status change to pending
	this.clickElementByXpath(locator.getString("xpath.record.panel.refresh.button"));
	Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.agent.comchange.processdone.clickrefresh.conform.info")), WAIT_TIME_MIN).isDisplayed());
	this.clickElementByXpath(locator.getString("xpath.record.agent.comchange.processdone.clickrefresh.conform.yes.button"));
	this.sleepCertainTime(5000);
	String statusBeforeSubmitAfterProcess = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input"))).trim();
	logger.info("after process done ,status expected is pending, infact it is :"+statusBeforeSubmitAfterProcess);
	Assert.assertFalse(initialStatus.equals(statusBeforeSubmitAfterProcess));
	Assert.assertTrue(statusBeforeSubmitAfterProcess.equals("pending"));
	
	//open journal and verify number of action entry for frank +1, update entry for administrator +1 ,then close journal
    this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int afterProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
	int afterProcessUpdateAdministrator = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("afterProcess action entry for frank is :"+afterProcess);
	logger.info("afterProcess update entry for administrator is :"+afterProcessUpdateAdministrator);
	Assert.assertTrue(afterProcess-beforeProcess==1);
	Assert.assertTrue(afterProcessUpdateAdministrator-beforeProcessUpdateAdministrator==1);
	
	//check action entry in data changes viewer for frank
	 OperationType="ACTION";
	 source="genericUI";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, initialCode, true);
	this.closeDatachangesViewer();
	
	//check update ectry in data changes viewer for administrator
	 OperationType="UPDATE";
	 source="workflow";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("Status", initialStatus, statusBeforeSubmitAfterProcess, false);
	this.closeDatachangesViewer();
	this.closeJournal();
	
	//for frank ,open workflow created and change the commission code ,then submit
	WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
	flow.openMenuGoven();
	flow.openMenuWorkFlowTask();
	this.sleepCertainTime(5000);
	flow.sortWorkFlowTaskBydate();
    flow.openAWorkTask();
	this.sleepCertainTime(10000);
	
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.firstname.input")).isEnabled(), "frank can not modify first name in opened task test failed!");
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.lastname.input")).isEnabled(), "frank can not modify last name in opened task test failed!");
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.identifer.input")).isEnabled(), "frank can not modify identifer in opened task test failed!");
	String codeSubmitted = flow.changeAgentCommissionCodeValidImpl(Integer.parseInt(initialCode), 2);
	this.sleepCertainTime(10000);
	
	//close data browser first,to check status and commission code is not changed 
	this.closeDataBrowser();
	flow.uncheckHideFinishedTask();
	flow.clickSearch();
	flow.sortWorkFlowTaskBydate();
	flow.openAWorkTask();
	flow.openRelatedRecord();
	
	this.sleepCertainTime(5000);
	Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input"))).equals(initialCode), "test frank can not change commission code directly failed");
    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input"))).trim().equals("pending"));
	flow.closeRelatedAgentRecord();
	
	//reopen data browser from welcome page
	this.switchtoTabWelcome();
	this.openDataBrowserFromWelcome();
	this.sleepCertainTime(5000);
	this.switchtoTabDataBrowser();
	this.chooseEntityDirectlyInDataBrowser(entity);
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.maxARecordPanel();
	this.openJournalFromDataBrowser();
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, initialCode, true);
	
	//logout frank ,login jennifer
	log.logout();
	log.loginUserForce( userJennifer, jenniferPass);
	chooseContainer(container);	
	chooseModle(model);
	clickSave();
	this.chooseEntity(entity);
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int beforeApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("beforeApprove ,the update entry for administrator is :"+beforeApprove);
	this.closeJournal();
	//open work flow task page
	flow.openMenuGoven();
	flow.openMenuWorkFlowTask();
	this.sleepCertainTime(10000);
	//sort work flow task by date and open the first work
	flow.sortWorkFlowTaskBydate();
    flow.openAWorkTask();
    
    
    //jennifer approved and submit
    flow.approveCommissionCodeChange("yes");
    flow.clickSubmit();
 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
	this.sleepCertainTime(5000);
	
	flow.uncheckHideFinishedTask();
	flow.clickSearch();
	flow.sortWorkFlowTaskBydate();
	this.sleepCertainTime(3000);
	flow.openAWorkTask();
	this.sleepCertainTime(10000);
	flow.openRelatedRecord();
	this.sleepCertainTime(10000);
    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflowtask.agent.openrelatedrecord.open.closeTab")), WAIT_TIME_MIN)!=null);
  
    //verify commission code is really changed.
    //close the data browser first ,for xpath duplicated
    this.closeDataBrowser();
    this.sleepCertainTime(3000);
	String codeApproved = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input")));
    logger.info("afterapproved ,the commission code is:"+codeApproved);
//    Assert.assertTrue(price.equals(priceSubmited));
    Assert.assertTrue(codeApproved.equals(codeSubmitted));
    Assert.assertFalse(codeApproved.equals(initialCode));
    
    //reopen data browser
    this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Home']");
    this.clickElementByXpath("//div[contains(@id,'menu-browserecords')]");
    this.chooseEntity(entity);
    this.sleepCertainTime(5000);
   
    //close the record opened
    flow.closeRelatedAgentRecord();

	//close the work task
	flow.closeAWorkTask();
	
	//verify in journal that an update entry for jennifer added
	this.switchtoTabDataBrowser();
	this.sleepCertainTime(3000);
	this.maxDataBrowserBoard();
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.sleepCertainTime(5000)	;
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int afterApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("afterApprove,the update entry for administrator is :"+afterApprove);
	Assert.assertTrue(afterApprove-beforeApprove==1);
		
	 OperationType="UPDATE";
	 source="workflow";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, codeSubmitted, false);
	this.checkPropertiesBeforeAfterInDatachangesViewer("Status", statusBeforeSubmitAfterProcess, initialStatus, false);
	//close datachangesviewer page.
	this.closeDatachangesViewer();
	this.closeJournal();
	}


public void changeCommissionCodeNotApprovedWorkflow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String Identifie,String agentID,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue){
	LogonImpl log = new LogonImpl(this.driver);
	log.logout();
	log.loginUserForce(userFrank, frankPass);
	String[] parametersID={entity,Identifie};
	chooseContainer(container);	
	chooseModle(model);
	clickSave();
	chooseEntity(entity);
	this.sleepCertainTime(3000);
	this.maxDataBrowserBoard();
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.sleepCertainTime(3000);
	
	//verify that frank can not modify agent properties directly
	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.commissioncode.input")).isEnabled(), "frank can not modify commission code test failed!");
	
	//get the initial agent properties.commissionCode
	String initialCode = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input")));
	String initialStatus = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input")));
	logger.info("for agent :"+agentID+"The initial commission code is:"+initialCode+",the initial status is:"+initialStatus);
	this.maxARecordPanel();
	
	//open journal to verify number of action entry for frank ,and update entry for administrator ,then close journal
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int beforeProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
	int beforeProcessUpdateAdministrator = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("beforeProcess action entry for frank is:"+beforeProcess);
	logger.info("beforeProcess update entry for administrator is:"+beforeProcessUpdateAdministrator);
	this.closeJournal();
	
	//frank launch com code change request process
	this.launchProcess("Com Change Request");
	this.checkProcessDoneAndClickOK();
	this.sleepCertainTime(3000);
	
	//click the refresh button ,and check status change to pending
	this.clickElementByXpath(locator.getString("xpath.record.panel.refresh.button"));
	Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.agent.comchange.processdone.clickrefresh.conform.info")), WAIT_TIME_MIN).isDisplayed());
	this.clickElementByXpath(locator.getString("xpath.record.agent.comchange.processdone.clickrefresh.conform.yes.button"));
	this.sleepCertainTime(5000);
	String statusBeforeSubmitAfterProcess = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input"))).trim();
	logger.info("after process done ,status expected is pending, infact it is :"+statusBeforeSubmitAfterProcess);
	Assert.assertFalse(initialStatus.equals(statusBeforeSubmitAfterProcess));
	Assert.assertTrue(statusBeforeSubmitAfterProcess.equals("pending"));
	
	//open journal and verify number of action entry for frank +1, update entry for administrator +1 ,then close journal
    this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int afterProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
	int afterProcessUpdateAdministrator = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("afterProcess action entry for frank is :"+afterProcess);
	logger.info("afterProcess update entry for administrator is :"+afterProcessUpdateAdministrator);
	Assert.assertTrue(afterProcess-beforeProcess==1);
	Assert.assertTrue(afterProcessUpdateAdministrator-beforeProcessUpdateAdministrator==1);
	
	//check action entry in data changes viewer for frank
	 OperationType="ACTION";
	 source="genericUI";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, initialCode, true);
	this.closeDatachangesViewer();
	
	//check update ectry in data changes viewer for administrator
	 OperationType="UPDATE";
	 source="workflow";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("Status", initialStatus, statusBeforeSubmitAfterProcess, false);
	this.closeDatachangesViewer();
	this.closeJournal();
	
	//for frank ,open workflow created and change the commission code ,then submit
	WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
	flow.openMenuGoven();
	flow.openMenuWorkFlowTask();
	this.sleepCertainTime(5000);
	flow.sortWorkFlowTaskBydate();
    flow.openAWorkTask();
	this.sleepCertainTime(10000);
	
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.firstname.input")).isEnabled(), "frank can not modify first name in opened task test failed!");
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.lastname.input")).isEnabled(), "frank can not modify last name in opened task test failed!");
//	Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.record.agent.comchangeworkflow.taskopened.identifer.input")).isEnabled(), "frank can not modify identifer in opened task test failed!");
	String codeSubmitted = flow.changeAgentCommissionCodeValidImpl(Integer.parseInt(initialCode), 2);
	this.sleepCertainTime(10000);
	
	//close data browser first,to check status and commission code is not changed 
	this.closeDataBrowser();
	flow.uncheckHideFinishedTask();
	flow.clickSearch();
	flow.sortWorkFlowTaskBydate();
	flow.openAWorkTask();
	this.sleepCertainTime(10000);
	flow.openRelatedRecord();
	
	this.sleepCertainTime(5000);
	Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input"))).equals(initialCode), "test frank can not change commission code directly failed");
    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.record.agent.status.input"))).trim().equals("pending"));
	flow.closeRelatedAgentRecord();
	
	//reopen data browser from welcome page
	this.switchtoTabWelcome();
	this.openDataBrowserFromWelcome();
	this.sleepCertainTime(5000);
	this.switchtoTabDataBrowser();
	this.chooseEntityDirectlyInDataBrowser(entity);
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.maxARecordPanel();
	this.openJournalFromDataBrowser();
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, initialCode, true);
	
	//logout frank ,login jennifer
	log.logout();
	log.loginUserForce( userJennifer, jenniferPass);
	chooseContainer(container);	
	chooseModle(model);
	clickSave();
	this.chooseEntity(entity);
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int beforeApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("beforeApprove ,the update entry for administrator is :"+beforeApprove);
	this.closeJournal();
	//open work flow task page
	flow.openMenuGoven();
	flow.openMenuWorkFlowTask();
	this.sleepCertainTime(10000);
	//sort work flow task by date and open the first work
	flow.sortWorkFlowTaskBydate();
    flow.openAWorkTask();
    
    
    //jennifer not approved and submit
    flow.approveCommissionCodeChange("no");
    flow.clickSubmit();
 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
	this.sleepCertainTime(5000);
	
	flow.uncheckHideFinishedTask();
	flow.clickSearch();
	flow.sortWorkFlowTaskBydate();
	this.sleepCertainTime(3000);
	flow.openAWorkTask();
	this.sleepCertainTime(10000);
	flow.openRelatedRecord();
	this.sleepCertainTime(10000);
    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflowtask.agent.openrelatedrecord.open.closeTab")), WAIT_TIME_MIN)!=null);
  
    //verify commission code is really changed.
    //close the data browser first ,for xpath duplicated
    this.closeDataBrowser();
    this.sleepCertainTime(3000);
	String codeApproved = this.getValueInput(By.xpath(locator.getString("xpath.record.agent.commissioncode.input")));
    logger.info("afterapproved ,the commission code is:"+codeApproved);
//    Assert.assertTrue(price.equals(priceSubmited));
    Assert.assertTrue(codeApproved.equals(initialCode));
    Assert.assertFalse(codeApproved.equals(codeSubmitted));
    
    //reopen data browser
    this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Home']");
    this.clickElementByXpath("//div[contains(@id,'menu-browserecords')]");
    this.chooseEntity(entity);
    this.sleepCertainTime(5000);
   
    //close the record opened
    flow.closeRelatedAgentRecord();

	//close the work task
	flow.closeAWorkTask();
	
	//verify in journal that an update entry for jennifer added
	this.switchtoTabDataBrowser();
	this.sleepCertainTime(3000);
	this.maxDataBrowserBoard();
	this.selectAgentRecordBySearch(entity,Identifie,agentID);
	this.sleepCertainTime(5000)	;
	this.openJournalFromDataBrowser();
	this.sleepCertainTime(5000);
	int afterApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.administrator")).size();
	logger.info("afterApprove,the update entry for administrator is :"+afterApprove);
	Assert.assertTrue(afterApprove-beforeApprove==0);
		
	 OperationType="UPDATE";
	 source="workflow";
	this.JournalCheckResult(agentID, OperationType);
	this.checkPropertiesBeforeAfterInDatachangesViewer("CommissionCode", initialCode, initialCode, true);
	this.checkPropertiesBeforeAfterInDatachangesViewer("Status", statusBeforeSubmitAfterProcess, "rejected", false);
	//close datachangesviewer page.
	this.closeDatachangesViewer();
	this.closeJournal();
	}
}
