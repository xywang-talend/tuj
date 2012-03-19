/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.soa.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.talend.model.tac.admin.AdminPackage;

import org.talend.model.tac.admin.impl.AdminPackageImpl;

import org.talend.model.tac.conductor.ConductorPackage;

import org.talend.model.tac.conductor.impl.ConductorPackageImpl;

import org.talend.model.tac.soa.SoaFactory;
import org.talend.model.tac.soa.SoaInputParameter;
import org.talend.model.tac.soa.SoaOperation;
import org.talend.model.tac.soa.SoaPackage;
import org.talend.model.tac.soa.SoaService;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoaPackageImpl extends EPackageImpl implements SoaPackage {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass soaOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass soaInputParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass soaServiceEClass = null;

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
     * @see org.talend.model.tac.soa.SoaPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SoaPackageImpl() {
        super(eNS_URI, SoaFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link SoaPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SoaPackage init() {
        if (isInited)
            return (SoaPackage) EPackage.Registry.INSTANCE.getEPackage(SoaPackage.eNS_URI);

        // Obtain or create and register package
        SoaPackageImpl theSoaPackage = (SoaPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SoaPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new SoaPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        AdminPackageImpl theAdminPackage = (AdminPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(AdminPackage.eNS_URI) instanceof AdminPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(AdminPackage.eNS_URI) : AdminPackage.eINSTANCE);
        ConductorPackageImpl theConductorPackage = (ConductorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ConductorPackage.eNS_URI) instanceof ConductorPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ConductorPackage.eNS_URI) : ConductorPackage.eINSTANCE);

        // Create package meta-data objects
        theSoaPackage.createPackageContents();
        theAdminPackage.createPackageContents();
        theConductorPackage.createPackageContents();

        // Initialize created meta-data
        theSoaPackage.initializePackageContents();
        theAdminPackage.initializePackageContents();
        theConductorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSoaPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SoaPackage.eNS_URI, theSoaPackage);
        return theSoaPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSoaOperation() {
        return soaOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Id() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Label() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Description() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSoaOperation_Project() {
        return (EReference) soaOperationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Context() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_JobVersion() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_JobName() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Active() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_LastScriptGenerationDate() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_JobId() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_ApplyContextToChildren() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSoaOperation_InputParameters() {
        return (EReference) soaOperationEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_JvmParameters() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Xms() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Xmx() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_MinJobInstances() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_MaxJobInstances() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_IdleTTL_forAllInstances() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_IdleTTL_forAdditionalInstances() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_QueueMaxSize() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_RequestInQueueTTL() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSoaOperation_Service() {
        return (EReference) soaOperationEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_ReturnStyle() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaOperation_Branch() {
        return (EAttribute) soaOperationEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSoaInputParameter() {
        return soaInputParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaInputParameter_Id() {
        return (EAttribute) soaInputParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaInputParameter_Label() {
        return (EAttribute) soaInputParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSoaInputParameter_Operation() {
        return (EReference) soaInputParameterEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaInputParameter_DefaultValue() {
        return (EAttribute) soaInputParameterEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaInputParameter_ExposedName() {
        return (EAttribute) soaInputParameterEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaInputParameter_Exposed() {
        return (EAttribute) soaInputParameterEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSoaService() {
        return soaServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Id() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Label() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_NameSpace() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Contact() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Description() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Creation() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Modification() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Port() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Type() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Style() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_UsedType() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_ParamStyle() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSoaService_Operations() {
        return (EReference) soaServiceEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSoaService_Status() {
        return (EAttribute) soaServiceEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaFactory getSoaFactory() {
        return (SoaFactory) getEFactoryInstance();
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
        soaOperationEClass = createEClass(SOA_OPERATION);
        createEAttribute(soaOperationEClass, SOA_OPERATION__ID);
        createEAttribute(soaOperationEClass, SOA_OPERATION__LABEL);
        createEAttribute(soaOperationEClass, SOA_OPERATION__DESCRIPTION);
        createEReference(soaOperationEClass, SOA_OPERATION__PROJECT);
        createEAttribute(soaOperationEClass, SOA_OPERATION__CONTEXT);
        createEAttribute(soaOperationEClass, SOA_OPERATION__JOB_VERSION);
        createEAttribute(soaOperationEClass, SOA_OPERATION__JOB_NAME);
        createEAttribute(soaOperationEClass, SOA_OPERATION__ACTIVE);
        createEAttribute(soaOperationEClass, SOA_OPERATION__LAST_SCRIPT_GENERATION_DATE);
        createEAttribute(soaOperationEClass, SOA_OPERATION__JOB_ID);
        createEAttribute(soaOperationEClass, SOA_OPERATION__APPLY_CONTEXT_TO_CHILDREN);
        createEReference(soaOperationEClass, SOA_OPERATION__INPUT_PARAMETERS);
        createEAttribute(soaOperationEClass, SOA_OPERATION__JVM_PARAMETERS);
        createEAttribute(soaOperationEClass, SOA_OPERATION__XMS);
        createEAttribute(soaOperationEClass, SOA_OPERATION__XMX);
        createEAttribute(soaOperationEClass, SOA_OPERATION__MIN_JOB_INSTANCES);
        createEAttribute(soaOperationEClass, SOA_OPERATION__MAX_JOB_INSTANCES);
        createEAttribute(soaOperationEClass, SOA_OPERATION__IDLE_TTL_FOR_ALL_INSTANCES);
        createEAttribute(soaOperationEClass, SOA_OPERATION__IDLE_TTL_FOR_ADDITIONAL_INSTANCES);
        createEAttribute(soaOperationEClass, SOA_OPERATION__QUEUE_MAX_SIZE);
        createEAttribute(soaOperationEClass, SOA_OPERATION__REQUEST_IN_QUEUE_TTL);
        createEReference(soaOperationEClass, SOA_OPERATION__SERVICE);
        createEAttribute(soaOperationEClass, SOA_OPERATION__RETURN_STYLE);
        createEAttribute(soaOperationEClass, SOA_OPERATION__BRANCH);

        soaInputParameterEClass = createEClass(SOA_INPUT_PARAMETER);
        createEAttribute(soaInputParameterEClass, SOA_INPUT_PARAMETER__ID);
        createEAttribute(soaInputParameterEClass, SOA_INPUT_PARAMETER__LABEL);
        createEReference(soaInputParameterEClass, SOA_INPUT_PARAMETER__OPERATION);
        createEAttribute(soaInputParameterEClass, SOA_INPUT_PARAMETER__DEFAULT_VALUE);
        createEAttribute(soaInputParameterEClass, SOA_INPUT_PARAMETER__EXPOSED_NAME);
        createEAttribute(soaInputParameterEClass, SOA_INPUT_PARAMETER__EXPOSED);

        soaServiceEClass = createEClass(SOA_SERVICE);
        createEAttribute(soaServiceEClass, SOA_SERVICE__ID);
        createEAttribute(soaServiceEClass, SOA_SERVICE__LABEL);
        createEAttribute(soaServiceEClass, SOA_SERVICE__NAME_SPACE);
        createEAttribute(soaServiceEClass, SOA_SERVICE__CONTACT);
        createEAttribute(soaServiceEClass, SOA_SERVICE__DESCRIPTION);
        createEAttribute(soaServiceEClass, SOA_SERVICE__CREATION);
        createEAttribute(soaServiceEClass, SOA_SERVICE__MODIFICATION);
        createEAttribute(soaServiceEClass, SOA_SERVICE__PORT);
        createEAttribute(soaServiceEClass, SOA_SERVICE__TYPE);
        createEAttribute(soaServiceEClass, SOA_SERVICE__STYLE);
        createEAttribute(soaServiceEClass, SOA_SERVICE__USED_TYPE);
        createEAttribute(soaServiceEClass, SOA_SERVICE__PARAM_STYLE);
        createEReference(soaServiceEClass, SOA_SERVICE__OPERATIONS);
        createEAttribute(soaServiceEClass, SOA_SERVICE__STATUS);
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

        // Initialize classes and features; add operations and parameters
        initEClass(soaOperationEClass, SoaOperation.class, "SoaOperation", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSoaOperation_Id(), ecorePackage.getEInt(), "id", null, 1, 1, SoaOperation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Label(), ecorePackage.getEString(), "label", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Description(), ecorePackage.getEString(), "description", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSoaOperation_Project(), theAdminPackage.getProject(), null, "project", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Context(), ecorePackage.getEString(), "context", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_JobVersion(), ecorePackage.getEString(), "jobVersion", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_JobName(), ecorePackage.getEString(), "jobName", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_LastScriptGenerationDate(), ecorePackage.getEDate(), "lastScriptGenerationDate", null, 0,
                1, SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_JobId(), ecorePackage.getEString(), "jobId", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_ApplyContextToChildren(), ecorePackage.getEBoolean(), "applyContextToChildren", null, 0,
                1, SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getSoaOperation_InputParameters(), this.getSoaInputParameter(), null, "inputParameters", null, 0, -1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSoaOperation_JvmParameters(), ecorePackage.getEString(), "jvmParameters", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getSoaOperation_Xms(), ecorePackage.getEInt(), "xms", null, 0, 1, SoaOperation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Xmx(), ecorePackage.getEInt(), "xmx", null, 0, 1, SoaOperation.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_MinJobInstances(), ecorePackage.getEInt(), "minJobInstances", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getSoaOperation_MaxJobInstances(), ecorePackage.getEInt(), "maxJobInstances", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getSoaOperation_IdleTTL_forAllInstances(), ecorePackage.getEInt(), "idleTTL_forAllInstances", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getSoaOperation_IdleTTL_forAdditionalInstances(), ecorePackage.getEInt(),
                "idleTTL_forAdditionalInstances", null, 0, 1, SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_QueueMaxSize(), ecorePackage.getEInt(), "queueMaxSize", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_RequestInQueueTTL(), ecorePackage.getEInt(), "requestInQueueTTL", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getSoaOperation_Service(), this.getSoaService(), this.getSoaService_Operations(), "service", null, 0, 1,
                SoaOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_ReturnStyle(), ecorePackage.getEString(), "returnStyle", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaOperation_Branch(), ecorePackage.getEString(), "branch", null, 0, 1, SoaOperation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(soaInputParameterEClass, SoaInputParameter.class, "SoaInputParameter", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSoaInputParameter_Id(), ecorePackage.getEInt(), "id", null, 1, 1, SoaInputParameter.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaInputParameter_Label(), ecorePackage.getEString(), "label", null, 0, 1, SoaInputParameter.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSoaInputParameter_Operation(), this.getSoaOperation(), null, "operation", null, 0, 1,
                SoaInputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaInputParameter_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1,
                SoaInputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaInputParameter_ExposedName(), ecorePackage.getEString(), "exposedName", null, 0, 1,
                SoaInputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaInputParameter_Exposed(), ecorePackage.getEBoolean(), "exposed", null, 0, 1,
                SoaInputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(soaServiceEClass, SoaService.class, "SoaService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSoaService_Id(), ecorePackage.getEInt(), "id", null, 1, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Label(), ecorePackage.getEString(), "label", null, 0, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_NameSpace(), ecorePackage.getEString(), "nameSpace", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Contact(), ecorePackage.getEString(), "contact", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Description(), ecorePackage.getEString(), "description", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Creation(), ecorePackage.getEDate(), "creation", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Modification(), ecorePackage.getEDate(), "modification", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Port(), ecorePackage.getEInt(), "port", null, 0, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Type(), ecorePackage.getEString(), "type", null, 0, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_Style(), ecorePackage.getEString(), "style", null, 0, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_UsedType(), ecorePackage.getEString(), "usedType", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSoaService_ParamStyle(), ecorePackage.getEString(), "paramStyle", null, 0, 1, SoaService.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSoaService_Operations(), this.getSoaOperation(), this.getSoaOperation_Service(), "operations", null, 0,
                -1, SoaService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSoaService_Status(), ecorePackage.getEString(), "status", null, 0, 1, SoaService.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //SoaPackageImpl
