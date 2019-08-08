package com.system.joke.user;



import com.system.joke.tool.MapTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserRespond userRespond;


    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public Map getUserList (Integer index, Integer size, String keyWord) {

        if (index < 0) {
            return MapTool.getMap("400", "请求失败,页码不能小于0", null);
        }

        if (size <= 0) {
            return MapTool.getMap("400", "请求失败,每页返回数量不能小于1", null);
        }

        List<UserModel> body;
        body = userRespond.findAll(PageRequest.of(index,size)).getContent();
        for (int i = 0; i < body.size(); i++) {

            UserModel userModel = body.get(i);
            if (userModel.count == null) {
                userModel.count = 0;
            }

        }
        if (body.size() <= 0) {
            return MapTool.getMap("300", "暂无数据", body);
        } else  {
            return MapTool.getMap("200", "请求成功", body);
        }

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


    @RequestMapping("/TestFun")
    public Map TestFun () {

          List<UserModel> body = userRespond.findAll();
          for (int i = 0; i < body.size(); i++) {

              UserModel userModel = body.get(i);
              userRespond.updateUserWithId(userModel.id);

          }

        return MapTool.getMap("200", "请求成功", null);
    }

































































































}
