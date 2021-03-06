package com.pregnant.health.model;

import com.pregnant.health.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.pregnant.health.dao.CategoryDao;
import com.pregnant.health.dao.TypeDao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "CATEGORY".
 */
public class Category {

    private String id;
    private String parentId;
    private String name;
    /** Not-null value. */
    private String typeId;
    private Long updateTime;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient CategoryDao myDao;

    private Type type;
    private String type__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Category() {
    }

    public Category(String id) {
        this.id = id;
    }

    public Category(String id, String parentId, String name, String typeId, Long updateTime) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.typeId = typeId;
        this.updateTime = updateTime;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCategoryDao() : null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getTypeId() {
        return typeId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /** To-one relationship, resolved on first access. */
    public Type getType() {
        String __key = this.typeId;
        if (type__resolvedKey == null || type__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypeDao targetDao = daoSession.getTypeDao();
            Type typeNew = targetDao.load(__key);
            synchronized (this) {
                type = typeNew;
            	type__resolvedKey = __key;
            }
        }
        return type;
    }

    public void setType(Type type) {
        if (type == null) {
            throw new DaoException("To-one property 'typeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.type = type;
            typeId = type.getId();
            type__resolvedKey = typeId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
