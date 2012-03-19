/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.model.tac.admin.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdminFactoryImpl extends EFactoryImpl implements AdminFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static AdminFactory init() {
        try {
            AdminFactory theAdminFactory = (AdminFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://www.talend.org/tac/admin");
            if (theAdminFactory != null) {
                return theAdminFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AdminFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AdminFactoryImpl() {
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
        case AdminPackage.NOTIFICATION:
            return createNotification();
        case AdminPackage.PROJECT:
            return createProject();
        case AdminPackage.PROJECT_REFERENCE:
            return createProjectReference();
        case AdminPackage.USER_ROLE:
            return createUserRole();
        case AdminPackage.USER:
            return createUser();
        case AdminPackage.USER_ROLE_REFERENCE:
            return createUserRoleReference();
        case AdminPackage.USER_PROJECT_AUTHORIZATION:
            return createUserProjectAuthorization();
        case AdminPackage.SCHEMA_INFORMATION:
            return createSchemaInformation();
        case AdminPackage.DASHBOARD_CONNECTION:
            return createDashboardConnection();
        case AdminPackage.LICENSE:
            return createLicense();
        case AdminPackage.TECHNICAL_VARIABLE:
            return createTechnicalVariable();
        case AdminPackage.ARTIFACT_NOTIFICATION:
            return createArtifactNotification();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case AdminPackage.USER_PROJECT_AUTHORIZATION_TYPE:
            return createUserProjectAuthorizationTypeFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case AdminPackage.USER_PROJECT_AUTHORIZATION_TYPE:
            return convertUserProjectAuthorizationTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Notification createNotification() {
        NotificationImpl notification = new NotificationImpl();
        return notification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Project createProject() {
        ProjectImpl project = new ProjectImpl();
        return project;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProjectReference createProjectReference() {
        ProjectReferenceImpl projectReference = new ProjectReferenceImpl();
        return projectReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRole createUserRole() {
        UserRoleImpl userRole = new UserRoleImpl();
        return userRole;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public User createUser() {
        UserImpl user = new UserImpl();
        return user;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRoleReference createUserRoleReference() {
        UserRoleReferenceImpl userRoleReference = new UserRoleReferenceImpl();
        return userRoleReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserProjectAuthorization createUserProjectAuthorization() {
        UserProjectAuthorizationImpl userProjectAuthorization = new UserProjectAuthorizationImpl();
        return userProjectAuthorization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SchemaInformation createSchemaInformation() {
        SchemaInformationImpl schemaInformation = new SchemaInformationImpl();
        return schemaInformation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DashboardConnection createDashboardConnection() {
        DashboardConnectionImpl dashboardConnection = new DashboardConnectionImpl();
        return dashboardConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public License createLicense() {
        LicenseImpl license = new LicenseImpl();
        return license;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnicalVariable createTechnicalVariable() {
        TechnicalVariableImpl technicalVariable = new TechnicalVariableImpl();
        return technicalVariable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArtifactNotification createArtifactNotification() {
        ArtifactNotificationImpl artifactNotification = new ArtifactNotificationImpl();
        return artifactNotification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserProjectAuthorizationType createUserProjectAuthorizationTypeFromString(EDataType eDataType, String initialValue) {
        UserProjectAuthorizationType result = UserProjectAuthorizationType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertUserProjectAuthorizationTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AdminPackage getAdminPackage() {
        return (AdminPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static AdminPackage getPackage() {
        return AdminPackage.eINSTANCE;
    }

} //AdminFactoryImpl
