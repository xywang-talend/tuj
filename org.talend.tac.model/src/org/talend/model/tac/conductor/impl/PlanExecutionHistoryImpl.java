/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.conductor.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.talend.model.tac.conductor.ConductorPackage;
import org.talend.model.tac.conductor.PlanExecutionHistory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plan Execution History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl#getOriginalLabel <em>Original Label</em>}</li>
 *   <li>{@link org.talend.model.tac.conductor.impl.PlanExecutionHistoryImpl#getCurrentLabel <em>Current Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlanExecutionHistoryImpl extends TaskExecutionHistoryImpl implements PlanExecutionHistory {

    /**
     * The default value of the '{@link #getOriginalLabel() <em>Original Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalLabel()
     * @generated
     * @ordered
     */
    protected static final String ORIGINAL_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOriginalLabel() <em>Original Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOriginalLabel()
     * @generated
     * @ordered
     */
    protected String originalLabel = ORIGINAL_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getCurrentLabel() <em>Current Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCurrentLabel()
     * @generated
     * @ordered
     */
    protected static final String CURRENT_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCurrentLabel() <em>Current Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCurrentLabel()
     * @generated
     * @ordered
     */
    protected String currentLabel = CURRENT_LABEL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PlanExecutionHistoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ConductorPackage.Literals.PLAN_EXECUTION_HISTORY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOriginalLabel() {
        return originalLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOriginalLabel(String newOriginalLabel) {
        String oldOriginalLabel = originalLabel;
        originalLabel = newOriginalLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL,
                    oldOriginalLabel, originalLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCurrentLabel() {
        return currentLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCurrentLabel(String newCurrentLabel) {
        String oldCurrentLabel = currentLabel;
        currentLabel = newCurrentLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConductorPackage.PLAN_EXECUTION_HISTORY__CURRENT_LABEL,
                    oldCurrentLabel, currentLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ConductorPackage.PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL:
            return getOriginalLabel();
        case ConductorPackage.PLAN_EXECUTION_HISTORY__CURRENT_LABEL:
            return getCurrentLabel();
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
        case ConductorPackage.PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL:
            setOriginalLabel((String) newValue);
            return;
        case ConductorPackage.PLAN_EXECUTION_HISTORY__CURRENT_LABEL:
            setCurrentLabel((String) newValue);
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
        case ConductorPackage.PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL:
            setOriginalLabel(ORIGINAL_LABEL_EDEFAULT);
            return;
        case ConductorPackage.PLAN_EXECUTION_HISTORY__CURRENT_LABEL:
            setCurrentLabel(CURRENT_LABEL_EDEFAULT);
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
        case ConductorPackage.PLAN_EXECUTION_HISTORY__ORIGINAL_LABEL:
            return ORIGINAL_LABEL_EDEFAULT == null ? originalLabel != null : !ORIGINAL_LABEL_EDEFAULT.equals(originalLabel);
        case ConductorPackage.PLAN_EXECUTION_HISTORY__CURRENT_LABEL:
            return CURRENT_LABEL_EDEFAULT == null ? currentLabel != null : !CURRENT_LABEL_EDEFAULT.equals(currentLabel);
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
        result.append(" (originalLabel: ");
        result.append(originalLabel);
        result.append(", currentLabel: ");
        result.append(currentLabel);
        result.append(')');
        return result.toString();
    }

} //PlanExecutionHistoryImpl
