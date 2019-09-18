package com.cys.blog.controller.admin;

import com.aliyuncs.exceptions.ClientException;
import com.cys.blog.pojo.User;
import com.cys.blog.service.user.UserService;
import com.cys.blog.util.MD5Utils;
import com.cys.blog.util.validatecode.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-0:32
 **/
@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register() {
        return "admin/register";
    }

    @Value("${user.avatar}")
    private String avatar;

    @Autowired
    private UserService userService;

    @Autowired
    MessageListener messageListener;
    private static Map<String, String> maps = new HashMap();


    @PostMapping("/afterRegister")
    @ResponseBody
    public Map afterRegister(@RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String username,
                                @RequestParam String nickname,
                                @RequestParam String phone,
                                @RequestParam String code) {

        Map<String,String> map=new HashMap<>();
        System.out.println("??");
        //todo 后端验证
        if (userService.findUser(username) != null) {
            throw new RuntimeException("用户已存在");

        }

        if (phone.length() != 11) {
            throw new RuntimeException("手机长度不正确或不存在");

        }

        if (!code.equals(maps.get(code))) {
            throw new RuntimeException("验证码错误");
        }

        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setPassword(MD5Utils.code(password));
        user.setEmail(email);
        user.setNickname(nickname);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setAvatar(avatar);
        user.setType(2);
        userService.saveUser(user);
        System.out.println("为什么那么奇怪？");
        map.put("message","注册成功");
        return map;
    }


    @PostMapping("/registerValidate")
    @ResponseBody
    public String senYzm(String phone) {
        String code = (int) (Math.random() * 10000.0D) + "";
        if (phone.length() != 11)
            return "手机长度不正确";
        maps.put(code, code);
        maps.put("signName", "藏龙阁");
        maps.put("templateCode", "SMS_172208261");
        maps.put("mobile", phone);
        maps.put("param", "{\"code\":\"" + code + "\"}");

      /*  try {
            this.messageListener.readMessage(maps);
        } catch (ClientException e) {
            e.printStackTrace();
        }*/

        System.out.println(code);
        return code;
    }
}
