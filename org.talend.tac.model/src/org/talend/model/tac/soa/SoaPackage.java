/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.soa;

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
 * @see org.talend.model.tac.soa.SoaFactory
 * @model kind="package"
 * @generated
 */
public interface SoaPackage extends EPackage {

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "soa";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.talend.org/tac/soa";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "soa";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SoaPackage eINSTANCE = org.talend.model.tac.soa.impl.SoaPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.model.tac.soa.impl.SoaOperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.soa.impl.SoaOperationImpl
     * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaOperation()
     * @generated
     */
    int SOA_OPERATION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__LABEL = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__DESCRIPTION = 2;

    /**
     * The feature id for the '<em><b>Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__PROJECT = 3;

    /**
     * The feature id for the '<em><b>Context</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__CONTEXT = 4;

    /**
     * The feature id for the '<em><b>Job Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__JOB_VERSION = 5;

    /**
     * The feature id for the '<em><b>Job Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__JOB_NAME = 6;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__ACTIVE = 7;

    /**
     * The feature id for the '<em><b>Last Script Generation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__LAST_SCRIPT_GENERATION_DATE = 8;

    /**
     * The feature id for the '<em><b>Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__JOB_ID = 9;

    /**
     * The feature id for the '<em><b>Apply Context To Children</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__APPLY_CONTEXT_TO_CHILDREN = 10;

    /**
     * The feature id for the '<em><b>Input Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__INPUT_PARAMETERS = 11;

    /**
     * The feature id for the '<em><b>Jvm Parameters</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__JVM_PARAMETERS = 12;

    /**
     * The feature id for the '<em><b>Xms</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__XMS = 13;

    /**
     * The feature id for the '<em><b>Xmx</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__XMX = 14;

    /**
     * The feature id for the '<em><b>Min Job Instances</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__MIN_JOB_INSTANCES = 15;

    /**
     * The feature id for the '<em><b>Max Job Instances</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__MAX_JOB_INSTANCES = 16;

    /**
     * The feature id for the '<em><b>Idle TTL for All Instances</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__IDLE_TTL_FOR_ALL_INSTANCES = 17;

    /**
     * The feature id for the '<em><b>Idle TTL for Additional Instances</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__IDLE_TTL_FOR_ADDITIONAL_INSTANCES = 18;

    /**
     * The feature id for the '<em><b>Queue Max Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__QUEUE_MAX_SIZE = 19;

    /**
     * The feature id for the '<em><b>Request In Queue TTL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__REQUEST_IN_QUEUE_TTL = 20;

    /**
     * The feature id for the '<em><b>Service</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__SERVICE = 21;

    /**
     * The feature id for the '<em><b>Return Style</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__RETURN_STYLE = 22;

    /**
     * The feature id for the '<em><b>Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION__BRANCH = 23;

    /**
     * The number of structural features of the '<em>Operation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_OPERATION_FEATURE_COUNT = 24;

    /**
     * The meta object id for the '{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl <em>Input Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.soa.impl.SoaInputParameterImpl
     * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaInputParameter()
     * @generated
     */
    int SOA_INPUT_PARAMETER = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__LABEL = 1;

    /**
     * The feature id for the '<em><b>Operation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__OPERATION = 2;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__DEFAULT_VALUE = 3;

    /**
     * The feature id for the '<em><b>Exposed Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__EXPOSED_NAME = 4;

    /**
     * The feature id for the '<em><b>Exposed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER__EXPOSED = 5;

    /**
     * The number of structural features of the '<em>Input Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_INPUT_PARAMETER_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.talend.model.tac.soa.impl.SoaServiceImpl <em>Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.soa.impl.SoaServiceImpl
     * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaService()
     * @generated
     */
    int SOA_SERVICE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__LABEL = 1;

