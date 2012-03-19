/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Trigger Mask</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#isActive <em>Active</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getFileTrigger <em>File Trigger</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getFolderPath <em>Folder Path</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getFileMask <em>File Mask</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getContextParameterBaseName <em>Context Parameter Base Name</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#getCheckFileServer <em>Check File Server</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#isExist <em>Exist</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#isCreated <em>Created</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.FileTriggerMask#isModified <em>Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask()
 * @model
 * @generated
 */
public interface FileTriggerMask extends EObject {

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
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active</em>' attribute.
     * @see #setActive(boolean)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Active()
     * @model
     * @generated
     */
    boolean isActive();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#isActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive(boolean value);

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
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getLabel <em>Label</em>}' attribute.
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
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>File Trigger</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Trigger</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Trigger</em>' reference.
     * @see #setFileTrigger(FileTrigger)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_FileTrigger()
     * @model
     * @generated
     */
    FileTrigger getFileTrigger();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getFileTrigger <em>File Trigger</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Trigger</em>' reference.
     * @see #getFileTrigger()
     * @generated
     */
    void setFileTrigger(FileTrigger value);

    /**
     * Returns the value of the '<em><b>Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Folder Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Folder Path</em>' attribute.
     * @see #setFolderPath(String)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_FolderPath()
     * @model
     * @generated
     */
    String getFolderPath();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getFolderPath <em>Folder Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Folder Path</em>' attribute.
     * @see #getFolderPath()
     * @generated
     */
    void setFolderPath(String value);

    /**
     * Returns the value of the '<em><b>File Mask</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Mask</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Mask</em>' attribute.
     * @see #setFileMask(String)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_FileMask()
     * @model
     * @generated
     */
    String getFileMask();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getFileMask <em>File Mask</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Mask</em>' attribute.
     * @see #getFileMask()
     * @generated
     */
    void setFileMask(String value);

    /**
     * Returns the value of the '<em><b>Context Parameter Base Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Parameter Base Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Parameter Base Name</em>' attribute.
     * @see #setContextParameterBaseName(String)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_ContextParameterBaseName()
     * @model
     * @generated
     */
    String getContextParameterBaseName();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getContextParameterBaseName <em>Context Parameter Base Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Parameter Base Name</em>' attribute.
     * @see #getContextParameterBaseName()
     * @generated
     */
    void setContextParameterBaseName(String value);

    /**
     * Returns the value of the '<em><b>Check File Server</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Check File Server</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Check File Server</em>' reference.
     * @see #setCheckFileServer(ExecutionServer)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_CheckFileServer()
     * @model
     * @generated
     */
    ExecutionServer getCheckFileServer();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#getCheckFileServer <em>Check File Server</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Check File Server</em>' reference.
     * @see #getCheckFileServer()
     * @generated
     */
    void setCheckFileServer(ExecutionServer value);

    /**
     * Returns the value of the '<em><b>Exist</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exist</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exist</em>' attribute.
     * @see #setExist(boolean)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Exist()
     * @model
     * @generated
     */
    boolean isExist();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#isExist <em>Exist</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exist</em>' attribute.
     * @see #isExist()
     * @generated
     */
    void setExist(boolean value);

    /**
     * Returns the value of the '<em><b>Created</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Created</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Created</em>' attribute.
     * @see #setCreated(boolean)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Created()
     * @model
     * @generated
     */
    boolean isCreated();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#isCreated <em>Created</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Created</em>' attribute.
     * @see #isCreated()
     * @generated
     */
    void setCreated(boolean value);

    /**
     * Returns the value of the '<em><b>Modified</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modified</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modified</em>' attribute.
     * @see #setModified(boolean)
     * @see org.talend.model.tac.conductor.ConductorPackage#getFileTriggerMask_Modified()
     * @model
     * @generated
     */
    boolean isModified();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.FileTriggerMask#isModified <em>Modified</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Modified</em>' attribute.
     * @see #isModified()
     * @generated
     */
    void setModified(boolean value);

} // FileTriggerMask
