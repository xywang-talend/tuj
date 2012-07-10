package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.OccurrencesImpl;
import org.talend.mdm.impl.RecordImplProduct;
import org.talend.mdm.impl.ThirdEntityImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRecordThirdEntity extends Login {
	ThirdEntityImpl thirdentity;
	@BeforeMethod
	public void beforeMethod(){
		thirdentity = new ThirdEntityImpl(driver);	
		logger.warn("Set Before Info");
	}
	

	
	@Test
	@Parameters( { "container","modle","entity","key","name","mandatoryDetails.mandatory1","mandatoryDetails.optional2","mandatoryDetails.optionalUbounded3"
		,"mandatoryDetails.mandatoryUbounded4","mandatoryDetails.optional5.mandatory51","mandatoryDetails.optional5.optional51","mandatoryDetails.optionalUbounded6.mandatory61","mandatoryDetails.optionalUbounded6.optional62"
		,"optionalDetails.mandatory1","optionalDetails.optional2","optionalDetails.optionalUbounded3","optionalDetails.mandatoryUbounded4","optionalDetails.optional5.mandatory51"
		,"optionalDetails.optional5.optional51","optionalDetails.optionalUbounded6.mandatory61","optionalDetails.optionalUbounded6.optional62"})
	public void testCreateThirdEntityRecordSuccess(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62) {
		thirdentity.createThirdEntityRecordSuccessImpl(container, modle, entity, key, name, mdM1, mdO2, mdOu3
				, mdMu4, mdO5m51, mdO5o51, mdOu6m61, mdOu6o62
				, odM1, odO2, odOu3, odMu4, odO5m51, odO5o51, odOu6m61, odOu6o62);
		}
	
	@Test
	@Parameters( { "container","modle","entity","key","name","mandatoryDetails.mandatory1","mandatoryDetails.optional2","mandatoryDetails.optionalUbounded3"
		,"mandatoryDetails.mandatoryUbounded4","mandatoryDetails.optional5.mandatory51","mandatoryDetails.optional5.optional51","mandatoryDetails.optionalUbounded6.mandatory61","mandatoryDetails.optionalUbounded6.optional62"
		,"optionalDetails.mandatory1","optionalDetails.optional2","optionalDetails.optionalUbounded3","optionalDetails.mandatoryUbounded4","optionalDetails.optional5.mandatory51"
		,"optionalDetails.optional5.optional51","optionalDetails.optionalUbounded6.mandatory61","optionalDetails.optionalUbounded6.optional62"})
	public void testCreateThirdEntityRecordSuccessWithMutipleOccurrences(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62) {
		thirdentity.createThirdEntityRecordSuccessWithMutipleOccurrencesImpl(container, modle, entity, key, name, mdM1, mdO2, mdOu3
				, mdMu4, mdO5m51, mdO5o51, mdOu6m61, mdOu6o62
				, odM1, odO2, odOu3, odMu4, odO5m51, odO5o51, odOu6m61, odOu6o62);
		}
	
	
	@Test
	@Parameters( { "container","modle","entity","key","name","mandatoryDetails.mandatory1","mandatoryDetails.optional2","mandatoryDetails.optionalUbounded3"
		,"mandatoryDetails.mandatoryUbounded4","mandatoryDetails.optional5.mandatory51","mandatoryDetails.optional5.optional51","mandatoryDetails.optionalUbounded6.mandatory61","mandatoryDetails.optionalUbounded6.optional62"
		,"optionalDetails.mandatory1","optionalDetails.optional2","optionalDetails.optionalUbounded3","optionalDetails.mandatoryUbounded4","optionalDetails.optional5.mandatory51"
		,"optionalDetails.optional5.optional51","optionalDetails.optionalUbounded6.mandatory61","optionalDetails.optionalUbounded6.optional62"})
	public void testCreateThirdEntityRecordFailed(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62) {
		thirdentity.createThirdEntityRecordFailedImpl(container, modle, entity, key, name, mdM1, mdO2, mdOu3
				, mdMu4, mdO5m51, mdO5o51, mdOu6m61, mdOu6o62
				, odM1, odO2, odOu3, odMu4, odO5m51, odO5o51, odOu6m61, odOu6o62);
		}
	
	@Test
	@Parameters( { "container","modle","entity","key","name","mandatoryDetails.mandatory1","mandatoryDetails.optional2","mandatoryDetails.optionalUbounded3"
		,"mandatoryDetails.mandatoryUbounded4","mandatoryDetails.optional5.mandatory51","mandatoryDetails.optional5.optional51","mandatoryDetails.optionalUbounded6.mandatory61","mandatoryDetails.optionalUbounded6.optional62"
		,"optionalDetails.mandatory1","optionalDetails.optional2","optionalDetails.optionalUbounded3","optionalDetails.mandatoryUbounded4","optionalDetails.optional5.mandatory51"
		,"optionalDetails.optional5.optional51","optionalDetails.optionalUbounded6.mandatory61","optionalDetails.optionalUbounded6.optional62"})
	public void testUpdateThirdEntityRecordSuccessWithMutipleOccurrences(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62) {
		thirdentity.updateThirdEntityRecordSuccessWithMutipleOccurrencesImpl(container, modle, entity, key, name, mdM1, mdO2, mdOu3
				, mdMu4, mdO5m51, mdO5o51, mdOu6m61, mdOu6o62
				, odM1, odO2, odOu3, odMu4, odO5m51, odO5o51, odOu6m61, odOu6o62);
		}
	
	@Test
	@Parameters( { "container","modle","entity","key","name","mandatoryDetails.mandatory1","mandatoryDetails.optional2","mandatoryDetails.optionalUbounded3"
		,"mandatoryDetails.mandatoryUbounded4","mandatoryDetails.optional5.mandatory51","mandatoryDetails.optional5.optional51","mandatoryDetails.optionalUbounded6.mandatory61","mandatoryDetails.optionalUbounded6.optional62"
		,"optionalDetails.mandatory1","optionalDetails.optional2","optionalDetails.optionalUbounded3","optionalDetails.mandatoryUbounded4","optionalDetails.optional5.mandatory51"
		,"optionalDetails.optional5.optional51","optionalDetails.optionalUbounded6.mandatory61","optionalDetails.optionalUbounded6.optional62"})
	public void testUpdateThirdEntityRecordSuccessWithMutipleOccurrencesExist(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62) {
		thirdentity.updateThirdEntityRecordSuccessWithMutipleOccurrencesAddImpl(container, modle, entity, key, name, mdM1, mdO2, mdOu3
				, mdMu4, mdO5m51, mdO5o51, mdOu6m61, mdOu6o62
				, odM1, odO2, odOu3, odMu4, odO5m51, odO5o51, odOu6m61, odOu6o62);
		}
}
