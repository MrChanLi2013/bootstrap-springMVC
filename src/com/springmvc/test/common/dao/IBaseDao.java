package com.springmvc.test.common.dao;

import java.io.Serializable;

public interface IBaseDao<M extends Serializable, PK extends Serializable> {
    public PK save(M model);

}
