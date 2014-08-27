package com.springmvc.test.common.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<M extends Serializable, PK extends Serializable> {
    public PK save(M model);

    /**
     * 分页查询表中数据
     *
     * @param firstResult 从多少条开始
     * @param maxResult   查询多少条数据
     * @param orderBy     排序条件
     * @param <T>
     * @return List
     */
    public <T> List<T> searchByPage(Class<T> tClass, int firstResult, int maxResult, String orderBy);
}
