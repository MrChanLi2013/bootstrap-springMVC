package com.springmvc.test.service.impl;

import com.springmvc.test.common.dao.IBaseDao;
import com.springmvc.test.common.service.impl.BaseService;
import com.springmvc.test.dao.NewsDao;
import com.springmvc.test.entity.News;
import com.springmvc.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("NewsService")
public class NewsServiceImpl extends BaseService<News,Integer> implements NewsService{

    private NewsDao newsDao;

    @Autowired(required = true)
    @Qualifier(value = "NewsDao")
    @Override
    public void setBaseDao(IBaseDao<News, Integer> newsDao) {
        this.baseDao = newsDao;
        this.newsDao = (NewsDao)newsDao;
    }
}
