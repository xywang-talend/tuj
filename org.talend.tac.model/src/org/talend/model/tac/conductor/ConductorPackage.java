/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.conductor.ConductorFactory
 * @model kind="package"
 * @generated
 */
public interface ConductorPackage extends EPackage {

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "conductor";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.talend.org/tac/conductor";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "conductor";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConductorPackage eINSTANCE = org.talend.model.tac.conductor.impl.ConductorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.ExecutionTriggerable <em>Execution Triggerable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.ExecutionTriggerable
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTriggerable()
     * @generated
     */
    int EXECUTION_TRIGGERABLE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__ID = 0;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__TRIGGERS = 1;

    /**
     * The feature id for the '<em><b>Id Quartz Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__ID_QUARTZ_JOB = 2;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__STATUS = 3;

    /**
     * The feature id for the '<em><b>Error Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__ERROR_STATUS = 4;

    /**
     * The feature id for the '<em><b>Concurrent Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__CONCURRENT_EXECUTION = 5;

    /**
     * The feature id for the '<em><b>Processing State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__PROCESSING_STATE = 6;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE__REQUEST_ID = 7;

    /**
     * The number of structural features of the '<em>Execution Triggerable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TRIGGERABLE_FEATURE_COUNT = 8;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanImpl <em>Execution Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionPlanImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlan()
     * @generated
     */
    int EXECUTION_PLAN = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__ID = EXECUTION_TRIGGERABLE__ID;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__TRIGGERS = EXECUTION_TRIGGERABLE__TRIGGERS;

    /**
     * The feature id for the '<em><b>Id Quartz Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__ID_QUARTZ_JOB = EXECUTION_TRIGGERABLE__ID_QUARTZ_JOB;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__STATUS = EXECUTION_TRIGGERABLE__STATUS;

    /**
     * The feature id for the '<em><b>Error Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__ERROR_STATUS = EXECUTION_TRIGGERABLE__ERROR_STATUS;

    /**
     * The feature id for the '<em><b>Concurrent Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__CONCURRENT_EXECUTION = EXECUTION_TRIGGERABLE__CONCURRENT_EXECUTION;

    /**
     * The feature id for the '<em><b>Processing State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__PROCESSING_STATE = EXECUTION_TRIGGERABLE__PROCESSING_STATE;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__REQUEST_ID = EXECUTION_TRIGGERABLE__REQUEST_ID;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__LABEL = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exec Plan Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__EXEC_PLAN_PARTS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Exec Plan Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__EXEC_PLAN_PRMS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN__DESCRIPTION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Execution Plan</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_FEATURE_COUNT = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartImpl <em>Execution Plan Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPart()
     * @generated
     */
    int EXECUTION_PLAN_PART = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__ID = 0;

    /**
     * The feature id for the '<em><b>Task</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__TASK = 1;

    /**
     * The feature id for the '<em><b>Execution Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__EXECUTION_PLAN = 2;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__PARENT = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__TYPE = 4;

    /**
     * The feature id for the '<em><b>Jvm Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__JVM_PRMS = 5;

    /**
     * The feature id for the '<em><b>Context Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__CONTEXT_PRMS = 6;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__STATUS = 7;

    /**
     * The feature id for the '<em><b>Start Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__START_DATE = 8;

    /**
     * The feature id for the '<em><b>End Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__END_DATE = 9;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__REQUEST_ID = 10;

    /**
     * The feature id for the '<em><b>Use Parallel</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__USE_PARALLEL = 11;

    /**
     * The feature id for the '<em><b>Max Threads</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART__MAX_THREADS = 12;

    /**
     * The number of structural features of the '<em>Execution Plan Part</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl <em>Execution Plan Prm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPrm()
     * @generated
     */
    int EXECUTION_PLAN_PRM = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PRM__ID = 0;

    /**
     * The feature id for the '<em><b>Execution Plan</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PRM__EXECUTION_PLAN = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PRM__NAME = 2;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PRM__VALUE = 3;

    /**
     * The number of structural features of the '<em>Execution Plan Prm</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PRM_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartCmdPrmImpl <em>Execution Plan Part Cmd Prm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartCmdPrmImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPartCmdPrm()
     * @generated
     */
    int EXECUTION_PLAN_PART_CMD_PRM = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_CMD_PRM__ID = 0;

    /**
     * The feature id for the '<em><b>Execution Plan Part</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_CMD_PRM__EXECUTION_PLAN_PART = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_CMD_PRM__NAME = 2;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_CMD_PRM__VALUE = 3;

    /**
     * The number of structural features of the '<em>Execution Plan Part Cmd Prm</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_CMD_PRM_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartJobPrmImpl <em>Execution Plan Part Job Prm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartJobPrmImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPartJobPrm()
     * @generated
     */
    int EXECUTION_PLAN_PART_JOB_PRM = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__ID = 0;

    /**
     * The feature id for the '<em><b>Execution Plan Part</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__EXECUTION_PLAN_PART = 1;

    /**
     * The feature id for the '<em><b>Override</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__OVERRIDE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__NAME = 3;

    /**
     * The feature id for the '<em><b>Custom Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__CUSTOM_VALUE = 4;

    /**
     * The feature id for the '<em><b>Part Custom Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM__PART_CUSTOM_VALUE = 5;

    /**
     * The number of structural features of the '<em>Execution Plan Part Job Prm</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_PLAN_PART_JOB_PRM_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskImpl <em>Execution Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionTaskImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTask()
     * @generated
     */
    int EXECUTION_TASK = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ID = EXECUTION_TRIGGERABLE__ID;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__TRIGGERS = EXECUTION_TRIGGERABLE__TRIGGERS;

    /**
     * The feature id for the '<em><b>Id Quartz Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ID_QUARTZ_JOB = EXECUTION_TRIGGERABLE__ID_QUARTZ_JOB;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__STATUS = EXECUTION_TRIGGERABLE__STATUS;

    /**
     * The feature id for the '<em><b>Error Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ERROR_STATUS = EXECUTION_TRIGGERABLE__ERROR_STATUS;

    /**
     * The feature id for the '<em><b>Concurrent Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__CONCURRENT_EXECUTION = EXECUTION_TRIGGERABLE__CONCURRENT_EXECUTION;

    /**
     * The feature id for the '<em><b>Processing State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__PROCESSING_STATE = EXECUTION_TRIGGERABLE__PROCESSING_STATE;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__REQUEST_ID = EXECUTION_TRIGGERABLE__REQUEST_ID;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LABEL = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__DESCRIPTION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Execution Server</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__EXECUTION_SERVER = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__PROJECT = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__BRANCH = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__CONTEXT = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Job Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__JOB_VERSION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Regenerate Job On Change</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__REGENERATE_JOB_ON_CHANGE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ACTIVE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Last Script Generation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LAST_SCRIPT_GENERATION_DATE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Generated Svn Revision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__GENERATED_SVN_REVISION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Id Remote Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ID_REMOTE_JOB = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Id Remote Job Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ID_REMOTE_JOB_EXECUTION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Checksum Archive</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__CHECKSUM_ARCHIVE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Job Script Archive Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__JOB_SCRIPT_ARCHIVE_FILENAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Last Run Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LAST_RUN_DATE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Last Deployment Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LAST_DEPLOYMENT_DATE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>Last Ended Run Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LAST_ENDED_RUN_DATE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 17;

    /**
     * The feature id for the '<em><b>Cmd Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__CMD_PRMS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 18;

    /**
     * The feature id for the '<em><b>Esb Properties Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ESB_PROPERTIES_PRMS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 19;

    /**
     * The feature id for the '<em><b>Job Prms</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__JOB_PRMS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 20;

    /**
     * The feature id for the '<em><b>Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__JOB_ID = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 21;

    /**
     * The feature id for the '<em><b>Virtual Server</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__VIRTUAL_SERVER = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 22;

    /**
     * The feature id for the '<em><b>Max Concurrent Executions</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__MAX_CONCURRENT_EXECUTIONS = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 23;

    /**
     * The feature id for the '<em><b>Generated Project Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__GENERATED_PROJECT_NAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 24;

    /**
     * The feature id for the '<em><b>Generated Job Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__GENERATED_JOB_NAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 25;

    /**
     * The feature id for the '<em><b>Generated Job Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__GENERATED_JOB_VERSION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 26;

    /**
     * The feature id for the '<em><b>Apply Context To Children</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__APPLY_CONTEXT_TO_CHILDREN = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 27;

    /**
     * The feature id for the '<em><b>Error Stack Trace</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ERROR_STACK_TRACE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 28;

    /**
     * The feature id for the '<em><b>Last Triggering Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__LAST_TRIGGERING_DATE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 29;

    /**
     * The feature id for the '<em><b>Exec Statistics Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__EXEC_STATISTICS_ENABLED = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 30;

    /**
     * The feature id for the '<em><b>Add Statistics Code Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ADD_STATISTICS_CODE_ENABLED = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 31;

    /**
     * The feature id for the '<em><b>Owner Scheduler Instance Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__OWNER_SCHEDULER_INSTANCE_ID = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 32;

    /**
     * The feature id for the '<em><b>On Unknown State Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__ON_UNKNOWN_STATE_JOB = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 33;

    /**
     * The feature id for the '<em><b>Use Latest Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__USE_LATEST_VERSION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 34;

    /**
     * The feature id for the '<em><b>Application Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__APPLICATION_TYPE = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 35;

    /**
     * The feature id for the '<em><b>Repository Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__REPOSITORY_NAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 36;

    /**
     * The feature id for the '<em><b>Features File Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__FEATURES_FILE_URL = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 37;

    /**
     * The feature id for the '<em><b>Feature Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__FEATURE_NAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 38;

    /**
     * The feature id for the '<em><b>Feature Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__FEATURE_VERSION = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 39;

    /**
     * The feature id for the '<em><b>Application Group</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__APPLICATION_GROUP = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 40;

    /**
     * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__BUNDLE_NAME = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 41;

    /**
     * The feature id for the '<em><b>Property Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK__PROPERTY_ID = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 42;

    /**
     * The number of structural features of the '<em>Execution Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_FEATURE_COUNT = EXECUTION_TRIGGERABLE_FEATURE_COUNT + 43;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl <em>Execution Task Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskProperties()
     * @generated
     */
    int EXECUTION_TASK_PROPERTIES = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_PROPERTIES__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_PROPERTIES__NAME = 1;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_PROPERTIES__VALUE = 2;

    /**
     * The feature id for the '<em><b>Execution Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_PROPERTIES__EXECUTION_TASK = 3;

    /**
     * The number of structural features of the '<em>Execution Task Properties</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_PROPERTIES_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskCmdPrmImpl <em>Execution Task Cmd Prm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionTaskCmdPrmImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskCmdPrm()
     * @generated
     */
    int EXECUTION_TASK_CMD_PRM = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM__ID = 0;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM__ACTIVE = 1;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM__PARAMETER = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Execution Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM__EXECUTION_TASK = 4;

    /**
     * The number of structural features of the '<em>Execution Task Cmd Prm</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_CMD_PRM_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskJobPrmImpl <em>Execution Task Job Prm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionTaskJobPrmImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskJobPrm()
     * @generated
     */
    int EXECUTION_TASK_JOB_PRM = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__LABEL = 1;

    /**
     * The feature id for the '<em><b>Override</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__OVERRIDE = 2;

    /**
     * The feature id for the '<em><b>Execution Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__EXECUTION_TASK = 3;

    /**
     * The feature id for the '<em><b>Original Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__ORIGINAL_VALUE = 4;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__DEFAULT_VALUE = 5;

    /**
     * The feature id for the '<em><b>Item Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM__ITEM_TYPE = 6;

    /**
     * The number of structural features of the '<em>Execution Task Job Prm</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_TASK_JOB_PRM_FEATURE_COUNT = 7;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.TaskExecutionHistoryImpl <em>Task Execution History</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.TaskExecutionHistoryImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getTaskExecutionHistory()
     * @generated
     */
    int TASK_EXECUTION_HISTORY = 10;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__ID = 0;

