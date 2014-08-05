package com.springmvc.test.common.service.impl;

import com.springmvc.test.common.AbstractEntity;
import com.springmvc.test.common.dao.ICommonDao;
import com.springmvc.test.common.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CommonService")
public class CommonService implements ICommonService {

    @Autowired(required = true)
    @Qualifier(value = "CommonHibernateDao")
    private ICommonDao commonDao;

    @Override
    public <T extends AbstractEntity> T save(T model) {
        return commonDao.save(model);
    }

}
