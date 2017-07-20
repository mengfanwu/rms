package com.mengfw.rms.common;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by MFW on 2017/5/23.
 */
public interface BaseService<T> {
    List<T> queryList(T t);

    int insert(T t);
    int insertSelective(T t);
    T selectByKey(Integer id);
    List<T> queryAll();
    int update(T t);
    int updateSelective(T t);
}
