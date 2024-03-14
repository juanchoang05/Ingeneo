package com.api.transportservices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column
    private String name;//licensePlate or fleetNumber

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_logistic_type_id")
    private LogisticTypeModel logisticTypeModel;


}