    /**
     * The feature id for the '<em><b>Name Space</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__NAME_SPACE = 2;

    /**
     * The feature id for the '<em><b>Contact</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__CONTACT = 3;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__DESCRIPTION = 4;

    /**
     * The feature id for the '<em><b>Creation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__CREATION = 5;

    /**
     * The feature id for the '<em><b>Modification</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__MODIFICATION = 6;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__PORT = 7;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__TYPE = 8;

    /**
     * The feature id for the '<em><b>Style</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__STYLE = 9;

    /**
     * The feature id for the '<em><b>Used Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__USED_TYPE = 10;

    /**
     * The feature id for the '<em><b>Param Style</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__PARAM_STYLE = 11;

    /**
     * The feature id for the '<em><b>Operations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__OPERATIONS = 12;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE__STATUS = 13;

    /**
     * The number of structural features of the '<em>Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOA_SERVICE_FEATURE_COUNT = 14;

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.soa.SoaOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation</em>'.
     * @see org.talend.model.tac.soa.SoaOperation
     * @generated
     */
    EClass getSoaOperation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getId()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getLabel()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getDescription()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Description();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.soa.SoaOperation#getProject <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Project</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getProject()
     * @see #getSoaOperation()
     * @generated
     */
    EReference getSoaOperation_Project();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getContext <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getContext()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Context();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getJobVersion <em>Job Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Version</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getJobVersion()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_JobVersion();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getJobName <em>Job Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Name</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getJobName()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_JobName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#isActive()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Active();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getLastScriptGenerationDate <em>Last Script Generation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Script Generation Date</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getLastScriptGenerationDate()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_LastScriptGenerationDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getJobId <em>Job Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Id</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getJobId()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_JobId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#isApplyContextToChildren <em>Apply Context To Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Apply Context To Children</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#isApplyContextToChildren()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_ApplyContextToChildren();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.soa.SoaOperation#getInputParameters <em>Input Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Parameters</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getInputParameters()
     * @see #getSoaOperation()
     * @generated
     */
    EReference getSoaOperation_InputParameters();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getJvmParameters <em>Jvm Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jvm Parameters</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getJvmParameters()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_JvmParameters();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getXms <em>Xms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xms</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getXms()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Xms();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getXmx <em>Xmx</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xmx</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getXmx()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Xmx();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getMinJobInstances <em>Min Job Instances</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min Job Instances</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getMinJobInstances()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_MinJobInstances();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getMaxJobInstances <em>Max Job Instances</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Job Instances</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getMaxJobInstances()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_MaxJobInstances();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getIdleTTL_forAllInstances <em>Idle TTL for All Instances</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Idle TTL for All Instances</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getIdleTTL_forAllInstances()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_IdleTTL_forAllInstances();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getIdleTTL_forAdditionalInstances <em>Idle TTL for Additional Instances</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Idle TTL for Additional Instances</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getIdleTTL_forAdditionalInstances()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_IdleTTL_forAdditionalInstances();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getQueueMaxSize <em>Queue Max Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Queue Max Size</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getQueueMaxSize()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_QueueMaxSize();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getRequestInQueueTTL <em>Request In Queue TTL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Request In Queue TTL</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getRequestInQueueTTL()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_RequestInQueueTTL();

    /**
     * Returns the meta object for the container reference '{@link org.talend.model.tac.soa.SoaOperation#getService <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Service</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getService()
     * @see #getSoaOperation()
     * @generated
     */
    EReference getSoaOperation_Service();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getReturnStyle <em>Return Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Return Style</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getReturnStyle()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_ReturnStyle();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaOperation#getBranch <em>Branch</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Branch</em>'.
     * @see org.talend.model.tac.soa.SoaOperation#getBranch()
     * @see #getSoaOperation()
     * @generated
     */
    EAttribute getSoaOperation_Branch();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.soa.SoaInputParameter <em>Input Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Parameter</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter
     * @generated
     */
    EClass getSoaInputParameter();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaInputParameter#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#getId()
     * @see #getSoaInputParameter()
     * @generated
     */
    EAttribute getSoaInputParameter_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaInputParameter#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#getLabel()
     * @see #getSoaInputParameter()
     * @generated
     */
    EAttribute getSoaInputParameter_Label();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.soa.SoaInputParameter#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Operation</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#getOperation()
     * @see #getSoaInputParameter()
     * @generated
     */
    EReference getSoaInputParameter_Operation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaInputParameter#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#getDefaultValue()
     * @see #getSoaInputParameter()
     * @generated
     */
    EAttribute getSoaInputParameter_DefaultValue();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaInputParameter#getExposedName <em>Exposed Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exposed Name</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#getExposedName()
     * @see #getSoaInputParameter()
     * @generated
     */
    EAttribute getSoaInputParameter_ExposedName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaInputParameter#isExposed <em>Exposed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exposed</em>'.
     * @see org.talend.model.tac.soa.SoaInputParameter#isExposed()
     * @see #getSoaInputParameter()
     * @generated
     */
    EAttribute getSoaInputParameter_Exposed();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.soa.SoaService <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service</em>'.
     * @see org.talend.model.tac.soa.SoaService
     * @generated
     */
    EClass getSoaService();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.soa.SoaService#getId()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.soa.SoaService#getLabel()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getNameSpace <em>Name Space</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name Space</em>'.
     * @see org.talend.model.tac.soa.SoaService#getNameSpace()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_NameSpace();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getContact <em>Contact</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Contact</em>'.
     * @see org.talend.model.tac.soa.SoaService#getContact()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Contact();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.soa.SoaService#getDescription()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getCreation <em>Creation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Creation</em>'.
     * @see org.talend.model.tac.soa.SoaService#getCreation()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Creation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getModification <em>Modification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Modification</em>'.
     * @see org.talend.model.tac.soa.SoaService#getModification()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Modification();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.talend.model.tac.soa.SoaService#getPort()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Port();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.soa.SoaService#getType()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Type();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getStyle <em>Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Style</em>'.
     * @see org.talend.model.tac.soa.SoaService#getStyle()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Style();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getUsedType <em>Used Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Used Type</em>'.
     * @see org.talend.model.tac.soa.SoaService#getUsedType()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_UsedType();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getParamStyle <em>Param Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Param Style</em>'.
     * @see org.talend.model.tac.soa.SoaService#getParamStyle()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_ParamStyle();

