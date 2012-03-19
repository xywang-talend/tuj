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
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.Project#getUserAuthorization <em>User Authorization</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getMasterJobId <em>Master Job Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getTechnicalLabel <em>Technical Label</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getDeleteDate <em>Delete Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getReferencedProjects <em>Referenced Projects</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getAvailableRefProject <em>Available Ref Project</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#isReference <em>Reference</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.Project#isLocal <em>Local</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.admin.AdminPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {

    /**
     * Returns the value of the '<em><b>User Authorization</b></em>' reference list.
     * The list contents are of type {@link org.talend.model.tac.admin.UserProjectAuthorization}.
     * It is bidirectional and its opposite is '{@link org.talend.model.tac.admin.UserProjectAuthorization#getProject <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Authorization</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Authorization</em>' reference list.
     * @see org.talend.model.tac.admin.AdminPackage#getProject_UserAuthorization()
     * @see org.talend.model.tac.admin.UserProjectAuthorization#getProject
     * @model type="org.talend.model.tac.admin.UserProjectAuthorization" opposite="project" ordered="false"
     * @generated
     */
    EList getUserAuthorization();

    /**
     * Returns the value of the '<em><b>Master Job Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master Job Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Master Job Id</em>' attribute.
     * @see #setMasterJobId(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_MasterJobId()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     * @generated
     */
    String getMasterJobId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getMasterJobId <em>Master Job Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Master Job Id</em>' attribute.
     * @see #getMasterJobId()
     * @generated
     */
    void setMasterJobId(String value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Label()
     * @model required="true"
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Description()
     * @model unique="false"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Language()
     * @model unique="false" required="true"
     * @generated
     */
    String getLanguage();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getLanguage <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language</em>' attribute.
     * @see #getLanguage()
     * @generated
     */
    void setLanguage(String value);

    /**
     * Returns the value of the '<em><b>Technical Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technical Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technical Label</em>' attribute.
     * @see #setTechnicalLabel(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_TechnicalLabel()
     * @model required="true"
     * @generated
     */
    String getTechnicalLabel();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getTechnicalLabel <em>Technical Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technical Label</em>' attribute.
     * @see #getTechnicalLabel()
     * @generated
     */
    void setTechnicalLabel(String value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Deleted()
     * @model unique="false" required="true"
     * @generated
     */
    boolean isDeleted();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#isDeleted <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deleted</em>' attribute.
     * @see #isDeleted()
     * @generated
     */
    void setDeleted(boolean value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_DeleteDate()
     * @model unique="false"
     * @generated
     */
    Date getDeleteDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getDeleteDate <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete Date</em>' attribute.
     * @see #getDeleteDate()
     * @generated
     */
    void setDeleteDate(Date value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_CreationDate()
     * @model unique="false" required="true"
     * @generated
     */
    Date getCreationDate();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(Date value);

    /**
     * Returns the value of the '<em><b>Author</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Author</em>' reference.
     * @see #setAuthor(User)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Author()
     * @model
     * @generated
     */
    User getAuthor();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getAuthor <em>Author</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Author</em>' reference.
     * @see #getAuthor()
     * @generated
     */
    void setAuthor(User value);

    /**
     * Returns the value of the '<em><b>Referenced Projects</b></em>' reference list.
     * The list contents are of type {@link org.talend.model.tac.admin.ProjectReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Projects</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced Projects</em>' reference list.
     * @see org.talend.model.tac.admin.AdminPackage#getProject_ReferencedProjects()
     * @model type="org.talend.model.tac.admin.ProjectReference" ordered="false"
     * @generated
     */
    EList getReferencedProjects();

    /**
     * Returns the value of the '<em><b>Available Ref Project</b></em>' reference list.
     * The list contents are of type {@link org.talend.model.tac.admin.ProjectReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Available Ref Project</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Available Ref Project</em>' reference list.
     * @see org.talend.model.tac.admin.AdminPackage#getProject_AvailableRefProject()
     * @model type="org.talend.model.tac.admin.ProjectReference" ordered="false"
     * @generated
     */
    EList getAvailableRefProject();

    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Url()
     * @model
     * @generated
     */
    String getUrl();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl(String value);

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
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Type()
     * @model unique="false"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Reference</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' attribute.
     * @see #setReference(boolean)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Reference()
     * @model unique="false" required="true"
     * @generated
     */
    boolean isReference();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#isReference <em>Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' attribute.
     * @see #isReference()
     * @generated
     */
    void setReference(boolean value);

    /**
     * Returns the value of the '<em><b>Local</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local</em>' attribute.
     * @see #setLocal(boolean)
     * @see org.talend.model.tac.admin.AdminPackage#getProject_Local()
     * @model unique="false" required="true"
     * @generated
     */
    boolean isLocal();

    /**
     * Sets the value of the '{@link org.talend.model.tac.admin.Project#isLocal <em>Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local</em>' attribute.
     * @see #isLocal()
     * @generated
     */
    void setLocal(boolean value);

} // Project