    /**
     * The feature id for the '<em><b>Basic Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__BASIC_STATUS = 1;

    /**
     * The feature id for the '<em><b>Detailed Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__DETAILED_STATUS = 2;

    /**
     * The feature id for the '<em><b>Task Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TASK_LABEL = 3;

    /**
     * The feature id for the '<em><b>Task Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TASK_DESCRIPTION = 4;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__PROJECT_NAME = 5;

    /**
     * The feature id for the '<em><b>Talend Job Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TALEND_JOB_NAME = 6;

    /**
     * The feature id for the '<em><b>Talend Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TALEND_JOB_ID = 7;

    /**
     * The feature id for the '<em><b>Talend Job Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TALEND_JOB_VERSION = 8;

    /**
     * The feature id for the '<em><b>Context Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__CONTEXT_NAME = 9;

    /**
     * The feature id for the '<em><b>Virtual Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__VIRTUAL_SERVER_NAME = 10;

    /**
     * The feature id for the '<em><b>Execution Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXECUTION_SERVER_NAME = 11;

    /**
     * The feature id for the '<em><b>Execution Server Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXECUTION_SERVER_HOST = 12;

    /**
     * The feature id for the '<em><b>Execution Server Cmd Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXECUTION_SERVER_CMD_PORT = 13;

    /**
     * The feature id for the '<em><b>Execution Server File Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXECUTION_SERVER_FILE_PORT = 14;

    /**
     * The feature id for the '<em><b>Execution Server Monitoring Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXECUTION_SERVER_MONITORING_PORT = 15;

    /**
     * The feature id for the '<em><b>Apply Context To Children</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__APPLY_CONTEXT_TO_CHILDREN = 16;

    /**
     * The feature id for the '<em><b>Triggered By</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TRIGGERED_BY = 17;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TRIGGER_TYPE = 18;

    /**
     * The feature id for the '<em><b>Trigger Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TRIGGER_NAME = 19;

    /**
     * The feature id for the '<em><b>Trigger Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TRIGGER_DESCRIPTION = 20;

    /**
     * The feature id for the '<em><b>Task Error Stack Trace</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TASK_ERROR_STACK_TRACE = 21;

    /**
     * The feature id for the '<em><b>Id Quartz Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__ID_QUARTZ_JOB = 22;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__ID_QUARTZ_TRIGGER = 23;

    /**
     * The feature id for the '<em><b>Last Job Generation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__LAST_JOB_GENERATION_DATE = 24;

    /**
     * The feature id for the '<em><b>Job Archive Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__JOB_ARCHIVE_FILENAME = 25;

    /**
     * The feature id for the '<em><b>File Trigger File Mask</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_MASK = 26;

    /**
     * The feature id for the '<em><b>File Trigger File Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_NAME = 27;

    /**
     * The feature id for the '<em><b>File Trigger Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__FILE_TRIGGER_FOLDER_PATH = 28;

    /**
     * The feature id for the '<em><b>File Trigger Triggered File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__FILE_TRIGGER_TRIGGERED_FILE_PATH = 29;

    /**
     * The feature id for the '<em><b>Expected Triggering Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__EXPECTED_TRIGGERING_DATE = 30;

    /**
     * The feature id for the '<em><b>Task Start Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TASK_START_DATE = 31;

    /**
     * The feature id for the '<em><b>Task End Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__TASK_END_DATE = 32;

    /**
     * The feature id for the '<em><b>Server Job Start Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__SERVER_JOB_START_DATE = 33;

    /**
     * The feature id for the '<em><b>Server Job End Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__SERVER_JOB_END_DATE = 34;

    /**
     * The feature id for the '<em><b>Id Remote Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__ID_REMOTE_JOB = 35;

    /**
     * The feature id for the '<em><b>Id Remote Job Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__ID_REMOTE_JOB_EXECUTION = 36;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__REQUEST_ID = 37;

    /**
     * The feature id for the '<em><b>Resuming Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__RESUMING_MODE = 38;

    /**
     * The feature id for the '<em><b>Context Values</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__CONTEXT_VALUES = 39;

    /**
     * The feature id for the '<em><b>Jvm Values</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__JVM_VALUES = 40;

    /**
     * The feature id for the '<em><b>Parent Task Exec Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__PARENT_TASK_EXEC_ID = 41;

    /**
     * The feature id for the '<em><b>Parent Plan Exec Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY__PARENT_PLAN_EXEC_ID = 42;

    /**
     * The number of structural features of the '<em>Task Execution History</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_EXECUTION_HISTORY_FEATURE_COUNT = 43;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl <em>Plan Execution History</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getPlanExecutionHistory()
     * @generated
     */
    int PLAN_EXECUTION_HISTORY = 11;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ID = TASK_EXECUTION_HISTORY__ID;

    /**
     * The feature id for the '<em><b>Basic Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__BASIC_STATUS = TASK_EXECUTION_HISTORY__BASIC_STATUS;

    /**
     * The feature id for the '<em><b>Detailed Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__DETAILED_STATUS = TASK_EXECUTION_HISTORY__DETAILED_STATUS;

    /**
     * The feature id for the '<em><b>Task Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TASK_LABEL = TASK_EXECUTION_HISTORY__TASK_LABEL;

    /**
     * The feature id for the '<em><b>Task Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TASK_DESCRIPTION = TASK_EXECUTION_HISTORY__TASK_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__PROJECT_NAME = TASK_EXECUTION_HISTORY__PROJECT_NAME;

    /**
     * The feature id for the '<em><b>Talend Job Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TALEND_JOB_NAME = TASK_EXECUTION_HISTORY__TALEND_JOB_NAME;

    /**
     * The feature id for the '<em><b>Talend Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TALEND_JOB_ID = TASK_EXECUTION_HISTORY__TALEND_JOB_ID;

    /**
     * The feature id for the '<em><b>Talend Job Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TALEND_JOB_VERSION = TASK_EXECUTION_HISTORY__TALEND_JOB_VERSION;

    /**
     * The feature id for the '<em><b>Context Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__CONTEXT_NAME = TASK_EXECUTION_HISTORY__CONTEXT_NAME;

    /**
     * The feature id for the '<em><b>Virtual Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__VIRTUAL_SERVER_NAME = TASK_EXECUTION_HISTORY__VIRTUAL_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Execution Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXECUTION_SERVER_NAME = TASK_EXECUTION_HISTORY__EXECUTION_SERVER_NAME;

    /**
     * The feature id for the '<em><b>Execution Server Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXECUTION_SERVER_HOST = TASK_EXECUTION_HISTORY__EXECUTION_SERVER_HOST;

    /**
     * The feature id for the '<em><b>Execution Server Cmd Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXECUTION_SERVER_CMD_PORT = TASK_EXECUTION_HISTORY__EXECUTION_SERVER_CMD_PORT;

    /**
     * The feature id for the '<em><b>Execution Server File Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXECUTION_SERVER_FILE_PORT = TASK_EXECUTION_HISTORY__EXECUTION_SERVER_FILE_PORT;

    /**
     * The feature id for the '<em><b>Execution Server Monitoring Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXECUTION_SERVER_MONITORING_PORT = TASK_EXECUTION_HISTORY__EXECUTION_SERVER_MONITORING_PORT;

    /**
     * The feature id for the '<em><b>Apply Context To Children</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__APPLY_CONTEXT_TO_CHILDREN = TASK_EXECUTION_HISTORY__APPLY_CONTEXT_TO_CHILDREN;

    /**
     * The feature id for the '<em><b>Triggered By</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TRIGGERED_BY = TASK_EXECUTION_HISTORY__TRIGGERED_BY;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TRIGGER_TYPE = TASK_EXECUTION_HISTORY__TRIGGER_TYPE;

    /**
     * The feature id for the '<em><b>Trigger Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TRIGGER_NAME = TASK_EXECUTION_HISTORY__TRIGGER_NAME;

    /**
     * The feature id for the '<em><b>Trigger Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TRIGGER_DESCRIPTION = TASK_EXECUTION_HISTORY__TRIGGER_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Task Error Stack Trace</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TASK_ERROR_STACK_TRACE = TASK_EXECUTION_HISTORY__TASK_ERROR_STACK_TRACE;

    /**
     * The feature id for the '<em><b>Id Quartz Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ID_QUARTZ_JOB = TASK_EXECUTION_HISTORY__ID_QUARTZ_JOB;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ID_QUARTZ_TRIGGER = TASK_EXECUTION_HISTORY__ID_QUARTZ_TRIGGER;

    /**
     * The feature id for the '<em><b>Last Job Generation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__LAST_JOB_GENERATION_DATE = TASK_EXECUTION_HISTORY__LAST_JOB_GENERATION_DATE;

    /**
     * The feature id for the '<em><b>Job Archive Filename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__JOB_ARCHIVE_FILENAME = TASK_EXECUTION_HISTORY__JOB_ARCHIVE_FILENAME;

    /**
     * The feature id for the '<em><b>File Trigger File Mask</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__FILE_TRIGGER_FILE_MASK = TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_MASK;

    /**
     * The feature id for the '<em><b>File Trigger File Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__FILE_TRIGGER_FILE_NAME = TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_NAME;

    /**
     * The feature id for the '<em><b>File Trigger Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__FILE_TRIGGER_FOLDER_PATH = TASK_EXECUTION_HISTORY__FILE_TRIGGER_FOLDER_PATH;

    /**
     * The feature id for the '<em><b>File Trigger Triggered File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__FILE_TRIGGER_TRIGGERED_FILE_PATH = TASK_EXECUTION_HISTORY__FILE_TRIGGER_TRIGGERED_FILE_PATH;

    /**
     * The feature id for the '<em><b>Expected Triggering Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__EXPECTED_TRIGGERING_DATE = TASK_EXECUTION_HISTORY__EXPECTED_TRIGGERING_DATE;

    /**
     * The feature id for the '<em><b>Task Start Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TASK_START_DATE = TASK_EXECUTION_HISTORY__TASK_START_DATE;

    /**
     * The feature id for the '<em><b>Task End Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__TASK_END_DATE = TASK_EXECUTION_HISTORY__TASK_END_DATE;

    /**
     * The feature id for the '<em><b>Server Job Start Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__SERVER_JOB_START_DATE = TASK_EXECUTION_HISTORY__SERVER_JOB_START_DATE;

    /**
     * The feature id for the '<em><b>Server Job End Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__SERVER_JOB_END_DATE = TASK_EXECUTION_HISTORY__SERVER_JOB_END_DATE;

    /**
     * The feature id for the '<em><b>Id Remote Job</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ID_REMOTE_JOB = TASK_EXECUTION_HISTORY__ID_REMOTE_JOB;

    /**
     * The feature id for the '<em><b>Id Remote Job Execution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ID_REMOTE_JOB_EXECUTION = TASK_EXECUTION_HISTORY__ID_REMOTE_JOB_EXECUTION;

    /**
     * The feature id for the '<em><b>Request Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__REQUEST_ID = TASK_EXECUTION_HISTORY__REQUEST_ID;

    /**
     * The feature id for the '<em><b>Resuming Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__RESUMING_MODE = TASK_EXECUTION_HISTORY__RESUMING_MODE;

    /**
     * The feature id for the '<em><b>Context Values</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__CONTEXT_VALUES = TASK_EXECUTION_HISTORY__CONTEXT_VALUES;

    /**
     * The feature id for the '<em><b>Jvm Values</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__JVM_VALUES = TASK_EXECUTION_HISTORY__JVM_VALUES;

    /**
     * The feature id for the '<em><b>Parent Task Exec Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__PARENT_TASK_EXEC_ID = TASK_EXECUTION_HISTORY__PARENT_TASK_EXEC_ID;

    /**
     * The feature id for the '<em><b>Parent Plan Exec Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__PARENT_PLAN_EXEC_ID = TASK_EXECUTION_HISTORY__PARENT_PLAN_EXEC_ID;

    /**
     * The feature id for the '<em><b>Original Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL = TASK_EXECUTION_HISTORY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Current Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY__CURRENT_LABEL = TASK_EXECUTION_HISTORY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Plan Execution History</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAN_EXECUTION_HISTORY_FEATURE_COUNT = TASK_EXECUTION_HISTORY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.TalendTriggerImpl <em>Talend Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.TalendTriggerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getTalendTrigger()
     * @generated
     */
    int TALEND_TRIGGER = 12;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__ID = 0;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__ACTIVE = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__LABEL = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__TRIGGER_TYPE = 4;

