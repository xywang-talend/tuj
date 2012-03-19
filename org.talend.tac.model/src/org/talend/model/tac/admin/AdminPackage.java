/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.admin.AdminFactory
 * @model kind="package"
 * @generated
 */
public interface AdminPackage extends EPackage {

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "admin";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.talend.org/tac/admin";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "admin";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    AdminPackage eINSTANCE = org.talend.model.tac.admin.impl.AdminPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.NotificationImpl <em>Notification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.NotificationImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getNotification()
     * @generated
     */
    int NOTIFICATION = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOTIFICATION__ID = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOTIFICATION__TYPE = 1;

    /**
     * The feature id for the '<em><b>Props</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOTIFICATION__PROPS = 2;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOTIFICATION__ENABLED = 3;

    /**
     * The number of structural features of the '<em>Notification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NOTIFICATION_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.ProjectImpl <em>Project</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.ProjectImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getProject()
     * @generated
     */
    int PROJECT = 1;

    /**
     * The feature id for the '<em><b>User Authorization</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__USER_AUTHORIZATION = 0;

    /**
     * The feature id for the '<em><b>Master Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__MASTER_JOB_ID = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__ID = 2;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__LABEL = 3;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__DESCRIPTION = 4;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__LANGUAGE = 5;

    /**
     * The feature id for the '<em><b>Technical Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__TECHNICAL_LABEL = 6;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__DELETED = 7;

    /**
     * The feature id for the '<em><b>Delete Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__DELETE_DATE = 8;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__CREATION_DATE = 9;

    /**
     * The feature id for the '<em><b>Author</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__AUTHOR = 10;

    /**
     * The feature id for the '<em><b>Referenced Projects</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__REFERENCED_PROJECTS = 11;

    /**
     * The feature id for the '<em><b>Available Ref Project</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__AVAILABLE_REF_PROJECT = 12;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__URL = 13;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__TYPE = 14;

    /**
     * The feature id for the '<em><b>Reference</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__REFERENCE = 15;

    /**
     * The feature id for the '<em><b>Local</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT__LOCAL = 16;

    /**
     * The number of structural features of the '<em>Project</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_FEATURE_COUNT = 17;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.ProjectReferenceImpl <em>Project Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.ProjectReferenceImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getProjectReference()
     * @generated
     */
    int PROJECT_REFERENCE = 2;

    /**
     * The feature id for the '<em><b>Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_REFERENCE__PROJECT = 0;

    /**
     * The feature id for the '<em><b>Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_REFERENCE__BRANCH = 1;

    /**
     * The feature id for the '<em><b>Referenced Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_REFERENCE__REFERENCED_PROJECT = 2;

    /**
     * The feature id for the '<em><b>Referenced Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_REFERENCE__REFERENCED_BRANCH = 3;

    /**
     * The number of structural features of the '<em>Project Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROJECT_REFERENCE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.UserRoleImpl <em>User Role</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.UserRoleImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserRole()
     * @generated
     */
    int USER_ROLE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE__NAME = 1;

    /**
     * The feature id for the '<em><b>Localized Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE__LOCALIZED_LABEL = 2;

    /**
     * The feature id for the '<em><b>Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE__FIXED = 3;

    /**
     * The number of structural features of the '<em>User Role</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.UserImpl <em>User</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.UserImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUser()
     * @generated
     */
    int USER = 4;

    /**
     * The feature id for the '<em><b>Project Authorization</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__PROJECT_AUTHORIZATION = 0;

    /**
     * The feature id for the '<em><b>Preferred Dashboard Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__PREFERRED_DASHBOARD_CONNECTION = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__ID = 2;

    /**
     * The feature id for the '<em><b>Login</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LOGIN = 3;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__PASSWORD = 4;

    /**
     * The feature id for the '<em><b>First Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__FIRST_NAME = 5;

    /**
     * The feature id for the '<em><b>Last Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LAST_NAME = 6;

    /**
     * The feature id for the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__CREATION_DATE = 7;

    /**
     * The feature id for the '<em><b>Delete Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__DELETE_DATE = 8;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__DELETED = 9;

    /**
     * The feature id for the '<em><b>Last Admin Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LAST_ADMIN_CONNECTION_DATE = 10;

    /**
     * The feature id for the '<em><b>Last Studio Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LAST_STUDIO_CONNECTION_DATE = 11;

    /**
     * The feature id for the '<em><b>First Admin Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__FIRST_ADMIN_CONNECTION_DATE = 12;

    /**
     * The feature id for the '<em><b>First Studio Connection Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__FIRST_STUDIO_CONNECTION_DATE = 13;

    /**
     * The feature id for the '<em><b>Admin Connexion Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__ADMIN_CONNEXION_NUMBER = 14;

    /**
     * The feature id for the '<em><b>Studio Connexion Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__STUDIO_CONNEXION_NUMBER = 15;

    /**
     * The feature id for the '<em><b>Authentication Info</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__AUTHENTICATION_INFO = 16;

    /**
     * The feature id for the '<em><b>Ldap Login</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LDAP_LOGIN = 17;

    /**
     * The feature id for the '<em><b>Ldap Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LDAP_ID = 18;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__LANGUAGE = 19;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__TYPE = 20;

    /**
     * The feature id for the '<em><b>Additionnal Data</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER__ADDITIONNAL_DATA = 21;

    /**
     * The number of structural features of the '<em>User</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_FEATURE_COUNT = 22;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.UserRoleReferenceImpl <em>User Role Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.UserRoleReferenceImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserRoleReference()
     * @generated
     */
    int USER_ROLE_REFERENCE = 5;

