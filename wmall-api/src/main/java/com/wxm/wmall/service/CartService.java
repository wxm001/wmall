package com.wxm.wmall.service;

import com.wxm.wmall.bean.OmsCartItem;

import java.util.List;

/**
 * @author wxm
 * @create 2020-02-11 11:26
 */
public interface CartService {
    OmsCartItem ifCartExistByUser(String memberId, String skuId);

    void addCart(OmsCartItem omsCartItem);

    void updateCart(OmsCartItem omsCartItemFromDb);

    void flushCartCache(String memberId);

    List<OmsCartItem> cartList(String memberId);

    void checkCart(OmsCartItem omsCartItem);
}