    /**
     * The feature id for the '<em><b>Execution Triggerable</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__EXECUTION_TRIGGERABLE = 5;

    /**
     * The feature id for the '<em><b>Start Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__START_TIME = 6;

    /**
     * The feature id for the '<em><b>End Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__END_TIME = 7;

    /**
     * The feature id for the '<em><b>Previous Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__PREVIOUS_FIRE_TIME = 8;

    /**
     * The feature id for the '<em><b>Final Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__FINAL_FIRE_TIME = 9;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__ID_QUARTZ_TRIGGER = 10;

    /**
     * The feature id for the '<em><b>Resume Pause Updated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__RESUME_PAUSE_UPDATED = 11;

    /**
     * The feature id for the '<em><b>Previously Paused</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER__PREVIOUSLY_PAUSED = 12;

    /**
     * The number of structural features of the '<em>Talend Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TALEND_TRIGGER_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.CronTalendTriggerImpl <em>Cron Talend Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.CronTalendTriggerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getCronTalendTrigger()
     * @generated
     */
    int CRON_TALEND_TRIGGER = 13;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__ID = TALEND_TRIGGER__ID;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__ACTIVE = TALEND_TRIGGER__ACTIVE;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__LABEL = TALEND_TRIGGER__LABEL;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__DESCRIPTION = TALEND_TRIGGER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__TRIGGER_TYPE = TALEND_TRIGGER__TRIGGER_TYPE;

    /**
     * The feature id for the '<em><b>Execution Triggerable</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__EXECUTION_TRIGGERABLE = TALEND_TRIGGER__EXECUTION_TRIGGERABLE;

    /**
     * The feature id for the '<em><b>Start Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__START_TIME = TALEND_TRIGGER__START_TIME;

    /**
     * The feature id for the '<em><b>End Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__END_TIME = TALEND_TRIGGER__END_TIME;

    /**
     * The feature id for the '<em><b>Previous Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__PREVIOUS_FIRE_TIME = TALEND_TRIGGER__PREVIOUS_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Final Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__FINAL_FIRE_TIME = TALEND_TRIGGER__FINAL_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__ID_QUARTZ_TRIGGER = TALEND_TRIGGER__ID_QUARTZ_TRIGGER;

    /**
     * The feature id for the '<em><b>Resume Pause Updated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__RESUME_PAUSE_UPDATED = TALEND_TRIGGER__RESUME_PAUSE_UPDATED;

    /**
     * The feature id for the '<em><b>Previously Paused</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__PREVIOUSLY_PAUSED = TALEND_TRIGGER__PREVIOUSLY_PAUSED;

    /**
     * The feature id for the '<em><b>Cron Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER__CRON_EXPRESSION = TALEND_TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Cron Talend Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_TALEND_TRIGGER_FEATURE_COUNT = TALEND_TRIGGER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.CronUITalendTriggerImpl <em>Cron UI Talend Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.CronUITalendTriggerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getCronUITalendTrigger()
     * @generated
     */
    int CRON_UI_TALEND_TRIGGER = 14;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__ID = TALEND_TRIGGER__ID;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__ACTIVE = TALEND_TRIGGER__ACTIVE;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LABEL = TALEND_TRIGGER__LABEL;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__DESCRIPTION = TALEND_TRIGGER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__TRIGGER_TYPE = TALEND_TRIGGER__TRIGGER_TYPE;

    /**
     * The feature id for the '<em><b>Execution Triggerable</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__EXECUTION_TRIGGERABLE = TALEND_TRIGGER__EXECUTION_TRIGGERABLE;

    /**
     * The feature id for the '<em><b>Start Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__START_TIME = TALEND_TRIGGER__START_TIME;

    /**
     * The feature id for the '<em><b>End Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__END_TIME = TALEND_TRIGGER__END_TIME;

    /**
     * The feature id for the '<em><b>Previous Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__PREVIOUS_FIRE_TIME = TALEND_TRIGGER__PREVIOUS_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Final Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__FINAL_FIRE_TIME = TALEND_TRIGGER__FINAL_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__ID_QUARTZ_TRIGGER = TALEND_TRIGGER__ID_QUARTZ_TRIGGER;

    /**
     * The feature id for the '<em><b>Resume Pause Updated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__RESUME_PAUSE_UPDATED = TALEND_TRIGGER__RESUME_PAUSE_UPDATED;

    /**
     * The feature id for the '<em><b>Previously Paused</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__PREVIOUSLY_PAUSED = TALEND_TRIGGER__PREVIOUSLY_PAUSED;

    /**
     * The feature id for the '<em><b>List Days Of Week</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_WEEK = TALEND_TRIGGER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>List Days Of Month</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_MONTH = TALEND_TRIGGER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>List Months</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_MONTHS = TALEND_TRIGGER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>List Years</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_YEARS = TALEND_TRIGGER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>List Hours</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_HOURS = TALEND_TRIGGER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>List Minutes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER__LIST_MINUTES = TALEND_TRIGGER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Cron UI Talend Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CRON_UI_TALEND_TRIGGER_FEATURE_COUNT = TALEND_TRIGGER_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.SimpleTalendTriggerImpl <em>Simple Talend Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.SimpleTalendTriggerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getSimpleTalendTrigger()
     * @generated
     */
    int SIMPLE_TALEND_TRIGGER = 15;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__ID = TALEND_TRIGGER__ID;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__ACTIVE = TALEND_TRIGGER__ACTIVE;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__LABEL = TALEND_TRIGGER__LABEL;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__DESCRIPTION = TALEND_TRIGGER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__TRIGGER_TYPE = TALEND_TRIGGER__TRIGGER_TYPE;

    /**
     * The feature id for the '<em><b>Execution Triggerable</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__EXECUTION_TRIGGERABLE = TALEND_TRIGGER__EXECUTION_TRIGGERABLE;

    /**
     * The feature id for the '<em><b>Start Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__START_TIME = TALEND_TRIGGER__START_TIME;

    /**
     * The feature id for the '<em><b>End Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__END_TIME = TALEND_TRIGGER__END_TIME;

    /**
     * The feature id for the '<em><b>Previous Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__PREVIOUS_FIRE_TIME = TALEND_TRIGGER__PREVIOUS_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Final Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__FINAL_FIRE_TIME = TALEND_TRIGGER__FINAL_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__ID_QUARTZ_TRIGGER = TALEND_TRIGGER__ID_QUARTZ_TRIGGER;

    /**
     * The feature id for the '<em><b>Resume Pause Updated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__RESUME_PAUSE_UPDATED = TALEND_TRIGGER__RESUME_PAUSE_UPDATED;

    /**
     * The feature id for the '<em><b>Previously Paused</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__PREVIOUSLY_PAUSED = TALEND_TRIGGER__PREVIOUSLY_PAUSED;

    /**
     * The feature id for the '<em><b>Repeat Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__REPEAT_COUNT = TALEND_TRIGGER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Repeat Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__REPEAT_INTERVAL = TALEND_TRIGGER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Times Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER__TIMES_TRIGGERED = TALEND_TRIGGER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Simple Talend Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_TALEND_TRIGGER_FEATURE_COUNT = TALEND_TRIGGER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.FileTriggerImpl <em>File Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.FileTriggerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getFileTrigger()
     * @generated
     */
    int FILE_TRIGGER = 16;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__ID = SIMPLE_TALEND_TRIGGER__ID;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__ACTIVE = SIMPLE_TALEND_TRIGGER__ACTIVE;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__LABEL = SIMPLE_TALEND_TRIGGER__LABEL;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__DESCRIPTION = SIMPLE_TALEND_TRIGGER__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__TRIGGER_TYPE = SIMPLE_TALEND_TRIGGER__TRIGGER_TYPE;

    /**
     * The feature id for the '<em><b>Execution Triggerable</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__EXECUTION_TRIGGERABLE = SIMPLE_TALEND_TRIGGER__EXECUTION_TRIGGERABLE;

    /**
     * The feature id for the '<em><b>Start Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__START_TIME = SIMPLE_TALEND_TRIGGER__START_TIME;

    /**
     * The feature id for the '<em><b>End Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__END_TIME = SIMPLE_TALEND_TRIGGER__END_TIME;

    /**
     * The feature id for the '<em><b>Previous Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__PREVIOUS_FIRE_TIME = SIMPLE_TALEND_TRIGGER__PREVIOUS_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Final Fire Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__FINAL_FIRE_TIME = SIMPLE_TALEND_TRIGGER__FINAL_FIRE_TIME;

    /**
     * The feature id for the '<em><b>Id Quartz Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__ID_QUARTZ_TRIGGER = SIMPLE_TALEND_TRIGGER__ID_QUARTZ_TRIGGER;

    /**
     * The feature id for the '<em><b>Resume Pause Updated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__RESUME_PAUSE_UPDATED = SIMPLE_TALEND_TRIGGER__RESUME_PAUSE_UPDATED;

    /**
     * The feature id for the '<em><b>Previously Paused</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__PREVIOUSLY_PAUSED = SIMPLE_TALEND_TRIGGER__PREVIOUSLY_PAUSED;

    /**
     * The feature id for the '<em><b>Repeat Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__REPEAT_COUNT = SIMPLE_TALEND_TRIGGER__REPEAT_COUNT;

    /**
     * The feature id for the '<em><b>Repeat Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__REPEAT_INTERVAL = SIMPLE_TALEND_TRIGGER__REPEAT_INTERVAL;

    /**
     * The feature id for the '<em><b>Times Triggered</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__TIMES_TRIGGERED = SIMPLE_TALEND_TRIGGER__TIMES_TRIGGERED;

    /**
     * The feature id for the '<em><b>File Trigger Masks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER__FILE_TRIGGER_MASKS = SIMPLE_TALEND_TRIGGER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>File Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_FEATURE_COUNT = SIMPLE_TALEND_TRIGGER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.FileTriggerMaskImpl <em>File Trigger Mask</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.FileTriggerMaskImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getFileTriggerMask()
     * @generated
     */
    int FILE_TRIGGER_MASK = 17;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__ID = 0;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__ACTIVE = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__LABEL = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>File Trigger</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__FILE_TRIGGER = 4;

    /**
     * The feature id for the '<em><b>Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__FOLDER_PATH = 5;

    /**
     * The feature id for the '<em><b>File Mask</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__FILE_MASK = 6;

    /**
     * The feature id for the '<em><b>Context Parameter Base Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__CONTEXT_PARAMETER_BASE_NAME = 7;

    /**
     * The feature id for the '<em><b>Check File Server</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__CHECK_FILE_SERVER = 8;

    /**
     * The feature id for the '<em><b>Exist</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__EXIST = 9;

    /**
     * The feature id for the '<em><b>Created</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__CREATED = 10;

    /**
     * The feature id for the '<em><b>Modified</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK__MODIFIED = 11;

    /**
     * The number of structural features of the '<em>File Trigger Mask</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_TRIGGER_MASK_FEATURE_COUNT = 12;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionServerImpl <em>Execution Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionServerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionServer()
     * @generated
     */
    int EXECUTION_SERVER = 18;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__LABEL = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__HOST = 3;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__PORT = 4;

    /**
     * The feature id for the '<em><b>File Transfert Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__FILE_TRANSFERT_PORT = 5;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__ACTIVE = 6;

    /**
     * The feature id for the '<em><b>Monitoring Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__MONITORING_PORT = 7;

    /**
     * The feature id for the '<em><b>Timeout Unknown State</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__TIMEOUT_UNKNOWN_STATE = 8;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__USERNAME = 9;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__PASSWORD = 10;

    /**
     * The feature id for the '<em><b>Jmx Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__JMX_URL = 11;

    /**
     * The feature id for the '<em><b>Web Console Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__WEB_CONSOLE_URL = 12;

    /**
     * The feature id for the '<em><b>Talend Runtime</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__TALEND_RUNTIME = 13;

    /**
     * The feature id for the '<em><b>Mgmt Server Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__MGMT_SERVER_PORT = 14;

    /**
     * The feature id for the '<em><b>Mgmt Reg Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__MGMT_REG_PORT = 15;

    /**
     * The feature id for the '<em><b>Admin Console Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__ADMIN_CONSOLE_PORT = 16;

    /**
     * The feature id for the '<em><b>Use SSL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__USE_SSL = 17;

    /**
     * The feature id for the '<em><b>Instance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER__INSTANCE = 18;

    /**
     * The number of structural features of the '<em>Execution Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_SERVER_FEATURE_COUNT = 19;

    /**
     * The meta object id for the '{@link org.talend.model.tac.conductor.impl.ExecutionVirtualServerImpl <em>Execution Virtual Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.conductor.impl.ExecutionVirtualServerImpl
     * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionVirtualServer()
     * @generated
     */
    int EXECUTION_VIRTUAL_SERVER = 19;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER__LABEL = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER__ACTIVE = 3;

