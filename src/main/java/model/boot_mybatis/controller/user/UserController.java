package model.boot_mybatis.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import model.boot_mybatis.model.user.User;
import model.boot_mybatis.model.user.UserExample;
import model.boot_mybatis.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public PageInfo<User> showUser() {
        logger.info("查看用户");
        logger.error("测试错误日志输出");
        PageHelper.startPage(1, 10);
        UserExample exa = new UserExample();
        UserExample.Criteria crit = exa.createCriteria();
        List<User> users =  userService.selectByExample(exa);
        PageInfo<User> pageList = new PageInfo<>(users);
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
