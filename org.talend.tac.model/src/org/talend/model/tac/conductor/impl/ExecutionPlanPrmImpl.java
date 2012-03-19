/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.model.tac.conductor.ConductorPackage;
import org.talend.model.tac.conductor.ExecutionPlan;
import org.talend.model.tac.conductor.ExecutionPlanPrm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Plan Prm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl#getExecutionPlan <em>Execution Plan</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.ExecutionPlanPrmImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionPlanPrmImpl extends EObjectImpl implements ExecutionPlanPrm {

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
     * The cached value of the '{@link #getExecutionPlan() <em>Execution Plan</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecutionPlan()
     * @generated
     * @ordered
     */
    protected ExecutionPlan executionPlan;

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
    protected ExecutionPlanPrmImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ConductorPackage.Literals.EXECUTION_PLAN_PRM;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_PLAN_PRM__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlan getExecutionPlan() {
        if (executionPlan != null && executionPlan.eIsProxy()) {
            InternalEObject oldExecutionPlan = (InternalEObject) executionPlan;
            executionPlan = (ExecutionPlan) eResolveProxy(oldExecutionPlan);
            if (executionPlan != oldExecutionPlan) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN, oldExecutionPlan, executionPlan));
            }
        }
        return executionPlan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecutionPlan basicGetExecutionPlan() {
        return executionPlan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExecutionPlan(ExecutionPlan newExecutionPlan) {
        ExecutionPlan oldExecutionPlan = executionPlan;
        executionPlan = newExecutionPlan;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN,
                    oldExecutionPlan, executionPlan));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_PLAN_PRM__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.EXECUTION_PLAN_PRM__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ConductorPackage.EXECUTION_PLAN_PRM__ID:
            return new Integer(getId());
        case ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN:
            if (resolve)
                return getExecutionPlan();
            return basicGetExecutionPlan();
        case ConductorPackage.EXECUTION_PLAN_PRM__NAME:
            return getName();
        case ConductorPackage.EXECUTION_PLAN_PRM__VALUE:
            return getValue();
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
        case ConductorPackage.EXECUTION_PLAN_PRM__ID:
            setId(((Integer) newValue).intValue());
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN:
            setExecutionPlan((ExecutionPlan) newValue);
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__NAME:
            setName((String) newValue);
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__VALUE:
            setValue((String) newValue);
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
        case ConductorPackage.EXECUTION_PLAN_PRM__ID:
            setId(ID_EDEFAULT);
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN:
            setExecutionPlan((ExecutionPlan) null);
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ConductorPackage.EXECUTION_PLAN_PRM__VALUE:
            setValue(VALUE_EDEFAULT);
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
        case ConductorPackage.EXECUTION_PLAN_PRM__ID:
            return id != ID_EDEFAULT;
        case ConductorPackage.EXECUTION_PLAN_PRM__EXECUTION_PLAN:
            return executionPlan != null;
        case ConductorPackage.EXECUTION_PLAN_PRM__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ConductorPackage.EXECUTION_PLAN_PRM__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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

} //ExecutionPlanPrmImpl