    /**
     * The feature id for the '<em><b>Execution Servers</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER__EXECUTION_SERVERS = 4;

    /**
     * The number of structural features of the '<em>Execution Virtual Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTION_VIRTUAL_SERVER_FEATURE_COUNT = 5;

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionTriggerable <em>Execution Triggerable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Triggerable</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable
     * @generated
     */
    EClass getExecutionTriggerable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getId()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_Id();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getTriggers <em>Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Triggers</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getTriggers()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EReference getExecutionTriggerable_Triggers();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getIdQuartzJob <em>Id Quartz Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Quartz Job</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getIdQuartzJob()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_IdQuartzJob();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Status</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getStatus()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_Status();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getErrorStatus <em>Error Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Error Status</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getErrorStatus()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_ErrorStatus();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#isConcurrentExecution <em>Concurrent Execution</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Concurrent Execution</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#isConcurrentExecution()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_ConcurrentExecution();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#isProcessingState <em>Processing State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Processing State</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#isProcessingState()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_ProcessingState();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTriggerable#getRequestId <em>Request Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Request Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTriggerable#getRequestId()
     * @see #getExecutionTriggerable()
     * @generated
     */
    EAttribute getExecutionTriggerable_RequestId();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionPlan <em>Execution Plan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Plan</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlan
     * @generated
     */
    EClass getExecutionPlan();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlan#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlan#getLabel()
     * @see #getExecutionPlan()
     * @generated
     */
    EAttribute getExecutionPlan_Label();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionPlan#getExecPlanParts <em>Exec Plan Parts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Exec Plan Parts</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlan#getExecPlanParts()
     * @see #getExecutionPlan()
     * @generated
     */
    EReference getExecutionPlan_ExecPlanParts();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionPlan#getExecPlanPrms <em>Exec Plan Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Exec Plan Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlan#getExecPlanPrms()
     * @see #getExecutionPlan()
     * @generated
     */
    EReference getExecutionPlan_ExecPlanPrms();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlan#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlan#getDescription()
     * @see #getExecutionPlan()
     * @generated
     */
    EAttribute getExecutionPlan_Description();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionPlanPart <em>Execution Plan Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Plan Part</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart
     * @generated
     */
    EClass getExecutionPlanPart();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getId()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_Id();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getTask <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Task</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getTask()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EReference getExecutionPlanPart_Task();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getExecutionPlan <em>Execution Plan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Execution Plan</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getExecutionPlan()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EReference getExecutionPlanPart_ExecutionPlan();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getParent()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EReference getExecutionPlanPart_Parent();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getType()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_Type();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getJvmPrms <em>Jvm Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jvm Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getJvmPrms()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EReference getExecutionPlanPart_JvmPrms();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getContextPrms <em>Context Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Context Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getContextPrms()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EReference getExecutionPlanPart_ContextPrms();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Status</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getStatus()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_Status();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getStartDate <em>Start Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getStartDate()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_StartDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getEndDate <em>End Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>End Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getEndDate()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_EndDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getRequestId <em>Request Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Request Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getRequestId()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_RequestId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#isUseParallel <em>Use Parallel</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Parallel</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#isUseParallel()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_UseParallel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPart#getMaxThreads <em>Max Threads</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Threads</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPart#getMaxThreads()
     * @see #getExecutionPlanPart()
     * @generated
     */
    EAttribute getExecutionPlanPart_MaxThreads();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionPlanPrm <em>Execution Plan Prm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Plan Prm</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm
     * @generated
     */
    EClass getExecutionPlanPrm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPrm#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm#getId()
     * @see #getExecutionPlanPrm()
     * @generated
     */
    EAttribute getExecutionPlanPrm_Id();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPrm#getExecutionPlan <em>Execution Plan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Execution Plan</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm#getExecutionPlan()
     * @see #getExecutionPlanPrm()
     * @generated
     */
    EReference getExecutionPlanPrm_ExecutionPlan();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPrm#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm#getName()
     * @see #getExecutionPlanPrm()
     * @generated
     */
    EAttribute getExecutionPlanPrm_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPrm#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPrm#getValue()
     * @see #getExecutionPlanPrm()
     * @generated
     */
    EAttribute getExecutionPlanPrm_Value();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm <em>Execution Plan Part Cmd Prm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Plan Part Cmd Prm</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm
     * @generated
     */
    EClass getExecutionPlanPartCmdPrm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getId()
     * @see #getExecutionPlanPartCmdPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartCmdPrm_Id();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getExecutionPlanPart <em>Execution Plan Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Execution Plan Part</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getExecutionPlanPart()
     * @see #getExecutionPlanPartCmdPrm()
     * @generated
     */
    EReference getExecutionPlanPartCmdPrm_ExecutionPlanPart();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getName()
     * @see #getExecutionPlanPartCmdPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartCmdPrm_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartCmdPrm#getValue()
     * @see #getExecutionPlanPartCmdPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartCmdPrm_Value();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm <em>Execution Plan Part Job Prm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Plan Part Job Prm</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm
     * @generated
     */
    EClass getExecutionPlanPartJobPrm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getId()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartJobPrm_Id();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getExecutionPlanPart <em>Execution Plan Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Execution Plan Part</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getExecutionPlanPart()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EReference getExecutionPlanPartJobPrm_ExecutionPlanPart();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#isOverride <em>Override</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Override</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#isOverride()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartJobPrm_Override();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getName()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartJobPrm_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getCustomValue <em>Custom Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Custom Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getCustomValue()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartJobPrm_CustomValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getPartCustomValue <em>Part Custom Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Part Custom Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionPlanPartJobPrm#getPartCustomValue()
     * @see #getExecutionPlanPartJobPrm()
     * @generated
     */
    EAttribute getExecutionPlanPartJobPrm_PartCustomValue();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Task</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask
     * @generated
     */
    EClass getExecutionTask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLabel()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getDescription()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_Description();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionTask#getExecutionServer <em>Execution Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Execution Server</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getExecutionServer()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_ExecutionServer();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionTask#getProject <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Project</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getProject()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_Project();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getBranch <em>Branch</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Branch</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getBranch()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_Branch();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getContext()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_Context();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getJobVersion <em>Job Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Version</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getJobVersion()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_JobVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isRegenerateJobOnChange <em>Regenerate Job On Change</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Regenerate Job On Change</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isRegenerateJobOnChange()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_RegenerateJobOnChange();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isActive()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLastScriptGenerationDate <em>Last Script Generation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Script Generation Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLastScriptGenerationDate()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_LastScriptGenerationDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getGeneratedSvnRevision <em>Generated Svn Revision</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generated Svn Revision</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getGeneratedSvnRevision()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_GeneratedSvnRevision();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getIdRemoteJob <em>Id Remote Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Remote Job</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getIdRemoteJob()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_IdRemoteJob();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getIdRemoteJobExecution <em>Id Remote Job Execution</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Remote Job Execution</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getIdRemoteJobExecution()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_IdRemoteJobExecution();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getChecksumArchive <em>Checksum Archive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Checksum Archive</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getChecksumArchive()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ChecksumArchive();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getJobScriptArchiveFilename <em>Job Script Archive Filename</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Script Archive Filename</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getJobScriptArchiveFilename()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_JobScriptArchiveFilename();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLastRunDate <em>Last Run Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Run Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLastRunDate()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_LastRunDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLastDeploymentDate <em>Last Deployment Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Deployment Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLastDeploymentDate()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_LastDeploymentDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLastEndedRunDate <em>Last Ended Run Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Ended Run Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLastEndedRunDate()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_LastEndedRunDate();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionTask#getCmdPrms <em>Cmd Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Cmd Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getCmdPrms()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_CmdPrms();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionTask#getEsbPropertiesPrms <em>Esb Properties Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Esb Properties Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getEsbPropertiesPrms()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_EsbPropertiesPrms();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.ExecutionTask#getJobPrms <em>Job Prms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Job Prms</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getJobPrms()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_JobPrms();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getJobId <em>Job Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getJobId()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_JobId();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.ExecutionTask#getVirtualServer <em>Virtual Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Virtual Server</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getVirtualServer()
     * @see #getExecutionTask()
     * @generated
     */
    EReference getExecutionTask_VirtualServer();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getMaxConcurrentExecutions <em>Max Concurrent Executions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Concurrent Executions</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getMaxConcurrentExecutions()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_MaxConcurrentExecutions();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getGeneratedProjectName <em>Generated Project Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generated Project Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getGeneratedProjectName()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_GeneratedProjectName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getGeneratedJobName <em>Generated Job Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generated Job Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getGeneratedJobName()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_GeneratedJobName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getGeneratedJobVersion <em>Generated Job Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Generated Job Version</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getGeneratedJobVersion()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_GeneratedJobVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isApplyContextToChildren <em>Apply Context To Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Apply Context To Children</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isApplyContextToChildren()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ApplyContextToChildren();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getErrorStackTrace <em>Error Stack Trace</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Error Stack Trace</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getErrorStackTrace()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ErrorStackTrace();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getLastTriggeringDate <em>Last Triggering Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Triggering Date</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getLastTriggeringDate()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_LastTriggeringDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isExecStatisticsEnabled <em>Exec Statistics Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exec Statistics Enabled</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isExecStatisticsEnabled()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ExecStatisticsEnabled();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isAddStatisticsCodeEnabled <em>Add Statistics Code Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Add Statistics Code Enabled</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isAddStatisticsCodeEnabled()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_AddStatisticsCodeEnabled();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getOwnerSchedulerInstanceId <em>Owner Scheduler Instance Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Owner Scheduler Instance Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getOwnerSchedulerInstanceId()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_OwnerSchedulerInstanceId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getOnUnknownStateJob <em>On Unknown State Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Unknown State Job</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getOnUnknownStateJob()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_OnUnknownStateJob();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#isUseLatestVersion <em>Use Latest Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Latest Version</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#isUseLatestVersion()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_UseLatestVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getApplicationType <em>Application Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Application Type</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getApplicationType()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ApplicationType();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getRepositoryName <em>Repository Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Repository Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getRepositoryName()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_RepositoryName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getFeaturesFileUrl <em>Features File Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Features File Url</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getFeaturesFileUrl()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_FeaturesFileUrl();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getFeatureName <em>Feature Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getFeatureName()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_FeatureName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getFeatureVersion <em>Feature Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature Version</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getFeatureVersion()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_FeatureVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getApplicationGroup <em>Application Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Application Group</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getApplicationGroup()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_ApplicationGroup();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getBundleName <em>Bundle Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Bundle Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getBundleName()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_BundleName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTask#getPropertyId <em>Property Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Property Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTask#getPropertyId()
     * @see #getExecutionTask()
     * @generated
     */
    EAttribute getExecutionTask_PropertyId();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionTaskProperties <em>Execution Task Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Task Properties</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties
     * @generated
     */
    EClass getExecutionTaskProperties();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties#getId()
     * @see #getExecutionTaskProperties()
     * @generated
     */
    EAttribute getExecutionTaskProperties_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties#getName()
     * @see #getExecutionTaskProperties()
     * @generated
     */
    EAttribute getExecutionTaskProperties_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties#getValue()
     * @see #getExecutionTaskProperties()
     * @generated
     */
    EAttribute getExecutionTaskProperties_Value();

    /**
     * Returns the meta object for the container reference '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Execution Task</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskProperties#getExecutionTask()
     * @see #getExecutionTaskProperties()
     * @generated
     */
    EReference getExecutionTaskProperties_ExecutionTask();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm <em>Execution Task Cmd Prm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Task Cmd Prm</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm
     * @generated
     */
    EClass getExecutionTaskCmdPrm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getId()
     * @see #getExecutionTaskCmdPrm()
     * @generated
     */
    EAttribute getExecutionTaskCmdPrm_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm#isActive()
     * @see #getExecutionTaskCmdPrm()
     * @generated
     */
    EAttribute getExecutionTaskCmdPrm_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameter</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getParameter()
     * @see #getExecutionTaskCmdPrm()
     * @generated
     */
    EAttribute getExecutionTaskCmdPrm_Parameter();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getDescription()
     * @see #getExecutionTaskCmdPrm()
     * @generated
     */
    EAttribute getExecutionTaskCmdPrm_Description();

    /**
     * Returns the meta object for the container reference '{@link org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Execution Task</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskCmdPrm#getExecutionTask()
     * @see #getExecutionTaskCmdPrm()
     * @generated
     */
    EReference getExecutionTaskCmdPrm_ExecutionTask();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm <em>Execution Task Job Prm</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Task Job Prm</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm
     * @generated
     */
    EClass getExecutionTaskJobPrm();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getId()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getLabel()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#isOverride <em>Override</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Override</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#isOverride()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_Override();