    /**
     * The feature id for the '<em><b>User</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE_REFERENCE__USER = 0;

    /**
     * The feature id for the '<em><b>Role</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE_REFERENCE__ROLE = 1;

    /**
     * The number of structural features of the '<em>User Role Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ROLE_REFERENCE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl <em>User Project Authorization</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserProjectAuthorization()
     * @generated
     */
    int USER_PROJECT_AUTHORIZATION = 6;

    /**
     * The feature id for the '<em><b>User</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_PROJECT_AUTHORIZATION__USER = 0;

    /**
     * The feature id for the '<em><b>Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_PROJECT_AUTHORIZATION__PROJECT = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_PROJECT_AUTHORIZATION__TYPE = 2;

    /**
     * The number of structural features of the '<em>User Project Authorization</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_PROJECT_AUTHORIZATION_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.SchemaInformationImpl <em>Schema Information</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.SchemaInformationImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getSchemaInformation()
     * @generated
     */
    int SCHEMA_INFORMATION = 7;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCHEMA_INFORMATION__VERSION = 0;

    /**
     * The number of structural features of the '<em>Schema Information</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCHEMA_INFORMATION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.DashboardConnectionImpl <em>Dashboard Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.DashboardConnectionImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getDashboardConnection()
     * @generated
     */
    int DASHBOARD_CONNECTION = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__LABEL = 1;

    /**
     * The feature id for the '<em><b>Dialect</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__DIALECT = 2;

    /**
     * The feature id for the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__HOST = 3;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__PORT = 4;

    /**
     * The feature id for the '<em><b>Database</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__DATABASE = 5;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__USERNAME = 6;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__PASSWORD = 7;

    /**
     * The feature id for the '<em><b>Log Table</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__LOG_TABLE = 8;

    /**
     * The feature id for the '<em><b>Stat Table</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__STAT_TABLE = 9;

    /**
     * The feature id for the '<em><b>Flow Meter Table</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__FLOW_METER_TABLE = 10;

    /**
     * The feature id for the '<em><b>Additionnals Params</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__ADDITIONNALS_PARAMS = 11;

    /**
     * The feature id for the '<em><b>Datasource</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION__DATASOURCE = 12;

    /**
     * The number of structural features of the '<em>Dashboard Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DASHBOARD_CONNECTION_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.LicenseImpl <em>License</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.LicenseImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getLicense()
     * @generated
     */
    int LICENSE = 9;

    /**
     * The feature id for the '<em><b>License</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE__LICENSE = 0;

    /**
     * The feature id for the '<em><b>Customer Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE__CUSTOMER_NAME = 1;

    /**
     * The feature id for the '<em><b>Params</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE__PARAMS = 2;

    /**
     * The feature id for the '<em><b>Token</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE__TOKEN = 3;

    /**
     * The feature id for the '<em><b>Date Token Check</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE__DATE_TOKEN_CHECK = 4;

    /**
     * The number of structural features of the '<em>License</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LICENSE_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.TechnicalVariableImpl <em>Technical Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.TechnicalVariableImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getTechnicalVariable()
     * @generated
     */
    int TECHNICAL_VARIABLE = 10;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TECHNICAL_VARIABLE__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TECHNICAL_VARIABLE__VALUE = 1;

    /**
     * The number of structural features of the '<em>Technical Variable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TECHNICAL_VARIABLE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.impl.ArtifactNotificationImpl <em>Artifact Notification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.impl.ArtifactNotificationImpl
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getArtifactNotification()
     * @generated
     */
    int ARTIFACT_NOTIFICATION = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARTIFACT_NOTIFICATION__NAME = 0;

