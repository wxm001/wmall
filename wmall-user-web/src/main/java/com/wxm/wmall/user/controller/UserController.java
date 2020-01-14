package com.wxm.wmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxm.wmall.bean.UmsMember;
import com.wxm.wmall.bean.UmsMemberReceiveAddress;

import com.wxm.wmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-12 11:38
 */

@Controller
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }


    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers= userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses= userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
}
