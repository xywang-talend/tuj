/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.impl.NotificationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.NotificationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.NotificationImpl#getProps <em>Props</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.NotificationImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationImpl extends EObjectImpl implements Notification {

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
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getProps() <em>Props</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProps()
     * @generated
     * @ordered
     */
    protected static final String PROPS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProps() <em>Props</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProps()
     * @generated
     * @ordered
     */
    protected String props = PROPS_EDEFAULT;

    /**
     * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected boolean enabled = ENABLED_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NotificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AdminPackage.Literals.NOTIFICATION;
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
            eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, AdminPackage.NOTIFICATION__ID,
                    oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, AdminPackage.NOTIFICATION__TYPE,
                    oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getProps() {
        return props;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProps(String newProps) {
        String oldProps = props;
        props = newProps;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET, AdminPackage.NOTIFICATION__PROPS,
                    oldProps, props));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnabled(boolean newEnabled) {
        boolean oldEnabled = enabled;
        enabled = newEnabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, org.eclipse.emf.common.notify.Notification.SET,
                    AdminPackage.NOTIFICATION__ENABLED, oldEnabled, enabled));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AdminPackage.NOTIFICATION__ID:
            return new Integer(getId());
        case AdminPackage.NOTIFICATION__TYPE:
            return getType();
        case AdminPackage.NOTIFICATION__PROPS:
            return getProps();
        case AdminPackage.NOTIFICATION__ENABLED:
            return isEnabled() ? Boolean.TRUE : Boolean.FALSE;
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
        case AdminPackage.NOTIFICATION__ID:
            setId(((Integer) newValue).intValue());
            return;
        case AdminPackage.NOTIFICATION__TYPE:
            setType((String) newValue);
            return;
        case AdminPackage.NOTIFICATION__PROPS:
            setProps((String) newValue);
            return;
        case AdminPackage.NOTIFICATION__ENABLED:
            setEnabled(((Boolean) newValue).booleanValue());
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
        case AdminPackage.NOTIFICATION__ID:
            setId(ID_EDEFAULT);
            return;
        case AdminPackage.NOTIFICATION__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case AdminPackage.NOTIFICATION__PROPS:
            setProps(PROPS_EDEFAULT);
            return;
        case AdminPackage.NOTIFICATION__ENABLED:
            setEnabled(ENABLED_EDEFAULT);
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
        case AdminPackage.NOTIFICATION__ID:
            return id != ID_EDEFAULT;
        case AdminPackage.NOTIFICATION__TYPE:
            return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
        case AdminPackage.NOTIFICATION__PROPS:
            return PROPS_EDEFAULT == null ? props != null : !PROPS_EDEFAULT.equals(props);
        case AdminPackage.NOTIFICATION__ENABLED:
            return enabled != ENABLED_EDEFAULT;
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
        result.append(", type: ");
        result.append(type);
        result.append(", props: ");
        result.append(props);
        result.append(", enabled: ");
        result.append(enabled);
        result.append(')');
        return result.toString();
    }

} //NotificationImpl