    /**
     * The number of structural features of the '<em>Artifact Notification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARTIFACT_NOTIFICATION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.talend.model.tac.admin.UserProjectAuthorizationType <em>User Project Authorization Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.model.tac.admin.UserProjectAuthorizationType
     * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserProjectAuthorizationType()
     * @generated
     */
    int USER_PROJECT_AUTHORIZATION_TYPE = 12;

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.Notification <em>Notification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Notification</em>'.
     * @see org.talend.model.tac.admin.Notification
     * @generated
     */
    EClass getNotification();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Notification#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.admin.Notification#getId()
     * @see #getNotification()
     * @generated
     */
    EAttribute getNotification_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Notification#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.admin.Notification#getType()
     * @see #getNotification()
     * @generated
     */
    EAttribute getNotification_Type();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Notification#getProps <em>Props</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Props</em>'.
     * @see org.talend.model.tac.admin.Notification#getProps()
     * @see #getNotification()
     * @generated
     */
    EAttribute getNotification_Props();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Notification#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.talend.model.tac.admin.Notification#isEnabled()
     * @see #getNotification()
     * @generated
     */
    EAttribute getNotification_Enabled();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.Project <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Project</em>'.
     * @see org.talend.model.tac.admin.Project
     * @generated
     */
    EClass getProject();

    /**
     * Returns the meta object for the reference list '{@link org.talend.model.tac.admin.Project#getUserAuthorization <em>User Authorization</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>User Authorization</em>'.
     * @see org.talend.model.tac.admin.Project#getUserAuthorization()
     * @see #getProject()
     * @generated
     */
    EReference getProject_UserAuthorization();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getMasterJobId <em>Master Job Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Master Job Id</em>'.
     * @see org.talend.model.tac.admin.Project#getMasterJobId()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_MasterJobId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.admin.Project#getId()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.admin.Project#getLabel()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.talend.model.tac.admin.Project#getDescription()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Description();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.talend.model.tac.admin.Project#getLanguage()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Language();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getTechnicalLabel <em>Technical Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Technical Label</em>'.
     * @see org.talend.model.tac.admin.Project#getTechnicalLabel()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_TechnicalLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#isDeleted <em>Deleted</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deleted</em>'.
     * @see org.talend.model.tac.admin.Project#isDeleted()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Deleted();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getDeleteDate <em>Delete Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Delete Date</em>'.
     * @see org.talend.model.tac.admin.Project#getDeleteDate()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_DeleteDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getCreationDate <em>Creation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Creation Date</em>'.
     * @see org.talend.model.tac.admin.Project#getCreationDate()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_CreationDate();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.Project#getAuthor <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Author</em>'.
     * @see org.talend.model.tac.admin.Project#getAuthor()
     * @see #getProject()
     * @generated
     */
    EReference getProject_Author();

    /**
     * Returns the meta object for the reference list '{@link org.talend.model.tac.admin.Project#getReferencedProjects <em>Referenced Projects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Referenced Projects</em>'.
     * @see org.talend.model.tac.admin.Project#getReferencedProjects()
     * @see #getProject()
     * @generated
     */
    EReference getProject_ReferencedProjects();

    /**
     * Returns the meta object for the reference list '{@link org.talend.model.tac.admin.Project#getAvailableRefProject <em>Available Ref Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Available Ref Project</em>'.
     * @see org.talend.model.tac.admin.Project#getAvailableRefProject()
     * @see #getProject()
     * @generated
     */
    EReference getProject_AvailableRefProject();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.talend.model.tac.admin.Project#getUrl()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Url();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.admin.Project#getType()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Type();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#isReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reference</em>'.
     * @see org.talend.model.tac.admin.Project#isReference()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Reference();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.Project#isLocal <em>Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local</em>'.
     * @see org.talend.model.tac.admin.Project#isLocal()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Local();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.ProjectReference <em>Project Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Project Reference</em>'.
     * @see org.talend.model.tac.admin.ProjectReference
     * @generated
     */
    EClass getProjectReference();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.ProjectReference#getProject <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Project</em>'.
     * @see org.talend.model.tac.admin.ProjectReference#getProject()
     * @see #getProjectReference()
     * @generated
     */
    EReference getProjectReference_Project();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.ProjectReference#getBranch <em>Branch</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Branch</em>'.
     * @see org.talend.model.tac.admin.ProjectReference#getBranch()
     * @see #getProjectReference()
     * @generated
     */
    EAttribute getProjectReference_Branch();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.ProjectReference#getReferencedProject <em>Referenced Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referenced Project</em>'.
     * @see org.talend.model.tac.admin.ProjectReference#getReferencedProject()
     * @see #getProjectReference()
     * @generated
     */
    EReference getProjectReference_ReferencedProject();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.ProjectReference#getReferencedBranch <em>Referenced Branch</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Referenced Branch</em>'.
     * @see org.talend.model.tac.admin.ProjectReference#getReferencedBranch()
     * @see #getProjectReference()
     * @generated
     */
    EAttribute getProjectReference_ReferencedBranch();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.UserRole <em>User Role</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Role</em>'.
     * @see org.talend.model.tac.admin.UserRole
     * @generated
     */
    EClass getUserRole();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.UserRole#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.admin.UserRole#getId()
     * @see #getUserRole()
     * @generated
     */
    EAttribute getUserRole_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.UserRole#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.admin.UserRole#getName()
     * @see #getUserRole()
     * @generated
     */
    EAttribute getUserRole_Name();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.UserRole#getLocalizedLabel <em>Localized Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Localized Label</em>'.
     * @see org.talend.model.tac.admin.UserRole#getLocalizedLabel()
     * @see #getUserRole()
     * @generated
     */
    EAttribute getUserRole_LocalizedLabel();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.UserRole#isFixed <em>Fixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fixed</em>'.
     * @see org.talend.model.tac.admin.UserRole#isFixed()
     * @see #getUserRole()
     * @generated
     */
    EAttribute getUserRole_Fixed();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.User <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User</em>'.
     * @see org.talend.model.tac.admin.User
     * @generated
     */
    EClass getUser();

