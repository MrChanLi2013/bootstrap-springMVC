package com.springmvc.test.common.dao.hibernate4;

import com.springmvc.test.common.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseHibernateDao<M extends Serializable, PK extends Serializable> implements IBaseDao<M, PK> {
    private final Class<M> entityClass;
    private String pkName = null;
    @Autowired(required = true)
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public BaseHibernateDao() {
        this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Field[] fields = this.entityClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Id.class)) {
                this.pkName = f.getName();
            }
        }
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public PK save(M model) {
        return (PK) getSession().save(model);
    }

    @Override
    public <T> List<T> searchByPage(Class<T> tClass, int firstResult, int maxResult, String orderBy) {
        StringBuffer sb = new StringBuffer();
        sb.append("from ").append(tClass.getSimpleName()).append(" ").append(orderBy);
        Query query = getSession().createQuery(sb.toString());
        query.setFirstResult(firstResult - 1);
        query.setMaxResults(maxResult - firstResult + 1);
        return query.list();
    }

    public void releaseSession() {
        getSession().close();
    }
}
