package com.mengfw.common;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by MFW on 2017/5/23.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected Mapper<T> mapper;
    @Autowired
    PageHelper pageHelper;
    @Override
    public List<T> queryList(T t) {
        return mapper.selectAll();
    }

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public T selectByKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateSelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

}