    /**
     * Returns the meta object for the reference list '{@link org.talend.model.tac.admin.User#getProjectAuthorization <em>Project Authorization</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Project Authorization</em>'.
     * @see org.talend.model.tac.admin.User#getProjectAuthorization()
     * @see #getUser()
     * @generated
     */
    EReference getUser_ProjectAuthorization();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.User#getPreferredDashboardConnection <em>Preferred Dashboard Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Preferred Dashboard Connection</em>'.
     * @see org.talend.model.tac.admin.User#getPreferredDashboardConnection()
     * @see #getUser()
     * @generated
     */
    EReference getUser_PreferredDashboardConnection();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.admin.User#getId()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLogin <em>Login</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Login</em>'.
     * @see org.talend.model.tac.admin.User#getLogin()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Login();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.talend.model.tac.admin.User#getPassword()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Password();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getFirstName <em>First Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>First Name</em>'.
     * @see org.talend.model.tac.admin.User#getFirstName()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_FirstName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLastName <em>Last Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Name</em>'.
     * @see org.talend.model.tac.admin.User#getLastName()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_LastName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getCreationDate <em>Creation Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Creation Date</em>'.
     * @see org.talend.model.tac.admin.User#getCreationDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_CreationDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getDeleteDate <em>Delete Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Delete Date</em>'.
     * @see org.talend.model.tac.admin.User#getDeleteDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_DeleteDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#isDeleted <em>Deleted</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Deleted</em>'.
     * @see org.talend.model.tac.admin.User#isDeleted()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Deleted();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLastAdminConnectionDate <em>Last Admin Connection Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Admin Connection Date</em>'.
     * @see org.talend.model.tac.admin.User#getLastAdminConnectionDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_LastAdminConnectionDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLastStudioConnectionDate <em>Last Studio Connection Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Last Studio Connection Date</em>'.
     * @see org.talend.model.tac.admin.User#getLastStudioConnectionDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_LastStudioConnectionDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getFirstAdminConnectionDate <em>First Admin Connection Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>First Admin Connection Date</em>'.
     * @see org.talend.model.tac.admin.User#getFirstAdminConnectionDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_FirstAdminConnectionDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getFirstStudioConnectionDate <em>First Studio Connection Date</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>First Studio Connection Date</em>'.
     * @see org.talend.model.tac.admin.User#getFirstStudioConnectionDate()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_FirstStudioConnectionDate();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getAdminConnexionNumber <em>Admin Connexion Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Admin Connexion Number</em>'.
     * @see org.talend.model.tac.admin.User#getAdminConnexionNumber()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_AdminConnexionNumber();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getStudioConnexionNumber <em>Studio Connexion Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Studio Connexion Number</em>'.
     * @see org.talend.model.tac.admin.User#getStudioConnexionNumber()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_StudioConnexionNumber();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getAuthenticationInfo <em>Authentication Info</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Authentication Info</em>'.
     * @see org.talend.model.tac.admin.User#getAuthenticationInfo()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_AuthenticationInfo();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLdapLogin <em>Ldap Login</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ldap Login</em>'.
     * @see org.talend.model.tac.admin.User#getLdapLogin()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_LdapLogin();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLdapId <em>Ldap Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ldap Id</em>'.
     * @see org.talend.model.tac.admin.User#getLdapId()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_LdapId();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.talend.model.tac.admin.User#getLanguage()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Language();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.admin.User#getType()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_Type();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.User#getAdditionnalData <em>Additionnal Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Additionnal Data</em>'.
     * @see org.talend.model.tac.admin.User#getAdditionnalData()
     * @see #getUser()
     * @generated
     */
    EAttribute getUser_AdditionnalData();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.UserRoleReference <em>User Role Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Role Reference</em>'.
     * @see org.talend.model.tac.admin.UserRoleReference
     * @generated
     */
    EClass getUserRoleReference();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.UserRoleReference#getUser <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>User</em>'.
     * @see org.talend.model.tac.admin.UserRoleReference#getUser()
     * @see #getUserRoleReference()
     * @generated
     */
    EReference getUserRoleReference_User();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.UserRoleReference#getRole <em>Role</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Role</em>'.
     * @see org.talend.model.tac.admin.UserRoleReference#getRole()
     * @see #getUserRoleReference()
     * @generated
     */
    EReference getUserRoleReference_Role();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.UserProjectAuthorization <em>User Project Authorization</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Project Authorization</em>'.
     * @see org.talend.model.tac.admin.UserProjectAuthorization
     * @generated
     */
    EClass getUserProjectAuthorization();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.UserProjectAuthorization#getUser <em>User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>User</em>'.
     * @see org.talend.model.tac.admin.UserProjectAuthorization#getUser()
     * @see #getUserProjectAuthorization()
     * @generated
     */
    EReference getUserProjectAuthorization_User();

