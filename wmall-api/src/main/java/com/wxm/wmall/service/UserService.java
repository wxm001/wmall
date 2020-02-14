package com.wxm.wmall.service;

import com.wxm.wmall.bean.UmsMember;
import com.wxm.wmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author wxm
 * @create 2020-01-12 11:38
 */
public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    UmsMember login(UmsMember umsMember);

    void addUserToken(String token, String memberId);

    UmsMember checkOauthUser(UmsMember umsCheck);

    UmsMember addOauthUser(UmsMember umsMember);

    UmsMemberReceiveAddress getReceiveAddressById(String receiveAddressId);
}
