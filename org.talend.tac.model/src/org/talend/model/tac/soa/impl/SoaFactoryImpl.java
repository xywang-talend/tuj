/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.soa.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.talend.model.tac.soa.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SoaFactoryImpl extends EFactoryImpl implements SoaFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SoaFactory init() {
        try {
            SoaFactory theSoaFactory = (SoaFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.talend.org/tac/soa");
            if (theSoaFactory != null) {
                return theSoaFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SoaFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SoaPackage.SOA_OPERATION:
            return createSoaOperation();
        case SoaPackage.SOA_INPUT_PARAMETER:
            return createSoaInputParameter();
        case SoaPackage.SOA_SERVICE:
            return createSoaService();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaOperation createSoaOperation() {
        SoaOperationImpl soaOperation = new SoaOperationImpl();
        return soaOperation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaInputParameter createSoaInputParameter() {
        SoaInputParameterImpl soaInputParameter = new SoaInputParameterImpl();
        return soaInputParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaService createSoaService() {
        SoaServiceImpl soaService = new SoaServiceImpl();
        return soaService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SoaPackage getSoaPackage() {
        return (SoaPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SoaPackage getPackage() {
        return SoaPackage.eINSTANCE;
    }

} //SoaFactoryImpl