    /**
     * Returns the meta object for the reference '{@link org.talend.model.tac.admin.UserProjectAuthorization#getProject <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Project</em>'.
     * @see org.talend.model.tac.admin.UserProjectAuthorization#getProject()
     * @see #getUserProjectAuthorization()
     * @generated
     */
    EReference getUserProjectAuthorization_Project();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.UserProjectAuthorization#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.talend.model.tac.admin.UserProjectAuthorization#getType()
     * @see #getUserProjectAuthorization()
     * @generated
     */
    EAttribute getUserProjectAuthorization_Type();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.SchemaInformation <em>Schema Information</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Schema Information</em>'.
     * @see org.talend.model.tac.admin.SchemaInformation
     * @generated
     */
    EClass getSchemaInformation();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.SchemaInformation#getVersion <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see org.talend.model.tac.admin.SchemaInformation#getVersion()
     * @see #getSchemaInformation()
     * @generated
     */
    EAttribute getSchemaInformation_Version();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.DashboardConnection <em>Dashboard Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dashboard Connection</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection
     * @generated
     */
    EClass getDashboardConnection();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getId()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Id();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getLabel()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Label();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getDialect <em>Dialect</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dialect</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getDialect()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Dialect();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getHost <em>Host</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getHost()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Host();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getPort()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Port();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getDatabase <em>Database</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Database</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getDatabase()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Database();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getUsername()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Username();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getPassword()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Password();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getLogTable <em>Log Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Log Table</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getLogTable()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_LogTable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getStatTable <em>Stat Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stat Table</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getStatTable()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_StatTable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getFlowMeterTable <em>Flow Meter Table</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Flow Meter Table</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getFlowMeterTable()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_FlowMeterTable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getAdditionnalsParams <em>Additionnals Params</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Additionnals Params</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getAdditionnalsParams()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_AdditionnalsParams();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.DashboardConnection#getDatasource <em>Datasource</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Datasource</em>'.
     * @see org.talend.model.tac.admin.DashboardConnection#getDatasource()
     * @see #getDashboardConnection()
     * @generated
     */
    EAttribute getDashboardConnection_Datasource();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.License <em>License</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>License</em>'.
     * @see org.talend.model.tac.admin.License
     * @generated
     */
    EClass getLicense();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.License#getLicense <em>License</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>License</em>'.
     * @see org.talend.model.tac.admin.License#getLicense()
     * @see #getLicense()
     * @generated
     */
    EAttribute getLicense_License();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.License#getCustomerName <em>Customer Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Customer Name</em>'.
     * @see org.talend.model.tac.admin.License#getCustomerName()
     * @see #getLicense()
     * @generated
     */
    EAttribute getLicense_CustomerName();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.License#getParams <em>Params</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Params</em>'.
     * @see org.talend.model.tac.admin.License#getParams()
     * @see #getLicense()
     * @generated
     */
    EAttribute getLicense_Params();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.License#getToken <em>Token</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Token</em>'.
     * @see org.talend.model.tac.admin.License#getToken()
     * @see #getLicense()
     * @generated
     */
    EAttribute getLicense_Token();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.License#getDateTokenCheck <em>Date Token Check</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Date Token Check</em>'.
     * @see org.talend.model.tac.admin.License#getDateTokenCheck()
     * @see #getLicense()
     * @generated
     */
    EAttribute getLicense_DateTokenCheck();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.TechnicalVariable <em>Technical Variable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Technical Variable</em>'.
     * @see org.talend.model.tac.admin.TechnicalVariable
     * @generated
     */
    EClass getTechnicalVariable();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.TechnicalVariable#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.talend.model.tac.admin.TechnicalVariable#getKey()
     * @see #getTechnicalVariable()
     * @generated
     */
    EAttribute getTechnicalVariable_Key();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.TechnicalVariable#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.talend.model.tac.admin.TechnicalVariable#getValue()
     * @see #getTechnicalVariable()
     * @generated
     */
    EAttribute getTechnicalVariable_Value();

