/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.soa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.model.tac.soa.SoaPackage
 * @generated
 */
public interface SoaFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SoaFactory eINSTANCE = org.talend.model.tac.soa.impl.SoaFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Operation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation</em>'.
     * @generated
     */
    SoaOperation createSoaOperation();

    /**
     * Returns a new object of class '<em>Input Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Input Parameter</em>'.
     * @generated
     */
    SoaInputParameter createSoaInputParameter();

    /**
     * Returns a new object of class '<em>Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Service</em>'.
     * @generated
     */
    SoaService createSoaService();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SoaPackage getSoaPackage();

} //SoaFactory
