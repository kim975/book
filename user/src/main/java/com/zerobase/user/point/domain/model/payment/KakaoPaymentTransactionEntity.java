package com.zerobase.user.point.domain.model.payment;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "kakao_payment_transaction")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoPaymentTransactionEntity extends PaymentTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pointPaymentOrdersId;

    private String cid;
    private String tid;
    private Long totalAmount;

    @Enumerated(EnumType.STRING)
    private PayStatus status;

    @Override
    public void setPaymentUuid(String token) {
        this.tid = token;
    }

    @Override
    public long getPaymentTransactionId() {
        return id;
    }

    @Override
    public String getTransactionUuid() {
        return tid;
    }
}