    /**
     * Returns the meta object for class '{@link org.talend.model.tac.admin.ArtifactNotification <em>Artifact Notification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Artifact Notification</em>'.
     * @see org.talend.model.tac.admin.ArtifactNotification
     * @generated
     */
    EClass getArtifactNotification();

    /**
     * Returns the meta object for the attribute '{@link org.talend.model.tac.admin.ArtifactNotification#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.talend.model.tac.admin.ArtifactNotification#getName()
     * @see #getArtifactNotification()
     * @generated
     */
    EAttribute getArtifactNotification_Name();

    /**
     * Returns the meta object for enum '{@link org.talend.model.tac.admin.UserProjectAuthorizationType <em>User Project Authorization Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>User Project Authorization Type</em>'.
     * @see org.talend.model.tac.admin.UserProjectAuthorizationType
     * @generated
     */
    EEnum getUserProjectAuthorizationType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    AdminFactory getAdminFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.NotificationImpl <em>Notification</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.NotificationImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getNotification()
         * @generated
         */
        EClass NOTIFICATION = eINSTANCE.getNotification();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NOTIFICATION__ID = eINSTANCE.getNotification_Id();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NOTIFICATION__TYPE = eINSTANCE.getNotification_Type();

        /**
         * The meta object literal for the '<em><b>Props</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NOTIFICATION__PROPS = eINSTANCE.getNotification_Props();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NOTIFICATION__ENABLED = eINSTANCE.getNotification_Enabled();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.ProjectImpl <em>Project</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.ProjectImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getProject()
         * @generated
         */
        EClass PROJECT = eINSTANCE.getProject();

        /**
         * The meta object literal for the '<em><b>User Authorization</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT__USER_AUTHORIZATION = eINSTANCE.getProject_UserAuthorization();

        /**
         * The meta object literal for the '<em><b>Master Job Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__MASTER_JOB_ID = eINSTANCE.getProject_MasterJobId();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__ID = eINSTANCE.getProject_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__LABEL = eINSTANCE.getProject_Label();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__DESCRIPTION = eINSTANCE.getProject_Description();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__LANGUAGE = eINSTANCE.getProject_Language();

        /**
         * The meta object literal for the '<em><b>Technical Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__TECHNICAL_LABEL = eINSTANCE.getProject_TechnicalLabel();

        /**
         * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__DELETED = eINSTANCE.getProject_Deleted();

        /**
         * The meta object literal for the '<em><b>Delete Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__DELETE_DATE = eINSTANCE.getProject_DeleteDate();

        /**
         * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__CREATION_DATE = eINSTANCE.getProject_CreationDate();

        /**
         * The meta object literal for the '<em><b>Author</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT__AUTHOR = eINSTANCE.getProject_Author();

        /**
         * The meta object literal for the '<em><b>Referenced Projects</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT__REFERENCED_PROJECTS = eINSTANCE.getProject_ReferencedProjects();

        /**
         * The meta object literal for the '<em><b>Available Ref Project</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT__AVAILABLE_REF_PROJECT = eINSTANCE.getProject_AvailableRefProject();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__URL = eINSTANCE.getProject_Url();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__TYPE = eINSTANCE.getProject_Type();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__REFERENCE = eINSTANCE.getProject_Reference();

        /**
         * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT__LOCAL = eINSTANCE.getProject_Local();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.ProjectReferenceImpl <em>Project Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.ProjectReferenceImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getProjectReference()
         * @generated
         */
        EClass PROJECT_REFERENCE = eINSTANCE.getProjectReference();

