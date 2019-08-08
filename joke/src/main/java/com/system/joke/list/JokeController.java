package com.system.joke.list;


import com.system.joke.tool.MapTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JokeController {

    @Autowired
    private JokeService jokeService;


    // 获取所有段子
    @RequestMapping("/getJokeList")
    public Map getJokeList () {


        List body = jokeService.findAll();
        return MapTool.getMap("200", "请求成功", body);

    }

    // 获取某条段子详情
    @RequestMapping("/GetJokeDetial")
        public Map GetJokeDetial (int id) {

            if (id >= 0) {

//                JokeModel jokeModel = jokeService.getJokeModelById(id);
                JokeModel jokeModel = jokeService.getJokeWithId(id);
                if (jokeModel != null) {
                    return MapTool.getMap("200", "请求成功", jokeModel);
                } else  {
                    return MapTool.getMap("300", "找不到对应数据", null);
                }

            } else  {

                return MapTool.getMap("400", "id不能为空", null);
            }


        }

        // 删除段子
    @RequestMapping("/delJokeById")
     public Map delJokeById (int id) {

//         jokeService.deleteJokeModelById(id);

         if (!jokeService.existsById(id)) {

             return MapTool.getMap("200", "操作成功", null);
         } else  {
             return MapTool.getMap("400", "操作失败", null);
         }

     }

     // 更新某条段子的内容
    @RequestMapping("/UpdateJoke")
    public Map UpdateJoke (int jokeId, String jokeContent) {

        if (jokeId < 0) {
            return MapTool.getMap("400", "jokeId有误", null);
        }
        if (jokeContent.isEmpty()) {
            return MapTool.getMap("400", "jokeContent不能为空", null);
        }

        jokeService.updateJokeWithIdAndContent(jokeId, jokeContent);

        return MapTool.getMap("200", "操作成功", jokeService.getJokeWithId(jokeId));

    }

    // 新增一个段子
    @RequestMapping("/AddJoke")
        public Map AddJoke (String jokeContent) {

            // 获取时间
            // id的设置

            jokeService.addJokeWithIdAndContent(2, jokeContent, "08-08");

            JokeModel joke = jokeService.getJokeWithId(1);
            if (joke != null) {
                return MapTool.getMap("200", "请求成功", joke);
            } else  {
                return MapTool.getMap("400", "操作失败", null);
            }



        }


}