    /**
     * Returns the meta object for the container reference '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Execution Task</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getExecutionTask()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EReference getExecutionTaskJobPrm_ExecutionTask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getOriginalValue <em>Original Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Original Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getOriginalValue()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_OriginalValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getDefaultValue()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_DefaultValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionTaskJobPrm#getItemType <em>Item Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Type</em>'.
     * @see org.talend.model.tac.conductor.ExecutionTaskJobPrm#getItemType()
     * @see #getExecutionTaskJobPrm()
     * @generated
     */
    EAttribute getExecutionTaskJobPrm_ItemType();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.TaskExecutionHistory <em>Task Execution History</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Task Execution History</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory
     * @generated
     */
    EClass getTaskExecutionHistory();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getId()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getBasicStatus <em>Basic Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Basic Status</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getBasicStatus()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_BasicStatus();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getDetailedStatus <em>Detailed Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Detailed Status</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getDetailedStatus()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_DetailedStatus();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTaskLabel <em>Task Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task Label</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTaskLabel()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TaskLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTaskDescription <em>Task Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task Description</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTaskDescription()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TaskDescription();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getProjectName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ProjectName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobName <em>Talend Job Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Talend Job Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TalendJobName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobId <em>Talend Job Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Talend Job Id</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobId()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TalendJobId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobVersion <em>Talend Job Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Talend Job Version</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTalendJobVersion()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TalendJobVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getContextName <em>Context Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getContextName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ContextName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getVirtualServerName <em>Virtual Server Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Virtual Server Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getVirtualServerName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_VirtualServerName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerName <em>Execution Server Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Server Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExecutionServerName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerHost <em>Execution Server Host</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Server Host</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerHost()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExecutionServerHost();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerCmdPort <em>Execution Server Cmd Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Server Cmd Port</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerCmdPort()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExecutionServerCmdPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerFilePort <em>Execution Server File Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Server File Port</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerFilePort()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExecutionServerFilePort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerMonitoringPort <em>Execution Server Monitoring Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Execution Server Monitoring Port</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExecutionServerMonitoringPort()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExecutionServerMonitoringPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#isApplyContextToChildren <em>Apply Context To Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Apply Context To Children</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#isApplyContextToChildren()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ApplyContextToChildren();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTriggeredBy <em>Triggered By</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Triggered By</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTriggeredBy()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TriggeredBy();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerType <em>Trigger Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Type</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerType()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TriggerType();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerName <em>Trigger Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TriggerName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerDescription <em>Trigger Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Description</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTriggerDescription()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TriggerDescription();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTaskErrorStackTrace <em>Task Error Stack Trace</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task Error Stack Trace</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTaskErrorStackTrace()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TaskErrorStackTrace();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getIdQuartzJob <em>Id Quartz Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Quartz Job</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getIdQuartzJob()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_IdQuartzJob();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getIdQuartzTrigger <em>Id Quartz Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Quartz Trigger</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getIdQuartzTrigger()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_IdQuartzTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getLastJobGenerationDate <em>Last Job Generation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Job Generation Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getLastJobGenerationDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_LastJobGenerationDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getJobArchiveFilename <em>Job Archive Filename</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Archive Filename</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getJobArchiveFilename()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_JobArchiveFilename();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFileMask <em>File Trigger File Mask</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Trigger File Mask</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFileMask()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_FileTriggerFileMask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFileName <em>File Trigger File Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Trigger File Name</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFileName()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_FileTriggerFileName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFolderPath <em>File Trigger Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Trigger Folder Path</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerFolderPath()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_FileTriggerFolderPath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerTriggeredFilePath <em>File Trigger Triggered File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Trigger Triggered File Path</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getFileTriggerTriggeredFilePath()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_FileTriggerTriggeredFilePath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getExpectedTriggeringDate <em>Expected Triggering Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expected Triggering Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getExpectedTriggeringDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ExpectedTriggeringDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTaskStartDate <em>Task Start Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task Start Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTaskStartDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TaskStartDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getTaskEndDate <em>Task End Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task End Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getTaskEndDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_TaskEndDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getServerJobStartDate <em>Server Job Start Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Server Job Start Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getServerJobStartDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ServerJobStartDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getServerJobEndDate <em>Server Job End Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Server Job End Date</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getServerJobEndDate()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ServerJobEndDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getIdRemoteJob <em>Id Remote Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Remote Job</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getIdRemoteJob()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_IdRemoteJob();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getIdRemoteJobExecution <em>Id Remote Job Execution</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Remote Job Execution</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getIdRemoteJobExecution()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_IdRemoteJobExecution();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getRequestId <em>Request Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Request Id</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getRequestId()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_RequestId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#isResumingMode <em>Resuming Mode</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Resuming Mode</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#isResumingMode()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ResumingMode();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getContextValues <em>Context Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Values</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getContextValues()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ContextValues();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getJvmValues <em>Jvm Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jvm Values</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getJvmValues()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_JvmValues();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getParentTaskExecId <em>Parent Task Exec Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parent Task Exec Id</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getParentTaskExecId()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ParentTaskExecId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TaskExecutionHistory#getParentPlanExecId <em>Parent Plan Exec Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parent Plan Exec Id</em>'.
     * @see org.talend.model.tac.conductor.TaskExecutionHistory#getParentPlanExecId()
     * @see #getTaskExecutionHistory()
     * @generated
     */
    EAttribute getTaskExecutionHistory_ParentPlanExecId();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.PlanExecutionHistory <em>Plan Execution History</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plan Execution History</em>'.
     * @see org.talend.model.tac.conductor.PlanExecutionHistory
     * @generated
     */
    EClass getPlanExecutionHistory();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.PlanExecutionHistory#getOriginalLabel <em>Original Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Original Label</em>'.
     * @see org.talend.model.tac.conductor.PlanExecutionHistory#getOriginalLabel()
     * @see #getPlanExecutionHistory()
     * @generated
     */
    EAttribute getPlanExecutionHistory_OriginalLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.PlanExecutionHistory#getCurrentLabel <em>Current Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Current Label</em>'.
     * @see org.talend.model.tac.conductor.PlanExecutionHistory#getCurrentLabel()
     * @see #getPlanExecutionHistory()
     * @generated
     */
    EAttribute getPlanExecutionHistory_CurrentLabel();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.TalendTrigger <em>Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Talend Trigger</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger
     * @generated
     */
    EClass getTalendTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getId()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#isActive()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getLabel()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getDescription()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getTriggerType <em>Trigger Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Type</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getTriggerType()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_TriggerType();

    /**
     * Returns the meta object for the container reference '{@link org.talend.model.tac.conductor.TalendTrigger#getExecutionTriggerable <em>Execution Triggerable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Execution Triggerable</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getExecutionTriggerable()
     * @see #getTalendTrigger()
     * @generated
     */
    EReference getTalendTrigger_ExecutionTriggerable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getStartTime <em>Start Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start Time</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getStartTime()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_StartTime();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getEndTime <em>End Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>End Time</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getEndTime()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_EndTime();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getPreviousFireTime <em>Previous Fire Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Previous Fire Time</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getPreviousFireTime()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_PreviousFireTime();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getFinalFireTime <em>Final Fire Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Final Fire Time</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getFinalFireTime()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_FinalFireTime();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getIdQuartzTrigger <em>Id Quartz Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Quartz Trigger</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getIdQuartzTrigger()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_IdQuartzTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#getResumePauseUpdated <em>Resume Pause Updated</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Resume Pause Updated</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#getResumePauseUpdated()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_ResumePauseUpdated();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.TalendTrigger#isPreviouslyPaused <em>Previously Paused</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Previously Paused</em>'.
     * @see org.talend.model.tac.conductor.TalendTrigger#isPreviouslyPaused()
     * @see #getTalendTrigger()
     * @generated
     */
    EAttribute getTalendTrigger_PreviouslyPaused();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.CronTalendTrigger <em>Cron Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cron Talend Trigger</em>'.
     * @see org.talend.model.tac.conductor.CronTalendTrigger
     * @generated
     */
    EClass getCronTalendTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronTalendTrigger#getCronExpression <em>Cron Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cron Expression</em>'.
     * @see org.talend.model.tac.conductor.CronTalendTrigger#getCronExpression()
     * @see #getCronTalendTrigger()
     * @generated
     */
    EAttribute getCronTalendTrigger_CronExpression();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.CronUITalendTrigger <em>Cron UI Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cron UI Talend Trigger</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger
     * @generated
     */
    EClass getCronUITalendTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListDaysOfWeek <em>List Days Of Week</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Days Of Week</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListDaysOfWeek()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListDaysOfWeek();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListDaysOfMonth <em>List Days Of Month</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Days Of Month</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListDaysOfMonth()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListDaysOfMonth();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListMonths <em>List Months</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Months</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListMonths()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListMonths();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListYears <em>List Years</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Years</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListYears()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListYears();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListHours <em>List Hours</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Hours</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListHours()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListHours();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.CronUITalendTrigger#getListMinutes <em>List Minutes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Minutes</em>'.
     * @see org.talend.model.tac.conductor.CronUITalendTrigger#getListMinutes()
     * @see #getCronUITalendTrigger()
     * @generated
     */
    EAttribute getCronUITalendTrigger_ListMinutes();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.SimpleTalendTrigger <em>Simple Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Talend Trigger</em>'.
     * @see org.talend.model.tac.conductor.SimpleTalendTrigger
     * @generated
     */
    EClass getSimpleTalendTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.SimpleTalendTrigger#getRepeatCount <em>Repeat Count</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Repeat Count</em>'.
     * @see org.talend.model.tac.conductor.SimpleTalendTrigger#getRepeatCount()
     * @see #getSimpleTalendTrigger()
     * @generated
     */
    EAttribute getSimpleTalendTrigger_RepeatCount();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.SimpleTalendTrigger#getRepeatInterval <em>Repeat Interval</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Repeat Interval</em>'.
     * @see org.talend.model.tac.conductor.SimpleTalendTrigger#getRepeatInterval()
     * @see #getSimpleTalendTrigger()
     * @generated
     */
    EAttribute getSimpleTalendTrigger_RepeatInterval();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.SimpleTalendTrigger#getTimesTriggered <em>Times Triggered</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Times Triggered</em>'.
     * @see org.talend.model.tac.conductor.SimpleTalendTrigger#getTimesTriggered()
     * @see #getSimpleTalendTrigger()
     * @generated
     */
    EAttribute getSimpleTalendTrigger_TimesTriggered();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.FileTrigger <em>File Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Trigger</em>'.
     * @see org.talend.model.tac.conductor.FileTrigger
     * @generated
     */
    EClass getFileTrigger();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.conductor.FileTrigger#getFileTriggerMasks <em>File Trigger Masks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>File Trigger Masks</em>'.
     * @see org.talend.model.tac.conductor.FileTrigger#getFileTriggerMasks()
     * @see #getFileTrigger()
     * @generated
     */
    EReference getFileTrigger_FileTriggerMasks();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.FileTriggerMask <em>File Trigger Mask</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Trigger Mask</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask
     * @generated
     */
    EClass getFileTriggerMask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getId()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#isActive()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getLabel()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getDescription()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Description();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.FileTriggerMask#getFileTrigger <em>File Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>File Trigger</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getFileTrigger()
     * @see #getFileTriggerMask()
     * @generated
     */
    EReference getFileTriggerMask_FileTrigger();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getFolderPath <em>Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Folder Path</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getFolderPath()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_FolderPath();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getFileMask <em>File Mask</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Mask</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getFileMask()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_FileMask();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#getContextParameterBaseName <em>Context Parameter Base Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Parameter Base Name</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getContextParameterBaseName()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_ContextParameterBaseName();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.conductor.FileTriggerMask#getCheckFileServer <em>Check File Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Check File Server</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#getCheckFileServer()
     * @see #getFileTriggerMask()
     * @generated
     */
    EReference getFileTriggerMask_CheckFileServer();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#isExist <em>Exist</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exist</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#isExist()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Exist();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#isCreated <em>Created</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Created</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#isCreated()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Created();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.FileTriggerMask#isModified <em>Modified</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Modified</em>'.
     * @see org.talend.model.tac.conductor.FileTriggerMask#isModified()
     * @see #getFileTriggerMask()
     * @generated
     */
    EAttribute getFileTriggerMask_Modified();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionServer <em>Execution Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Server</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer
     * @generated
     */
    EClass getExecutionServer();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getId()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getLabel()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getDescription()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getHost <em>Host</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getHost()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Host();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getPort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Port();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getFileTransfertPort <em>File Transfert Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Transfert Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getFileTransfertPort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_FileTransfertPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#isActive()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getMonitoringPort <em>Monitoring Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Monitoring Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getMonitoringPort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_MonitoringPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getTimeoutUnknownState <em>Timeout Unknown State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout Unknown State</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getTimeoutUnknownState()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_TimeoutUnknownState();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getUsername()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Username();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getPassword()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Password();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getJmxUrl <em>Jmx Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jmx Url</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getJmxUrl()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_JmxUrl();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getWebConsoleUrl <em>Web Console Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Web Console Url</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getWebConsoleUrl()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_WebConsoleUrl();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#isTalendRuntime <em>Talend Runtime</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Talend Runtime</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#isTalendRuntime()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_TalendRuntime();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getMgmtServerPort <em>Mgmt Server Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mgmt Server Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getMgmtServerPort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_MgmtServerPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getMgmtRegPort <em>Mgmt Reg Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mgmt Reg Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getMgmtRegPort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_MgmtRegPort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getAdminConsolePort <em>Admin Console Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Admin Console Port</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getAdminConsolePort()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_AdminConsolePort();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#isUseSSL <em>Use SSL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use SSL</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#isUseSSL()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_UseSSL();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionServer#getInstance <em>Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance</em>'.
     * @see org.talend.model.tac.conductor.ExecutionServer#getInstance()
     * @see #getExecutionServer()
     * @generated
     */
    EAttribute getExecutionServer_Instance();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.conductor.ExecutionVirtualServer <em>Execution Virtual Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execution Virtual Server</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer
     * @generated
     */
    EClass getExecutionVirtualServer();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer#getId()
     * @see #getExecutionVirtualServer()
     * @generated
     */
    EAttribute getExecutionVirtualServer_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer#getLabel()
     * @see #getExecutionVirtualServer()
     * @generated
     */
    EAttribute getExecutionVirtualServer_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer#getDescription()
     * @see #getExecutionVirtualServer()
     * @generated
     */
    EAttribute getExecutionVirtualServer_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer#isActive()
     * @see #getExecutionVirtualServer()
     * @generated
     */
    EAttribute getExecutionVirtualServer_Active();

