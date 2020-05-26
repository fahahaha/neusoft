package lingnan.controller;

import lingnan.pojo.User;
import lingnan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 查找所有用户
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/getAll")
    public String getAll(HttpSession session){
        List<User> allUser =  userService.getList();
        if (allUser != null){
            //找到用户信息
            System.out.println("所有用户的信息:");
            System.out.println(allUser);
            //session保存
            session.setAttribute("allUser", allUser);
        }else {
            //没有找到用户信息
            System.out.println("错误");
            return "index";
        }
        return "success";
    }



}
