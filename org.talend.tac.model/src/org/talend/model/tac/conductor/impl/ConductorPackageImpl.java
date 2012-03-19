/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.model.tac.admin.AdminPackage;

import org.talend.model.tac.admin.impl.AdminPackageImpl;

import org.talend.model.tac.conductor.ConductorFactory;
import org.talend.model.tac.conductor.ConductorPackage;
import org.talend.model.tac.conductor.CronTalendTrigger;
import org.talend.model.tac.conductor.CronUITalendTrigger;
import org.talend.model.tac.conductor.ExecutionPlan;
import org.talend.model.tac.conductor.ExecutionPlanPart;
import org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm;
import org.talend.model.tac.conductor.ExecutionPlanPartJobPrm;
import org.talend.model.tac.conductor.ExecutionPlanPrm;
import org.talend.model.tac.conductor.ExecutionServer;
import org.talend.model.tac.conductor.ExecutionTask;
import org.talend.model.tac.conductor.ExecutionTaskCmdPrm;
import org.talend.model.tac.conductor.ExecutionTaskJobPrm;
import org.talend.model.tac.conductor.ExecutionTaskProperties;
import org.talend.model.tac.conductor.ExecutionTriggerable;
import org.talend.model.tac.conductor.ExecutionVirtualServer;
import org.talend.model.tac.conductor.FileTrigger;
import org.talend.model.tac.conductor.FileTriggerMask;
import org.talend.model.tac.conductor.PlanExecutionHistory;
import org.talend.model.tac.conductor.SimpleTalendTrigger;
import org.talend.model.tac.conductor.TalendTrigger;
import org.talend.model.tac.conductor.TaskExecutionHistory;

import org.talend.model.tac.soa.SoaPackage;

