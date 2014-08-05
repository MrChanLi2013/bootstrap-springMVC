package com.springmvc.test.common.service;

import com.springmvc.test.common.AbstractEntity;

public interface ICommonService {
    public <T extends AbstractEntity> T save(T model);

}
