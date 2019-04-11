package medol.boot_mybatis;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smx
 * @date : 2019/1/25
 */
public class MainTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", null);
        JSONObject.toJSONString(map);
        System.out.println(JSONObject.toJSONString(map));
    }
}