    /**
     * Returns the meta object for the containment reference list '{@link org.talend.model.tac.soa.SoaService#getOperations <em>Operations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operations</em>'.
     * @see org.talend.model.tac.soa.SoaService#getOperations()
     * @see #getSoaService()
     * @generated
     */
    EReference getSoaService_Operations();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.soa.SoaService#getStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Status</em>'.
     * @see org.talend.model.tac.soa.SoaService#getStatus()
     * @see #getSoaService()
     * @generated
     */
    EAttribute getSoaService_Status();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SoaFactory getSoaFactory();

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
         * The meta object literal for the '{@link org.talend.model.tac.soa.impl.SoaOperationImpl <em>Operation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.soa.impl.SoaOperationImpl
         * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaOperation()
         * @generated
         */
        EClass SOA_OPERATION = eINSTANCE.getSoaOperation();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__ID = eINSTANCE.getSoaOperation_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__LABEL = eINSTANCE.getSoaOperation_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__DESCRIPTION = eINSTANCE.getSoaOperation_Description();

        /**
         * The meta object literal for the '<em><b>Project</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOA_OPERATION__PROJECT = eINSTANCE.getSoaOperation_Project();

        /**
         * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__CONTEXT = eINSTANCE.getSoaOperation_Context();

        /**
         * The meta object literal for the '<em><b>Job Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__JOB_VERSION = eINSTANCE.getSoaOperation_JobVersion();

        /**
         * The meta object literal for the '<em><b>Job Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__JOB_NAME = eINSTANCE.getSoaOperation_JobName();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__ACTIVE = eINSTANCE.getSoaOperation_Active();

        /**
         * The meta object literal for the '<em><b>Last Script Generation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__LAST_SCRIPT_GENERATION_DATE = eINSTANCE.getSoaOperation_LastScriptGenerationDate();

        /**
         * The meta object literal for the '<em><b>Job Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__JOB_ID = eINSTANCE.getSoaOperation_JobId();

        /**
         * The meta object literal for the '<em><b>Apply Context To Children</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__APPLY_CONTEXT_TO_CHILDREN = eINSTANCE.getSoaOperation_ApplyContextToChildren();

        /**
         * The meta object literal for the '<em><b>Input Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOA_OPERATION__INPUT_PARAMETERS = eINSTANCE.getSoaOperation_InputParameters();

        /**
         * The meta object literal for the '<em><b>Jvm Parameters</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__JVM_PARAMETERS = eINSTANCE.getSoaOperation_JvmParameters();

        /**
         * The meta object literal for the '<em><b>Xms</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__XMS = eINSTANCE.getSoaOperation_Xms();

        /**
         * The meta object literal for the '<em><b>Xmx</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__XMX = eINSTANCE.getSoaOperation_Xmx();

        /**
         * The meta object literal for the '<em><b>Min Job Instances</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__MIN_JOB_INSTANCES = eINSTANCE.getSoaOperation_MinJobInstances();

        /**
         * The meta object literal for the '<em><b>Max Job Instances</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__MAX_JOB_INSTANCES = eINSTANCE.getSoaOperation_MaxJobInstances();

        /**
         * The meta object literal for the '<em><b>Idle TTL for All Instances</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__IDLE_TTL_FOR_ALL_INSTANCES = eINSTANCE.getSoaOperation_IdleTTL_forAllInstances();

        /**
         * The meta object literal for the '<em><b>Idle TTL for Additional Instances</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__IDLE_TTL_FOR_ADDITIONAL_INSTANCES = eINSTANCE.getSoaOperation_IdleTTL_forAdditionalInstances();

        /**
         * The meta object literal for the '<em><b>Queue Max Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__QUEUE_MAX_SIZE = eINSTANCE.getSoaOperation_QueueMaxSize();

        /**
         * The meta object literal for the '<em><b>Request In Queue TTL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__REQUEST_IN_QUEUE_TTL = eINSTANCE.getSoaOperation_RequestInQueueTTL();

        /**
         * The meta object literal for the '<em><b>Service</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOA_OPERATION__SERVICE = eINSTANCE.getSoaOperation_Service();

        /**
         * The meta object literal for the '<em><b>Return Style</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__RETURN_STYLE = eINSTANCE.getSoaOperation_ReturnStyle();

        /**
         * The meta object literal for the '<em><b>Branch</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_OPERATION__BRANCH = eINSTANCE.getSoaOperation_Branch();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl <em>Input Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.soa.impl.SoaInputParameterImpl
         * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaInputParameter()
         * @generated
         */
        EClass SOA_INPUT_PARAMETER = eINSTANCE.getSoaInputParameter();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_INPUT_PARAMETER__ID = eINSTANCE.getSoaInputParameter_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_INPUT_PARAMETER__LABEL = eINSTANCE.getSoaInputParameter_Label();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOA_INPUT_PARAMETER__OPERATION = eINSTANCE.getSoaInputParameter_Operation();

        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_INPUT_PARAMETER__DEFAULT_VALUE = eINSTANCE.getSoaInputParameter_DefaultValue();