import org.talend.model.tac.soa.impl.SoaPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConductorPackageImpl extends EPackageImpl implements ConductorPackage {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionTriggerableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionPlanEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionPlanPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionPlanPrmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionPlanPartCmdPrmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionPlanPartJobPrmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionTaskPropertiesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionTaskCmdPrmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionTaskJobPrmEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass taskExecutionHistoryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass planExecutionHistoryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass talendTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cronTalendTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cronUITalendTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleTalendTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fileTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fileTriggerMaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executionVirtualServerEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.talend.model.tac.conductor.ConductorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ConductorPackageImpl() {
        super(eNS_URI, ConductorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ConductorPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ConductorPackage init() {
        if (isInited)
            return (ConductorPackage) EPackage.Registry.INSTANCE.getEPackage(ConductorPackage.eNS_URI);

        // Obtain or create and register package
        ConductorPackageImpl theConductorPackage = (ConductorPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConductorPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new ConductorPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        AdminPackageImpl theAdminPackage = (AdminPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(AdminPackage.eNS_URI) instanceof AdminPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(AdminPackage.eNS_URI) : AdminPackage.eINSTANCE);
        SoaPackageImpl theSoaPackage = (SoaPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SoaPackage.eNS_URI) instanceof SoaPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SoaPackage.eNS_URI) : SoaPackage.eINSTANCE);

        // Create package meta-data objects
        theConductorPackage.createPackageContents();
        theAdminPackage.createPackageContents();
        theSoaPackage.createPackageContents();

        // Initialize created meta-data
        theConductorPackage.initializePackageContents();
        theAdminPackage.initializePackageContents();
        theSoaPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theConductorPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ConductorPackage.eNS_URI, theConductorPackage);
        return theConductorPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionTriggerable() {
        return executionTriggerableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_Id() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTriggerable_Triggers() {
        return (EReference) executionTriggerableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_IdQuartzJob() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_Status() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_ErrorStatus() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_ConcurrentExecution() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_ProcessingState() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTriggerable_RequestId() {
        return (EAttribute) executionTriggerableEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionPlan() {
        return executionPlanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlan_Label() {
        return (EAttribute) executionPlanEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlan_ExecPlanParts() {
        return (EReference) executionPlanEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlan_ExecPlanPrms() {
        return (EReference) executionPlanEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlan_Description() {
        return (EAttribute) executionPlanEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionPlanPart() {
        return executionPlanPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_Id() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPart_Task() {
        return (EReference) executionPlanPartEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPart_ExecutionPlan() {
        return (EReference) executionPlanPartEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPart_Parent() {
        return (EReference) executionPlanPartEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_Type() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPart_JvmPrms() {
        return (EReference) executionPlanPartEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPart_ContextPrms() {
        return (EReference) executionPlanPartEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_Status() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_StartDate() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_EndDate() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_RequestId() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_UseParallel() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPart_MaxThreads() {
        return (EAttribute) executionPlanPartEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionPlanPrm() {
        return executionPlanPrmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPrm_Id() {
        return (EAttribute) executionPlanPrmEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPrm_ExecutionPlan() {
        return (EReference) executionPlanPrmEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPrm_Name() {
        return (EAttribute) executionPlanPrmEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPrm_Value() {
        return (EAttribute) executionPlanPrmEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionPlanPartCmdPrm() {
        return executionPlanPartCmdPrmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartCmdPrm_Id() {
        return (EAttribute) executionPlanPartCmdPrmEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPartCmdPrm_ExecutionPlanPart() {
        return (EReference) executionPlanPartCmdPrmEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartCmdPrm_Name() {
        return (EAttribute) executionPlanPartCmdPrmEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartCmdPrm_Value() {
        return (EAttribute) executionPlanPartCmdPrmEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionPlanPartJobPrm() {
        return executionPlanPartJobPrmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartJobPrm_Id() {
        return (EAttribute) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionPlanPartJobPrm_ExecutionPlanPart() {
        return (EReference) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartJobPrm_Override() {
        return (EAttribute) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartJobPrm_Name() {
        return (EAttribute) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartJobPrm_CustomValue() {
        return (EAttribute) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionPlanPartJobPrm_PartCustomValue() {
        return (EAttribute) executionPlanPartJobPrmEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionTask() {
        return executionTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_Label() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_Description() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_ExecutionServer() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_Project() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_Branch() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_Context() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_JobVersion() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_RegenerateJobOnChange() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_Active() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_LastScriptGenerationDate() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_GeneratedSvnRevision() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_IdRemoteJob() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_IdRemoteJobExecution() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ChecksumArchive() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_JobScriptArchiveFilename() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_LastRunDate() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_LastDeploymentDate() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_LastEndedRunDate() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_CmdPrms() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_EsbPropertiesPrms() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_JobPrms() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_JobId() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTask_VirtualServer() {
        return (EReference) executionTaskEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_MaxConcurrentExecutions() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_GeneratedProjectName() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_GeneratedJobName() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_GeneratedJobVersion() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ApplyContextToChildren() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ErrorStackTrace() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_LastTriggeringDate() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ExecStatisticsEnabled() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_AddStatisticsCodeEnabled() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_OwnerSchedulerInstanceId() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(32);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_OnUnknownStateJob() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(33);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_UseLatestVersion() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(34);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ApplicationType() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(35);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_RepositoryName() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(36);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_FeaturesFileUrl() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(37);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_FeatureName() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(38);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_FeatureVersion() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(39);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_ApplicationGroup() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(40);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_BundleName() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(41);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTask_PropertyId() {
        return (EAttribute) executionTaskEClass.getEStructuralFeatures().get(42);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionTaskProperties() {
        return executionTaskPropertiesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskProperties_Id() {
        return (EAttribute) executionTaskPropertiesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskProperties_Name() {
        return (EAttribute) executionTaskPropertiesEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskProperties_Value() {
        return (EAttribute) executionTaskPropertiesEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTaskProperties_ExecutionTask() {
        return (EReference) executionTaskPropertiesEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionTaskCmdPrm() {
        return executionTaskCmdPrmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskCmdPrm_Id() {
        return (EAttribute) executionTaskCmdPrmEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskCmdPrm_Active() {
        return (EAttribute) executionTaskCmdPrmEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskCmdPrm_Parameter() {
        return (EAttribute) executionTaskCmdPrmEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskCmdPrm_Description() {
        return (EAttribute) executionTaskCmdPrmEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTaskCmdPrm_ExecutionTask() {
        return (EReference) executionTaskCmdPrmEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionTaskJobPrm() {
        return executionTaskJobPrmEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_Id() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_Label() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_Override() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionTaskJobPrm_ExecutionTask() {
        return (EReference) executionTaskJobPrmEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_OriginalValue() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_DefaultValue() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionTaskJobPrm_ItemType() {
        return (EAttribute) executionTaskJobPrmEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTaskExecutionHistory() {
        return taskExecutionHistoryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_Id() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_BasicStatus() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_DetailedStatus() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TaskLabel() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TaskDescription() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ProjectName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TalendJobName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TalendJobId() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TalendJobVersion() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ContextName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_VirtualServerName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExecutionServerName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExecutionServerHost() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExecutionServerCmdPort() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExecutionServerFilePort() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExecutionServerMonitoringPort() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ApplyContextToChildren() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TriggeredBy() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TriggerType() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TriggerName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TriggerDescription() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TaskErrorStackTrace() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_IdQuartzJob() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_IdQuartzTrigger() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_LastJobGenerationDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_JobArchiveFilename() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_FileTriggerFileMask() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_FileTriggerFileName() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_FileTriggerFolderPath() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_FileTriggerTriggeredFilePath() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ExpectedTriggeringDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TaskStartDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_TaskEndDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(32);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ServerJobStartDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(33);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ServerJobEndDate() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(34);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_IdRemoteJob() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(35);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_IdRemoteJobExecution() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(36);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_RequestId() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(37);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ResumingMode() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(38);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ContextValues() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(39);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_JvmValues() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(40);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ParentTaskExecId() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(41);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTaskExecutionHistory_ParentPlanExecId() {
        return (EAttribute) taskExecutionHistoryEClass.getEStructuralFeatures().get(42);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPlanExecutionHistory() {
        return planExecutionHistoryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlanExecutionHistory_OriginalLabel() {
        return (EAttribute) planExecutionHistoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlanExecutionHistory_CurrentLabel() {
        return (EAttribute) planExecutionHistoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTalendTrigger() {
        return talendTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_Id() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_Active() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_Label() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_Description() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_TriggerType() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTalendTrigger_ExecutionTriggerable() {
        return (EReference) talendTriggerEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_StartTime() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_EndTime() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_PreviousFireTime() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_FinalFireTime() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_IdQuartzTrigger() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_ResumePauseUpdated() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTalendTrigger_PreviouslyPaused() {
        return (EAttribute) talendTriggerEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCronTalendTrigger() {
        return cronTalendTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronTalendTrigger_CronExpression() {
        return (EAttribute) cronTalendTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCronUITalendTrigger() {
        return cronUITalendTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListDaysOfWeek() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListDaysOfMonth() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListMonths() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListYears() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListHours() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCronUITalendTrigger_ListMinutes() {
        return (EAttribute) cronUITalendTriggerEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleTalendTrigger() {
        return simpleTalendTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleTalendTrigger_RepeatCount() {
        return (EAttribute) simpleTalendTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleTalendTrigger_RepeatInterval() {
        return (EAttribute) simpleTalendTriggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleTalendTrigger_TimesTriggered() {
        return (EAttribute) simpleTalendTriggerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFileTrigger() {
        return fileTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFileTrigger_FileTriggerMasks() {
        return (EReference) fileTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFileTriggerMask() {
        return fileTriggerMaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Id() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Active() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Label() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Description() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFileTriggerMask_FileTrigger() {
        return (EReference) fileTriggerMaskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_FolderPath() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_FileMask() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_ContextParameterBaseName() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFileTriggerMask_CheckFileServer() {
        return (EReference) fileTriggerMaskEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Exist() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Created() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileTriggerMask_Modified() {
        return (EAttribute) fileTriggerMaskEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionServer() {
        return executionServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Id() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Label() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Description() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Host() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Port() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_FileTransfertPort() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Active() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_MonitoringPort() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_TimeoutUnknownState() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Username() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Password() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_JmxUrl() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_WebConsoleUrl() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_TalendRuntime() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_MgmtServerPort() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_MgmtRegPort() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_AdminConsolePort() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_UseSSL() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionServer_Instance() {
        return (EAttribute) executionServerEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecutionVirtualServer() {
        return executionVirtualServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionVirtualServer_Id() {
        return (EAttribute) executionVirtualServerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionVirtualServer_Label() {
        return (EAttribute) executionVirtualServerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionVirtualServer_Description() {
        return (EAttribute) executionVirtualServerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecutionVirtualServer_Active() {
        return (EAttribute) executionVirtualServerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecutionVirtualServer_ExecutionServers() {
        return (EReference) executionVirtualServerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConductorFactory getConductorFactory() {
        return (ConductorFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        executionTriggerableEClass = createEClass(EXECUTION_TRIGGERABLE);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__ID);
        createEReference(executionTriggerableEClass, EXECUTION_TRIGGERABLE__TRIGGERS);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__ID_QUARTZ_JOB);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__STATUS);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__ERROR_STATUS);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__CONCURRENT_EXECUTION);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__PROCESSING_STATE);
        createEAttribute(executionTriggerableEClass, EXECUTION_TRIGGERABLE__REQUEST_ID);

        executionPlanEClass = createEClass(EXECUTION_PLAN);
        createEAttribute(executionPlanEClass, EXECUTION_PLAN__LABEL);
        createEReference(executionPlanEClass, EXECUTION_PLAN__EXEC_PLAN_PARTS);
        createEReference(executionPlanEClass, EXECUTION_PLAN__EXEC_PLAN_PRMS);
        createEAttribute(executionPlanEClass, EXECUTION_PLAN__DESCRIPTION);

        executionPlanPartEClass = createEClass(EXECUTION_PLAN_PART);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__ID);
        createEReference(executionPlanPartEClass, EXECUTION_PLAN_PART__TASK);
        createEReference(executionPlanPartEClass, EXECUTION_PLAN_PART__EXECUTION_PLAN);
        createEReference(executionPlanPartEClass, EXECUTION_PLAN_PART__PARENT);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__TYPE);
        createEReference(executionPlanPartEClass, EXECUTION_PLAN_PART__JVM_PRMS);
        createEReference(executionPlanPartEClass, EXECUTION_PLAN_PART__CONTEXT_PRMS);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__STATUS);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__START_DATE);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__END_DATE);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__REQUEST_ID);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__USE_PARALLEL);
        createEAttribute(executionPlanPartEClass, EXECUTION_PLAN_PART__MAX_THREADS);

        executionPlanPrmEClass = createEClass(EXECUTION_PLAN_PRM);
        createEAttribute(executionPlanPrmEClass, EXECUTION_PLAN_PRM__ID);
        createEReference(executionPlanPrmEClass, EXECUTION_PLAN_PRM__EXECUTION_PLAN);
        createEAttribute(executionPlanPrmEClass, EXECUTION_PLAN_PRM__NAME);
        createEAttribute(executionPlanPrmEClass, EXECUTION_PLAN_PRM__VALUE);

        executionPlanPartCmdPrmEClass = createEClass(EXECUTION_PLAN_PART_CMD_PRM);
        createEAttribute(executionPlanPartCmdPrmEClass, EXECUTION_PLAN_PART_CMD_PRM__ID);
        createEReference(executionPlanPartCmdPrmEClass, EXECUTION_PLAN_PART_CMD_PRM__EXECUTION_PLAN_PART);
        createEAttribute(executionPlanPartCmdPrmEClass, EXECUTION_PLAN_PART_CMD_PRM__NAME);
        createEAttribute(executionPlanPartCmdPrmEClass, EXECUTION_PLAN_PART_CMD_PRM__VALUE);

        executionPlanPartJobPrmEClass = createEClass(EXECUTION_PLAN_PART_JOB_PRM);
        createEAttribute(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__ID);
        createEReference(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__EXECUTION_PLAN_PART);
        createEAttribute(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__OVERRIDE);
        createEAttribute(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__NAME);
        createEAttribute(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__CUSTOM_VALUE);
        createEAttribute(executionPlanPartJobPrmEClass, EXECUTION_PLAN_PART_JOB_PRM__PART_CUSTOM_VALUE);

        executionTaskEClass = createEClass(EXECUTION_TASK);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LABEL);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__DESCRIPTION);
        createEReference(executionTaskEClass, EXECUTION_TASK__EXECUTION_SERVER);
        createEReference(executionTaskEClass, EXECUTION_TASK__PROJECT);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__BRANCH);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__CONTEXT);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__JOB_VERSION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__REGENERATE_JOB_ON_CHANGE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ACTIVE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LAST_SCRIPT_GENERATION_DATE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__GENERATED_SVN_REVISION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ID_REMOTE_JOB);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ID_REMOTE_JOB_EXECUTION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__CHECKSUM_ARCHIVE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__JOB_SCRIPT_ARCHIVE_FILENAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LAST_RUN_DATE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LAST_DEPLOYMENT_DATE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LAST_ENDED_RUN_DATE);
        createEReference(executionTaskEClass, EXECUTION_TASK__CMD_PRMS);
        createEReference(executionTaskEClass, EXECUTION_TASK__ESB_PROPERTIES_PRMS);
        createEReference(executionTaskEClass, EXECUTION_TASK__JOB_PRMS);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__JOB_ID);
        createEReference(executionTaskEClass, EXECUTION_TASK__VIRTUAL_SERVER);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__MAX_CONCURRENT_EXECUTIONS);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__GENERATED_PROJECT_NAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__GENERATED_JOB_NAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__GENERATED_JOB_VERSION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__APPLY_CONTEXT_TO_CHILDREN);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ERROR_STACK_TRACE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__LAST_TRIGGERING_DATE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__EXEC_STATISTICS_ENABLED);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ADD_STATISTICS_CODE_ENABLED);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__OWNER_SCHEDULER_INSTANCE_ID);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__ON_UNKNOWN_STATE_JOB);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__USE_LATEST_VERSION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__APPLICATION_TYPE);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__REPOSITORY_NAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__FEATURES_FILE_URL);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__FEATURE_NAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__FEATURE_VERSION);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__APPLICATION_GROUP);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__BUNDLE_NAME);
        createEAttribute(executionTaskEClass, EXECUTION_TASK__PROPERTY_ID);

        executionTaskPropertiesEClass = createEClass(EXECUTION_TASK_PROPERTIES);
        createEAttribute(executionTaskPropertiesEClass, EXECUTION_TASK_PROPERTIES__ID);
        createEAttribute(executionTaskPropertiesEClass, EXECUTION_TASK_PROPERTIES__NAME);
        createEAttribute(executionTaskPropertiesEClass, EXECUTION_TASK_PROPERTIES__VALUE);
        createEReference(executionTaskPropertiesEClass, EXECUTION_TASK_PROPERTIES__EXECUTION_TASK);

        executionTaskCmdPrmEClass = createEClass(EXECUTION_TASK_CMD_PRM);
        createEAttribute(executionTaskCmdPrmEClass, EXECUTION_TASK_CMD_PRM__ID);
        createEAttribute(executionTaskCmdPrmEClass, EXECUTION_TASK_CMD_PRM__ACTIVE);
        createEAttribute(executionTaskCmdPrmEClass, EXECUTION_TASK_CMD_PRM__PARAMETER);
        createEAttribute(executionTaskCmdPrmEClass, EXECUTION_TASK_CMD_PRM__DESCRIPTION);
        createEReference(executionTaskCmdPrmEClass, EXECUTION_TASK_CMD_PRM__EXECUTION_TASK);

        executionTaskJobPrmEClass = createEClass(EXECUTION_TASK_JOB_PRM);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__ID);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__LABEL);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__OVERRIDE);
        createEReference(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__EXECUTION_TASK);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__ORIGINAL_VALUE);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__DEFAULT_VALUE);
        createEAttribute(executionTaskJobPrmEClass, EXECUTION_TASK_JOB_PRM__ITEM_TYPE);

        taskExecutionHistoryEClass = createEClass(TASK_EXECUTION_HISTORY);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__ID);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__BASIC_STATUS);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__DETAILED_STATUS);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TASK_LABEL);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TASK_DESCRIPTION);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__PROJECT_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TALEND_JOB_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TALEND_JOB_ID);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TALEND_JOB_VERSION);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__CONTEXT_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__VIRTUAL_SERVER_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXECUTION_SERVER_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXECUTION_SERVER_HOST);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXECUTION_SERVER_CMD_PORT);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXECUTION_SERVER_FILE_PORT);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXECUTION_SERVER_MONITORING_PORT);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__APPLY_CONTEXT_TO_CHILDREN);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TRIGGERED_BY);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TRIGGER_TYPE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TRIGGER_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TRIGGER_DESCRIPTION);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TASK_ERROR_STACK_TRACE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__ID_QUARTZ_JOB);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__ID_QUARTZ_TRIGGER);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__LAST_JOB_GENERATION_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__JOB_ARCHIVE_FILENAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_MASK);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_NAME);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__FILE_TRIGGER_FOLDER_PATH);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__FILE_TRIGGER_TRIGGERED_FILE_PATH);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__EXPECTED_TRIGGERING_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TASK_START_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__TASK_END_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__SERVER_JOB_START_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__SERVER_JOB_END_DATE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__ID_REMOTE_JOB);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__ID_REMOTE_JOB_EXECUTION);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__REQUEST_ID);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__RESUMING_MODE);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__CONTEXT_VALUES);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__JVM_VALUES);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__PARENT_TASK_EXEC_ID);
        createEAttribute(taskExecutionHistoryEClass, TASK_EXECUTION_HISTORY__PARENT_PLAN_EXEC_ID);

        planExecutionHistoryEClass = createEClass(PLAN_EXECUTION_HISTORY);
        createEAttribute(planExecutionHistoryEClass, PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL);
        createEAttribute(planExecutionHistoryEClass, PLAN_EXECUTION_HISTORY__CURRENT_LABEL);

        talendTriggerEClass = createEClass(TALEND_TRIGGER);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__ID);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__ACTIVE);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__LABEL);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__DESCRIPTION);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__TRIGGER_TYPE);
        createEReference(talendTriggerEClass, TALEND_TRIGGER__EXECUTION_TRIGGERABLE);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__START_TIME);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__END_TIME);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__PREVIOUS_FIRE_TIME);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__FINAL_FIRE_TIME);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__ID_QUARTZ_TRIGGER);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__RESUME_PAUSE_UPDATED);
        createEAttribute(talendTriggerEClass, TALEND_TRIGGER__PREVIOUSLY_PAUSED);

        cronTalendTriggerEClass = createEClass(CRON_TALEND_TRIGGER);
        createEAttribute(cronTalendTriggerEClass, CRON_TALEND_TRIGGER__CRON_EXPRESSION);

        cronUITalendTriggerEClass = createEClass(CRON_UI_TALEND_TRIGGER);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_WEEK);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_MONTH);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_MONTHS);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_YEARS);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_HOURS);
        createEAttribute(cronUITalendTriggerEClass, CRON_UI_TALEND_TRIGGER__LIST_MINUTES);

        simpleTalendTriggerEClass = createEClass(SIMPLE_TALEND_TRIGGER);
        createEAttribute(simpleTalendTriggerEClass, SIMPLE_TALEND_TRIGGER__REPEAT_COUNT);
        createEAttribute(simpleTalendTriggerEClass, SIMPLE_TALEND_TRIGGER__REPEAT_INTERVAL);
        createEAttribute(simpleTalendTriggerEClass, SIMPLE_TALEND_TRIGGER__TIMES_TRIGGERED);

        fileTriggerEClass = createEClass(FILE_TRIGGER);
        createEReference(fileTriggerEClass, FILE_TRIGGER__FILE_TRIGGER_MASKS);

        fileTriggerMaskEClass = createEClass(FILE_TRIGGER_MASK);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__ID);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__ACTIVE);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__LABEL);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__DESCRIPTION);
        createEReference(fileTriggerMaskEClass, FILE_TRIGGER_MASK__FILE_TRIGGER);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__FOLDER_PATH);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__FILE_MASK);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__CONTEXT_PARAMETER_BASE_NAME);
        createEReference(fileTriggerMaskEClass, FILE_TRIGGER_MASK__CHECK_FILE_SERVER);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__EXIST);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__CREATED);
        createEAttribute(fileTriggerMaskEClass, FILE_TRIGGER_MASK__MODIFIED);

        executionServerEClass = createEClass(EXECUTION_SERVER);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__ID);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__LABEL);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__DESCRIPTION);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__HOST);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__FILE_TRANSFERT_PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__ACTIVE);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__MONITORING_PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__TIMEOUT_UNKNOWN_STATE);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__USERNAME);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__PASSWORD);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__JMX_URL);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__WEB_CONSOLE_URL);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__TALEND_RUNTIME);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__MGMT_SERVER_PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__MGMT_REG_PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__ADMIN_CONSOLE_PORT);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__USE_SSL);
        createEAttribute(executionServerEClass, EXECUTION_SERVER__INSTANCE);

        executionVirtualServerEClass = createEClass(EXECUTION_VIRTUAL_SERVER);
        createEAttribute(executionVirtualServerEClass, EXECUTION_VIRTUAL_SERVER__ID);
        createEAttribute(executionVirtualServerEClass, EXECUTION_VIRTUAL_SERVER__LABEL);
        createEAttribute(executionVirtualServerEClass, EXECUTION_VIRTUAL_SERVER__DESCRIPTION);
        createEAttribute(executionVirtualServerEClass, EXECUTION_VIRTUAL_SERVER__ACTIVE);
        createEReference(executionVirtualServerEClass, EXECUTION_VIRTUAL_SERVER__EXECUTION_SERVERS);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        AdminPackage theAdminPackage = (AdminPackage) EPackage.Registry.INSTANCE.getEPackage(AdminPackage.eNS_URI);

        // Add supertypes to classes
        executionPlanEClass.getESuperTypes().add(this.getExecutionTriggerable());
        executionTaskEClass.getESuperTypes().add(this.getExecutionTriggerable());
        planExecutionHistoryEClass.getESuperTypes().add(this.getTaskExecutionHistory());
        cronTalendTriggerEClass.getESuperTypes().add(this.getTalendTrigger());
        cronUITalendTriggerEClass.getESuperTypes().add(this.getTalendTrigger());
        simpleTalendTriggerEClass.getESuperTypes().add(this.getTalendTrigger());
        fileTriggerEClass.getESuperTypes().add(this.getSimpleTalendTrigger());

        // Initialize classes and features; add operations and parameters
        initEClass(executionTriggerableEClass, ExecutionTriggerable.class, "ExecutionTriggerable", IS_ABSTRACT, IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionTriggerable_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionTriggerable.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTriggerable_Triggers(), this.getTalendTrigger(), this.getTalendTrigger_ExecutionTriggerable(),
                "triggers", null, 0, -1, ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExecutionTriggerable_IdQuartzJob(), ecorePackage.getEInt(), "idQuartzJob", null, 0, 1,
                ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTriggerable_Status(), ecorePackage.getEString(), "status", null, 0, 1,
                ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTriggerable_ErrorStatus(), ecorePackage.getEString(), "errorStatus", null, 0, 1,
                ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTriggerable_ConcurrentExecution(), ecorePackage.getEBoolean(), "concurrentExecution", null, 0,
                1, ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTriggerable_ProcessingState(), ecorePackage.getEBoolean(), "processingState", null, 0, 1,
                ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTriggerable_RequestId(), ecorePackage.getEString(), "requestId", null, 0, 1,
                ExecutionTriggerable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(executionPlanEClass, ExecutionPlan.class, "ExecutionPlan", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionPlan_Label(), ecorePackage.getEString(), "label", null, 0, 1, ExecutionPlan.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlan_ExecPlanParts(), this.getExecutionPlanPart(), null, "execPlanParts", null, 0, -1,
                ExecutionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExecutionPlan_ExecPlanPrms(), this.getExecutionPlanPrm(), null, "execPlanPrms", null, 0, -1,
                ExecutionPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExecutionPlan_Description(), ecorePackage.getEString(), "description", null, 0, 1, ExecutionPlan.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionPlanPartEClass, ExecutionPlanPart.class, "ExecutionPlanPart", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionPlanPart_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionPlanPart.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPart_Task(), this.getExecutionTask(), null, "task", null, 0, 1, ExecutionPlanPart.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPart_ExecutionPlan(), this.getExecutionPlan(), null, "executionPlan", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPart_Parent(), this.getExecutionPlanPart(), null, "parent", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_Type(), ecorePackage.getEString(), "type", null, 0, 1, ExecutionPlanPart.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPart_JvmPrms(), this.getExecutionPlanPartCmdPrm(), null, "jvmPrms", null, 0, -1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExecutionPlanPart_ContextPrms(), this.getExecutionPlanPartJobPrm(), null, "contextPrms", null, 0, -1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExecutionPlanPart_Status(), ecorePackage.getEString(), "status", null, 0, 1, ExecutionPlanPart.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_EndDate(), ecorePackage.getEDate(), "endDate", null, 0, 1, ExecutionPlanPart.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_RequestId(), ecorePackage.getEString(), "requestId", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_UseParallel(), ecorePackage.getEBoolean(), "useParallel", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPart_MaxThreads(), ecorePackage.getEIntegerObject(), "maxThreads", null, 0, 1,
                ExecutionPlanPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(executionPlanPrmEClass, ExecutionPlanPrm.class, "ExecutionPlanPrm", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionPlanPrm_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionPlanPrm.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPrm_ExecutionPlan(), this.getExecutionPlan(), null, "executionPlan", null, 0, 1,
                ExecutionPlanPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPrm_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExecutionPlanPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPrm_Value(), ecorePackage.getEString(), "value", null, 0, 1, ExecutionPlanPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionPlanPartCmdPrmEClass, ExecutionPlanPartCmdPrm.class, "ExecutionPlanPartCmdPrm", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionPlanPartCmdPrm_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionPlanPartCmdPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPartCmdPrm_ExecutionPlanPart(), this.getExecutionPlanPart(), null, "executionPlanPart",
                null, 0, 1, ExecutionPlanPartCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartCmdPrm_Name(), ecorePackage.getEString(), "name", null, 0, 1,
                ExecutionPlanPartCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartCmdPrm_Value(), ecorePackage.getEString(), "value", null, 0, 1,
                ExecutionPlanPartCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(executionPlanPartJobPrmEClass, ExecutionPlanPartJobPrm.class, "ExecutionPlanPartJobPrm", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionPlanPartJobPrm_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionPlanPartJobPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionPlanPartJobPrm_ExecutionPlanPart(), this.getExecutionPlanPart(), null, "executionPlanPart",
                null, 0, 1, ExecutionPlanPartJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartJobPrm_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1,
                ExecutionPlanPartJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartJobPrm_Name(), ecorePackage.getEString(), "name", null, 0, 1,
                ExecutionPlanPartJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartJobPrm_CustomValue(), ecorePackage.getEString(), "customValue", null, 0, 1,
                ExecutionPlanPartJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionPlanPartJobPrm_PartCustomValue(), ecorePackage.getEString(), "partCustomValue", null, 0, 1,
                ExecutionPlanPartJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(executionTaskEClass, ExecutionTask.class, "ExecutionTask", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionTask_Label(), ecorePackage.getEString(), "label", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_Description(), ecorePackage.getEString(), "description", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTask_ExecutionServer(), this.getExecutionServer(), null, "executionServer", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTask_Project(), theAdminPackage.getProject(), null, "project", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_Branch(), ecorePackage.getEString(), "branch", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_Context(), ecorePackage.getEString(), "context", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_JobVersion(), ecorePackage.getEString(), "jobVersion", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_RegenerateJobOnChange(), ecorePackage.getEBoolean(), "regenerateJobOnChange", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_Active(), ecorePackage.getEBoolean(), "active", "true", 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_LastScriptGenerationDate(), ecorePackage.getEDate(), "lastScriptGenerationDate", null, 0,
                1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_GeneratedSvnRevision(), ecorePackage.getELongObject(), "generatedSvnRevision", null, 0,
                1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_IdRemoteJob(), ecorePackage.getEString(), "idRemoteJob", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_IdRemoteJobExecution(), ecorePackage.getEString(), "idRemoteJobExecution", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_ChecksumArchive(), ecorePackage.getEString(), "checksumArchive", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_JobScriptArchiveFilename(), ecorePackage.getEString(), "jobScriptArchiveFilename", null,
                0, 1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_LastRunDate(), ecorePackage.getEDate(), "lastRunDate", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_LastDeploymentDate(), ecorePackage.getEDate(), "lastDeploymentDate", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_LastEndedRunDate(), ecorePackage.getEDate(), "lastEndedRunDate", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getExecutionTask_CmdPrms(), this.getExecutionTaskCmdPrm(), this.getExecutionTaskCmdPrm_ExecutionTask(),
                "cmdPrms", null, 0, -1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getExecutionTask_EsbPropertiesPrms(), this.getExecutionTaskProperties(),
                this.getExecutionTaskProperties_ExecutionTask(), "esbPropertiesPrms", null, 0, -1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEReference(getExecutionTask_JobPrms(), this.getExecutionTaskJobPrm(), this.getExecutionTaskJobPrm_ExecutionTask(),
                "jobPrms", null, 0, -1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getExecutionTask_JobId(), ecorePackage.getEString(), "jobId", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTask_VirtualServer(), this.getExecutionVirtualServer(), null, "virtualServer", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_MaxConcurrentExecutions(), ecorePackage.getEInt(), "maxConcurrentExecutions", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_GeneratedProjectName(), ecorePackage.getEString(), "generatedProjectName", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_GeneratedJobName(), ecorePackage.getEString(), "generatedJobName", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_GeneratedJobVersion(), ecorePackage.getEString(), "generatedJobVersion", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_ApplyContextToChildren(), ecorePackage.getEBoolean(), "applyContextToChildren", null, 0,
                1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_ErrorStackTrace(), ecorePackage.getEString(), "errorStackTrace", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_LastTriggeringDate(), ecorePackage.getEDate(), "lastTriggeringDate", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_ExecStatisticsEnabled(), ecorePackage.getEBoolean(), "execStatisticsEnabled", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_AddStatisticsCodeEnabled(), ecorePackage.getEBoolean(), "addStatisticsCodeEnabled", null,
                0, 1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_OwnerSchedulerInstanceId(), ecorePackage.getEString(), "ownerSchedulerInstanceId", null,
                0, 1, ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_OnUnknownStateJob(), ecorePackage.getEString(), "onUnknownStateJob", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_UseLatestVersion(), ecorePackage.getEBoolean(), "useLatestVersion", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_ApplicationType(), ecorePackage.getEString(), "applicationType", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_RepositoryName(), ecorePackage.getEString(), "repositoryName", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_FeaturesFileUrl(), ecorePackage.getEString(), "featuresFileUrl", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_FeatureVersion(), ecorePackage.getEString(), "featureVersion", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_ApplicationGroup(), ecorePackage.getEString(), "applicationGroup", null, 0, 1,
                ExecutionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getExecutionTask_BundleName(), ecorePackage.getEString(), "bundleName", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTask_PropertyId(), ecorePackage.getEString(), "propertyId", null, 0, 1, ExecutionTask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionTaskPropertiesEClass, ExecutionTaskProperties.class, "ExecutionTaskProperties", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionTaskProperties_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionTaskProperties.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskProperties_Name(), ecorePackage.getEString(), "name", null, 0, 1,
                ExecutionTaskProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskProperties_Value(), ecorePackage.getEString(), "value", null, 0, 1,
                ExecutionTaskProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTaskProperties_ExecutionTask(), this.getExecutionTask(),
                this.getExecutionTask_EsbPropertiesPrms(), "executionTask", null, 0, 1, ExecutionTaskProperties.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(executionTaskCmdPrmEClass, ExecutionTaskCmdPrm.class, "ExecutionTaskCmdPrm", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionTaskCmdPrm_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionTaskCmdPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskCmdPrm_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1,
                ExecutionTaskCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskCmdPrm_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1,
                ExecutionTaskCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskCmdPrm_Description(), ecorePackage.getEString(), "description", null, 0, 1,
                ExecutionTaskCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTaskCmdPrm_ExecutionTask(), this.getExecutionTask(), this.getExecutionTask_CmdPrms(),
                "executionTask", null, 0, 1, ExecutionTaskCmdPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionTaskJobPrmEClass, ExecutionTaskJobPrm.class, "ExecutionTaskJobPrm", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionTaskJobPrm_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionTaskJobPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskJobPrm_Label(), ecorePackage.getEString(), "label", null, 0, 1, ExecutionTaskJobPrm.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskJobPrm_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1,
                ExecutionTaskJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionTaskJobPrm_ExecutionTask(), this.getExecutionTask(), this.getExecutionTask_JobPrms(),
                "executionTask", null, 0, 1, ExecutionTaskJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskJobPrm_OriginalValue(), ecorePackage.getEString(), "originalValue", null, 0, 1,
                ExecutionTaskJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskJobPrm_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1,
                ExecutionTaskJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionTaskJobPrm_ItemType(), ecorePackage.getEString(), "itemType", null, 0, 1,
                ExecutionTaskJobPrm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(taskExecutionHistoryEClass, TaskExecutionHistory.class, "TaskExecutionHistory", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTaskExecutionHistory_Id(), ecorePackage.getEInt(), "id", null, 1, 1, TaskExecutionHistory.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_BasicStatus(), ecorePackage.getEString(), "basicStatus", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_DetailedStatus(), ecorePackage.getEString(), "detailedStatus", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TaskLabel(), ecorePackage.getEString(), "taskLabel", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TaskDescription(), ecorePackage.getEString(), "taskDescription", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TalendJobName(), ecorePackage.getEString(), "talendJobName", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TalendJobId(), ecorePackage.getEString(), "talendJobId", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TalendJobVersion(), ecorePackage.getEString(), "talendJobVersion", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ContextName(), ecorePackage.getEString(), "contextName", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_VirtualServerName(), ecorePackage.getEString(), "virtualServerName", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExecutionServerName(), ecorePackage.getEString(), "executionServerName", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExecutionServerHost(), ecorePackage.getEString(), "executionServerHost", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExecutionServerCmdPort(), ecorePackage.getEInt(), "executionServerCmdPort", null,
                0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExecutionServerFilePort(), ecorePackage.getEInt(), "executionServerFilePort",
                null, 0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExecutionServerMonitoringPort(), ecorePackage.getEInt(),
                "executionServerMonitoringPort", null, 0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ApplyContextToChildren(), ecorePackage.getEBoolean(), "applyContextToChildren",
                null, 0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TriggeredBy(), ecorePackage.getEString(), "triggeredBy", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TriggerType(), ecorePackage.getEString(), "triggerType", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TriggerName(), ecorePackage.getEString(), "triggerName", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TriggerDescription(), ecorePackage.getEString(), "triggerDescription", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TaskErrorStackTrace(), ecorePackage.getEString(), "taskErrorStackTrace", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_IdQuartzJob(), ecorePackage.getEInt(), "idQuartzJob", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_IdQuartzTrigger(), ecorePackage.getEIntegerObject(), "idQuartzTrigger", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_LastJobGenerationDate(), ecorePackage.getEDate(), "lastJobGenerationDate", null,
                0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_JobArchiveFilename(), ecorePackage.getEString(), "jobArchiveFilename", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_FileTriggerFileMask(), ecorePackage.getEString(), "fileTriggerFileMask", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_FileTriggerFileName(), ecorePackage.getEString(), "fileTriggerFileName", null, 0,
                1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_FileTriggerFolderPath(), ecorePackage.getEString(), "fileTriggerFolderPath", null,
                0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_FileTriggerTriggeredFilePath(), ecorePackage.getEString(),
                "fileTriggerTriggeredFilePath", null, 0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ExpectedTriggeringDate(), ecorePackage.getEDate(), "expectedTriggeringDate", null,
                0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TaskStartDate(), ecorePackage.getEDate(), "taskStartDate", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_TaskEndDate(), ecorePackage.getEDate(), "taskEndDate", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ServerJobStartDate(), ecorePackage.getEDate(), "serverJobStartDate", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ServerJobEndDate(), ecorePackage.getEDate(), "serverJobEndDate", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_IdRemoteJob(), ecorePackage.getEString(), "idRemoteJob", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_IdRemoteJobExecution(), ecorePackage.getEString(), "idRemoteJobExecution", null,
                0, 1, TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_RequestId(), ecorePackage.getEString(), "requestId", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ResumingMode(), ecorePackage.getEBoolean(), "resumingMode", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ContextValues(), ecorePackage.getEString(), "contextValues", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_JvmValues(), ecorePackage.getEString(), "jvmValues", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ParentTaskExecId(), ecorePackage.getEInt(), "parentTaskExecId", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTaskExecutionHistory_ParentPlanExecId(), ecorePackage.getEInt(), "parentPlanExecId", null, 0, 1,
                TaskExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(planExecutionHistoryEClass, PlanExecutionHistory.class, "PlanExecutionHistory", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPlanExecutionHistory_OriginalLabel(), ecorePackage.getEString(), "originalLabel", null, 0, 1,
                PlanExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPlanExecutionHistory_CurrentLabel(), ecorePackage.getEString(), "currentLabel", null, 0, 1,
                PlanExecutionHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(talendTriggerEClass, TalendTrigger.class, "TalendTrigger", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTalendTrigger_Id(), ecorePackage.getEInt(), "id", null, 1, 1, TalendTrigger.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_Label(), ecorePackage.getEString(), "label", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_Description(), ecorePackage.getEString(), "description", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_TriggerType(), ecorePackage.getEString(), "triggerType", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTalendTrigger_ExecutionTriggerable(), this.getExecutionTriggerable(),
                this.getExecutionTriggerable_Triggers(), "executionTriggerable", null, 0, 1, TalendTrigger.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTalendTrigger_StartTime(), ecorePackage.getEDate(), "startTime", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_EndTime(), ecorePackage.getEDate(), "endTime", null, 0, 1, TalendTrigger.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTalendTrigger_PreviousFireTime(), ecorePackage.getEDate(), "previousFireTime", null, 0, 1,
                TalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTalendTrigger_FinalFireTime(), ecorePackage.getEDate(), "finalFireTime", null, 0, 1,
                TalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTalendTrigger_IdQuartzTrigger(), ecorePackage.getEInt(), "idQuartzTrigger", null, 0, 1,
                TalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTalendTrigger_ResumePauseUpdated(), ecorePackage.getEDate(), "resumePauseUpdated", null, 0, 1,
                TalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTalendTrigger_PreviouslyPaused(), ecorePackage.getEBoolean(), "previouslyPaused", null, 0, 1,
                TalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(cronTalendTriggerEClass, CronTalendTrigger.class, "CronTalendTrigger", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCronTalendTrigger_CronExpression(), ecorePackage.getEString(), "cronExpression", null, 0, 1,
                CronTalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(cronUITalendTriggerEClass, CronUITalendTrigger.class, "CronUITalendTrigger", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCronUITalendTrigger_ListDaysOfWeek(), ecorePackage.getEString(), "listDaysOfWeek", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCronUITalendTrigger_ListDaysOfMonth(), ecorePackage.getEString(), "listDaysOfMonth", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCronUITalendTrigger_ListMonths(), ecorePackage.getEString(), "listMonths", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCronUITalendTrigger_ListYears(), ecorePackage.getEString(), "listYears", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCronUITalendTrigger_ListHours(), ecorePackage.getEString(), "listHours", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCronUITalendTrigger_ListMinutes(), ecorePackage.getEString(), "listMinutes", null, 0, 1,
                CronUITalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(simpleTalendTriggerEClass, SimpleTalendTrigger.class, "SimpleTalendTrigger", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSimpleTalendTrigger_RepeatCount(), ecorePackage.getEIntegerObject(), "repeatCount", null, 0, 1,
                SimpleTalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimpleTalendTrigger_RepeatInterval(), ecorePackage.getELong(), "repeatInterval", null, 0, 1,
                SimpleTalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimpleTalendTrigger_TimesTriggered(), ecorePackage.getEInt(), "timesTriggered", null, 0, 1,
                SimpleTalendTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(fileTriggerEClass, FileTrigger.class, "FileTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFileTrigger_FileTriggerMasks(), this.getFileTriggerMask(), null, "fileTriggerMasks", null, 0, -1,
                FileTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(fileTriggerMaskEClass, FileTriggerMask.class, "FileTriggerMask", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFileTriggerMask_Id(), ecorePackage.getEInt(), "id", null, 1, 1, FileTriggerMask.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Label(), ecorePackage.getEString(), "label", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Description(), ecorePackage.getEString(), "description", null, 0, 1,
                FileTriggerMask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getFileTriggerMask_FileTrigger(), this.getFileTrigger(), null, "fileTrigger", null, 0, 1,
                FileTriggerMask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_FolderPath(), ecorePackage.getEString(), "folderPath", null, 0, 1,
                FileTriggerMask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_FileMask(), ecorePackage.getEString(), "fileMask", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_ContextParameterBaseName(), ecorePackage.getEString(), "contextParameterBaseName",
                null, 0, 1, FileTriggerMask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getFileTriggerMask_CheckFileServer(), this.getExecutionServer(), null, "checkFileServer", null, 0, 1,
                FileTriggerMask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Exist(), ecorePackage.getEBoolean(), "exist", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Created(), ecorePackage.getEBoolean(), "created", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFileTriggerMask_Modified(), ecorePackage.getEBoolean(), "modified", null, 0, 1, FileTriggerMask.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionServerEClass, ExecutionServer.class, "ExecutionServer", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionServer_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionServer.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Label(), ecorePackage.getEString(), "label", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Description(), ecorePackage.getEString(), "description", null, 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Host(), ecorePackage.getEString(), "host", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Port(), ecorePackage.getEInt(), "port", "-1", 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_FileTransfertPort(), ecorePackage.getEInt(), "fileTransfertPort", "-1", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Active(), ecorePackage.getEBoolean(), "active", "true", 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_MonitoringPort(), ecorePackage.getEInt(), "monitoringPort", "-1", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_TimeoutUnknownState(), ecorePackage.getEInt(), "timeoutUnknownState", "120", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Username(), ecorePackage.getEString(), "username", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Password(), ecorePackage.getEString(), "password", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_JmxUrl(), ecorePackage.getEString(), "jmxUrl", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_WebConsoleUrl(), ecorePackage.getEString(), "webConsoleUrl", null, 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_TalendRuntime(), ecorePackage.getEBoolean(), "talendRuntime", null, 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_MgmtServerPort(), ecorePackage.getEInt(), "mgmtServerPort", "-1", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_MgmtRegPort(), ecorePackage.getEInt(), "mgmtRegPort", "-1", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_AdminConsolePort(), ecorePackage.getEInt(), "adminConsolePort", "-1", 0, 1,
                ExecutionServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_UseSSL(), ecorePackage.getEBoolean(), "useSSL", "false", 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionServer_Instance(), ecorePackage.getEString(), "instance", null, 0, 1, ExecutionServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(executionVirtualServerEClass, ExecutionVirtualServer.class, "ExecutionVirtualServer", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExecutionVirtualServer_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ExecutionVirtualServer.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionVirtualServer_Label(), ecorePackage.getEString(), "label", null, 0, 1,
                ExecutionVirtualServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionVirtualServer_Description(), ecorePackage.getEString(), "description", null, 0, 1,
                ExecutionVirtualServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExecutionVirtualServer_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1,
                ExecutionVirtualServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getExecutionVirtualServer_ExecutionServers(), this.getExecutionServer(), null, "executionServers", null,
                0, -1, ExecutionVirtualServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //ConductorPackageImpl
