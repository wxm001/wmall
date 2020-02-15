package com.wxm.wmall.service;

import com.wxm.wmall.bean.PaymentInfo; /**
 * @author wxm
 * @create 2020-02-15 19:59
 */
public interface PaymentService {
    void savePaymentInfo(PaymentInfo paymentInfo);

    void updatePayment(PaymentInfo paymentInfo);
}
