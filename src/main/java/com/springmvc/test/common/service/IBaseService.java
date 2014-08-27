package com.springmvc.test.common.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<M extends Serializable, PK extends Serializable> {
    public M save(M model);

    public <T> List<T> searchByPage(Class<T> tClass, int firstResult, int maxResult, String orderBy);
}
