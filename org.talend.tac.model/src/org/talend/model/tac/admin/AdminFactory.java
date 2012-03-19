/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.admin.AdminPackage
 * @generated
 */
public interface AdminFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    AdminFactory eINSTANCE = org.talend.model.tac.admin.impl.AdminFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Notification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Notification</em>'.
     * @generated
     */
    Notification createNotification();

    /**
     * Returns a new object of class '<em>Project</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Project</em>'.
     * @generated
     */
    Project createProject();

    /**
     * Returns a new object of class '<em>Project Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Project Reference</em>'.
     * @generated
     */
    ProjectReference createProjectReference();

    /**
     * Returns a new object of class '<em>User Role</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User Role</em>'.
     * @generated
     */
    UserRole createUserRole();

    /**
     * Returns a new object of class '<em>User</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User</em>'.
     * @generated
     */
    User createUser();

    /**
     * Returns a new object of class '<em>User Role Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User Role Reference</em>'.
     * @generated
     */
    UserRoleReference createUserRoleReference();

    /**
     * Returns a new object of class '<em>User Project Authorization</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User Project Authorization</em>'.
     * @generated
     */
    UserProjectAuthorization createUserProjectAuthorization();

    /**
     * Returns a new object of class '<em>Schema Information</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Schema Information</em>'.
     * @generated
     */
    SchemaInformation createSchemaInformation();

    /**
     * Returns a new object of class '<em>Dashboard Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Dashboard Connection</em>'.
     * @generated
     */
    DashboardConnection createDashboardConnection();

    /**
     * Returns a new object of class '<em>License</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>License</em>'.
     * @generated
     */
    License createLicense();

    /**
     * Returns a new object of class '<em>Technical Variable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Technical Variable</em>'.
     * @generated
     */
    TechnicalVariable createTechnicalVariable();

    /**
     * Returns a new object of class '<em>Artifact Notification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Artifact Notification</em>'.
     * @generated
     */
    ArtifactNotification createArtifactNotification();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    AdminPackage getAdminPackage();

} //AdminFactory
