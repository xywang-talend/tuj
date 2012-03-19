/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.model.tac.admin.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.talend.model.tac.admin.AdminPackage;
import org.talend.model.tac.admin.Project;
import org.talend.model.tac.admin.ProjectReference;
import org.talend.model.tac.admin.User;
import org.talend.model.tac.admin.UserProjectAuthorization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getUserAuthorization <em>User Authorization</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getMasterJobId <em>Master Job Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getTechnicalLabel <em>Technical Label</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getDeleteDate <em>Delete Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getReferencedProjects <em>Referenced Projects</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getAvailableRefProject <em>Available Ref Project</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#isReference <em>Reference</em>}</li>
 *   <li>{@link org.talend.model.tac.admin.impl.ProjectImpl#isLocal <em>Local</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {

    /**
     * The cached value of the '{@link #getUserAuthorization() <em>User Authorization</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserAuthorization()
     * @generated
     * @ordered
     */
    protected EList userAuthorization;

    /**
     * The default value of the '{@link #getMasterJobId() <em>Master Job Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterJobId()
     * @generated
     * @ordered
     */
    protected static final String MASTER_JOB_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMasterJobId() <em>Master Job Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterJobId()
     * @generated
     * @ordered
     */
    protected String masterJobId = MASTER_JOB_ID_EDEFAULT;

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
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected String language = LANGUAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getTechnicalLabel() <em>Technical Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnicalLabel()
     * @generated
     * @ordered
     */
    protected static final String TECHNICAL_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTechnicalLabel() <em>Technical Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnicalLabel()
     * @generated
     * @ordered
     */
    protected String technicalLabel = TECHNICAL_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected static final boolean DELETED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected boolean deleted = DELETED_EDEFAULT;

    /**
     * The default value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected static final Date DELETE_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDeleteDate() <em>Delete Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteDate()
     * @generated
     * @ordered
     */
    protected Date deleteDate = DELETE_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final Date CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected Date creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getAuthor() <em>Author</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected User author;

    /**
     * The cached value of the '{@link #getReferencedProjects() <em>Referenced Projects</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferencedProjects()
     * @generated
     * @ordered
     */
    protected EList referencedProjects;

    /**
     * The cached value of the '{@link #getAvailableRefProject() <em>Available Ref Project</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAvailableRefProject()
     * @generated
     * @ordered
     */
    protected EList availableRefProject;

    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

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
     * The default value of the '{@link #isReference() <em>Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReference()
     * @generated
     * @ordered
     */
    protected static final boolean REFERENCE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReference() <em>Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReference()
     * @generated
     * @ordered
     */
    protected boolean reference = REFERENCE_EDEFAULT;

    /**
     * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLocal()
     * @generated
     * @ordered
     */
    protected static final boolean LOCAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLocal()
     * @generated
     * @ordered
     */
    protected boolean local = LOCAL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AdminPackage.Literals.PROJECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getUserAuthorization() {
        if (userAuthorization == null) {
            userAuthorization = new EObjectWithInverseResolvingEList(UserProjectAuthorization.class, this,
                    AdminPackage.PROJECT__USER_AUTHORIZATION, AdminPackage.USER_PROJECT_AUTHORIZATION__PROJECT);
        }
        return userAuthorization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMasterJobId() {
        return masterJobId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMasterJobId(String newMasterJobId) {
        String oldMasterJobId = masterJobId;
        masterJobId = newMasterJobId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__MASTER_JOB_ID, oldMasterJobId,
                    masterJobId));
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
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__ID, oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLanguage(String newLanguage) {
        String oldLanguage = language;
        language = newLanguage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__LANGUAGE, oldLanguage, language));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTechnicalLabel() {
        return technicalLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnicalLabel(String newTechnicalLabel) {
        String oldTechnicalLabel = technicalLabel;
        technicalLabel = newTechnicalLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__TECHNICAL_LABEL, oldTechnicalLabel,
                    technicalLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleted(boolean newDeleted) {
        boolean oldDeleted = deleted;
        deleted = newDeleted;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__DELETED, oldDeleted, deleted));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteDate(Date newDeleteDate) {
        Date oldDeleteDate = deleteDate;
        deleteDate = newDeleteDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__DELETE_DATE, oldDeleteDate, deleteDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCreationDate(Date newCreationDate) {
        Date oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__CREATION_DATE, oldCreationDate,
                    creationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public User getAuthor() {
        if (author != null && author.eIsProxy()) {
            InternalEObject oldAuthor = (InternalEObject) author;
            author = (User) eResolveProxy(oldAuthor);
            if (author != oldAuthor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdminPackage.PROJECT__AUTHOR, oldAuthor, author));
            }
        }
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public User basicGetAuthor() {
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthor(User newAuthor) {
        User oldAuthor = author;
        author = newAuthor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__AUTHOR, oldAuthor, author));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getReferencedProjects() {
        if (referencedProjects == null) {
            referencedProjects = new EObjectResolvingEList(ProjectReference.class, this,
                    AdminPackage.PROJECT__REFERENCED_PROJECTS);
        }
        return referencedProjects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getAvailableRefProject() {
        if (availableRefProject == null) {
            availableRefProject = new EObjectResolvingEList(ProjectReference.class, this,
                    AdminPackage.PROJECT__AVAILABLE_REF_PROJECT);
        }
        return availableRefProject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUrl(String newUrl) {
        String oldUrl = url;
        url = newUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__URL, oldUrl, url));
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
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReference() {
        return reference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReference(boolean newReference) {
        boolean oldReference = reference;
        reference = newReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLocal() {
        return local;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocal(boolean newLocal) {
        boolean oldLocal = local;
        local = newLocal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AdminPackage.PROJECT__LOCAL, oldLocal, local));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            return ((InternalEList) getUserAuthorization()).basicAdd(otherEnd, msgs);
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
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            return ((InternalEList) getUserAuthorization()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            return getUserAuthorization();
        case AdminPackage.PROJECT__MASTER_JOB_ID:
            return getMasterJobId();
        case AdminPackage.PROJECT__ID:
            return new Integer(getId());
        case AdminPackage.PROJECT__LABEL:
            return getLabel();
        case AdminPackage.PROJECT__DESCRIPTION:
            return getDescription();
        case AdminPackage.PROJECT__LANGUAGE:
            return getLanguage();
        case AdminPackage.PROJECT__TECHNICAL_LABEL:
            return getTechnicalLabel();
        case AdminPackage.PROJECT__DELETED:
            return isDeleted() ? Boolean.TRUE : Boolean.FALSE;
        case AdminPackage.PROJECT__DELETE_DATE:
            return getDeleteDate();
        case AdminPackage.PROJECT__CREATION_DATE:
            return getCreationDate();
        case AdminPackage.PROJECT__AUTHOR:
            if (resolve)
                return getAuthor();
            return basicGetAuthor();
        case AdminPackage.PROJECT__REFERENCED_PROJECTS:
            return getReferencedProjects();
        case AdminPackage.PROJECT__AVAILABLE_REF_PROJECT:
            return getAvailableRefProject();
        case AdminPackage.PROJECT__URL:
            return getUrl();
        case AdminPackage.PROJECT__TYPE:
            return getType();
        case AdminPackage.PROJECT__REFERENCE:
            return isReference() ? Boolean.TRUE : Boolean.FALSE;
        case AdminPackage.PROJECT__LOCAL:
            return isLocal() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            getUserAuthorization().clear();
            getUserAuthorization().addAll((Collection) newValue);
            return;
        case AdminPackage.PROJECT__MASTER_JOB_ID:
            setMasterJobId((String) newValue);
            return;
        case AdminPackage.PROJECT__ID:
            setId(((Integer) newValue).intValue());
            return;
        case AdminPackage.PROJECT__LABEL:
            setLabel((String) newValue);
            return;
        case AdminPackage.PROJECT__DESCRIPTION:
            setDescription((String) newValue);
            return;
        case AdminPackage.PROJECT__LANGUAGE:
            setLanguage((String) newValue);
            return;
        case AdminPackage.PROJECT__TECHNICAL_LABEL:
            setTechnicalLabel((String) newValue);
            return;
        case AdminPackage.PROJECT__DELETED:
            setDeleted(((Boolean) newValue).booleanValue());
            return;
        case AdminPackage.PROJECT__DELETE_DATE:
            setDeleteDate((Date) newValue);
            return;
        case AdminPackage.PROJECT__CREATION_DATE:
            setCreationDate((Date) newValue);
            return;
        case AdminPackage.PROJECT__AUTHOR:
            setAuthor((User) newValue);
            return;
        case AdminPackage.PROJECT__REFERENCED_PROJECTS:
            getReferencedProjects().clear();
            getReferencedProjects().addAll((Collection) newValue);
            return;
        case AdminPackage.PROJECT__AVAILABLE_REF_PROJECT:
            getAvailableRefProject().clear();
            getAvailableRefProject().addAll((Collection) newValue);
            return;
        case AdminPackage.PROJECT__URL:
            setUrl((String) newValue);
            return;
        case AdminPackage.PROJECT__TYPE:
            setType((String) newValue);
            return;
        case AdminPackage.PROJECT__REFERENCE:
            setReference(((Boolean) newValue).booleanValue());
            return;
        case AdminPackage.PROJECT__LOCAL:
            setLocal(((Boolean) newValue).booleanValue());
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
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            getUserAuthorization().clear();
            return;
        case AdminPackage.PROJECT__MASTER_JOB_ID:
            setMasterJobId(MASTER_JOB_ID_EDEFAULT);
            return;
        case AdminPackage.PROJECT__ID:
            setId(ID_EDEFAULT);
            return;
        case AdminPackage.PROJECT__LABEL:
            setLabel(LABEL_EDEFAULT);
            return;
        case AdminPackage.PROJECT__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
            return;
        case AdminPackage.PROJECT__LANGUAGE:
            setLanguage(LANGUAGE_EDEFAULT);
            return;
        case AdminPackage.PROJECT__TECHNICAL_LABEL:
            setTechnicalLabel(TECHNICAL_LABEL_EDEFAULT);
            return;
        case AdminPackage.PROJECT__DELETED:
            setDeleted(DELETED_EDEFAULT);
            return;
        case AdminPackage.PROJECT__DELETE_DATE:
            setDeleteDate(DELETE_DATE_EDEFAULT);
            return;
        case AdminPackage.PROJECT__CREATION_DATE:
            setCreationDate(CREATION_DATE_EDEFAULT);
            return;
        case AdminPackage.PROJECT__AUTHOR:
            setAuthor((User) null);
            return;
        case AdminPackage.PROJECT__REFERENCED_PROJECTS:
            getReferencedProjects().clear();
            return;
        case AdminPackage.PROJECT__AVAILABLE_REF_PROJECT:
            getAvailableRefProject().clear();
            return;
        case AdminPackage.PROJECT__URL:
            setUrl(URL_EDEFAULT);
            return;
        case AdminPackage.PROJECT__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case AdminPackage.PROJECT__REFERENCE:
            setReference(REFERENCE_EDEFAULT);
            return;
        case AdminPackage.PROJECT__LOCAL:
            setLocal(LOCAL_EDEFAULT);
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
        case AdminPackage.PROJECT__USER_AUTHORIZATION:
            return userAuthorization != null && !userAuthorization.isEmpty();
        case AdminPackage.PROJECT__MASTER_JOB_ID:
            return MASTER_JOB_ID_EDEFAULT == null ? masterJobId != null : !MASTER_JOB_ID_EDEFAULT.equals(masterJobId);
        case AdminPackage.PROJECT__ID:
            return id != ID_EDEFAULT;
        case AdminPackage.PROJECT__LABEL:
            return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
        case AdminPackage.PROJECT__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
        case AdminPackage.PROJECT__LANGUAGE:
            return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
        case AdminPackage.PROJECT__TECHNICAL_LABEL:
            return TECHNICAL_LABEL_EDEFAULT == null ? technicalLabel != null : !TECHNICAL_LABEL_EDEFAULT.equals(technicalLabel);
        case AdminPackage.PROJECT__DELETED:
            return deleted != DELETED_EDEFAULT;
        case AdminPackage.PROJECT__DELETE_DATE:
            return DELETE_DATE_EDEFAULT == null ? deleteDate != null : !DELETE_DATE_EDEFAULT.equals(deleteDate);
        case AdminPackage.PROJECT__CREATION_DATE:
            return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
        case AdminPackage.PROJECT__AUTHOR:
            return author != null;
        case AdminPackage.PROJECT__REFERENCED_PROJECTS:
            return referencedProjects != null && !referencedProjects.isEmpty();
        case AdminPackage.PROJECT__AVAILABLE_REF_PROJECT:
            return availableRefProject != null && !availableRefProject.isEmpty();
        case AdminPackage.PROJECT__URL:
            return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
        case AdminPackage.PROJECT__TYPE:
            return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
        case AdminPackage.PROJECT__REFERENCE:
            return reference != REFERENCE_EDEFAULT;
        case AdminPackage.PROJECT__LOCAL:
            return local != LOCAL_EDEFAULT;
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
        result.append(" (masterJobId: ");
        result.append(masterJobId);
        result.append(", id: ");
        result.append(id);
        result.append(", label: ");
        result.append(label);
        result.append(", description: ");
        result.append(description);
        result.append(", language: ");
        result.append(language);
        result.append(", technicalLabel: ");
        result.append(technicalLabel);
        result.append(", deleted: ");
        result.append(deleted);
        result.append(", deleteDate: ");
        result.append(deleteDate);
        result.append(", creationDate: ");
        result.append(creationDate);
        result.append(", url: ");
        result.append(url);
        result.append(", type: ");
        result.append(type);
        result.append(", reference: ");
        result.append(reference);
        result.append(", local: ");
        result.append(local);
        result.append(')');
        return result.toString();
    }

} //ProjectImpl
