package com.system.joke.tool;

import java.util.HashMap;
import java.util.Map;

public class MapTool {

    static public Map getMap (String code, String msg, Object body) {

            Map map = new HashMap();
            map.put("code" , code);
            map.put("msg" , msg);
            map.put("body" , body);

            return map;
        }

}
