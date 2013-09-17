package com.springmvc.test.common.service.impl;

import com.springmvc.test.common.dao.IBaseDao;
import com.springmvc.test.common.service.IBaseService;

import java.io.Serializable;

public abstract class BaseService<M extends Serializable, PK extends Serializable> implements IBaseService<M, PK> {
    protected IBaseDao<M, PK> baseDao;

    public abstract void setBaseDao(IBaseDao<M,PK> baseDao);

    @Override
    public M save(M model) {
        baseDao.save(model);
        return model;
    }
}
