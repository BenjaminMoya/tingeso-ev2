package com.project.tracking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "trackings")
@NoArgsConstructor
@AllArgsConstructor
public class TrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long trackingId;

    private Long trackingCreditId;
    private int trackingPhase;
}
