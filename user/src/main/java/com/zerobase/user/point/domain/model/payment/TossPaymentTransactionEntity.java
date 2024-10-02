package com.zerobase.user.point.domain.model.payment;

import com.zerobase.user.point.domain.model.PointPaymentOrdersEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "toss_payment_transaction")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TossPaymentTransactionEntity extends PaymentTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pointPaymentOrdersId;

    private String paymentKey;
    private String orderId;
    private Long amount;

    @Enumerated(EnumType.STRING)
    private PayStatus status;

    @Override
    public void setPaymentUuid(String token) {
        this.paymentKey = token;
    }

    @Override
    public long getPaymentTransactionId() {
        return id;
    }

    @Override
    public String getTransactionUuid() {
        return paymentKey;
    }
}
