/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.UserRole#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.UserRole#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.UserRole#getLocalizedLabel <em>Localized Label</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.UserRole#isFixed <em>Fixed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.admin.AdminPackage#getUserRole()
 * @model
 * @generated
 */
public interface UserRole extends EObject {

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
     * @see org.talend.model.tac.admin.AdminPackage#getUserRole_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.UserRole#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUserRole_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.UserRole#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Localized Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Localized Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Localized Label</em>' attribute.
     * @see #setLocalizedLabel(String)
     * @see org.talend.model.tac.admin.AdminPackage#getUserRole_LocalizedLabel()
     * @model required="true"
     * @generated
     */
    String getLocalizedLabel();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.UserRole#getLocalizedLabel <em>Localized Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Localized Label</em>' attribute.
     * @see #getLocalizedLabel()
     * @generated
     */
    void setLocalizedLabel(String value);

    /**
     * Returns the value of the '<em><b>Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fixed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fixed</em>' attribute.
     * @see #setFixed(boolean)
     * @see org.talend.model.tac.admin.AdminPackage#getUserRole_Fixed()
     * @model unique="false"
     * @generated
     */
    boolean isFixed();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.UserRole#isFixed <em>Fixed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fixed</em>' attribute.
     * @see #isFixed()
     * @generated
     */
    void setFixed(boolean value);

} // UserRole
