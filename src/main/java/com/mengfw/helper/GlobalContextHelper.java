package com.mengfw.helper;

import com.mengfw.bean.Constant;
import com.mengfw.bean.GlobalContext;
import com.mengfw.bean.GlobalRequest;
import com.mengfw.bean.GlobalResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by MFW on 2017/5/28.
 */
public class GlobalContextHelper {
    public static GlobalRequest getGlobalRequest(){
        GlobalContext globalContext = getGlobalContext();
        return globalContext == null ? new GlobalRequest():globalContext.getGlobalRequest();

    }
    public static GlobalContext getGlobalContext(){
        HttpServletRequest servletRequest = ServletHelper.getServletRequest();
        HttpSession session = servletRequest.getSession();
        GlobalContext context = (GlobalContext) session.getAttribute(Constant.GLOBAL_CONTEXT_KEY);
        return context;
    }
    public static GlobalResult getGlobalResult(){
        GlobalContext globalContext = getGlobalContext();
        return globalContext == null ? null : globalContext.getGlobalResult();
    }
}
