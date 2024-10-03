package com.zerobase.user.point.domain.model;

import com.zerobase.user.point.domain.model.payment.PointPaymentOrderEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "point_history")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PointEntity point;

    @OneToOne(fetch = FetchType.LAZY)
    private PointPaymentOrderEntity pointPaymentOrder;

    private Long beforePoint;
    private Long afterPoint;
    private Long changePoint;

    @Enumerated(EnumType.STRING)
    private PointType pointType;

}
