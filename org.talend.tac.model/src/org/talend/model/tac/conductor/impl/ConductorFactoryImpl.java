/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.model.tac.conductor.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConductorFactoryImpl extends EFactoryImpl implements ConductorFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ConductorFactory init() {
        try {
            ConductorFactory theConductorFactory = (ConductorFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://www.talend.org/tac/conductor");
            if (theConductorFactory != null) {
                return theConductorFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ConductorFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConductorFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ConductorPackage.EXECUTION_PLAN:
            return createExecutionPlan();
        case ConductorPackage.EXECUTION_PLAN_PART:
            return createExecutionPlanPart();
        case ConductorPackage.EXECUTION_PLAN_PRM:
            return createExecutionPlanPrm();
        case ConductorPackage.EXECUTION_PLAN_PART_CMD_PRM:
            return createExecutionPlanPartCmdPrm();
        case ConductorPackage.EXECUTION_PLAN_PART_JOB_PRM:
            return createExecutionPlanPartJobPrm();
        case ConductorPackage.EXECUTION_TASK:
            return createExecutionTask();
        case ConductorPackage.EXECUTION_TASK_PROPERTIES:
            return createExecutionTaskProperties();
        case ConductorPackage.EXECUTION_TASK_CMD_PRM:
            return createExecutionTaskCmdPrm();
        case ConductorPackage.EXECUTION_TASK_JOB_PRM:
            return createExecutionTaskJobPrm();
        case ConductorPackage.TASK_EXECUTION_HISTORY:
            return createTaskExecutionHistory();
        case ConductorPackage.PLAN_EXECUTION_HISTORY:
            return createPlanExecutionHistory();
        case ConductorPackage.TALEND_TRIGGER:
            return createTalendTrigger();
        case ConductorPackage.CRON_TALEND_TRIGGER:
            return createCronTalendTrigger();
        case ConductorPackage.CRON_UI_TALEND_TRIGGER:
            return createCronUITalendTrigger();
        case ConductorPackage.SIMPLE_TALEND_TRIGGER:
            return createSimpleTalendTrigger();
        case ConductorPackage.FILE_TRIGGER:
            return createFileTrigger();
        case ConductorPackage.FILE_TRIGGER_MASK:
            return createFileTriggerMask();
        case ConductorPackage.EXECUTION_SERVER:
            return createExecutionServer();
        case ConductorPackage.EXECUTION_VIRTUAL_SERVER:
            return createExecutionVirtualServer();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlan createExecutionPlan() {
        ExecutionPlanImpl executionPlan = new ExecutionPlanImpl();
        return executionPlan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlanPart createExecutionPlanPart() {
        ExecutionPlanPartImpl executionPlanPart = new ExecutionPlanPartImpl();
        return executionPlanPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlanPrm createExecutionPlanPrm() {
        ExecutionPlanPrmImpl executionPlanPrm = new ExecutionPlanPrmImpl();
        return executionPlanPrm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlanPartCmdPrm createExecutionPlanPartCmdPrm() {
        ExecutionPlanPartCmdPrmImpl executionPlanPartCmdPrm = new ExecutionPlanPartCmdPrmImpl();
        return executionPlanPartCmdPrm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlanPartJobPrm createExecutionPlanPartJobPrm() {
        ExecutionPlanPartJobPrmImpl executionPlanPartJobPrm = new ExecutionPlanPartJobPrmImpl();
        return executionPlanPartJobPrm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionTask createExecutionTask() {
        ExecutionTaskImpl executionTask = new ExecutionTaskImpl();
        return executionTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionTaskProperties createExecutionTaskProperties() {
        ExecutionTaskPropertiesImpl executionTaskProperties = new ExecutionTaskPropertiesImpl();
        return executionTaskProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionTaskCmdPrm createExecutionTaskCmdPrm() {
        ExecutionTaskCmdPrmImpl executionTaskCmdPrm = new ExecutionTaskCmdPrmImpl();
        return executionTaskCmdPrm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionTaskJobPrm createExecutionTaskJobPrm() {
        ExecutionTaskJobPrmImpl executionTaskJobPrm = new ExecutionTaskJobPrmImpl();
        return executionTaskJobPrm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TaskExecutionHistory createTaskExecutionHistory() {
        TaskExecutionHistoryImpl taskExecutionHistory = new TaskExecutionHistoryImpl();
        return taskExecutionHistory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlanExecutionHistory createPlanExecutionHistory() {
        PlanExecutionHistoryImpl planExecutionHistory = new PlanExecutionHistoryImpl();
        return planExecutionHistory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TalendTrigger createTalendTrigger() {
        TalendTriggerImpl talendTrigger = new TalendTriggerImpl();
        return talendTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CronTalendTrigger createCronTalendTrigger() {
        CronTalendTriggerImpl cronTalendTrigger = new CronTalendTriggerImpl();
        return cronTalendTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CronUITalendTrigger createCronUITalendTrigger() {
        CronUITalendTriggerImpl cronUITalendTrigger = new CronUITalendTriggerImpl();
        return cronUITalendTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleTalendTrigger createSimpleTalendTrigger() {
        SimpleTalendTriggerImpl simpleTalendTrigger = new SimpleTalendTriggerImpl();
        return simpleTalendTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FileTrigger createFileTrigger() {
        FileTriggerImpl fileTrigger = new FileTriggerImpl();
        return fileTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FileTriggerMask createFileTriggerMask() {
        FileTriggerMaskImpl fileTriggerMask = new FileTriggerMaskImpl();
        return fileTriggerMask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionServer createExecutionServer() {
        ExecutionServerImpl executionServer = new ExecutionServerImpl();
        return executionServer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionVirtualServer createExecutionVirtualServer() {
        ExecutionVirtualServerImpl executionVirtualServer = new ExecutionVirtualServerImpl();
        return executionVirtualServer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConductorPackage getConductorPackage() {
        return (ConductorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ConductorPackage getPackage() {
        return ConductorPackage.eINSTANCE;
    }

} //ConductorFactoryImpl
