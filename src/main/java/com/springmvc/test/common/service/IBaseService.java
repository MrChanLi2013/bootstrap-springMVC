package com.springmvc.test.common.service;

import java.io.Serializable;

public interface IBaseService<M extends Serializable, PK extends Serializable> {
    public M save(M model);
}
