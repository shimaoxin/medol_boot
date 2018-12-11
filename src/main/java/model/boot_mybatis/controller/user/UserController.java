package model.boot_mybatis.controller.user;

import model.boot_mybatis.model.user.User;
import model.boot_mybatis.model.user.UserExample;
import model.boot_mybatis.service.user.IUserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public String showUser() {
        UserExample exa = new UserExample();
        UserExample.Criteria crit = exa.createCriteria();
        List<User> users =  userService.selectByExample(exa);
        JSONArray array = JSONArray.fromObject(users);

        return array.toString();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName("岳陈");
        return userService.insertSelective(user);
    }

}
