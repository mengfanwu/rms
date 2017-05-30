package com.mengfw.bean;

import java.util.List;

/**
 * Created by MFW on 2017/5/29.
 */
public class DataPage<T> {
    private int pageSize;
    private int pageIndex;
    private List<T> content;

}