        /**
         * The meta object literal for the '<em><b>Exposed Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_INPUT_PARAMETER__EXPOSED_NAME = eINSTANCE.getSoaInputParameter_ExposedName();

        /**
         * The meta object literal for the '<em><b>Exposed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_INPUT_PARAMETER__EXPOSED = eINSTANCE.getSoaInputParameter_Exposed();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.soa.impl.SoaServiceImpl <em>Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.soa.impl.SoaServiceImpl
         * @see org.talend.model.tac.soa.impl.SoaPackageImpl#getSoaService()
         * @generated
         */
        EClass SOA_SERVICE = eINSTANCE.getSoaService();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__ID = eINSTANCE.getSoaService_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__LABEL = eINSTANCE.getSoaService_Label();

        /**
         * The meta object literal for the '<em><b>Name Space</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__NAME_SPACE = eINSTANCE.getSoaService_NameSpace();

        /**
         * The meta object literal for the '<em><b>Contact</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__CONTACT = eINSTANCE.getSoaService_Contact();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__DESCRIPTION = eINSTANCE.getSoaService_Description();

        /**
         * The meta object literal for the '<em><b>Creation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__CREATION = eINSTANCE.getSoaService_Creation();

        /**
         * The meta object literal for the '<em><b>Modification</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__MODIFICATION = eINSTANCE.getSoaService_Modification();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__PORT = eINSTANCE.getSoaService_Port();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__TYPE = eINSTANCE.getSoaService_Type();

        /**
         * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__STYLE = eINSTANCE.getSoaService_Style();

        /**
         * The meta object literal for the '<em><b>Used Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__USED_TYPE = eINSTANCE.getSoaService_UsedType();

        /**
         * The meta object literal for the '<em><b>Param Style</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__PARAM_STYLE = eINSTANCE.getSoaService_ParamStyle();

        /**
         * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOA_SERVICE__OPERATIONS = eINSTANCE.getSoaService_Operations();

        /**
         * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOA_SERVICE__STATUS = eINSTANCE.getSoaService_Status();

    }

} //SoaPackage
