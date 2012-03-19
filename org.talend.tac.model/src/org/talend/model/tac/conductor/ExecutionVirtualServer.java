/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Virtual Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionVirtualServer#isActive <em>Active</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getExecutionServers <em>Execution Servers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer()
 * @model
 * @generated
 */
public interface ExecutionVirtualServer extends EObject {

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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getId <em>Id</em>}' attribute.
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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getLabel <em>Label</em>}' attribute.
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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer_Active()
     * @model
     * @generated
     */
    boolean isActive();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionVirtualServer#isActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive(boolean value);

    /**
     * Returns the value of the '<em><b>Execution Servers</b></em>' reference list.
     * The list contents are of type {@link org.talend.model.tac.conductor.ExecutionServer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Execution Servers</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Execution Servers</em>' reference list.
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionVirtualServer_ExecutionServers()
     * @model type="org.talend.model.tac.conductor.ExecutionServer" ordered="false"
     * @generated
     */
    EList getExecutionServers();

} // ExecutionVirtualServer
