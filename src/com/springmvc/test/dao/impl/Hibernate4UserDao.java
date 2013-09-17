package com.springmvc.test.dao.impl;

import com.springmvc.test.common.dao.hibernate4.BaseHibernateDao;
import com.springmvc.test.dao.UserDao;
import com.springmvc.test.entity.User;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class Hibernate4UserDao extends BaseHibernateDao<User,Integer> implements UserDao{

}
