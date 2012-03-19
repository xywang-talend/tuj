/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.DashboardConnection;
import org.talend.model.tac.admin.User;
import org.talend.model.tac.admin.UserProjectAuthorization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getProjectAuthorization <em>Project Authorization</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getPreferredDashboardConnection <em>Preferred Dashboard Connection</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getDeleteDate <em>Delete Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLastAdminConnectionDate <em>Last Admin Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLastStudioConnectionDate <em>Last Studio Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getFirstAdminConnectionDate <em>First Admin Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getFirstStudioConnectionDate <em>First Studio Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getAdminConnexionNumber <em>Admin Connexion Number</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getStudioConnexionNumber <em>Studio Connexion Number</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getAuthenticationInfo <em>Authentication Info</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLdapLogin <em>Ldap Login</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLdapId <em>Ldap Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.UserImpl#getAdditionnalData <em>Additionnal Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {

    /**
     * The cached value of the '{@link #getProjectAuthorization() <em>Project Authorization</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectAuthorization()
     * @generated
     * @ordered
     */
    protected EList projectAuthorization;

    /**
     * The cached value of the '{@link #getPreferredDashboardConnection() <em>Preferred Dashboard Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPreferredDashboardConnection()
     * @generated
     * @ordered
     */
    protected DashboardConnection preferredDashboardConnection;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected static final String LOGIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected String login = LOGIN_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final byte[] PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected byte[] password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstName()
     * @generated
     * @ordered
     */
    protected static final String FIRST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstName()
     * @generated
     * @ordered
     */
    protected String firstName = FIRST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastName()
     * @generated
     * @ordered
     */
    protected static final String LAST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastName()
     * @generated
     * @ordered
     */
    protected String lastName = LAST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final Date CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected Date creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected static final Date DELETE_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected Date deleteDate = DELETE_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected static final boolean DELETED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected boolean deleted = DELETED_EDEFAULT;

    /**
     * The default value of the '{@link #getLastAdminConnectionDate() <em>Last Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastAdminConnectionDate()
     * @generated
     * @ordered
     */
    protected static final Date LAST_ADMIN_CONNECTION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastAdminConnectionDate() <em>Last Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastAdminConnectionDate()
     * @generated
     * @ordered
     */
    protected Date lastAdminConnectionDate = LAST_ADMIN_CONNECTION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getLastStudioConnectionDate() <em>Last Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastStudioConnectionDate()
     * @generated
     * @ordered
     */
    protected static final Date LAST_STUDIO_CONNECTION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastStudioConnectionDate() <em>Last Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLastStudioConnectionDate()
     * @generated
     * @ordered
     */
    protected Date lastStudioConnectionDate = LAST_STUDIO_CONNECTION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstAdminConnectionDate() <em>First Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstAdminConnectionDate()
     * @generated
     * @ordered
     */
    protected static final Date FIRST_ADMIN_CONNECTION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFirstAdminConnectionDate() <em>First Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstAdminConnectionDate()
     * @generated
     * @ordered
     */
    protected Date firstAdminConnectionDate = FIRST_ADMIN_CONNECTION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstStudioConnectionDate() <em>First Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstStudioConnectionDate()
     * @generated
     * @ordered
     */
    protected static final Date FIRST_STUDIO_CONNECTION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFirstStudioConnectionDate() <em>First Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstStudioConnectionDate()
     * @generated
     * @ordered
     */
    protected Date firstStudioConnectionDate = FIRST_STUDIO_CONNECTION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getAdminConnexionNumber() <em>Admin Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdminConnexionNumber()
     * @generated
     * @ordered
     */
    protected static final int ADMIN_CONNEXION_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAdminConnexionNumber() <em>Admin Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdminConnexionNumber()
     * @generated
     * @ordered
     */
    protected int adminConnexionNumber = ADMIN_CONNEXION_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getStudioConnexionNumber() <em>Studio Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStudioConnexionNumber()
     * @generated
     * @ordered
     */
    protected static final int STUDIO_CONNEXION_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStudioConnexionNumber() <em>Studio Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStudioConnexionNumber()
     * @generated
     * @ordered
     */
    protected int studioConnexionNumber = STUDIO_CONNEXION_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getAuthenticationInfo() <em>Authentication Info</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthenticationInfo()
     * @generated
     * @ordered
     */
    protected static final String AUTHENTICATION_INFO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAuthenticationInfo() <em>Authentication Info</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthenticationInfo()
     * @generated
     * @ordered
     */
    protected String authenticationInfo = AUTHENTICATION_INFO_EDEFAULT;

    /**
     * The default value of the '{@link #getLdapLogin() <em>Ldap Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLdapLogin()
     * @generated
     * @ordered
     */
    protected static final String LDAP_LOGIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLdapLogin() <em>Ldap Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLdapLogin()
     * @generated
     * @ordered
     */
    protected String ldapLogin = LDAP_LOGIN_EDEFAULT;

    /**
     * The default value of the '{@link #getLdapId() <em>Ldap Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLdapId()
     * @generated
     * @ordered
     */
    protected static final String LDAP_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLdapId() <em>Ldap Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLdapId()
     * @generated
     * @ordered
     */
    protected String ldapId = LDAP_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected String language = LANGUAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getAdditionnalData() <em>Additionnal Data</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionnalData()
     * @generated
     * @ordered
     */
    protected static final String ADDITIONNAL_DATA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAdditionnalData() <em>Additionnal Data</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionnalData()
     * @generated
     * @ordered
     */
    protected String additionnalData = ADDITIONNAL_DATA_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AdminPackage.Literals.USER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getProjectAuthorization() {
        if (projectAuthorization == null) {
            projectAuthorization = new EObjectWithInverseResolvingEList(UserProjectAuthorization.class, this,
                    AdminPackage.USER__PROJECT_AUTHORIZATION, AdminPackage.USER_PROJECT_AUTHORIZATION__USER);
        }
        return projectAuthorization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DashboardConnection getPreferredDashboardConnection() {
        if (preferredDashboardConnection != null && preferredDashboardConnection.eIsProxy()) {
            InternalEObject oldPreferredDashboardConnection = (InternalEObject) preferredDashboardConnection;
            preferredDashboardConnection = (DashboardConnection) eResolveProxy(oldPreferredDashboardConnection);
            if (preferredDashboardConnection != oldPreferredDashboardConnection) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION,
                            oldPreferredDashboardConnection, preferredDashboardConnection));
            }
        }
        return preferredDashboardConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DashboardConnection basicGetPreferredDashboardConnection() {
        return preferredDashboardConnection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreferredDashboardConnection(DashboardConnection newPreferredDashboardConnection) {
        DashboardConnection oldPreferredDashboardConnection = preferredDashboardConnection;
        preferredDashboardConnection = newPreferredDashboardConnection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION,
                    oldPreferredDashboardConnection, preferredDashboardConnection));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLogin() {
        return login;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLogin(String newLogin) {
        String oldLogin = login;
        login = newLogin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LOGIN, oldLogin, login));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword(byte[] newPassword) {
        byte[] oldPassword = password;
        password = newPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__PASSWORD, oldPassword, password));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFirstName(String newFirstName) {
        String oldFirstName = firstName;
        firstName = newFirstName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__FIRST_NAME, oldFirstName, firstName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLastName(String newLastName) {
        String oldLastName = lastName;
        lastName = newLastName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LAST_NAME, oldLastName, lastName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCreationDate(Date newCreationDate) {
        Date oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__CREATION_DATE, oldCreationDate, creationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteDate(Date newDeleteDate) {
        Date oldDeleteDate = deleteDate;
        deleteDate = newDeleteDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__DELETE_DATE, oldDeleteDate, deleteDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleted(boolean newDeleted) {
        boolean oldDeleted = deleted;
        deleted = newDeleted;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__DELETED, oldDeleted, deleted));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getLastAdminConnectionDate() {
        return lastAdminConnectionDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLastAdminConnectionDate(Date newLastAdminConnectionDate) {
        Date oldLastAdminConnectionDate = lastAdminConnectionDate;
        lastAdminConnectionDate = newLastAdminConnectionDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LAST_ADMIN_CONNECTION_DATE,
                    oldLastAdminConnectionDate, lastAdminConnectionDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getLastStudioConnectionDate() {
        return lastStudioConnectionDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLastStudioConnectionDate(Date newLastStudioConnectionDate) {
        Date oldLastStudioConnectionDate = lastStudioConnectionDate;
        lastStudioConnectionDate = newLastStudioConnectionDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LAST_STUDIO_CONNECTION_DATE,
                    oldLastStudioConnectionDate, lastStudioConnectionDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getFirstAdminConnectionDate() {
        return firstAdminConnectionDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFirstAdminConnectionDate(Date newFirstAdminConnectionDate) {
        Date oldFirstAdminConnectionDate = firstAdminConnectionDate;
        firstAdminConnectionDate = newFirstAdminConnectionDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__FIRST_ADMIN_CONNECTION_DATE,
                    oldFirstAdminConnectionDate, firstAdminConnectionDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getFirstStudioConnectionDate() {
        return firstStudioConnectionDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFirstStudioConnectionDate(Date newFirstStudioConnectionDate) {
        Date oldFirstStudioConnectionDate = firstStudioConnectionDate;
        firstStudioConnectionDate = newFirstStudioConnectionDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__FIRST_STUDIO_CONNECTION_DATE,
                    oldFirstStudioConnectionDate, firstStudioConnectionDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getAdminConnexionNumber() {
        return adminConnexionNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAdminConnexionNumber(int newAdminConnexionNumber) {
        int oldAdminConnexionNumber = adminConnexionNumber;
        adminConnexionNumber = newAdminConnexionNumber;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__ADMIN_CONNEXION_NUMBER,
                    oldAdminConnexionNumber, adminConnexionNumber));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getStudioConnexionNumber() {
        return studioConnexionNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStudioConnexionNumber(int newStudioConnexionNumber) {
        int oldStudioConnexionNumber = studioConnexionNumber;
        studioConnexionNumber = newStudioConnexionNumber;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__STUDIO_CONNEXION_NUMBER,
                    oldStudioConnexionNumber, studioConnexionNumber));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAuthenticationInfo() {
        return authenticationInfo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthenticationInfo(String newAuthenticationInfo) {
        String oldAuthenticationInfo = authenticationInfo;
        authenticationInfo = newAuthenticationInfo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__AUTHENTICATION_INFO, oldAuthenticationInfo,
                    authenticationInfo));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLdapLogin() {
        return ldapLogin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLdapLogin(String newLdapLogin) {
        String oldLdapLogin = ldapLogin;
        ldapLogin = newLdapLogin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LDAP_LOGIN, oldLdapLogin, ldapLogin));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLdapId() {
        return ldapId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLdapId(String newLdapId) {
        String oldLdapId = ldapId;
        ldapId = newLdapId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LDAP_ID, oldLdapId, ldapId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLanguage(String newLanguage) {
        String oldLanguage = language;
        language = newLanguage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__LANGUAGE, oldLanguage, language));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAdditionnalData() {
        return additionnalData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAdditionnalData(String newAdditionnalData) {
        String oldAdditionnalData = additionnalData;
        additionnalData = newAdditionnalData;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.USER__ADDITIONNAL_DATA, oldAdditionnalData,
                    additionnalData));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            return ((InternalEList) getProjectAuthorization()).basicAdd(otherEnd, msgs);
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
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            return ((InternalEList) getProjectAuthorization()).basicRemove(otherEnd, msgs);
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
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            return getProjectAuthorization();
        case AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
            if (resolve)
                return getPreferredDashboardConnection();
            return basicGetPreferredDashboardConnection();
        case AdminPackage.USER__ID:
            return new Integer(getId());
        case AdminPackage.USER__LOGIN:
            return getLogin();
        case AdminPackage.USER__PASSWORD:
            return getPassword();
        case AdminPackage.USER__FIRST_NAME:
            return getFirstName();
        case AdminPackage.USER__LAST_NAME:
            return getLastName();
        case AdminPackage.USER__CREATION_DATE:
            return getCreationDate();
        case AdminPackage.USER__DELETE_DATE:
            return getDeleteDate();
        case AdminPackage.USER__DELETED:
            return isDeleted() ? Boolean.TRUE : Boolean.FALSE;
        case AdminPackage.USER__LAST_ADMIN_CONNECTION_DATE:
            return getLastAdminConnectionDate();
        case AdminPackage.USER__LAST_STUDIO_CONNECTION_DATE:
            return getLastStudioConnectionDate();
        case AdminPackage.USER__FIRST_ADMIN_CONNECTION_DATE:
            return getFirstAdminConnectionDate();
        case AdminPackage.USER__FIRST_STUDIO_CONNECTION_DATE:
            return getFirstStudioConnectionDate();
        case AdminPackage.USER__ADMIN_CONNEXION_NUMBER:
            return new Integer(getAdminConnexionNumber());
        case AdminPackage.USER__STUDIO_CONNEXION_NUMBER:
            return new Integer(getStudioConnexionNumber());
        case AdminPackage.USER__AUTHENTICATION_INFO:
            return getAuthenticationInfo();
        case AdminPackage.USER__LDAP_LOGIN:
            return getLdapLogin();
        case AdminPackage.USER__LDAP_ID:
            return getLdapId();
        case AdminPackage.USER__LANGUAGE:
            return getLanguage();
        case AdminPackage.USER__TYPE:
            return getType();
        case AdminPackage.USER__ADDITIONNAL_DATA:
            return getAdditionnalData();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            getProjectAuthorization().clear();
            getProjectAuthorization().addAll((Collection) newValue);
            return;
        case AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
            setPreferredDashboardConnection((DashboardConnection) newValue);
            return;
        case AdminPackage.USER__ID:
            setId(((Integer) newValue).intValue());
            return;
        case AdminPackage.USER__LOGIN:
            setLogin((String) newValue);
            return;
        case AdminPackage.USER__PASSWORD:
            setPassword((byte[]) newValue);
            return;
        case AdminPackage.USER__FIRST_NAME:
            setFirstName((String) newValue);
            return;
        case AdminPackage.USER__LAST_NAME:
            setLastName((String) newValue);
            return;
        case AdminPackage.USER__CREATION_DATE:
            setCreationDate((Date) newValue);
            return;
        case AdminPackage.USER__DELETE_DATE:
            setDeleteDate((Date) newValue);
            return;
        case AdminPackage.USER__DELETED:
            setDeleted(((Boolean) newValue).booleanValue());
            return;
        case AdminPackage.USER__LAST_ADMIN_CONNECTION_DATE:
            setLastAdminConnectionDate((Date) newValue);
            return;
        case AdminPackage.USER__LAST_STUDIO_CONNECTION_DATE:
            setLastStudioConnectionDate((Date) newValue);
            return;
        case AdminPackage.USER__FIRST_ADMIN_CONNECTION_DATE:
            setFirstAdminConnectionDate((Date) newValue);
            return;
        case AdminPackage.USER__FIRST_STUDIO_CONNECTION_DATE:
            setFirstStudioConnectionDate((Date) newValue);
            return;
        case AdminPackage.USER__ADMIN_CONNEXION_NUMBER:
            setAdminConnexionNumber(((Integer) newValue).intValue());
            return;
        case AdminPackage.USER__STUDIO_CONNEXION_NUMBER:
            setStudioConnexionNumber(((Integer) newValue).intValue());
            return;
        case AdminPackage.USER__AUTHENTICATION_INFO:
            setAuthenticationInfo((String) newValue);
            return;
        case AdminPackage.USER__LDAP_LOGIN:
            setLdapLogin((String) newValue);
            return;
        case AdminPackage.USER__LDAP_ID:
            setLdapId((String) newValue);
            return;
        case AdminPackage.USER__LANGUAGE:
            setLanguage((String) newValue);
            return;
        case AdminPackage.USER__TYPE:
            setType((String) newValue);
            return;
        case AdminPackage.USER__ADDITIONNAL_DATA:
            setAdditionnalData((String) newValue);
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
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            getProjectAuthorization().clear();
            return;
        case AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
            setPreferredDashboardConnection((DashboardConnection) null);
            return;
        case AdminPackage.USER__ID:
            setId(ID_EDEFAULT);
            return;
        case AdminPackage.USER__LOGIN:
            setLogin(LOGIN_EDEFAULT);
            return;
        case AdminPackage.USER__PASSWORD:
            setPassword(PASSWORD_EDEFAULT);
            return;
        case AdminPackage.USER__FIRST_NAME:
            setFirstName(FIRST_NAME_EDEFAULT);
            return;
        case AdminPackage.USER__LAST_NAME:
            setLastName(LAST_NAME_EDEFAULT);
            return;
        case AdminPackage.USER__CREATION_DATE:
            setCreationDate(CREATION_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__DELETE_DATE:
            setDeleteDate(DELETE_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__DELETED:
            setDeleted(DELETED_EDEFAULT);
            return;
        case AdminPackage.USER__LAST_ADMIN_CONNECTION_DATE:
            setLastAdminConnectionDate(LAST_ADMIN_CONNECTION_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__LAST_STUDIO_CONNECTION_DATE:
            setLastStudioConnectionDate(LAST_STUDIO_CONNECTION_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__FIRST_ADMIN_CONNECTION_DATE:
            setFirstAdminConnectionDate(FIRST_ADMIN_CONNECTION_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__FIRST_STUDIO_CONNECTION_DATE:
            setFirstStudioConnectionDate(FIRST_STUDIO_CONNECTION_DATE_EDEFAULT);
            return;
        case AdminPackage.USER__ADMIN_CONNEXION_NUMBER:
            setAdminConnexionNumber(ADMIN_CONNEXION_NUMBER_EDEFAULT);
            return;
        case AdminPackage.USER__STUDIO_CONNEXION_NUMBER:
            setStudioConnexionNumber(STUDIO_CONNEXION_NUMBER_EDEFAULT);
            return;
        case AdminPackage.USER__AUTHENTICATION_INFO:
            setAuthenticationInfo(AUTHENTICATION_INFO_EDEFAULT);
            return;
        case AdminPackage.USER__LDAP_LOGIN:
            setLdapLogin(LDAP_LOGIN_EDEFAULT);
            return;
        case AdminPackage.USER__LDAP_ID:
            setLdapId(LDAP_ID_EDEFAULT);
            return;
        case AdminPackage.USER__LANGUAGE:
            setLanguage(LANGUAGE_EDEFAULT);
            return;
        case AdminPackage.USER__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case AdminPackage.USER__ADDITIONNAL_DATA:
            setAdditionnalData(ADDITIONNAL_DATA_EDEFAULT);
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
        case AdminPackage.USER__PROJECT_AUTHORIZATION:
            return projectAuthorization != null && !projectAuthorization.isEmpty();
        case AdminPackage.USER__PREFERRED_DASHBOARD_CONNECTION:
            return preferredDashboardConnection != null;
        case AdminPackage.USER__ID:
            return id != ID_EDEFAULT;
        case AdminPackage.USER__LOGIN:
            return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
        case AdminPackage.USER__PASSWORD:
            return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
        case AdminPackage.USER__FIRST_NAME:
            return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
        case AdminPackage.USER__LAST_NAME:
            return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
        case AdminPackage.USER__CREATION_DATE:
            return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
        case AdminPackage.USER__DELETE_DATE:
            return DELETE_DATE_EDEFAULT == null ? deleteDate != null : !DELETE_DATE_EDEFAULT.equals(deleteDate);
        case AdminPackage.USER__DELETED:
            return deleted != DELETED_EDEFAULT;
        case AdminPackage.USER__LAST_ADMIN_CONNECTION_DATE:
            return LAST_ADMIN_CONNECTION_DATE_EDEFAULT == null ? lastAdminConnectionDate != null
                    : !LAST_ADMIN_CONNECTION_DATE_EDEFAULT.equals(lastAdminConnectionDate);
        case AdminPackage.USER__LAST_STUDIO_CONNECTION_DATE:
            return LAST_STUDIO_CONNECTION_DATE_EDEFAULT == null ? lastStudioConnectionDate != null
                    : !LAST_STUDIO_CONNECTION_DATE_EDEFAULT.equals(lastStudioConnectionDate);
        case AdminPackage.USER__FIRST_ADMIN_CONNECTION_DATE:
            return FIRST_ADMIN_CONNECTION_DATE_EDEFAULT == null ? firstAdminConnectionDate != null
                    : !FIRST_ADMIN_CONNECTION_DATE_EDEFAULT.equals(firstAdminConnectionDate);
        case AdminPackage.USER__FIRST_STUDIO_CONNECTION_DATE:
            return FIRST_STUDIO_CONNECTION_DATE_EDEFAULT == null ? firstStudioConnectionDate != null
                    : !FIRST_STUDIO_CONNECTION_DATE_EDEFAULT.equals(firstStudioConnectionDate);
        case AdminPackage.USER__ADMIN_CONNEXION_NUMBER:
            return adminConnexionNumber != ADMIN_CONNEXION_NUMBER_EDEFAULT;
        case AdminPackage.USER__STUDIO_CONNEXION_NUMBER:
            return studioConnexionNumber != STUDIO_CONNEXION_NUMBER_EDEFAULT;
        case AdminPackage.USER__AUTHENTICATION_INFO:
            return AUTHENTICATION_INFO_EDEFAULT == null ? authenticationInfo != null : !AUTHENTICATION_INFO_EDEFAULT
                    .equals(authenticationInfo);
        case AdminPackage.USER__LDAP_LOGIN:
            return LDAP_LOGIN_EDEFAULT == null ? ldapLogin != null : !LDAP_LOGIN_EDEFAULT.equals(ldapLogin);
        case AdminPackage.USER__LDAP_ID:
            return LDAP_ID_EDEFAULT == null ? ldapId != null : !LDAP_ID_EDEFAULT.equals(ldapId);
        case AdminPackage.USER__LANGUAGE:
            return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
        case AdminPackage.USER__TYPE:
            return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
        case AdminPackage.USER__ADDITIONNAL_DATA:
            return ADDITIONNAL_DATA_EDEFAULT == null ? additionnalData != null : !ADDITIONNAL_DATA_EDEFAULT
                    .equals(additionnalData);
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
        result.append(" (id: ");
        result.append(id);
        result.append(", login: ");
        result.append(login);
        result.append(", password: ");
        result.append(password);
        result.append(", firstName: ");
        result.append(firstName);
        result.append(", lastName: ");
        result.append(lastName);
        result.append(", creationDate: ");
        result.append(creationDate);
        result.append(", deleteDate: ");
        result.append(deleteDate);
        result.append(", deleted: ");
        result.append(deleted);
        result.append(", lastAdminConnectionDate: ");
        result.append(lastAdminConnectionDate);
        result.append(", lastStudioConnectionDate: ");
        result.append(lastStudioConnectionDate);
        result.append(", firstAdminConnectionDate: ");
        result.append(firstAdminConnectionDate);
        result.append(", firstStudioConnectionDate: ");
        result.append(firstStudioConnectionDate);
        result.append(", adminConnexionNumber: ");
        result.append(adminConnexionNumber);
        result.append(", studioConnexionNumber: ");
        result.append(studioConnexionNumber);
        result.append(", authenticationInfo: ");
        result.append(authenticationInfo);
        result.append(", ldapLogin: ");
        result.append(ldapLogin);
        result.append(", ldapId: ");
        result.append(ldapId);
        result.append(", language: ");
        result.append(language);
        result.append(", type: ");
        result.append(type);
        result.append(", additionnalData: ");
        result.append(additionnalData);
        result.append(')');
        return result.toString();
    }

} //UserImpl
