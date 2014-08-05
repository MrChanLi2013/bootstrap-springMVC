package com.springmvc.test.service.impl;

import com.springmvc.test.common.dao.IBaseDao;
import com.springmvc.test.common.service.impl.BaseService;
import com.springmvc.test.dao.UserDao;
import com.springmvc.test.entity.User;
import com.springmvc.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserSerivceImpl extends BaseService<User, Integer> implements UserService {
    private UserDao userDao;

    @Autowired(required = true)
    @Qualifier(value = "UserDao")
    @Override
    public void setBaseDao(IBaseDao<User, Integer> userDao) {
        this.baseDao = userDao;
        this.userDao = (UserDao) userDao;
    }
}
