/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.model.tac.admin.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.admin.AdminPackage
 * @generated
 */
public class AdminAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static AdminPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AdminAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AdminPackage.eINSTANCE;
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
    protected AdminSwitch modelSwitch = new AdminSwitch() {

        public Object caseNotification(Notification object) {
            return createNotificationAdapter();
        }

        public Object caseProject(Project object) {
            return createProjectAdapter();
        }

        public Object caseProjectReference(ProjectReference object) {
            return createProjectReferenceAdapter();
        }

        public Object caseUserRole(UserRole object) {
            return createUserRoleAdapter();
        }

        public Object caseUser(User object) {
            return createUserAdapter();
        }

        public Object caseUserRoleReference(UserRoleReference object) {
            return createUserRoleReferenceAdapter();
        }

        public Object caseUserProjectAuthorization(UserProjectAuthorization object) {
            return createUserProjectAuthorizationAdapter();
        }

        public Object caseSchemaInformation(SchemaInformation object) {
            return createSchemaInformationAdapter();
        }

        public Object caseDashboardConnection(DashboardConnection object) {
            return createDashboardConnectionAdapter();
        }

        public Object caseLicense(License object) {
            return createLicenseAdapter();
        }

        public Object caseTechnicalVariable(TechnicalVariable object) {
            return createTechnicalVariableAdapter();
        }

        public Object caseArtifactNotification(ArtifactNotification object) {
            return createArtifactNotificationAdapter();
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
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.Notification <em>Notification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.Notification
     * @generated
     */
    public Adapter createNotificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.Project <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.Project
     * @generated
     */
    public Adapter createProjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.ProjectReference <em>Project Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.ProjectReference
     * @generated
     */
    public Adapter createProjectReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.UserRole <em>User Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.UserRole
     * @generated
     */
    public Adapter createUserRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.User <em>User</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.User
     * @generated
     */
    public Adapter createUserAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.UserRoleReference <em>User Role Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.UserRoleReference
     * @generated
     */
    public Adapter createUserRoleReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.UserProjectAuthorization <em>User Project Authorization</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.UserProjectAuthorization
     * @generated
     */
    public Adapter createUserProjectAuthorizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.SchemaInformation <em>Schema Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.SchemaInformation
     * @generated
     */
    public Adapter createSchemaInformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.DashboardConnection <em>Dashboard Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.DashboardConnection
     * @generated
     */
    public Adapter createDashboardConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.License <em>License</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.License
     * @generated
     */
    public Adapter createLicenseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.TechnicalVariable <em>Technical Variable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.TechnicalVariable
     * @generated
     */
    public Adapter createTechnicalVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.model.tac.admin.ArtifactNotification <em>Artifact Notification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.model.tac.admin.ArtifactNotification
     * @generated
     */
    public Adapter createArtifactNotificationAdapter() {
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

} //AdminAdapterFactory
