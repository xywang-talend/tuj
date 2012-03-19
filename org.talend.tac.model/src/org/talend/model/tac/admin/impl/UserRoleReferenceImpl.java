/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.User;
import org.talend.model.tac.admin.UserRole;
import org.talend.model.tac.admin.UserRoleReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Role Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.impl.UserRoleReferenceImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserRoleReferenceImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserRoleReferenceImpl extends EObjectImpl implements UserRoleReference {

    /**
     * The cached value of the '{@link #getUser() <em>User</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected User user;

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected UserRole role;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserRoleReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AdminPackage.Literals.USER_ROLE_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public User getUser() {
        if (user != null && user.eIsProxy()) {
            InternalEObject oldUser = (InternalEObject) user;
            user = (User) eResolveProxy(oldUser);
            if (user != oldUser) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.USER_ROLE_REFERENCE__USER, oldUser,
                            user));
            }
        }
        return user;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public User basicGetUser() {
        return user;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUser(User newUser) {
        User oldUser = user;
        user = newUser;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER_ROLE_REFERENCE__USER, oldUser, user));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRole getRole() {
        if (role != null && role.eIsProxy()) {
            InternalEObject oldRole = (InternalEObject) role;
            role = (UserRole) eResolveProxy(oldRole);
            if (role != oldRole) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.USER_ROLE_REFERENCE__ROLE, oldRole,
                            role));
            }
        }
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserRole basicGetRole() {
        return role;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole(UserRole newRole) {
        UserRole oldRole = role;
        role = newRole;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER_ROLE_REFERENCE__ROLE, oldRole, role));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AdminPackage.USER_ROLE_REFERENCE__USER:
            if (resolve)
                return getUser();
            return basicGetUser();
        case AdminPackage.USER_ROLE_REFERENCE__ROLE:
            if (resolve)
                return getRole();
            return basicGetRole();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AdminPackage.USER_ROLE_REFERENCE__USER:
            setUser((User) newValue);
            return;
        case AdminPackage.USER_ROLE_REFERENCE__ROLE:
            setRole((UserRole) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case AdminPackage.USER_ROLE_REFERENCE__USER:
            setUser((User) null);
            return;
        case AdminPackage.USER_ROLE_REFERENCE__ROLE:
            setRole((UserRole) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case AdminPackage.USER_ROLE_REFERENCE__USER:
            return user != null;
        case AdminPackage.USER_ROLE_REFERENCE__ROLE:
            return role != null;
        }
        return super.eIsSet(featureID);
    }

} //UserRoleReferenceImpl
