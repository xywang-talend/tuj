/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.talend.model.tac.admin.AdminFactory;
import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.ArtifactNotification;
import org.talend.model.tac.admin.DashboardConnection;
import org.talend.model.tac.admin.License;
import org.talend.model.tac.admin.Notification;
import org.talend.model.tac.admin.Project;
import org.talend.model.tac.admin.ProjectReference;
import org.talend.model.tac.admin.SchemaInformation;
import org.talend.model.tac.admin.TechnicalVariable;
import org.talend.model.tac.admin.User;
import org.talend.model.tac.admin.UserProjectAuthorization;
import org.talend.model.tac.admin.UserProjectAuthorizationType;
import org.talend.model.tac.admin.UserRole;
import org.talend.model.tac.admin.UserRoleReference;

import org.talend.model.tac.conductor.ConductorPackage;

import org.talend.model.tac.conductor.impl.ConductorPackageImpl;

import org.talend.model.tac.soa.SoaPackage;

import org.talend.model.tac.soa.impl.SoaPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdminPackageImpl extends EPackageImpl implements AdminPackage {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass notificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass projectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass projectReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userRoleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userRoleReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userProjectAuthorizationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass schemaInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dashboardConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass licenseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass technicalVariableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass artifactNotificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum userProjectAuthorizationTypeEEnum = null;

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
     * @see org.talend.model.tac.admin.AdminPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AdminPackageImpl() {
        super(eNS_URI, AdminFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link AdminPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AdminPackage init() {
        if (isInited)
            return (AdminPackage) EPackage.Registry.INSTANCE.getEPackage(AdminPackage.eNS_URI);

        // Obtain or create and register package
        AdminPackageImpl theAdminPackage = (AdminPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AdminPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new AdminPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        ConductorPackageImpl theConductorPackage = (ConductorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ConductorPackage.eNS_URI) instanceof ConductorPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ConductorPackage.eNS_URI) : ConductorPackage.eINSTANCE);
        SoaPackageImpl theSoaPackage = (SoaPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SoaPackage.eNS_URI) instanceof SoaPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SoaPackage.eNS_URI) : SoaPackage.eINSTANCE);

        // Create package meta-data objects
        theAdminPackage.createPackageContents();
        theConductorPackage.createPackageContents();
        theSoaPackage.createPackageContents();

        // Initialize created meta-data
        theAdminPackage.initializePackageContents();
        theConductorPackage.initializePackageContents();
        theSoaPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAdminPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AdminPackage.eNS_URI, theAdminPackage);
        return theAdminPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNotification() {
        return notificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNotification_Id() {
        return (EAttribute) notificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNotification_Type() {
        return (EAttribute) notificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNotification_Props() {
        return (EAttribute) notificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNotification_Enabled() {
        return (EAttribute) notificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProject() {
        return projectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProject_UserAuthorization() {
        return (EReference) projectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_MasterJobId() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Id() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Label() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Description() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Language() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_TechnicalLabel() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Deleted() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_DeleteDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_CreationDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProject_Author() {
        return (EReference) projectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProject_ReferencedProjects() {
        return (EReference) projectEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProject_AvailableRefProject() {
        return (EReference) projectEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Url() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Type() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Reference() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProject_Local() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProjectReference() {
        return projectReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProjectReference_Project() {
        return (EReference) projectReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProjectReference_Branch() {
        return (EAttribute) projectReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProjectReference_ReferencedProject() {
        return (EReference) projectReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProjectReference_ReferencedBranch() {
        return (EAttribute) projectReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUserRole() {
        return userRoleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserRole_Id() {
        return (EAttribute) userRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserRole_Name() {
        return (EAttribute) userRoleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserRole_LocalizedLabel() {
        return (EAttribute) userRoleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserRole_Fixed() {
        return (EAttribute) userRoleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUser() {
        return userEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUser_ProjectAuthorization() {
        return (EReference) userEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUser_PreferredDashboardConnection() {
        return (EReference) userEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Id() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Login() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Password() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_FirstName() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_LastName() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_CreationDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_DeleteDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Deleted() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_LastAdminConnectionDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_LastStudioConnectionDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_FirstAdminConnectionDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_FirstStudioConnectionDate() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_AdminConnexionNumber() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_StudioConnexionNumber() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_AuthenticationInfo() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_LdapLogin() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_LdapId() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Language() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_Type() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUser_AdditionnalData() {
        return (EAttribute) userEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUserRoleReference() {
        return userRoleReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserRoleReference_User() {
        return (EReference) userRoleReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserRoleReference_Role() {
        return (EReference) userRoleReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUserProjectAuthorization() {
        return userProjectAuthorizationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserProjectAuthorization_User() {
        return (EReference) userProjectAuthorizationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserProjectAuthorization_Project() {
        return (EReference) userProjectAuthorizationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserProjectAuthorization_Type() {
        return (EAttribute) userProjectAuthorizationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSchemaInformation() {
        return schemaInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSchemaInformation_Version() {
        return (EAttribute) schemaInformationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDashboardConnection() {
        return dashboardConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Id() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Label() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Dialect() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Host() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Port() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Database() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Username() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Password() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_LogTable() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_StatTable() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_FlowMeterTable() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_AdditionnalsParams() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDashboardConnection_Datasource() {
        return (EAttribute) dashboardConnectionEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLicense() {
        return licenseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLicense_License() {
        return (EAttribute) licenseEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLicense_CustomerName() {
        return (EAttribute) licenseEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLicense_Params() {
        return (EAttribute) licenseEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLicense_Token() {
        return (EAttribute) licenseEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLicense_DateTokenCheck() {
        return (EAttribute) licenseEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTechnicalVariable() {
        return technicalVariableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnicalVariable_Key() {
        return (EAttribute) technicalVariableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTechnicalVariable_Value() {
        return (EAttribute) technicalVariableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArtifactNotification() {
        return artifactNotificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArtifactNotification_Name() {
        return (EAttribute) artifactNotificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getUserProjectAuthorizationType() {
        return userProjectAuthorizationTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AdminFactory getAdminFactory() {
        return (AdminFactory) getEFactoryInstance();
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
        notificationEClass = createEClass(NOTIFICATION);
        createEAttribute(notificationEClass, NOTIFICATION__ID);
        createEAttribute(notificationEClass, NOTIFICATION__TYPE);
        createEAttribute(notificationEClass, NOTIFICATION__PROPS);
        createEAttribute(notificationEClass, NOTIFICATION__ENABLED);

        projectEClass = createEClass(PROJECT);
        createEReference(projectEClass, PROJECT__USER_AUTHORIZATION);
        createEAttribute(projectEClass, PROJECT__MASTER_JOB_ID);
        createEAttribute(projectEClass, PROJECT__ID);
        createEAttribute(projectEClass, PROJECT__LABEL);
        createEAttribute(projectEClass, PROJECT__DESCRIPTION);
        createEAttribute(projectEClass, PROJECT__LANGUAGE);
        createEAttribute(projectEClass, PROJECT__TECHNICAL_LABEL);
        createEAttribute(projectEClass, PROJECT__DELETED);
        createEAttribute(projectEClass, PROJECT__DELETE_DATE);
        createEAttribute(projectEClass, PROJECT__CREATION_DATE);
        createEReference(projectEClass, PROJECT__AUTHOR);
        createEReference(projectEClass, PROJECT__REFERENCED_PROJECTS);
        createEReference(projectEClass, PROJECT__AVAILABLE_REF_PROJECT);
        createEAttribute(projectEClass, PROJECT__URL);
        createEAttribute(projectEClass, PROJECT__TYPE);
        createEAttribute(projectEClass, PROJECT__REFERENCE);
        createEAttribute(projectEClass, PROJECT__LOCAL);

        projectReferenceEClass = createEClass(PROJECT_REFERENCE);
        createEReference(projectReferenceEClass, PROJECT_REFERENCE__PROJECT);
        createEAttribute(projectReferenceEClass, PROJECT_REFERENCE__BRANCH);
        createEReference(projectReferenceEClass, PROJECT_REFERENCE__REFERENCED_PROJECT);
        createEAttribute(projectReferenceEClass, PROJECT_REFERENCE__REFERENCED_BRANCH);

        userRoleEClass = createEClass(USER_ROLE);
        createEAttribute(userRoleEClass, USER_ROLE__ID);
        createEAttribute(userRoleEClass, USER_ROLE__NAME);
        createEAttribute(userRoleEClass, USER_ROLE__LOCALIZED_LABEL);
        createEAttribute(userRoleEClass, USER_ROLE__FIXED);

        userEClass = createEClass(USER);
        createEReference(userEClass, USER__PROJECT_AUTHORIZATION);
        createEReference(userEClass, USER__PREFERRED_DASHBOARD_CONNECTION);
        createEAttribute(userEClass, USER__ID);
        createEAttribute(userEClass, USER__LOGIN);
        createEAttribute(userEClass, USER__PASSWORD);
        createEAttribute(userEClass, USER__FIRST_NAME);
        createEAttribute(userEClass, USER__LAST_NAME);
        createEAttribute(userEClass, USER__CREATION_DATE);
        createEAttribute(userEClass, USER__DELETE_DATE);
        createEAttribute(userEClass, USER__DELETED);
        createEAttribute(userEClass, USER__LAST_ADMIN_CONNECTION_DATE);
        createEAttribute(userEClass, USER__LAST_STUDIO_CONNECTION_DATE);
        createEAttribute(userEClass, USER__FIRST_ADMIN_CONNECTION_DATE);
        createEAttribute(userEClass, USER__FIRST_STUDIO_CONNECTION_DATE);
        createEAttribute(userEClass, USER__ADMIN_CONNEXION_NUMBER);
        createEAttribute(userEClass, USER__STUDIO_CONNEXION_NUMBER);
        createEAttribute(userEClass, USER__AUTHENTICATION_INFO);
        createEAttribute(userEClass, USER__LDAP_LOGIN);
        createEAttribute(userEClass, USER__LDAP_ID);
        createEAttribute(userEClass, USER__LANGUAGE);
        createEAttribute(userEClass, USER__TYPE);
        createEAttribute(userEClass, USER__ADDITIONNAL_DATA);

        userRoleReferenceEClass = createEClass(USER_ROLE_REFERENCE);
        createEReference(userRoleReferenceEClass, USER_ROLE_REFERENCE__USER);
        createEReference(userRoleReferenceEClass, USER_ROLE_REFERENCE__ROLE);

        userProjectAuthorizationEClass = createEClass(USER_PROJECT_AUTHORIZATION);
        createEReference(userProjectAuthorizationEClass, USER_PROJECT_AUTHORIZATION__USER);
        createEReference(userProjectAuthorizationEClass, USER_PROJECT_AUTHORIZATION__PROJECT);
        createEAttribute(userProjectAuthorizationEClass, USER_PROJECT_AUTHORIZATION__TYPE);

        schemaInformationEClass = createEClass(SCHEMA_INFORMATION);
        createEAttribute(schemaInformationEClass, SCHEMA_INFORMATION__VERSION);

        dashboardConnectionEClass = createEClass(DASHBOARD_CONNECTION);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__ID);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__LABEL);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__DIALECT);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__HOST);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__PORT);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__DATABASE);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__USERNAME);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__PASSWORD);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__LOG_TABLE);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__STAT_TABLE);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__FLOW_METER_TABLE);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__ADDITIONNALS_PARAMS);
        createEAttribute(dashboardConnectionEClass, DASHBOARD_CONNECTION__DATASOURCE);

        licenseEClass = createEClass(LICENSE);
        createEAttribute(licenseEClass, LICENSE__LICENSE);
        createEAttribute(licenseEClass, LICENSE__CUSTOMER_NAME);
        createEAttribute(licenseEClass, LICENSE__PARAMS);
        createEAttribute(licenseEClass, LICENSE__TOKEN);
        createEAttribute(licenseEClass, LICENSE__DATE_TOKEN_CHECK);

        technicalVariableEClass = createEClass(TECHNICAL_VARIABLE);
        createEAttribute(technicalVariableEClass, TECHNICAL_VARIABLE__KEY);
        createEAttribute(technicalVariableEClass, TECHNICAL_VARIABLE__VALUE);

        artifactNotificationEClass = createEClass(ARTIFACT_NOTIFICATION);
        createEAttribute(artifactNotificationEClass, ARTIFACT_NOTIFICATION__NAME);

        // Create enums
        userProjectAuthorizationTypeEEnum = createEEnum(USER_PROJECT_AUTHORIZATION_TYPE);
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
        XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(notificationEClass, Notification.class, "Notification", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNotification_Id(), ecorePackage.getEInt(), "id", null, 1, 1, Notification.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNotification_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, Notification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNotification_Props(), ecorePackage.getEString(), "props", null, 0, 1, Notification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNotification_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, Notification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getProject_UserAuthorization(), this.getUserProjectAuthorization(),
                this.getUserProjectAuthorization_Project(), "userAuthorization", null, 0, -1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEAttribute(getProject_MasterJobId(), theXMLTypePackage.getString(), "masterJobId", null, 0, 1, Project.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Id(), ecorePackage.getEInt(), "id", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Label(), ecorePackage.getEString(), "label", null, 1, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Description(), ecorePackage.getEString(), "description", null, 0, 1, Project.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Language(), ecorePackage.getEString(), "language", null, 1, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_TechnicalLabel(), ecorePackage.getEString(), "technicalLabel", null, 1, 1, Project.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Deleted(), ecorePackage.getEBoolean(), "deleted", null, 1, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_DeleteDate(), ecorePackage.getEDate(), "deleteDate", null, 0, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 1, 1, Project.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_Author(), this.getUser(), null, "author", null, 0, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getProject_ReferencedProjects(), this.getProjectReference(), null, "referencedProjects", null, 0, -1,
                Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProject_AvailableRefProject(), this.getProjectReference(), null, "availableRefProject", null, 0, -1,
                Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProject_Url(), ecorePackage.getEString(), "url", null, 0, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Type(), ecorePackage.getEString(), "type", null, 0, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Reference(), ecorePackage.getEBoolean(), "reference", null, 1, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Local(), ecorePackage.getEBoolean(), "local", null, 1, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(projectReferenceEClass, ProjectReference.class, "ProjectReference", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getProjectReference_Project(), this.getProject(), null, "project", null, 1, 1, ProjectReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProjectReference_Branch(), ecorePackage.getEString(), "branch", null, 0, 1, ProjectReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProjectReference_ReferencedProject(), this.getProject(), null, "referencedProject", null, 1, 1,
                ProjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProjectReference_ReferencedBranch(), ecorePackage.getEString(), "referencedBranch", null, 0, 1,
                ProjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(userRoleEClass, UserRole.class, "UserRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getUserRole_Id(), ecorePackage.getEInt(), "id", null, 1, 1, UserRole.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserRole_Name(), ecorePackage.getEString(), "name", null, 1, 1, UserRole.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserRole_LocalizedLabel(), ecorePackage.getEString(), "localizedLabel", null, 1, 1, UserRole.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserRole_Fixed(), ecorePackage.getEBoolean(), "fixed", null, 0, 1, UserRole.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUser_ProjectAuthorization(), this.getUserProjectAuthorization(),
                this.getUserProjectAuthorization_User(), "projectAuthorization", null, 0, -1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(getUser_PreferredDashboardConnection(), this.getDashboardConnection(), null,
                "preferredDashboardConnection", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Id(), ecorePackage.getEInt(), "id", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Login(), ecorePackage.getEString(), "login", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Password(), ecorePackage.getEByteArray(), "password", null, 1, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_LastName(), ecorePackage.getEString(), "lastName", null, 1, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 1, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_DeleteDate(), ecorePackage.getEDate(), "deleteDate", null, 0, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Deleted(), ecorePackage.getEBoolean(), "deleted", null, 0, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_LastAdminConnectionDate(), ecorePackage.getEDate(), "lastAdminConnectionDate", null, 0, 1,
                User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getUser_LastStudioConnectionDate(), ecorePackage.getEDate(), "lastStudioConnectionDate", null, 0, 1,
                User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getUser_FirstAdminConnectionDate(), ecorePackage.getEDate(), "firstAdminConnectionDate", null, 0, 1,
                User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getUser_FirstStudioConnectionDate(), ecorePackage.getEDate(), "firstStudioConnectionDate", null, 0, 1,
                User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getUser_AdminConnexionNumber(), ecorePackage.getEInt(), "adminConnexionNumber", null, 0, 1, User.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_StudioConnexionNumber(), ecorePackage.getEInt(), "studioConnexionNumber", null, 0, 1, User.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_AuthenticationInfo(), ecorePackage.getEString(), "authenticationInfo", null, 0, 1, User.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_LdapLogin(), ecorePackage.getEString(), "ldapLogin", null, 0, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_LdapId(), ecorePackage.getEString(), "ldapId", null, 0, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Language(), ecorePackage.getEString(), "language", null, 0, 1, User.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_Type(), ecorePackage.getEString(), "type", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUser_AdditionnalData(), ecorePackage.getEString(), "additionnalData", null, 0, 1, User.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(userRoleReferenceEClass, UserRoleReference.class, "UserRoleReference", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUserRoleReference_User(), this.getUser(), null, "user", null, 1, 1, UserRoleReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getUserRoleReference_Role(), this.getUserRole(), null, "role", null, 1, 1, UserRoleReference.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(userProjectAuthorizationEClass, UserProjectAuthorization.class, "UserProjectAuthorization", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUserProjectAuthorization_User(), this.getUser(), this.getUser_ProjectAuthorization(), "user", null, 0,
                1, UserProjectAuthorization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserProjectAuthorization_Project(), this.getProject(), this.getProject_UserAuthorization(), "project",
                null, 0, 1, UserProjectAuthorization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserProjectAuthorization_Type(), this.getUserProjectAuthorizationType(), "type", "ReadWrite", 0, 1,
                UserProjectAuthorization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(schemaInformationEClass, SchemaInformation.class, "SchemaInformation", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSchemaInformation_Version(), ecorePackage.getEString(), "version", null, 0, 1, SchemaInformation.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dashboardConnectionEClass, DashboardConnection.class, "DashboardConnection", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDashboardConnection_Id(), ecorePackage.getEInt(), "id", null, 1, 1, DashboardConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Label(), ecorePackage.getEString(), "label", null, 0, 1, DashboardConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Dialect(), ecorePackage.getEString(), "dialect", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Host(), ecorePackage.getEString(), "host", null, 0, 1, DashboardConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Port(), ecorePackage.getEString(), "port", null, 0, 1, DashboardConnection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Database(), ecorePackage.getEString(), "database", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Username(), ecorePackage.getEString(), "username", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Password(), ecorePackage.getEString(), "password", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_LogTable(), ecorePackage.getEString(), "logTable", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_StatTable(), ecorePackage.getEString(), "statTable", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_FlowMeterTable(), ecorePackage.getEString(), "flowMeterTable", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_AdditionnalsParams(), ecorePackage.getEString(), "additionnalsParams", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDashboardConnection_Datasource(), ecorePackage.getEString(), "datasource", null, 0, 1,
                DashboardConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(licenseEClass, License.class, "License", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLicense_License(), ecorePackage.getEByteArray(), "license", null, 0, 1, License.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLicense_CustomerName(), theXMLTypePackage.getString(), "customerName", null, 0, 1, License.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLicense_Params(), theXMLTypePackage.getString(), "params", null, 0, 1, License.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLicense_Token(), theXMLTypePackage.getString(), "token", null, 0, 1, License.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLicense_DateTokenCheck(), theXMLTypePackage.getString(), "dateTokenCheck", null, 0, 1, License.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(technicalVariableEClass, TechnicalVariable.class, "TechnicalVariable", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTechnicalVariable_Key(), ecorePackage.getEString(), "key", null, 0, 1, TechnicalVariable.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTechnicalVariable_Value(), ecorePackage.getEString(), "value", null, 0, 1, TechnicalVariable.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(artifactNotificationEClass, ArtifactNotification.class, "ArtifactNotification", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getArtifactNotification_Name(), ecorePackage.getEString(), "name", null, 1, 1, ArtifactNotification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(userProjectAuthorizationTypeEEnum, UserProjectAuthorizationType.class, "UserProjectAuthorizationType");
        addEEnumLiteral(userProjectAuthorizationTypeEEnum, UserProjectAuthorizationType.READ_WRITE_LITERAL);
        addEEnumLiteral(userProjectAuthorizationTypeEEnum, UserProjectAuthorizationType.READ_ONLY_LITERAL);

        // Create resource
        createResource(eNS_URI);
    }

} //AdminPackageImpl