    /**
     * Returns the meta object for the reference list '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getExecutionServers <em>Execution Servers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Execution Servers</em>'.
     * @see org.talend.model.tac.conductor.ExecutionVirtualServer#getExecutionServers()
     * @see #getExecutionVirtualServer()
     * @generated
     */
    EReference getExecutionVirtualServer_ExecutionServers();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ConductorFactory getConductorFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.ExecutionTriggerable <em>Execution Triggerable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.ExecutionTriggerable
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTriggerable()
         * @generated
         */
        EClass EXECUTION_TRIGGERABLE = eINSTANCE.getExecutionTriggerable();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__ID = eINSTANCE.getExecutionTriggerable_Id();

        /**
         * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TRIGGERABLE__TRIGGERS = eINSTANCE.getExecutionTriggerable_Triggers();

        /**
         * The meta object literal for the '<em><b>Id Quartz Job</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__ID_QUARTZ_JOB = eINSTANCE.getExecutionTriggerable_IdQuartzJob();

        /**
         * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__STATUS = eINSTANCE.getExecutionTriggerable_Status();

        /**
         * The meta object literal for the '<em><b>Error Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__ERROR_STATUS = eINSTANCE.getExecutionTriggerable_ErrorStatus();

        /**
         * The meta object literal for the '<em><b>Concurrent Execution</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__CONCURRENT_EXECUTION = eINSTANCE.getExecutionTriggerable_ConcurrentExecution();

        /**
         * The meta object literal for the '<em><b>Processing State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__PROCESSING_STATE = eINSTANCE.getExecutionTriggerable_ProcessingState();

        /**
         * The meta object literal for the '<em><b>Request Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TRIGGERABLE__REQUEST_ID = eINSTANCE.getExecutionTriggerable_RequestId();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanImpl <em>Execution Plan</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionPlanImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlan()
         * @generated
         */
        EClass EXECUTION_PLAN = eINSTANCE.getExecutionPlan();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN__LABEL = eINSTANCE.getExecutionPlan_Label();

        /**
         * The meta object literal for the '<em><b>Exec Plan Parts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN__EXEC_PLAN_PARTS = eINSTANCE.getExecutionPlan_ExecPlanParts();

        /**
         * The meta object literal for the '<em><b>Exec Plan Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN__EXEC_PLAN_PRMS = eINSTANCE.getExecutionPlan_ExecPlanPrms();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN__DESCRIPTION = eINSTANCE.getExecutionPlan_Description();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartImpl <em>Execution Plan Part</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPart()
         * @generated
         */
        EClass EXECUTION_PLAN_PART = eINSTANCE.getExecutionPlanPart();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__ID = eINSTANCE.getExecutionPlanPart_Id();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART__TASK = eINSTANCE.getExecutionPlanPart_Task();

        /**
         * The meta object literal for the '<em><b>Execution Plan</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART__EXECUTION_PLAN = eINSTANCE.getExecutionPlanPart_ExecutionPlan();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART__PARENT = eINSTANCE.getExecutionPlanPart_Parent();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__TYPE = eINSTANCE.getExecutionPlanPart_Type();

        /**
         * The meta object literal for the '<em><b>Jvm Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART__JVM_PRMS = eINSTANCE.getExecutionPlanPart_JvmPrms();

        /**
         * The meta object literal for the '<em><b>Context Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART__CONTEXT_PRMS = eINSTANCE.getExecutionPlanPart_ContextPrms();

        /**
         * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__STATUS = eINSTANCE.getExecutionPlanPart_Status();

        /**
         * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__START_DATE = eINSTANCE.getExecutionPlanPart_StartDate();

        /**
         * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__END_DATE = eINSTANCE.getExecutionPlanPart_EndDate();

        /**
         * The meta object literal for the '<em><b>Request Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__REQUEST_ID = eINSTANCE.getExecutionPlanPart_RequestId();

        /**
         * The meta object literal for the '<em><b>Use Parallel</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__USE_PARALLEL = eINSTANCE.getExecutionPlanPart_UseParallel();

        /**
         * The meta object literal for the '<em><b>Max Threads</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART__MAX_THREADS = eINSTANCE.getExecutionPlanPart_MaxThreads();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl <em>Execution Plan Prm</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPrm()
         * @generated
         */
        EClass EXECUTION_PLAN_PRM = eINSTANCE.getExecutionPlanPrm();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PRM__ID = eINSTANCE.getExecutionPlanPrm_Id();

        /**
         * The meta object literal for the '<em><b>Execution Plan</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PRM__EXECUTION_PLAN = eINSTANCE.getExecutionPlanPrm_ExecutionPlan();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PRM__NAME = eINSTANCE.getExecutionPlanPrm_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PRM__VALUE = eINSTANCE.getExecutionPlanPrm_Value();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartCmdPrmImpl <em>Execution Plan Part Cmd Prm</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartCmdPrmImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPartCmdPrm()
         * @generated
         */
        EClass EXECUTION_PLAN_PART_CMD_PRM = eINSTANCE.getExecutionPlanPartCmdPrm();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_CMD_PRM__ID = eINSTANCE.getExecutionPlanPartCmdPrm_Id();

        /**
         * The meta object literal for the '<em><b>Execution Plan Part</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART_CMD_PRM__EXECUTION_PLAN_PART = eINSTANCE.getExecutionPlanPartCmdPrm_ExecutionPlanPart();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_CMD_PRM__NAME = eINSTANCE.getExecutionPlanPartCmdPrm_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_CMD_PRM__VALUE = eINSTANCE.getExecutionPlanPartCmdPrm_Value();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionPlanPartJobPrmImpl <em>Execution Plan Part Job Prm</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionPlanPartJobPrmImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionPlanPartJobPrm()
         * @generated
         */
        EClass EXECUTION_PLAN_PART_JOB_PRM = eINSTANCE.getExecutionPlanPartJobPrm();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_JOB_PRM__ID = eINSTANCE.getExecutionPlanPartJobPrm_Id();

        /**
         * The meta object literal for the '<em><b>Execution Plan Part</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_PLAN_PART_JOB_PRM__EXECUTION_PLAN_PART = eINSTANCE.getExecutionPlanPartJobPrm_ExecutionPlanPart();

        /**
         * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_JOB_PRM__OVERRIDE = eINSTANCE.getExecutionPlanPartJobPrm_Override();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_JOB_PRM__NAME = eINSTANCE.getExecutionPlanPartJobPrm_Name();

        /**
         * The meta object literal for the '<em><b>Custom Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_JOB_PRM__CUSTOM_VALUE = eINSTANCE.getExecutionPlanPartJobPrm_CustomValue();

        /**
         * The meta object literal for the '<em><b>Part Custom Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_PLAN_PART_JOB_PRM__PART_CUSTOM_VALUE = eINSTANCE.getExecutionPlanPartJobPrm_PartCustomValue();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskImpl <em>Execution Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionTaskImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTask()
         * @generated
         */
        EClass EXECUTION_TASK = eINSTANCE.getExecutionTask();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LABEL = eINSTANCE.getExecutionTask_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__DESCRIPTION = eINSTANCE.getExecutionTask_Description();

