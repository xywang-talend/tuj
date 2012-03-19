/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.talend.model.tac.admin.*;

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
 * @see org.talend.model.tac.admin.AdminPackage
 * @generated
 */
public class AdminSwitch {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static AdminPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AdminSwitch() {
        if (modelPackage == null) {
            modelPackage = AdminPackage.eINSTANCE;
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
        case AdminPackage.NOTIFICATION: {
            Notification notification = (Notification) theEObject;
            Object result = caseNotification(notification);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.PROJECT: {
            Project project = (Project) theEObject;
            Object result = caseProject(project);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.PROJECT_REFERENCE: {
            ProjectReference projectReference = (ProjectReference) theEObject;
            Object result = caseProjectReference(projectReference);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.USER_ROLE: {
            UserRole userRole = (UserRole) theEObject;
            Object result = caseUserRole(userRole);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.USER: {
            User user = (User) theEObject;
            Object result = caseUser(user);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.USER_ROLE_REFERENCE: {
            UserRoleReference userRoleReference = (UserRoleReference) theEObject;
            Object result = caseUserRoleReference(userRoleReference);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.USER_PROJECT_AUTHORIZATION: {
            UserProjectAuthorization userProjectAuthorization = (UserProjectAuthorization) theEObject;
            Object result = caseUserProjectAuthorization(userProjectAuthorization);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.SCHEMA_INFORMATION: {
            SchemaInformation schemaInformation = (SchemaInformation) theEObject;
            Object result = caseSchemaInformation(schemaInformation);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.DASHBOARD_CONNECTION: {
            DashboardConnection dashboardConnection = (DashboardConnection) theEObject;
            Object result = caseDashboardConnection(dashboardConnection);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.LICENSE: {
            License license = (License) theEObject;
            Object result = caseLicense(license);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.TECHNICAL_VARIABLE: {
            TechnicalVariable technicalVariable = (TechnicalVariable) theEObject;
            Object result = caseTechnicalVariable(technicalVariable);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case AdminPackage.ARTIFACT_NOTIFICATION: {
            ArtifactNotification artifactNotification = (ArtifactNotification) theEObject;
            Object result = caseArtifactNotification(artifactNotification);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Notification</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Notification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseNotification(Notification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Project</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseProject(Project object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Project Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Project Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseProjectReference(ProjectReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>User Role</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseUserRole(UserRole object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>User</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseUser(User object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>User Role Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Role Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseUserRoleReference(UserRoleReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>User Project Authorization</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Project Authorization</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseUserProjectAuthorization(UserProjectAuthorization object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Schema Information</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Schema Information</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSchemaInformation(SchemaInformation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dashboard Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dashboard Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDashboardConnection(DashboardConnection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>License</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>License</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseLicense(License object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Technical Variable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Technical Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTechnicalVariable(TechnicalVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Artifact Notification</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Artifact Notification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseArtifactNotification(ArtifactNotification object) {
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

} //AdminSwitch
