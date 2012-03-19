/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.ProjectReference#getProject <em>Project</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.ProjectReference#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.ProjectReference#getReferencedProject <em>Referenced Project</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.ProjectReference#getReferencedBranch <em>Referenced Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.admin.AdminPackage#getProjectReference()
 * @model
 * @generated
 */
public interface ProjectReference extends EObject {

    /**
     * Returns the value of the '<em><b>Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Project</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Project</em>' reference.
     * @see #setProject(Project)
     * @see org.talend.model.tac.admin.AdminPackage#getProjectReference_Project()
     * @model required="true"
     * @generated
     */
    Project getProject();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.ProjectReference#getProject <em>Project</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Project</em>' reference.
     * @see #getProject()
     * @generated
     */
    void setProject(Project value);

    /**
     * Returns the value of the '<em><b>Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Branch</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Branch</em>' attribute.
     * @see #setBranch(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProjectReference_Branch()
     * @model
     * @generated
     */
    String getBranch();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.ProjectReference#getBranch <em>Branch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Branch</em>' attribute.
     * @see #getBranch()
     * @generated
     */
    void setBranch(String value);

    /**
     * Returns the value of the '<em><b>Referenced Project</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Project</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced Project</em>' reference.
     * @see #setReferencedProject(Project)
     * @see org.talend.model.tac.admin.AdminPackage#getProjectReference_ReferencedProject()
     * @model required="true"
     * @generated
     */
    Project getReferencedProject();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.ProjectReference#getReferencedProject <em>Referenced Project</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referenced Project</em>' reference.
     * @see #getReferencedProject()
     * @generated
     */
    void setReferencedProject(Project value);

    /**
     * Returns the value of the '<em><b>Referenced Branch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Branch</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced Branch</em>' attribute.
     * @see #setReferencedBranch(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProjectReference_ReferencedBranch()
     * @model
     * @generated
     */
    String getReferencedBranch();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.ProjectReference#getReferencedBranch <em>Referenced Branch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referenced Branch</em>' attribute.
     * @see #getReferencedBranch()
     * @generated
     */
    void setReferencedBranch(String value);

} // ProjectReference
