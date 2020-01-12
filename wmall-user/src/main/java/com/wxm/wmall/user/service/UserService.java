package com.wxm.wmall.user.service;

import com.wxm.wmall.user.bean.UmsMember;
import com.wxm.wmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-12 11:38
 */
public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
