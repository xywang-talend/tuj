/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.soa.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.model.tac.soa.SoaInputParameter;
import org.talend.model.tac.soa.SoaOperation;
import org.talend.model.tac.soa.SoaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#getExposedName <em>Exposed Name</em>}</li>
 *   <li>{@link org.talend.model.tac.soa.impl.SoaInputParameterImpl#isExposed <em>Exposed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoaInputParameterImpl extends EObjectImpl implements SoaInputParameter {

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
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperation()
     * @generated
     * @ordered
     */
    protected SoaOperation operation;

    /**
     * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getExposedName() <em>Exposed Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExposedName()
     * @generated
     * @ordered
     */
    protected static final String EXPOSED_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExposedName() <em>Exposed Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExposedName()
     * @generated
     * @ordered
     */
    protected String exposedName = EXPOSED_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isExposed() <em>Exposed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExposed()
     * @generated
     * @ordered
     */
    protected static final boolean EXPOSED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isExposed() <em>Exposed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExposed()
     * @generated
     * @ordered
     */
    protected boolean exposed = EXPOSED_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SoaInputParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SoaPackage.Literals.SOA_INPUT_PARAMETER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaOperation getOperation() {
        if (operation != null && operation.eIsProxy()) {
            InternalEObject oldOperation = (InternalEObject) operation;
            operation = (SoaOperation) eResolveProxy(oldOperation);
            if (operation != oldOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaPackage.SOA_INPUT_PARAMETER__OPERATION,
                            oldOperation, operation));
            }
        }
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaOperation basicGetOperation() {
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(SoaOperation newOperation) {
        SoaOperation oldOperation = operation;
        operation = newOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__OPERATION, oldOperation,
                    operation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValue(String newDefaultValue) {
        String oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__DEFAULT_VALUE, oldDefaultValue,
                    defaultValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExposedName() {
        return exposedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExposedName(String newExposedName) {
        String oldExposedName = exposedName;
        exposedName = newExposedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__EXPOSED_NAME, oldExposedName,
                    exposedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isExposed() {
        return exposed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExposed(boolean newExposed) {
        boolean oldExposed = exposed;
        exposed = newExposed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SoaPackage.SOA_INPUT_PARAMETER__EXPOSED, oldExposed, exposed));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SoaPackage.SOA_INPUT_PARAMETER__ID:
            return new Integer(getId());
        case SoaPackage.SOA_INPUT_PARAMETER__LABEL:
            return getLabel();
        case SoaPackage.SOA_INPUT_PARAMETER__OPERATION:
            if (resolve)
                return getOperation();
            return basicGetOperation();
        case SoaPackage.SOA_INPUT_PARAMETER__DEFAULT_VALUE:
            return getDefaultValue();
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED_NAME:
            return getExposedName();
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED:
            return isExposed() ? Boolean.TRUE : Boolean.FALSE;
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
        case SoaPackage.SOA_INPUT_PARAMETER__ID:
            setId(((Integer) newValue).intValue());
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__LABEL:
            setLabel((String) newValue);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__OPERATION:
            setOperation((SoaOperation) newValue);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__DEFAULT_VALUE:
            setDefaultValue((String) newValue);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED_NAME:
            setExposedName((String) newValue);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED:
            setExposed(((Boolean) newValue).booleanValue());
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
        case SoaPackage.SOA_INPUT_PARAMETER__ID:
            setId(ID_EDEFAULT);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__LABEL:
            setLabel(LABEL_EDEFAULT);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__OPERATION:
            setOperation((SoaOperation) null);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__DEFAULT_VALUE:
            setDefaultValue(DEFAULT_VALUE_EDEFAULT);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED_NAME:
            setExposedName(EXPOSED_NAME_EDEFAULT);
            return;
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED:
            setExposed(EXPOSED_EDEFAULT);
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
        case SoaPackage.SOA_INPUT_PARAMETER__ID:
            return id != ID_EDEFAULT;
        case SoaPackage.SOA_INPUT_PARAMETER__LABEL:
            return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        case SoaPackage.SOA_INPUT_PARAMETER__OPERATION:
            return operation != null;
        case SoaPackage.SOA_INPUT_PARAMETER__DEFAULT_VALUE:
            return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED_NAME:
            return EXPOSED_NAME_EDEFAULT == null ? exposedName != null : !EXPOSED_NAME_EDEFAULT.equals(exposedName);
        case SoaPackage.SOA_INPUT_PARAMETER__EXPOSED:
            return exposed != EXPOSED_EDEFAULT;
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
        result.append(", label: ");
        result.append(label);
        result.append(", defaultValue: ");
        result.append(defaultValue);
        result.append(", exposedName: ");
        result.append(exposedName);
        result.append(", exposed: ");
        result.append(exposed);
        result.append(')');
        return result.toString();
    }

} //SoaInputParameterImpl
