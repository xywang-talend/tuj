/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.User#getProjectAuthorization <em>Project Authorization</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getPreferredDashboardConnection <em>Preferred Dashboard Connection</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLogin <em>Login</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getPassword <em>Password</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getDeleteDate <em>Delete Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLastAdminConnectionDate <em>Last Admin Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLastStudioConnectionDate <em>Last Studio Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getFirstAdminConnectionDate <em>First Admin Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getFirstStudioConnectionDate <em>First Studio Connection Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getAdminConnexionNumber <em>Admin Connexion Number</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getStudioConnexionNumber <em>Studio Connexion Number</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getAuthenticationInfo <em>Authentication Info</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLdapLogin <em>Ldap Login</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLdapId <em>Ldap Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.User#getAdditionnalData <em>Additionnal Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.admin.AdminPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {

    /**
     * Returns the value of the '<em><b>Project Authorization</b></em>' reference list.
     * The list contents are of type {@link org.talend.model.tac.admin.UserProjectAuthorization}.
     * It is bidirectional and its opposite is '{@link org.talend.model.tac.admin.UserProjectAuthorization#getUser <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Project Authorization</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Project Authorization</em>' reference list.
     * @see org.talend.model.tac.admin.AdminPackage#getUser_ProjectAuthorization()
     * @see org.talend.model.tac.admin.UserProjectAuthorization#getUser
     * @model type="org.talend.model.tac.admin.UserProjectAuthorization" opposite="user" ordered="false"
     * @generated
     */
    EList getProjectAuthorization();

    /**
     * Returns the value of the '<em><b>Preferred Dashboard Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Preferred Dashboard Connection</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Preferred Dashboard Connection</em>' reference.
     * @see #setPreferredDashboardConnection(DashboardConnection)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_PreferredDashboardConnection()
     * @model
     * @generated
     */
    DashboardConnection getPreferredDashboardConnection();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getPreferredDashboardConnection <em>Preferred Dashboard Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Preferred Dashboard Connection</em>' reference.
     * @see #getPreferredDashboardConnection()
     * @generated
     */
    void setPreferredDashboardConnection(DashboardConnection value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Login</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Login</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Login</em>' attribute.
     * @see #setLogin(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Login()
     * @model required="true"
     * @generated
     */
    String getLogin();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLogin <em>Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Login</em>' attribute.
     * @see #getLogin()
     * @generated
     */
    void setLogin(String value);

    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(byte[])
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Password()
     * @model unique="false" required="true"
     * @generated
     */
    byte[] getPassword();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getPassword <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword(byte[] value);

    /**
     * Returns the value of the '<em><b>First Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>First Name</em>' attribute.
     * @see #setFirstName(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_FirstName()
     * @model unique="false" required="true"
     * @generated
     */
    String getFirstName();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getFirstName <em>First Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>First Name</em>' attribute.
     * @see #getFirstName()
     * @generated
     */
    void setFirstName(String value);

    /**
     * Returns the value of the '<em><b>Last Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Name</em>' attribute.
     * @see #setLastName(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_LastName()
     * @model unique="false" required="true"
     * @generated
     */
    String getLastName();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLastName <em>Last Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Name</em>' attribute.
     * @see #getLastName()
     * @generated
     */
    void setLastName(String value);

    /**
     * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Creation Date</em>' attribute.
     * @see #setCreationDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_CreationDate()
     * @model unique="false" required="true"
     * @generated
     */
    Date getCreationDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(Date value);

    /**
     * Returns the value of the '<em><b>Delete Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delete Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delete Date</em>' attribute.
     * @see #setDeleteDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_DeleteDate()
     * @model unique="false"
     * @generated
     */
    Date getDeleteDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getDeleteDate <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete Date</em>' attribute.
     * @see #getDeleteDate()
     * @generated
     */
    void setDeleteDate(Date value);

    /**
     * Returns the value of the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deleted</em>' attribute.
     * @see #setDeleted(boolean)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Deleted()
     * @model unique="false"
     * @generated
     */
    boolean isDeleted();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#isDeleted <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deleted</em>' attribute.
     * @see #isDeleted()
     * @generated
     */
    void setDeleted(boolean value);

    /**
     * Returns the value of the '<em><b>Last Admin Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Admin Connection Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Admin Connection Date</em>' attribute.
     * @see #setLastAdminConnectionDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_LastAdminConnectionDate()
     * @model unique="false"
     * @generated
     */
    Date getLastAdminConnectionDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLastAdminConnectionDate <em>Last Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Admin Connection Date</em>' attribute.
     * @see #getLastAdminConnectionDate()
     * @generated
     */
    void setLastAdminConnectionDate(Date value);

    /**
     * Returns the value of the '<em><b>Last Studio Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Studio Connection Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Last Studio Connection Date</em>' attribute.
     * @see #setLastStudioConnectionDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_LastStudioConnectionDate()
     * @model unique="false"
     * @generated
     */
    Date getLastStudioConnectionDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLastStudioConnectionDate <em>Last Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last Studio Connection Date</em>' attribute.
     * @see #getLastStudioConnectionDate()
     * @generated
     */
    void setLastStudioConnectionDate(Date value);

    /**
     * Returns the value of the '<em><b>First Admin Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Admin Connection Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>First Admin Connection Date</em>' attribute.
     * @see #setFirstAdminConnectionDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_FirstAdminConnectionDate()
     * @model unique="false"
     * @generated
     */
    Date getFirstAdminConnectionDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getFirstAdminConnectionDate <em>First Admin Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>First Admin Connection Date</em>' attribute.
     * @see #getFirstAdminConnectionDate()
     * @generated
     */
    void setFirstAdminConnectionDate(Date value);

    /**
     * Returns the value of the '<em><b>First Studio Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Studio Connection Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>First Studio Connection Date</em>' attribute.
     * @see #setFirstStudioConnectionDate(Date)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_FirstStudioConnectionDate()
     * @model unique="false"
     * @generated
     */
    Date getFirstStudioConnectionDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getFirstStudioConnectionDate <em>First Studio Connection Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>First Studio Connection Date</em>' attribute.
     * @see #getFirstStudioConnectionDate()
     * @generated
     */
    void setFirstStudioConnectionDate(Date value);

    /**
     * Returns the value of the '<em><b>Admin Connexion Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Admin Connexion Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Admin Connexion Number</em>' attribute.
     * @see #setAdminConnexionNumber(int)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_AdminConnexionNumber()
     * @model
     * @generated
     */
    int getAdminConnexionNumber();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getAdminConnexionNumber <em>Admin Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Admin Connexion Number</em>' attribute.
     * @see #getAdminConnexionNumber()
     * @generated
     */
    void setAdminConnexionNumber(int value);

    /**
     * Returns the value of the '<em><b>Studio Connexion Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Studio Connexion Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Studio Connexion Number</em>' attribute.
     * @see #setStudioConnexionNumber(int)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_StudioConnexionNumber()
     * @model
     * @generated
     */
    int getStudioConnexionNumber();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getStudioConnexionNumber <em>Studio Connexion Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Studio Connexion Number</em>' attribute.
     * @see #getStudioConnexionNumber()
     * @generated
     */
    void setStudioConnexionNumber(int value);

    /**
     * Returns the value of the '<em><b>Authentication Info</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authentication Info</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authentication Info</em>' attribute.
     * @see #setAuthenticationInfo(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_AuthenticationInfo()
     * @model unique="false"
     * @generated
     */
    String getAuthenticationInfo();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getAuthenticationInfo <em>Authentication Info</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Authentication Info</em>' attribute.
     * @see #getAuthenticationInfo()
     * @generated
     */
    void setAuthenticationInfo(String value);

    /**
     * Returns the value of the '<em><b>Ldap Login</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ldap Login</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ldap Login</em>' attribute.
     * @see #setLdapLogin(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_LdapLogin()
     * @model unique="false"
     * @generated
     */
    String getLdapLogin();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLdapLogin <em>Ldap Login</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ldap Login</em>' attribute.
     * @see #getLdapLogin()
     * @generated
     */
    void setLdapLogin(String value);

    /**
     * Returns the value of the '<em><b>Ldap Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ldap Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ldap Id</em>' attribute.
     * @see #setLdapId(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_LdapId()
     * @model
     * @generated
     */
    String getLdapId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLdapId <em>Ldap Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ldap Id</em>' attribute.
     * @see #getLdapId()
     * @generated
     */
    void setLdapId(String value);

    /**
     * Returns the value of the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Language</em>' attribute.
     * @see #setLanguage(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Language()
     * @model unique="false"
     * @generated
     */
    String getLanguage();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getLanguage <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language</em>' attribute.
     * @see #getLanguage()
     * @generated
     */
    void setLanguage(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_Type()
     * @model unique="false"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Additionnal Data</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Additionnal Data</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Additionnal Data</em>' attribute.
     * @see #setAdditionnalData(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUser_AdditionnalData()
     * @model unique="false"
     * @generated
     */
    String getAdditionnalData();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.User#getAdditionnalData <em>Additionnal Data</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Additionnal Data</em>' attribute.
     * @see #getAdditionnalData()
     * @generated
     */
    void setAdditionnalData(String value);

} // User
