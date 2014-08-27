package com.springmvc.test.common.service.impl;

import com.springmvc.test.common.dao.IBaseDao;
import com.springmvc.test.common.service.IBaseService;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<M extends Serializable, PK extends Serializable> implements IBaseService<M, PK> {
    protected IBaseDao<M, PK> baseDao;

    public abstract void setBaseDao(IBaseDao<M, PK> baseDao);

    @Override
    public M save(M model) {
        baseDao.save(model);
        return model;
    }

    @Override
    public <T> List<T> searchByPage(Class<T> tClass, int firstResult, int maxResult, String orderBy) {
        return baseDao.searchByPage(tClass, firstResult, maxResult, orderBy);
    }
}
