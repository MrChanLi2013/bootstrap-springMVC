package com.springmvc.test.common.dao.hibernate4;

import com.springmvc.test.common.AbstractEntity;
import com.springmvc.test.common.dao.ICommonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("CommonHibernateDao")
public class CommonHibernateDao implements ICommonDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public <T extends AbstractEntity> T save(T model) {
        getSession().save(model);
        return model;
    }
}