        /**
         * The meta object literal for the '<em><b>Project</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT_REFERENCE__PROJECT = eINSTANCE.getProjectReference_Project();

        /**
         * The meta object literal for the '<em><b>Branch</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT_REFERENCE__BRANCH = eINSTANCE.getProjectReference_Branch();

        /**
         * The meta object literal for the '<em><b>Referenced Project</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROJECT_REFERENCE__REFERENCED_PROJECT = eINSTANCE.getProjectReference_ReferencedProject();

        /**
         * The meta object literal for the '<em><b>Referenced Branch</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROJECT_REFERENCE__REFERENCED_BRANCH = eINSTANCE.getProjectReference_ReferencedBranch();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.UserRoleImpl <em>User Role</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.UserRoleImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserRole()
         * @generated
         */
        EClass USER_ROLE = eINSTANCE.getUserRole();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ROLE__ID = eINSTANCE.getUserRole_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ROLE__NAME = eINSTANCE.getUserRole_Name();

        /**
         * The meta object literal for the '<em><b>Localized Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ROLE__LOCALIZED_LABEL = eINSTANCE.getUserRole_LocalizedLabel();

        /**
         * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ROLE__FIXED = eINSTANCE.getUserRole_Fixed();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.UserImpl <em>User</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.UserImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUser()
         * @generated
         */
        EClass USER = eINSTANCE.getUser();

        /**
         * The meta object literal for the '<em><b>Project Authorization</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER__PROJECT_AUTHORIZATION = eINSTANCE.getUser_ProjectAuthorization();

        /**
         * The meta object literal for the '<em><b>Preferred Dashboard Connection</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER__PREFERRED_DASHBOARD_CONNECTION = eINSTANCE.getUser_PreferredDashboardConnection();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__ID = eINSTANCE.getUser_Id();

        /**
         * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LOGIN = eINSTANCE.getUser_Login();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

        /**
         * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__FIRST_NAME = eINSTANCE.getUser_FirstName();

        /**
         * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LAST_NAME = eINSTANCE.getUser_LastName();

        /**
         * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__CREATION_DATE = eINSTANCE.getUser_CreationDate();

        /**
         * The meta object literal for the '<em><b>Delete Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__DELETE_DATE = eINSTANCE.getUser_DeleteDate();

        /**
         * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__DELETED = eINSTANCE.getUser_Deleted();

        /**
         * The meta object literal for the '<em><b>Last Admin Connection Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LAST_ADMIN_CONNECTION_DATE = eINSTANCE.getUser_LastAdminConnectionDate();

        /**
         * The meta object literal for the '<em><b>Last Studio Connection Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LAST_STUDIO_CONNECTION_DATE = eINSTANCE.getUser_LastStudioConnectionDate();

        /**
         * The meta object literal for the '<em><b>First Admin Connection Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__FIRST_ADMIN_CONNECTION_DATE = eINSTANCE.getUser_FirstAdminConnectionDate();

        /**
         * The meta object literal for the '<em><b>First Studio Connection Date</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__FIRST_STUDIO_CONNECTION_DATE = eINSTANCE.getUser_FirstStudioConnectionDate();

        /**
         * The meta object literal for the '<em><b>Admin Connexion Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__ADMIN_CONNEXION_NUMBER = eINSTANCE.getUser_AdminConnexionNumber();

        /**
         * The meta object literal for the '<em><b>Studio Connexion Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__STUDIO_CONNEXION_NUMBER = eINSTANCE.getUser_StudioConnexionNumber();

        /**
         * The meta object literal for the '<em><b>Authentication Info</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__AUTHENTICATION_INFO = eINSTANCE.getUser_AuthenticationInfo();

        /**
         * The meta object literal for the '<em><b>Ldap Login</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LDAP_LOGIN = eINSTANCE.getUser_LdapLogin();

        /**
         * The meta object literal for the '<em><b>Ldap Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LDAP_ID = eINSTANCE.getUser_LdapId();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__LANGUAGE = eINSTANCE.getUser_Language();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__TYPE = eINSTANCE.getUser_Type();

        /**
         * The meta object literal for the '<em><b>Additionnal Data</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER__ADDITIONNAL_DATA = eINSTANCE.getUser_AdditionnalData();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.UserRoleReferenceImpl <em>User Role Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.UserRoleReferenceImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserRoleReference()
         * @generated
         */
        EClass USER_ROLE_REFERENCE = eINSTANCE.getUserRoleReference();

        /**
         * The meta object literal for the '<em><b>User</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_ROLE_REFERENCE__USER = eINSTANCE.getUserRoleReference_User();

        /**
         * The meta object literal for the '<em><b>Role</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_ROLE_REFERENCE__ROLE = eINSTANCE.getUserRoleReference_Role();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl <em>User Project Authorization</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.UserProjectAuthorizationImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserProjectAuthorization()
         * @generated
         */
        EClass USER_PROJECT_AUTHORIZATION = eINSTANCE.getUserProjectAuthorization();

