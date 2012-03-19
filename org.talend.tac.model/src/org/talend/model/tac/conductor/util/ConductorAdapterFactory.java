/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.model.tac.conductor.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.conductor.ConductorPackage
 * @generated
 */
public class ConductorAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConductorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConductorAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ConductorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConductorSwitch modelSwitch = new ConductorSwitch() {

        public Object caseExecutionTriggerable(ExecutionTriggerable object) {
            return createExecutionTriggerableAdapter();
        }

        public Object caseExecutionPlan(ExecutionPlan object) {
            return createExecutionPlanAdapter();
        }

        public Object caseExecutionPlanPart(ExecutionPlanPart object) {
            return createExecutionPlanPartAdapter();
        }

        public Object caseExecutionPlanPrm(ExecutionPlanPrm object) {
            return createExecutionPlanPrmAdapter();
        }

        public Object caseExecutionPlanPartCmdPrm(ExecutionPlanPartCmdPrm object) {
            return createExecutionPlanPartCmdPrmAdapter();
        }

        public Object caseExecutionPlanPartJobPrm(ExecutionPlanPartJobPrm object) {
            return createExecutionPlanPartJobPrmAdapter();
        }

        public Object caseExecutionTask(ExecutionTask object) {
            return createExecutionTaskAdapter();
        }

        public Object caseExecutionTaskProperties(ExecutionTaskProperties object) {
            return createExecutionTaskPropertiesAdapter();
        }

        public Object caseExecutionTaskCmdPrm(ExecutionTaskCmdPrm object) {
            return createExecutionTaskCmdPrmAdapter();
        }

        public Object caseExecutionTaskJobPrm(ExecutionTaskJobPrm object) {
            return createExecutionTaskJobPrmAdapter();
        }

        public Object caseTaskExecutionHistory(TaskExecutionHistory object) {
            return createTaskExecutionHistoryAdapter();
        }

        public Object casePlanExecutionHistory(PlanExecutionHistory object) {
            return createPlanExecutionHistoryAdapter();
        }

        public Object caseTalendTrigger(TalendTrigger object) {
            return createTalendTriggerAdapter();
        }

        public Object caseCronTalendTrigger(CronTalendTrigger object) {
            return createCronTalendTriggerAdapter();
        }

        public Object caseCronUITalendTrigger(CronUITalendTrigger object) {
            return createCronUITalendTriggerAdapter();
        }

        public Object caseSimpleTalendTrigger(SimpleTalendTrigger object) {
            return createSimpleTalendTriggerAdapter();
        }

        public Object caseFileTrigger(FileTrigger object) {
            return createFileTriggerAdapter();
        }

        public Object caseFileTriggerMask(FileTriggerMask object) {
            return createFileTriggerMaskAdapter();
        }

        public Object caseExecutionServer(ExecutionServer object) {
            return createExecutionServerAdapter();
        }

        public Object caseExecutionVirtualServer(ExecutionVirtualServer object) {
            return createExecutionVirtualServerAdapter();
        }

        public Object defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return (Adapter) modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionTriggerable <em>Execution Triggerable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable
     * @generated
     */
    public Adapter createExecutionTriggerableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionPlan <em>Execution Plan</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionPlan
     * @generated
     */
    public Adapter createExecutionPlanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionPlanPart <em>Execution Plan Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart
     * @generated
     */
    public Adapter createExecutionPlanPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionPlanPrm <em>Execution Plan Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm
     * @generated
     */
    public Adapter createExecutionPlanPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm <em>Execution Plan Part Cmd Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm
     * @generated
     */
    public Adapter createExecutionPlanPartCmdPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm <em>Execution Plan Part Job Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm
     * @generated
     */
    public Adapter createExecutionPlanPartJobPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionTask
     * @generated
     */
    public Adapter createExecutionTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionTaskProperties <em>Execution Task Properties</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties
     * @generated
     */
    public Adapter createExecutionTaskPropertiesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm <em>Execution Task Cmd Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm
     * @generated
     */
    public Adapter createExecutionTaskCmdPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm <em>Execution Task Job Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm
     * @generated
     */
    public Adapter createExecutionTaskJobPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.TaskExecutionHistory <em>Task Execution History</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory
     * @generated
     */
    public Adapter createTaskExecutionHistoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.PlanExecutionHistory <em>Plan Execution History</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.PlanExecutionHistory
     * @generated
     */
    public Adapter createPlanExecutionHistoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.TalendTrigger <em>Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.TalendTrigger
     * @generated
     */
    public Adapter createTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.CronTalendTrigger <em>Cron Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.CronTalendTrigger
     * @generated
     */
    public Adapter createCronTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.CronUITalendTrigger <em>Cron UI Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger
     * @generated
     */
    public Adapter createCronUITalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.SimpleTalendTrigger <em>Simple Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.SimpleTalendTrigger
     * @generated
     */
    public Adapter createSimpleTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.FileTrigger <em>File Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.FileTrigger
     * @generated
     */
    public Adapter createFileTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.FileTriggerMask <em>File Trigger Mask</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.FileTriggerMask
     * @generated
     */
    public Adapter createFileTriggerMaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionServer <em>Execution Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionServer
     * @generated
     */
    public Adapter createExecutionServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.conductor.ExecutionVirtualServer <em>Execution Virtual Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer
     * @generated
     */
    public Adapter createExecutionVirtualServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //ConductorAdapterFactory