        /**
         * The meta object literal for the '<em><b>Execution Server</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__EXECUTION_SERVER = eINSTANCE.getExecutionTask_ExecutionServer();

        /**
         * The meta object literal for the '<em><b>Project</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__PROJECT = eINSTANCE.getExecutionTask_Project();

        /**
         * The meta object literal for the '<em><b>Branch</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__BRANCH = eINSTANCE.getExecutionTask_Branch();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__CONTEXT = eINSTANCE.getExecutionTask_Context();

        /**
         * The meta object literal for the '<em><b>Job Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__JOB_VERSION = eINSTANCE.getExecutionTask_JobVersion();

        /**
         * The meta object literal for the '<em><b>Regenerate Job On Change</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__REGENERATE_JOB_ON_CHANGE = eINSTANCE.getExecutionTask_RegenerateJobOnChange();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ACTIVE = eINSTANCE.getExecutionTask_Active();

        /**
         * The meta object literal for the '<em><b>Last Script Generation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LAST_SCRIPT_GENERATION_DATE = eINSTANCE.getExecutionTask_LastScriptGenerationDate();

        /**
         * The meta object literal for the '<em><b>Generated Svn Revision</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__GENERATED_SVN_REVISION = eINSTANCE.getExecutionTask_GeneratedSvnRevision();

        /**
         * The meta object literal for the '<em><b>Id Remote Job</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ID_REMOTE_JOB = eINSTANCE.getExecutionTask_IdRemoteJob();

        /**
         * The meta object literal for the '<em><b>Id Remote Job Execution</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ID_REMOTE_JOB_EXECUTION = eINSTANCE.getExecutionTask_IdRemoteJobExecution();

        /**
         * The meta object literal for the '<em><b>Checksum Archive</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__CHECKSUM_ARCHIVE = eINSTANCE.getExecutionTask_ChecksumArchive();

        /**
         * The meta object literal for the '<em><b>Job Script Archive Filename</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__JOB_SCRIPT_ARCHIVE_FILENAME = eINSTANCE.getExecutionTask_JobScriptArchiveFilename();

        /**
         * The meta object literal for the '<em><b>Last Run Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LAST_RUN_DATE = eINSTANCE.getExecutionTask_LastRunDate();

        /**
         * The meta object literal for the '<em><b>Last Deployment Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LAST_DEPLOYMENT_DATE = eINSTANCE.getExecutionTask_LastDeploymentDate();

        /**
         * The meta object literal for the '<em><b>Last Ended Run Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LAST_ENDED_RUN_DATE = eINSTANCE.getExecutionTask_LastEndedRunDate();

        /**
         * The meta object literal for the '<em><b>Cmd Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__CMD_PRMS = eINSTANCE.getExecutionTask_CmdPrms();

        /**
         * The meta object literal for the '<em><b>Esb Properties Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__ESB_PROPERTIES_PRMS = eINSTANCE.getExecutionTask_EsbPropertiesPrms();

        /**
         * The meta object literal for the '<em><b>Job Prms</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__JOB_PRMS = eINSTANCE.getExecutionTask_JobPrms();

        /**
         * The meta object literal for the '<em><b>Job Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__JOB_ID = eINSTANCE.getExecutionTask_JobId();

        /**
         * The meta object literal for the '<em><b>Virtual Server</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK__VIRTUAL_SERVER = eINSTANCE.getExecutionTask_VirtualServer();

        /**
         * The meta object literal for the '<em><b>Max Concurrent Executions</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__MAX_CONCURRENT_EXECUTIONS = eINSTANCE.getExecutionTask_MaxConcurrentExecutions();

        /**
         * The meta object literal for the '<em><b>Generated Project Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__GENERATED_PROJECT_NAME = eINSTANCE.getExecutionTask_GeneratedProjectName();

        /**
         * The meta object literal for the '<em><b>Generated Job Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__GENERATED_JOB_NAME = eINSTANCE.getExecutionTask_GeneratedJobName();

        /**
         * The meta object literal for the '<em><b>Generated Job Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__GENERATED_JOB_VERSION = eINSTANCE.getExecutionTask_GeneratedJobVersion();

        /**
         * The meta object literal for the '<em><b>Apply Context To Children</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__APPLY_CONTEXT_TO_CHILDREN = eINSTANCE.getExecutionTask_ApplyContextToChildren();

        /**
         * The meta object literal for the '<em><b>Error Stack Trace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ERROR_STACK_TRACE = eINSTANCE.getExecutionTask_ErrorStackTrace();

        /**
         * The meta object literal for the '<em><b>Last Triggering Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__LAST_TRIGGERING_DATE = eINSTANCE.getExecutionTask_LastTriggeringDate();

        /**
         * The meta object literal for the '<em><b>Exec Statistics Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__EXEC_STATISTICS_ENABLED = eINSTANCE.getExecutionTask_ExecStatisticsEnabled();

        /**
         * The meta object literal for the '<em><b>Add Statistics Code Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ADD_STATISTICS_CODE_ENABLED = eINSTANCE.getExecutionTask_AddStatisticsCodeEnabled();

        /**
         * The meta object literal for the '<em><b>Owner Scheduler Instance Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__OWNER_SCHEDULER_INSTANCE_ID = eINSTANCE.getExecutionTask_OwnerSchedulerInstanceId();

        /**
         * The meta object literal for the '<em><b>On Unknown State Job</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__ON_UNKNOWN_STATE_JOB = eINSTANCE.getExecutionTask_OnUnknownStateJob();

        /**
         * The meta object literal for the '<em><b>Use Latest Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__USE_LATEST_VERSION = eINSTANCE.getExecutionTask_UseLatestVersion();

        /**
         * The meta object literal for the '<em><b>Application Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__APPLICATION_TYPE = eINSTANCE.getExecutionTask_ApplicationType();

        /**
         * The meta object literal for the '<em><b>Repository Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__REPOSITORY_NAME = eINSTANCE.getExecutionTask_RepositoryName();

        /**
         * The meta object literal for the '<em><b>Features File Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__FEATURES_FILE_URL = eINSTANCE.getExecutionTask_FeaturesFileUrl();

        /**
         * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__FEATURE_NAME = eINSTANCE.getExecutionTask_FeatureName();

        /**
         * The meta object literal for the '<em><b>Feature Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__FEATURE_VERSION = eINSTANCE.getExecutionTask_FeatureVersion();

        /**
         * The meta object literal for the '<em><b>Application Group</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__APPLICATION_GROUP = eINSTANCE.getExecutionTask_ApplicationGroup();

        /**
         * The meta object literal for the '<em><b>Bundle Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__BUNDLE_NAME = eINSTANCE.getExecutionTask_BundleName();

        /**
         * The meta object literal for the '<em><b>Property Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK__PROPERTY_ID = eINSTANCE.getExecutionTask_PropertyId();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl <em>Execution Task Properties</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskProperties()
         * @generated
         */
        EClass EXECUTION_TASK_PROPERTIES = eINSTANCE.getExecutionTaskProperties();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_PROPERTIES__ID = eINSTANCE.getExecutionTaskProperties_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_PROPERTIES__NAME = eINSTANCE.getExecutionTaskProperties_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_PROPERTIES__VALUE = eINSTANCE.getExecutionTaskProperties_Value();

        /**
         * The meta object literal for the '<em><b>Execution Task</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK_PROPERTIES__EXECUTION_TASK = eINSTANCE.getExecutionTaskProperties_ExecutionTask();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskCmdPrmImpl <em>Execution Task Cmd Prm</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionTaskCmdPrmImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskCmdPrm()
         * @generated
         */
        EClass EXECUTION_TASK_CMD_PRM = eINSTANCE.getExecutionTaskCmdPrm();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_CMD_PRM__ID = eINSTANCE.getExecutionTaskCmdPrm_Id();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_CMD_PRM__ACTIVE = eINSTANCE.getExecutionTaskCmdPrm_Active();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_CMD_PRM__PARAMETER = eINSTANCE.getExecutionTaskCmdPrm_Parameter();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_CMD_PRM__DESCRIPTION = eINSTANCE.getExecutionTaskCmdPrm_Description();

        /**
         * The meta object literal for the '<em><b>Execution Task</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK_CMD_PRM__EXECUTION_TASK = eINSTANCE.getExecutionTaskCmdPrm_ExecutionTask();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionTaskJobPrmImpl <em>Execution Task Job Prm</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionTaskJobPrmImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionTaskJobPrm()
         * @generated
         */
        EClass EXECUTION_TASK_JOB_PRM = eINSTANCE.getExecutionTaskJobPrm();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__ID = eINSTANCE.getExecutionTaskJobPrm_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__LABEL = eINSTANCE.getExecutionTaskJobPrm_Label();

        /**
         * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__OVERRIDE = eINSTANCE.getExecutionTaskJobPrm_Override();

        /**
         * The meta object literal for the '<em><b>Execution Task</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_TASK_JOB_PRM__EXECUTION_TASK = eINSTANCE.getExecutionTaskJobPrm_ExecutionTask();

        /**
         * The meta object literal for the '<em><b>Original Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__ORIGINAL_VALUE = eINSTANCE.getExecutionTaskJobPrm_OriginalValue();

        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__DEFAULT_VALUE = eINSTANCE.getExecutionTaskJobPrm_DefaultValue();

        /**
         * The meta object literal for the '<em><b>Item Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_TASK_JOB_PRM__ITEM_TYPE = eINSTANCE.getExecutionTaskJobPrm_ItemType();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.TaskExecutionHistoryImpl <em>Task Execution History</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.TaskExecutionHistoryImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getTaskExecutionHistory()
         * @generated
         */
        EClass TASK_EXECUTION_HISTORY = eINSTANCE.getTaskExecutionHistory();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__ID = eINSTANCE.getTaskExecutionHistory_Id();

        /**
         * The meta object literal for the '<em><b>Basic Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__BASIC_STATUS = eINSTANCE.getTaskExecutionHistory_BasicStatus();

        /**
         * The meta object literal for the '<em><b>Detailed Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__DETAILED_STATUS = eINSTANCE.getTaskExecutionHistory_DetailedStatus();

        /**
         * The meta object literal for the '<em><b>Task Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TASK_LABEL = eINSTANCE.getTaskExecutionHistory_TaskLabel();

        /**
         * The meta object literal for the '<em><b>Task Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TASK_DESCRIPTION = eINSTANCE.getTaskExecutionHistory_TaskDescription();

        /**
         * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__PROJECT_NAME = eINSTANCE.getTaskExecutionHistory_ProjectName();

        /**
         * The meta object literal for the '<em><b>Talend Job Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TALEND_JOB_NAME = eINSTANCE.getTaskExecutionHistory_TalendJobName();

        /**
         * The meta object literal for the '<em><b>Talend Job Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TALEND_JOB_ID = eINSTANCE.getTaskExecutionHistory_TalendJobId();

        /**
         * The meta object literal for the '<em><b>Talend Job Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TALEND_JOB_VERSION = eINSTANCE.getTaskExecutionHistory_TalendJobVersion();

        /**
         * The meta object literal for the '<em><b>Context Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__CONTEXT_NAME = eINSTANCE.getTaskExecutionHistory_ContextName();

        /**
         * The meta object literal for the '<em><b>Virtual Server Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__VIRTUAL_SERVER_NAME = eINSTANCE.getTaskExecutionHistory_VirtualServerName();

        /**
         * The meta object literal for the '<em><b>Execution Server Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXECUTION_SERVER_NAME = eINSTANCE.getTaskExecutionHistory_ExecutionServerName();

        /**
         * The meta object literal for the '<em><b>Execution Server Host</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXECUTION_SERVER_HOST = eINSTANCE.getTaskExecutionHistory_ExecutionServerHost();

        /**
         * The meta object literal for the '<em><b>Execution Server Cmd Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXECUTION_SERVER_CMD_PORT = eINSTANCE.getTaskExecutionHistory_ExecutionServerCmdPort();

        /**
         * The meta object literal for the '<em><b>Execution Server File Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXECUTION_SERVER_FILE_PORT = eINSTANCE
                .getTaskExecutionHistory_ExecutionServerFilePort();

        /**
         * The meta object literal for the '<em><b>Execution Server Monitoring Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXECUTION_SERVER_MONITORING_PORT = eINSTANCE
                .getTaskExecutionHistory_ExecutionServerMonitoringPort();

        /**
         * The meta object literal for the '<em><b>Apply Context To Children</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__APPLY_CONTEXT_TO_CHILDREN = eINSTANCE.getTaskExecutionHistory_ApplyContextToChildren();

        /**
         * The meta object literal for the '<em><b>Triggered By</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TRIGGERED_BY = eINSTANCE.getTaskExecutionHistory_TriggeredBy();

        /**
         * The meta object literal for the '<em><b>Trigger Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TRIGGER_TYPE = eINSTANCE.getTaskExecutionHistory_TriggerType();

        /**
         * The meta object literal for the '<em><b>Trigger Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TRIGGER_NAME = eINSTANCE.getTaskExecutionHistory_TriggerName();

        /**
         * The meta object literal for the '<em><b>Trigger Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TRIGGER_DESCRIPTION = eINSTANCE.getTaskExecutionHistory_TriggerDescription();

        /**
         * The meta object literal for the '<em><b>Task Error Stack Trace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TASK_ERROR_STACK_TRACE = eINSTANCE.getTaskExecutionHistory_TaskErrorStackTrace();

        /**
         * The meta object literal for the '<em><b>Id Quartz Job</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__ID_QUARTZ_JOB = eINSTANCE.getTaskExecutionHistory_IdQuartzJob();

        /**
         * The meta object literal for the '<em><b>Id Quartz Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__ID_QUARTZ_TRIGGER = eINSTANCE.getTaskExecutionHistory_IdQuartzTrigger();

        /**
         * The meta object literal for the '<em><b>Last Job Generation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__LAST_JOB_GENERATION_DATE = eINSTANCE.getTaskExecutionHistory_LastJobGenerationDate();

        /**
         * The meta object literal for the '<em><b>Job Archive Filename</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__JOB_ARCHIVE_FILENAME = eINSTANCE.getTaskExecutionHistory_JobArchiveFilename();

        /**
         * The meta object literal for the '<em><b>File Trigger File Mask</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_MASK = eINSTANCE.getTaskExecutionHistory_FileTriggerFileMask();

        /**
         * The meta object literal for the '<em><b>File Trigger File Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__FILE_TRIGGER_FILE_NAME = eINSTANCE.getTaskExecutionHistory_FileTriggerFileName();

        /**
         * The meta object literal for the '<em><b>File Trigger Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__FILE_TRIGGER_FOLDER_PATH = eINSTANCE.getTaskExecutionHistory_FileTriggerFolderPath();

        /**
         * The meta object literal for the '<em><b>File Trigger Triggered File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__FILE_TRIGGER_TRIGGERED_FILE_PATH = eINSTANCE
                .getTaskExecutionHistory_FileTriggerTriggeredFilePath();

        /**
         * The meta object literal for the '<em><b>Expected Triggering Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__EXPECTED_TRIGGERING_DATE = eINSTANCE.getTaskExecutionHistory_ExpectedTriggeringDate();

        /**
         * The meta object literal for the '<em><b>Task Start Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TASK_START_DATE = eINSTANCE.getTaskExecutionHistory_TaskStartDate();

        /**
         * The meta object literal for the '<em><b>Task End Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__TASK_END_DATE = eINSTANCE.getTaskExecutionHistory_TaskEndDate();

        /**
         * The meta object literal for the '<em><b>Server Job Start Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__SERVER_JOB_START_DATE = eINSTANCE.getTaskExecutionHistory_ServerJobStartDate();

        /**
         * The meta object literal for the '<em><b>Server Job End Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__SERVER_JOB_END_DATE = eINSTANCE.getTaskExecutionHistory_ServerJobEndDate();

        /**
         * The meta object literal for the '<em><b>Id Remote Job</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__ID_REMOTE_JOB = eINSTANCE.getTaskExecutionHistory_IdRemoteJob();

        /**
         * The meta object literal for the '<em><b>Id Remote Job Execution</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__ID_REMOTE_JOB_EXECUTION = eINSTANCE.getTaskExecutionHistory_IdRemoteJobExecution();

        /**
         * The meta object literal for the '<em><b>Request Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__REQUEST_ID = eINSTANCE.getTaskExecutionHistory_RequestId();

        /**
         * The meta object literal for the '<em><b>Resuming Mode</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__RESUMING_MODE = eINSTANCE.getTaskExecutionHistory_ResumingMode();

        /**
         * The meta object literal for the '<em><b>Context Values</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__CONTEXT_VALUES = eINSTANCE.getTaskExecutionHistory_ContextValues();

        /**
         * The meta object literal for the '<em><b>Jvm Values</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__JVM_VALUES = eINSTANCE.getTaskExecutionHistory_JvmValues();

        /**
         * The meta object literal for the '<em><b>Parent Task Exec Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__PARENT_TASK_EXEC_ID = eINSTANCE.getTaskExecutionHistory_ParentTaskExecId();

        /**
         * The meta object literal for the '<em><b>Parent Plan Exec Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK_EXECUTION_HISTORY__PARENT_PLAN_EXEC_ID = eINSTANCE.getTaskExecutionHistory_ParentPlanExecId();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl <em>Plan Execution History</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getPlanExecutionHistory()
         * @generated
         */
        EClass PLAN_EXECUTION_HISTORY = eINSTANCE.getPlanExecutionHistory();

