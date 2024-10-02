package com.zerobase.user.point.domain.model;

import com.zerobase.user.domain.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "point_payment_orders")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointPaymentOrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
