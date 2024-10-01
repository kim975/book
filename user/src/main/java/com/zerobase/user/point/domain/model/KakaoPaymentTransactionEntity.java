package com.zerobase.user.point.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "kakao_payment_transaction")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakaoPaymentTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PointPaymentOrdersEntity pointPaymentOrders;

    private String cid;
    private String tid;
    private Long totalAmount;
    private PayStatus status;
}
