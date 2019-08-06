package com.system.joke.user;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.system.joke.tool.MapTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserRespond userRespond;


    @RequestMapping("/getUserList")
    public Map getUserList () {

        List body = userRespond.findAll();
        return MapTool.getMap("200", "请求成功", body);

    }



    @RequestMapping("/insertTestUsers")
    public  Map insertTestUsers () {


        List<UserModel> list = userRespond.findAll();

        UserModel lastUser = list.get(list.size() - 1);
        int lastId = lastUser.id;
        String lastPhone = lastUser.phone;

        for (int i = 1; i < 100; i++) {

            UserModel user = new UserModel();
            user.id = lastId + i;
            user.name = String.format("test%d", i);
            user.phone = "13700001111";

            // 储存
            userRespond.save(user);

            System.out.println(user.phone);
        }

        return MapTool.getMap("200", "请求成功", null);

    }




































































































}
