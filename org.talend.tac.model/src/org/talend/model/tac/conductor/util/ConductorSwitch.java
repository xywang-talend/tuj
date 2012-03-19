/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.model.tac.conductor.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.conductor.ConductorPackage
 * @generated
 */
public class ConductorSwitch {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConductorPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConductorSwitch() {
        if (modelPackage == null) {
            modelPackage = ConductorPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public Object doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case ConductorPackage.EXECUTION_TRIGGERABLE: {
            ExecutionTriggerable executionTriggerable = (ExecutionTriggerable) theEObject;
            Object result = caseExecutionTriggerable(executionTriggerable);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_PLAN: {
            ExecutionPlan executionPlan = (ExecutionPlan) theEObject;
            Object result = caseExecutionPlan(executionPlan);
            if (result == null)
                result = caseExecutionTriggerable(executionPlan);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_PLAN_PART: {
            ExecutionPlanPart executionPlanPart = (ExecutionPlanPart) theEObject;
            Object result = caseExecutionPlanPart(executionPlanPart);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_PLAN_PRM: {
            ExecutionPlanPrm executionPlanPrm = (ExecutionPlanPrm) theEObject;
            Object result = caseExecutionPlanPrm(executionPlanPrm);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_PLAN_PART_CMD_PRM: {
            ExecutionPlanPartCmdPrm executionPlanPartCmdPrm = (ExecutionPlanPartCmdPrm) theEObject;
            Object result = caseExecutionPlanPartCmdPrm(executionPlanPartCmdPrm);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_PLAN_PART_JOB_PRM: {
            ExecutionPlanPartJobPrm executionPlanPartJobPrm = (ExecutionPlanPartJobPrm) theEObject;
            Object result = caseExecutionPlanPartJobPrm(executionPlanPartJobPrm);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_TASK: {
            ExecutionTask executionTask = (ExecutionTask) theEObject;
            Object result = caseExecutionTask(executionTask);
            if (result == null)
                result = caseExecutionTriggerable(executionTask);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_TASK_PROPERTIES: {
            ExecutionTaskProperties executionTaskProperties = (ExecutionTaskProperties) theEObject;
            Object result = caseExecutionTaskProperties(executionTaskProperties);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_TASK_CMD_PRM: {
            ExecutionTaskCmdPrm executionTaskCmdPrm = (ExecutionTaskCmdPrm) theEObject;
            Object result = caseExecutionTaskCmdPrm(executionTaskCmdPrm);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_TASK_JOB_PRM: {
            ExecutionTaskJobPrm executionTaskJobPrm = (ExecutionTaskJobPrm) theEObject;
            Object result = caseExecutionTaskJobPrm(executionTaskJobPrm);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.TASK_EXECUTION_HISTORY: {
            TaskExecutionHistory taskExecutionHistory = (TaskExecutionHistory) theEObject;
            Object result = caseTaskExecutionHistory(taskExecutionHistory);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.PLAN_EXECUTION_HISTORY: {
            PlanExecutionHistory planExecutionHistory = (PlanExecutionHistory) theEObject;
            Object result = casePlanExecutionHistory(planExecutionHistory);
            if (result == null)
                result = caseTaskExecutionHistory(planExecutionHistory);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.TALEND_TRIGGER: {
            TalendTrigger talendTrigger = (TalendTrigger) theEObject;
            Object result = caseTalendTrigger(talendTrigger);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.CRON_TALEND_TRIGGER: {
            CronTalendTrigger cronTalendTrigger = (CronTalendTrigger) theEObject;
            Object result = caseCronTalendTrigger(cronTalendTrigger);
            if (result == null)
                result = caseTalendTrigger(cronTalendTrigger);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.CRON_UI_TALEND_TRIGGER: {
            CronUITalendTrigger cronUITalendTrigger = (CronUITalendTrigger) theEObject;
            Object result = caseCronUITalendTrigger(cronUITalendTrigger);
            if (result == null)
                result = caseTalendTrigger(cronUITalendTrigger);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.SIMPLE_TALEND_TRIGGER: {
            SimpleTalendTrigger simpleTalendTrigger = (SimpleTalendTrigger) theEObject;
            Object result = caseSimpleTalendTrigger(simpleTalendTrigger);
            if (result == null)
                result = caseTalendTrigger(simpleTalendTrigger);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.FILE_TRIGGER: {
            FileTrigger fileTrigger = (FileTrigger) theEObject;
            Object result = caseFileTrigger(fileTrigger);
            if (result == null)
                result = caseSimpleTalendTrigger(fileTrigger);
            if (result == null)
                result = caseTalendTrigger(fileTrigger);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.FILE_TRIGGER_MASK: {
            FileTriggerMask fileTriggerMask = (FileTriggerMask) theEObject;
            Object result = caseFileTriggerMask(fileTriggerMask);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_SERVER: {
            ExecutionServer executionServer = (ExecutionServer) theEObject;
            Object result = caseExecutionServer(executionServer);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ConductorPackage.EXECUTION_VIRTUAL_SERVER: {
            ExecutionVirtualServer executionVirtualServer = (ExecutionVirtualServer) theEObject;
            Object result = caseExecutionVirtualServer(executionVirtualServer);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Triggerable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Triggerable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionTriggerable(ExecutionTriggerable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Plan</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Plan</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionPlan(ExecutionPlan object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Plan Part</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Plan Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionPlanPart(ExecutionPlanPart object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Plan Prm</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Plan Prm</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionPlanPrm(ExecutionPlanPrm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Plan Part Cmd Prm</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Plan Part Cmd Prm</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionPlanPartCmdPrm(ExecutionPlanPartCmdPrm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Plan Part Job Prm</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Plan Part Job Prm</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionPlanPartJobPrm(ExecutionPlanPartJobPrm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionTask(ExecutionTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Task Properties</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Task Properties</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionTaskProperties(ExecutionTaskProperties object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Task Cmd Prm</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Task Cmd Prm</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionTaskCmdPrm(ExecutionTaskCmdPrm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Task Job Prm</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Task Job Prm</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionTaskJobPrm(ExecutionTaskJobPrm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task Execution History</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task Execution History</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTaskExecutionHistory(TaskExecutionHistory object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plan Execution History</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plan Execution History</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePlanExecutionHistory(PlanExecutionHistory object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Talend Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTalendTrigger(TalendTrigger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Cron Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Cron Talend Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCronTalendTrigger(CronTalendTrigger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Cron UI Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Cron UI Talend Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCronUITalendTrigger(CronUITalendTrigger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Talend Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSimpleTalendTrigger(SimpleTalendTrigger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseFileTrigger(FileTrigger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Trigger Mask</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Trigger Mask</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseFileTriggerMask(FileTriggerMask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionServer(ExecutionServer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execution Virtual Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execution Virtual Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseExecutionVirtualServer(ExecutionVirtualServer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public Object defaultCase(EObject object) {
        return null;
    }

} //ConductorSwitch