        /**
         * The meta object literal for the '<em><b>User</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_PROJECT_AUTHORIZATION__USER = eINSTANCE.getUserProjectAuthorization_User();

        /**
         * The meta object literal for the '<em><b>Project</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_PROJECT_AUTHORIZATION__PROJECT = eINSTANCE.getUserProjectAuthorization_Project();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_PROJECT_AUTHORIZATION__TYPE = eINSTANCE.getUserProjectAuthorization_Type();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.SchemaInformationImpl <em>Schema Information</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.SchemaInformationImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getSchemaInformation()
         * @generated
         */
        EClass SCHEMA_INFORMATION = eINSTANCE.getSchemaInformation();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCHEMA_INFORMATION__VERSION = eINSTANCE.getSchemaInformation_Version();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.DashboardConnectionImpl <em>Dashboard Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.DashboardConnectionImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getDashboardConnection()
         * @generated
         */
        EClass DASHBOARD_CONNECTION = eINSTANCE.getDashboardConnection();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__ID = eINSTANCE.getDashboardConnection_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__LABEL = eINSTANCE.getDashboardConnection_Label();

        /**
         * The meta object literal for the '<em><b>Dialect</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__DIALECT = eINSTANCE.getDashboardConnection_Dialect();

        /**
         * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__HOST = eINSTANCE.getDashboardConnection_Host();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__PORT = eINSTANCE.getDashboardConnection_Port();

        /**
         * The meta object literal for the '<em><b>Database</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__DATABASE = eINSTANCE.getDashboardConnection_Database();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__USERNAME = eINSTANCE.getDashboardConnection_Username();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__PASSWORD = eINSTANCE.getDashboardConnection_Password();

        /**
         * The meta object literal for the '<em><b>Log Table</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__LOG_TABLE = eINSTANCE.getDashboardConnection_LogTable();

        /**
         * The meta object literal for the '<em><b>Stat Table</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__STAT_TABLE = eINSTANCE.getDashboardConnection_StatTable();

        /**
         * The meta object literal for the '<em><b>Flow Meter Table</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__FLOW_METER_TABLE = eINSTANCE.getDashboardConnection_FlowMeterTable();

        /**
         * The meta object literal for the '<em><b>Additionnals Params</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__ADDITIONNALS_PARAMS = eINSTANCE.getDashboardConnection_AdditionnalsParams();

        /**
         * The meta object literal for the '<em><b>Datasource</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DASHBOARD_CONNECTION__DATASOURCE = eINSTANCE.getDashboardConnection_Datasource();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.LicenseImpl <em>License</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.LicenseImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getLicense()
         * @generated
         */
        EClass LICENSE = eINSTANCE.getLicense();

        /**
         * The meta object literal for the '<em><b>License</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LICENSE__LICENSE = eINSTANCE.getLicense_License();

        /**
         * The meta object literal for the '<em><b>Customer Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LICENSE__CUSTOMER_NAME = eINSTANCE.getLicense_CustomerName();

        /**
         * The meta object literal for the '<em><b>Params</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LICENSE__PARAMS = eINSTANCE.getLicense_Params();

        /**
         * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LICENSE__TOKEN = eINSTANCE.getLicense_Token();

        /**
         * The meta object literal for the '<em><b>Date Token Check</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LICENSE__DATE_TOKEN_CHECK = eINSTANCE.getLicense_DateTokenCheck();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.TechnicalVariableImpl <em>Technical Variable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.TechnicalVariableImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getTechnicalVariable()
         * @generated
         */
        EClass TECHNICAL_VARIABLE = eINSTANCE.getTechnicalVariable();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TECHNICAL_VARIABLE__KEY = eINSTANCE.getTechnicalVariable_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TECHNICAL_VARIABLE__VALUE = eINSTANCE.getTechnicalVariable_Value();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.impl.ArtifactNotificationImpl <em>Artifact Notification</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.impl.ArtifactNotificationImpl
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getArtifactNotification()
         * @generated
         */
        EClass ARTIFACT_NOTIFICATION = eINSTANCE.getArtifactNotification();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARTIFACT_NOTIFICATION__NAME = eINSTANCE.getArtifactNotification_Name();

        /**
         * The meta object literal for the '{@link org.talend.model.tac.admin.UserProjectAuthorizationType <em>User Project Authorization Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.model.tac.admin.UserProjectAuthorizationType
         * @see org.talend.model.tac.admin.impl.AdminPackageImpl#getUserProjectAuthorizationType()
         * @generated
         */
        EEnum USER_PROJECT_AUTHORIZATION_TYPE = eINSTANCE.getUserProjectAuthorizationType();

    }

} //AdminPackage
