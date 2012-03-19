/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.conductor.ConductorPackage
 * @generated
 */
public interface ConductorFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConductorFactory eINSTANCE = org.talend.model.tac.conductor.impl.ConductorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Execution Plan</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Plan</em>'.
     * @generated
     */
    ExecutionPlan createExecutionPlan();

    /**
     * Returns a new object of class '<em>Execution Plan Part</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Plan Part</em>'.
     * @generated
     */
    ExecutionPlanPart createExecutionPlanPart();

    /**
     * Returns a new object of class '<em>Execution Plan Prm</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Plan Prm</em>'.
     * @generated
     */
    ExecutionPlanPrm createExecutionPlanPrm();

    /**
     * Returns a new object of class '<em>Execution Plan Part Cmd Prm</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Plan Part Cmd Prm</em>'.
     * @generated
     */
    ExecutionPlanPartCmdPrm createExecutionPlanPartCmdPrm();

    /**
     * Returns a new object of class '<em>Execution Plan Part Job Prm</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Plan Part Job Prm</em>'.
     * @generated
     */
    ExecutionPlanPartJobPrm createExecutionPlanPartJobPrm();

    /**
     * Returns a new object of class '<em>Execution Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Task</em>'.
     * @generated
     */
    ExecutionTask createExecutionTask();

    /**
     * Returns a new object of class '<em>Execution Task Properties</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Task Properties</em>'.
     * @generated
     */
    ExecutionTaskProperties createExecutionTaskProperties();

    /**
     * Returns a new object of class '<em>Execution Task Cmd Prm</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Task Cmd Prm</em>'.
     * @generated
     */
    ExecutionTaskCmdPrm createExecutionTaskCmdPrm();

    /**
     * Returns a new object of class '<em>Execution Task Job Prm</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Task Job Prm</em>'.
     * @generated
     */
    ExecutionTaskJobPrm createExecutionTaskJobPrm();

    /**
     * Returns a new object of class '<em>Task Execution History</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Task Execution History</em>'.
     * @generated
     */
    TaskExecutionHistory createTaskExecutionHistory();

    /**
     * Returns a new object of class '<em>Plan Execution History</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Plan Execution History</em>'.
     * @generated
     */
    PlanExecutionHistory createPlanExecutionHistory();

    /**
     * Returns a new object of class '<em>Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Talend Trigger</em>'.
     * @generated
     */
    TalendTrigger createTalendTrigger();

    /**
     * Returns a new object of class '<em>Cron Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Cron Talend Trigger</em>'.
     * @generated
     */
    CronTalendTrigger createCronTalendTrigger();

    /**
     * Returns a new object of class '<em>Cron UI Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Cron UI Talend Trigger</em>'.
     * @generated
     */
    CronUITalendTrigger createCronUITalendTrigger();

    /**
     * Returns a new object of class '<em>Simple Talend Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Talend Trigger</em>'.
     * @generated
     */
    SimpleTalendTrigger createSimpleTalendTrigger();

    /**
     * Returns a new object of class '<em>File Trigger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>File Trigger</em>'.
     * @generated
     */
    FileTrigger createFileTrigger();

    /**
     * Returns a new object of class '<em>File Trigger Mask</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>File Trigger Mask</em>'.
     * @generated
     */
    FileTriggerMask createFileTriggerMask();

    /**
     * Returns a new object of class '<em>Execution Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Server</em>'.
     * @generated
     */
    ExecutionServer createExecutionServer();

    /**
     * Returns a new object of class '<em>Execution Virtual Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execution Virtual Server</em>'.
     * @generated
     */
    ExecutionVirtualServer createExecutionVirtualServer();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ConductorPackage getConductorPackage();

} //ConductorFactory
