package com.springmvc.test.common.dao;

import com.springmvc.test.common.AbstractEntity;

public interface ICommonDao {
    public <T extends AbstractEntity> T save(T model);
}
