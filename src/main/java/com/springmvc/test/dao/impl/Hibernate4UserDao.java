package com.springmvc.test.dao.impl;

import com.springmvc.test.common.dao.helper.Checker;
import com.springmvc.test.common.dao.hibernate4.BaseHibernateDao;
import com.springmvc.test.dao.UserDao;
import com.springmvc.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public class Hibernate4UserDao extends BaseHibernateDao<User, Integer> implements UserDao {

    @Override
    public User findByName(String name) {
        List list = getSession().createQuery("from User u where u.username = ?").setString(0, name).list();
        System.out.println(list.get(0));
        Checker.ensureNotEmpty(list, "未找到用户名为" + name + "的用户");
        return (User) list.get(0);
    }
}
