package com.cn.hnust.ctrl;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linsa
 * @date 2019-07-09 15:55
 **/
@Controller
@RequestMapping(value="/hnust/user")
public class UserCtrl {

    @Resource
    private IUserService userService;

    @RequestMapping(value="/list.do")
    public String list(HttpServletRequest req, HttpServletResponse resp){

        return "/hnust/list";
    }

    @RequestMapping(value="/view.do")
    public String view(HttpServletRequest req, HttpServletResponse resp){//, @Param("id") Integer id
        User user = userService.getUserById(1);
        req.setAttribute("user",user);
        System.out.print("123123：："+user.getUserName());
        return "/hnust/userView";
    }

}
