package com.wxm.wmall.service;

import com.wxm.wmall.bean.OmsOrder; /**
 * @author wxm
 * @create 2020-02-14 14:25
 */
public interface OrderService {
    String genTradeCode(String memberId);

    String checkTradeCode(String memberId, String tradeCode);

    void saveOrder(OmsOrder omsOrder);

    OmsOrder getOrderByOutTradeNo(String outTradeNo);

    void updateOrder(OmsOrder omsOrder);
}
