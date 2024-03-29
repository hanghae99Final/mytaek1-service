package org.sparta.mytaek1.domain.payment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class PaymentOnetimeDto {
    private String pg;
    private String merchant_uid;
    private BigDecimal amount;
    private String card_number;
    private String expiry;
    private String birth;
    private String pwd_2digit;
    private String customer_uid;
    private String buyer_email;
    private String buyer_name;
    private String buyer_tel;
    private String buyer_addr;
    private String buyer_postcode;
    private Long buyer_orderId;
}
