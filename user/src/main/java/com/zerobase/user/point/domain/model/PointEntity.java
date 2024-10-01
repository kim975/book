package com.zerobase.user.point.domain.model;

import com.zerobase.user.common.model.BaseEntity;
import com.zerobase.user.domain.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "point")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserEntity user;

    private Integer point;
}