        /**
         * The meta object literal for the '<em><b>Original Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL = eINSTANCE.getPlanExecutionHistory_OriginalLabel();

        /**
         * The meta object literal for the '<em><b>Current Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLAN_EXECUTION_HISTORY__CURRENT_LABEL = eINSTANCE.getPlanExecutionHistory_CurrentLabel();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.TalendTriggerImpl <em>Talend Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.TalendTriggerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getTalendTrigger()
         * @generated
         */
        EClass TALEND_TRIGGER = eINSTANCE.getTalendTrigger();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__ID = eINSTANCE.getTalendTrigger_Id();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__ACTIVE = eINSTANCE.getTalendTrigger_Active();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__LABEL = eINSTANCE.getTalendTrigger_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__DESCRIPTION = eINSTANCE.getTalendTrigger_Description();

        /**
         * The meta object literal for the '<em><b>Trigger Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__TRIGGER_TYPE = eINSTANCE.getTalendTrigger_TriggerType();

        /**
         * The meta object literal for the '<em><b>Execution Triggerable</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TALEND_TRIGGER__EXECUTION_TRIGGERABLE = eINSTANCE.getTalendTrigger_ExecutionTriggerable();

        /**
         * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__START_TIME = eINSTANCE.getTalendTrigger_StartTime();

        /**
         * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__END_TIME = eINSTANCE.getTalendTrigger_EndTime();

        /**
         * The meta object literal for the '<em><b>Previous Fire Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__PREVIOUS_FIRE_TIME = eINSTANCE.getTalendTrigger_PreviousFireTime();

        /**
         * The meta object literal for the '<em><b>Final Fire Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__FINAL_FIRE_TIME = eINSTANCE.getTalendTrigger_FinalFireTime();

        /**
         * The meta object literal for the '<em><b>Id Quartz Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__ID_QUARTZ_TRIGGER = eINSTANCE.getTalendTrigger_IdQuartzTrigger();

        /**
         * The meta object literal for the '<em><b>Resume Pause Updated</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__RESUME_PAUSE_UPDATED = eINSTANCE.getTalendTrigger_ResumePauseUpdated();

        /**
         * The meta object literal for the '<em><b>Previously Paused</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TALEND_TRIGGER__PREVIOUSLY_PAUSED = eINSTANCE.getTalendTrigger_PreviouslyPaused();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.CronTalendTriggerImpl <em>Cron Talend Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.CronTalendTriggerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getCronTalendTrigger()
         * @generated
         */
        EClass CRON_TALEND_TRIGGER = eINSTANCE.getCronTalendTrigger();

        /**
         * The meta object literal for the '<em><b>Cron Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_TALEND_TRIGGER__CRON_EXPRESSION = eINSTANCE.getCronTalendTrigger_CronExpression();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.CronUITalendTriggerImpl <em>Cron UI Talend Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.CronUITalendTriggerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getCronUITalendTrigger()
         * @generated
         */
        EClass CRON_UI_TALEND_TRIGGER = eINSTANCE.getCronUITalendTrigger();

        /**
         * The meta object literal for the '<em><b>List Days Of Week</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_WEEK = eINSTANCE.getCronUITalendTrigger_ListDaysOfWeek();

        /**
         * The meta object literal for the '<em><b>List Days Of Month</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_DAYS_OF_MONTH = eINSTANCE.getCronUITalendTrigger_ListDaysOfMonth();

        /**
         * The meta object literal for the '<em><b>List Months</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_MONTHS = eINSTANCE.getCronUITalendTrigger_ListMonths();

        /**
         * The meta object literal for the '<em><b>List Years</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_YEARS = eINSTANCE.getCronUITalendTrigger_ListYears();

        /**
         * The meta object literal for the '<em><b>List Hours</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_HOURS = eINSTANCE.getCronUITalendTrigger_ListHours();

        /**
         * The meta object literal for the '<em><b>List Minutes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CRON_UI_TALEND_TRIGGER__LIST_MINUTES = eINSTANCE.getCronUITalendTrigger_ListMinutes();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.SimpleTalendTriggerImpl <em>Simple Talend Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.SimpleTalendTriggerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getSimpleTalendTrigger()
         * @generated
         */
        EClass SIMPLE_TALEND_TRIGGER = eINSTANCE.getSimpleTalendTrigger();

        /**
         * The meta object literal for the '<em><b>Repeat Count</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_TALEND_TRIGGER__REPEAT_COUNT = eINSTANCE.getSimpleTalendTrigger_RepeatCount();

        /**
         * The meta object literal for the '<em><b>Repeat Interval</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_TALEND_TRIGGER__REPEAT_INTERVAL = eINSTANCE.getSimpleTalendTrigger_RepeatInterval();

        /**
         * The meta object literal for the '<em><b>Times Triggered</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_TALEND_TRIGGER__TIMES_TRIGGERED = eINSTANCE.getSimpleTalendTrigger_TimesTriggered();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.FileTriggerImpl <em>File Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.FileTriggerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getFileTrigger()
         * @generated
         */
        EClass FILE_TRIGGER = eINSTANCE.getFileTrigger();

        /**
         * The meta object literal for the '<em><b>File Trigger Masks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILE_TRIGGER__FILE_TRIGGER_MASKS = eINSTANCE.getFileTrigger_FileTriggerMasks();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.FileTriggerMaskImpl <em>File Trigger Mask</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.FileTriggerMaskImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getFileTriggerMask()
         * @generated
         */
        EClass FILE_TRIGGER_MASK = eINSTANCE.getFileTriggerMask();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__ID = eINSTANCE.getFileTriggerMask_Id();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__ACTIVE = eINSTANCE.getFileTriggerMask_Active();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__LABEL = eINSTANCE.getFileTriggerMask_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__DESCRIPTION = eINSTANCE.getFileTriggerMask_Description();

        /**
         * The meta object literal for the '<em><b>File Trigger</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILE_TRIGGER_MASK__FILE_TRIGGER = eINSTANCE.getFileTriggerMask_FileTrigger();

        /**
         * The meta object literal for the '<em><b>Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__FOLDER_PATH = eINSTANCE.getFileTriggerMask_FolderPath();

        /**
         * The meta object literal for the '<em><b>File Mask</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__FILE_MASK = eINSTANCE.getFileTriggerMask_FileMask();

        /**
         * The meta object literal for the '<em><b>Context Parameter Base Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__CONTEXT_PARAMETER_BASE_NAME = eINSTANCE.getFileTriggerMask_ContextParameterBaseName();

        /**
         * The meta object literal for the '<em><b>Check File Server</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILE_TRIGGER_MASK__CHECK_FILE_SERVER = eINSTANCE.getFileTriggerMask_CheckFileServer();

        /**
         * The meta object literal for the '<em><b>Exist</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__EXIST = eINSTANCE.getFileTriggerMask_Exist();

        /**
         * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__CREATED = eINSTANCE.getFileTriggerMask_Created();

        /**
         * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_TRIGGER_MASK__MODIFIED = eINSTANCE.getFileTriggerMask_Modified();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionServerImpl <em>Execution Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionServerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionServer()
         * @generated
         */
        EClass EXECUTION_SERVER = eINSTANCE.getExecutionServer();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__ID = eINSTANCE.getExecutionServer_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__LABEL = eINSTANCE.getExecutionServer_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__DESCRIPTION = eINSTANCE.getExecutionServer_Description();

        /**
         * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__HOST = eINSTANCE.getExecutionServer_Host();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__PORT = eINSTANCE.getExecutionServer_Port();

        /**
         * The meta object literal for the '<em><b>File Transfert Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__FILE_TRANSFERT_PORT = eINSTANCE.getExecutionServer_FileTransfertPort();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__ACTIVE = eINSTANCE.getExecutionServer_Active();

        /**
         * The meta object literal for the '<em><b>Monitoring Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__MONITORING_PORT = eINSTANCE.getExecutionServer_MonitoringPort();

        /**
         * The meta object literal for the '<em><b>Timeout Unknown State</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__TIMEOUT_UNKNOWN_STATE = eINSTANCE.getExecutionServer_TimeoutUnknownState();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__USERNAME = eINSTANCE.getExecutionServer_Username();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__PASSWORD = eINSTANCE.getExecutionServer_Password();

        /**
         * The meta object literal for the '<em><b>Jmx Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__JMX_URL = eINSTANCE.getExecutionServer_JmxUrl();

        /**
         * The meta object literal for the '<em><b>Web Console Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__WEB_CONSOLE_URL = eINSTANCE.getExecutionServer_WebConsoleUrl();

        /**
         * The meta object literal for the '<em><b>Talend Runtime</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__TALEND_RUNTIME = eINSTANCE.getExecutionServer_TalendRuntime();

        /**
         * The meta object literal for the '<em><b>Mgmt Server Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__MGMT_SERVER_PORT = eINSTANCE.getExecutionServer_MgmtServerPort();

        /**
         * The meta object literal for the '<em><b>Mgmt Reg Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__MGMT_REG_PORT = eINSTANCE.getExecutionServer_MgmtRegPort();

        /**
         * The meta object literal for the '<em><b>Admin Console Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__ADMIN_CONSOLE_PORT = eINSTANCE.getExecutionServer_AdminConsolePort();

        /**
         * The meta object literal for the '<em><b>Use SSL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__USE_SSL = eINSTANCE.getExecutionServer_UseSSL();

        /**
         * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_SERVER__INSTANCE = eINSTANCE.getExecutionServer_Instance();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.conductor.impl.ExecutionVirtualServerImpl <em>Execution Virtual Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.conductor.impl.ExecutionVirtualServerImpl
         * @see org.talend.model.tac.conductor.impl.ConductorPackageImpl#getExecutionVirtualServer()
         * @generated
         */
        EClass EXECUTION_VIRTUAL_SERVER = eINSTANCE.getExecutionVirtualServer();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_VIRTUAL_SERVER__ID = eINSTANCE.getExecutionVirtualServer_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_VIRTUAL_SERVER__LABEL = eINSTANCE.getExecutionVirtualServer_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_VIRTUAL_SERVER__DESCRIPTION = eINSTANCE.getExecutionVirtualServer_Description();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTION_VIRTUAL_SERVER__ACTIVE = eINSTANCE.getExecutionVirtualServer_Active();

        /**
         * The meta object literal for the '<em><b>Execution Servers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTION_VIRTUAL_SERVER__EXECUTION_SERVERS = eINSTANCE.getExecutionVirtualServer_ExecutionServers();

    }

} //ConductorPackage
