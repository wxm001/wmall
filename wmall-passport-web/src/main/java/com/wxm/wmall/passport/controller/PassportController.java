package com.wxm.wmall.passport.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.wxm.wmall.bean.UmsMember;
import com.wxm.wmall.service.UserService;
import com.wxm.wmall.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wxm
 * @create 2020-02-11 17:56
 */
@Controller
public class PassportController {

    @Reference
    UserService userService;

    @RequestMapping("index")
    public String index(String ReturnUrl, ModelMap map){
        map.put("ReturnUrl",ReturnUrl);
        return "index";
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(UmsMember umsMember,HttpServletRequest request){

        String token = "";

        // 调用用户服务验证用户名和密码
        UmsMember umsMemberLogin = userService.login(umsMember);

        if(umsMemberLogin!=null){
            // 登录成功

            // 用jwt制作token
            String memberId = umsMemberLogin.getId();
            String nickname = umsMemberLogin.getNickname();
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("memberId",memberId);
            userMap.put("nickname",nickname);


            String ip = request.getHeader("x-forwarded-for");// 通过nginx转发的客户端ip
            if(StringUtils.isBlank(ip)){
                ip = request.getRemoteAddr();// 从request中获取ip
                if(StringUtils.isBlank(ip)){
                    ip = "127.0.0.1";
                }
            }

            // 按照设计的算法对参数进行加密后，生成token
            token = JwtUtil.encode("2020wmall", userMap, ip);

            // 将token存入redis一份
            userService.addUserToken(token,memberId);

        }else{
            // 登录失败
            token = "fail";
        }

        return token;
    }


    @RequestMapping("verify")
    @ResponseBody
    public String verify(String token,String currentIp,HttpServletRequest request){

        // 通过jwt校验token真假
        Map<String,String> map = new HashMap<>();

        Map<String, Object> decode = JwtUtil.decode(token, "2020wmall", currentIp);

        if(decode!=null){
            map.put("status","success");
            map.put("memberId",(String)decode.get("memberId"));
            map.put("nickname",(String)decode.get("nickname"));
        }else{
            map.put("status","fail");
        }


        return JSON.toJSONString(map);
    }
}
