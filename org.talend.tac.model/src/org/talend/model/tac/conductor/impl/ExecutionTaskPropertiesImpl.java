/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.talend.model.tac.conductor.ConductorPackage;
import org.talend.model.tac.conductor.ExecutionTask;
import org.talend.model.tac.conductor.ExecutionTaskProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Task Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionTaskPropertiesImpl#getExecutionTask <em>Execution Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTaskPropertiesImpl extends EObjectImpl implements ExecutionTaskProperties {

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
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExecutionTaskPropertiesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ConductorPackage.Literals.EXECUTION_TASK_PROPERTIES;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_TASK_PROPERTIES__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_TASK_PROPERTIES__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_TASK_PROPERTIES__VALUE, oldValue,
                    value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionTask getExecutionTask() {
        if (eContainerFeatureID() != ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK)
            return null;
        return (ExecutionTask) eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExecutionTask(ExecutionTask newExecutionTask, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newExecutionTask, ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExecutionTask(ExecutionTask newExecutionTask) {
        if (newExecutionTask != eInternalContainer()
                || (eContainerFeatureID() != ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK && newExecutionTask != null)) {
            if (EcoreUtil.isAncestor(this, newExecutionTask))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newExecutionTask != null)
                msgs = ((InternalEObject) newExecutionTask).eInverseAdd(this,
                        ConductorPackage.EXECUTION_TASK__ESB_PROPERTIES_PRMS, ExecutionTask.class, msgs);
            msgs = basicSetExecutionTask(newExecutionTask, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK,
                    newExecutionTask, newExecutionTask));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetExecutionTask((ExecutionTask) otherEnd, msgs);
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
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            return basicSetExecutionTask(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            return eInternalContainer().eInverseRemove(this, ConductorPackage.EXECUTION_TASK__ESB_PROPERTIES_PRMS,
                    ExecutionTask.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__ID:
            return new Integer(getId());
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__NAME:
            return getName();
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__VALUE:
            return getValue();
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            return getExecutionTask();
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
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__ID:
            setId(((Integer) newValue).intValue());
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__NAME:
            setName((String) newValue);
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__VALUE:
            setValue((String) newValue);
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            setExecutionTask((ExecutionTask) newValue);
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
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__ID:
            setId(ID_EDEFAULT);
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__VALUE:
            setValue(VALUE_EDEFAULT);
            return;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            setExecutionTask((ExecutionTask) null);
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
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__ID:
            return id != ID_EDEFAULT;
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
        case ConductorPackage.EXECUTION_TASK_PROPERTIES__EXECUTION_TASK:
            return getExecutionTask() != null;
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
        result.append(", name: ");
        result.append(name);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //ExecutionTaskPropertiesImpl
