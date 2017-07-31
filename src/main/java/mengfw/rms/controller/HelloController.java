package mengfw.rms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import mengfw.rms.model.User;
import mengfw.rms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by MFW on 2017/5/22.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private UserService userService;
    @RequestMapping("/say")
    public String say(){
        User user = userService.query(1);
        return JSONObject.toJSONString(user);
    }
    @RequestMapping("/say2")
    public String say2(){
        User user = userService.selectByKey(1);
        return JSONObject.toJSONString(user);
    }
    @RequestMapping("/say3")
    public String say3(){
        PageHelper.startPage(1, 4);
        List<User> users = userService.queryAll();
        return JSONArray.toJSONString(users);
    }
    @RequestMapping("/say4")
    public String say4(){
        List<User> users = userService.queryAll();
        return JSONArray.toJSONString(users);
    }
}
