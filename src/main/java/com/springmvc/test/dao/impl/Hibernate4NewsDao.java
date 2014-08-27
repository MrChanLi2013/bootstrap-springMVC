package com.springmvc.test.dao.impl;

import com.springmvc.test.common.dao.hibernate4.BaseHibernateDao;
import com.springmvc.test.dao.NewsDao;
import com.springmvc.test.entity.News;
import org.springframework.stereotype.Repository;

@Repository("NewsDao")
public class Hibernate4NewsDao extends BaseHibernateDao<News, Integer> implements NewsDao {
}
