package com.mengfw.rms.controller;

import com.mengfw.rms.bean.GlobalResult;
import com.mengfw.rms.form.LoginForm;
import com.mengfw.rms.model.Emp;
import com.mengfw.rms.service.EmpService;
import com.mengfw.rms.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by MFW on 2017/5/29.
 */
@RestController
@RequestMapping(value = "/home",method = RequestMethod.POST)
public class HomeController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/login")
    public GlobalResult login(@RequestBody @Validated LoginForm form){
        GlobalResult result = new GlobalResult();
        Emp emp = empService.queryByMobile(form.getMobile());
        if(emp != null && form.getPassword().equals(emp.getPassword())){
            String token = UUID.randomUUID().toString();
            Emp updater = new Emp();
            updater.setId(emp.getId());
            updater.setToken(token);
            updater.setLastLoginTime(new Date());
            empService.updateSelective(updater);
            LoginVO vo = new LoginVO();
            vo.setEmpId(emp.getId());
            vo.setToken(token);
            result.setLogin(true);
            result.setSuccess(true);
            result.getModel().put("empInfo",vo);
        }else {
            result.setMessage("登录失败");
        }
        return result;
    }
}
