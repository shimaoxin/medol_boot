package model.boot_mybatis.controller.user;

import com.github.pagehelper.PageHelper;
import model.boot_mybatis.commom.page.PagedList;
import model.boot_mybatis.model.user.User;
import model.boot_mybatis.model.user.UserExample;
import model.boot_mybatis.service.user.IUserService;
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
    public PagedList<User> showUser() {
        PageHelper.startPage(1, 10);
        UserExample exa = new UserExample();
        UserExample.Criteria crit = exa.createCriteria();
        List<User> users =  userService.selectByExample(exa);
        PagedList<User> pageList = new PagedList<>(users);

        return pageList;
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
