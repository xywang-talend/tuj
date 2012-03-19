/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Task Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getExecutionTask <em>Execution Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionTaskProperties()
 * @model
 * @generated
 */
public interface ExecutionTaskProperties extends EObject {

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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionTaskProperties_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getId <em>Id</em>}' attribute.
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
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionTaskProperties_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionTaskProperties_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Execution Task</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.talend.model.tac.conductor.ExecutionTask#getEsbPropertiesPrms <em>Esb Properties Prms</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Execution Task</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Execution Task</em>' container reference.
     * @see #setExecutionTask(ExecutionTask)
     * @see org.talend.model.tac.conductor.ConductorPackage#getExecutionTaskProperties_ExecutionTask()
     * @see org.talend.model.tac.conductor.ExecutionTask#getEsbPropertiesPrms
     * @model opposite="esbPropertiesPrms" transient="false"
     * @generated
     */
    ExecutionTask getExecutionTask();

    /**
     * Sets the value of the '{@link org.talend.model.tac.conductor.ExecutionTaskProperties#getExecutionTask <em>Execution Task</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Execution Task</em>' container reference.
     * @see #getExecutionTask()
     * @generated
     */
    void setExecutionTask(ExecutionTask value);

} // ExecutionTaskProperties
