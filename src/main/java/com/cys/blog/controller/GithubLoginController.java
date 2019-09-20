package com.cys.blog.controller;

import com.cys.blog.pojo.User;
import com.cys.blog.service.user.UserService;
import com.cys.blog.util.MD5Utils;
import com.cys.blog.util.github.GithubProvider;
import com.cys.blog.vo.AccessTokenVO;
import com.cys.blog.vo.GithubUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-20-7:39
 **/
@Controller
@Slf4j
public class GithubLoginController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    @GetMapping("/login/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response, HttpSession session) {
        AccessTokenVO accessTokenVO = new AccessTokenVO();
        accessTokenVO.setClient_id(clientId);
        accessTokenVO.setClient_secret(clientSecret);
        accessTokenVO.setCode(code);
        accessTokenVO.setRedirect_uri(redirectUri);
        accessTokenVO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenVO);

        GithubUser githubUser = githubProvider.getUser(accessToken);
        User u = userService.findUser(githubUser.getName());
        if (githubUser != null && githubUser.getId() != null) {
            if (u == null) {
                //保存user
                User user = new User();
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setEmail("example@eample.com");
                user.setUsername(githubUser.getName());
                user.setNickname(githubUser.getName());
                user.setPhone(String.valueOf(githubUser.getId()));
                user.setPassword(MD5Utils.code(String.valueOf(githubUser.getId())));
                user.setAvatar(githubUser.getAvatar_url());
                user.setType(2);
                userService.saveUser(user);
                response.addCookie(new Cookie("token", token));//用于去数据库查找是否有token
            } else {
                u.setUpdateTime(new Date());
            }
            session.setAttribute("user", u);
            session.setMaxInactiveInterval(60 * 60 * 20);
            return "redirect:/"; //重定向，地址栏清空
        } else {
            //登陆失败，重新登陆
            log.error("callback get github error,{}", githubUser);
            return "redirect:/";
        }
    }
}
