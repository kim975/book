package com.zerobase.user.point.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "toss_payment_transaction")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TossPaymentTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PointPaymentOrdersEntity pointPaymentOrders;

    private String paymentKey;
    private String orderId;
    private Long amount;
    private PayStatus status;

}
