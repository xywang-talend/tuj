/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.Project;
import org.talend.model.tac.admin.User;
import org.talend.model.tac.admin.UserProjectAuthorization;
import org.talend.model.tac.admin.UserProjectAuthorizationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Project Authorization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserProjectAuthorizationImpl extends EObjectImpl implements UserProjectAuthorization {

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
     * The cached value of the '{@link #getProject() <em>Project</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProject()
     * @generated
     * @ordered
     */
    protected Project project;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final UserProjectAuthorizationType TYPE_EDEFAULT = UserProjectAuthorizationType.READ_WRITE_LITERAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected UserProjectAuthorizationType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserProjectAuthorizationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AdminPackage.Literals.USER_PROJECT_AUTHORIZATION;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.USER_PROJECT_AUTHORIZATION__USER,
                            oldUser, user));
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
    public NotificationChain basicSetUser(User newUser, NotificationChain msgs) {
        User oldUser = user;
        user = newUser;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AdminPackage.USER_PROJECT_AUTHORIZATION__USER, oldUser, newUser);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUser(User newUser) {
        if (newUser != user) {
            NotificationChain msgs = null;
            if (user != null)
                msgs = ((InternalEObject) user).eInverseRemove(this, AdminPackage.USER__PROJECT_AUTHORIZATION, User.class, msgs);
            if (newUser != null)
                msgs = ((InternalEObject) newUser).eInverseAdd(this, AdminPackage.USER__PROJECT_AUTHORIZATION, User.class, msgs);
            msgs = basicSetUser(newUser, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER_PROJECT_AUTHORIZATION__USER, newUser, newUser));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Project getProject() {
        if (project != null && project.eIsProxy()) {
            InternalEObject oldProject = (InternalEObject) project;
            project = (Project) eResolveProxy(oldProject);
            if (project != oldProject) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT,
                            oldProject, project));
            }
        }
        return project;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Project basicGetProject() {
        return project;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
        Project oldProject = project;
        project = newProject;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT, oldProject, newProject);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProject(Project newProject) {
        if (newProject != project) {
            NotificationChain msgs = null;
            if (project != null)
                msgs = ((InternalEObject) project).eInverseRemove(this, AdminPackage.PROJECT__USER_AUTHORIZATION, Project.class,
                        msgs);
            if (newProject != null)
                msgs = ((InternalEObject) newProject).eInverseAdd(this, AdminPackage.PROJECT__USER_AUTHORIZATION, Project.class,
                        msgs);
            msgs = basicSetProject(newProject, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT, newProject,
                    newProject));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserProjectAuthorizationType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(UserProjectAuthorizationType newType) {
        UserProjectAuthorizationType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER_PROJECT_AUTHORIZATION__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            if (user != null)
                msgs = ((InternalEObject) user).eInverseRemove(this, AdminPackage.USER__PROJECT_AUTHORIZATION, User.class, msgs);
            return basicSetUser((User) otherEnd, msgs);
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            if (project != null)
                msgs = ((InternalEObject) project).eInverseRemove(this, AdminPackage.PROJECT__USER_AUTHORIZATION, Project.class,
                        msgs);
            return basicSetProject((Project) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            return basicSetUser(null, msgs);
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            return basicSetProject(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            if (resolve)
                return getUser();
            return basicGetUser();
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            if (resolve)
                return getProject();
            return basicGetProject();
        case AdminPackage.USER_PROJECT_AUTHORIZATION__TYPE:
            return getType();
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
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            setUser((User) newValue);
            return;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            setProject((Project) newValue);
            return;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__TYPE:
            setType((UserProjectAuthorizationType) newValue);
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
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            setUser((User) null);
            return;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            setProject((Project) null);
            return;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__TYPE:
            setType(TYPE_EDEFAULT);
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
        case AdminPackage.USER_PROJECT_AUTHORIZATION__USER:
            return user != null;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT:
            return project != null;
        case AdminPackage.USER_PROJECT_AUTHORIZATION__TYPE:
            return type != TYPE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} //UserProjectAuthorizationImpl
