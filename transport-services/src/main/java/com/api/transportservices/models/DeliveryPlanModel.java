package com.api.transportservices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.Date;

@Entity
@Table(name = "delivery_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_plan_id")
    private Long deliveryPlanId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_id")
    private ProductModel productModel;

    @ManyToOne
    private UserModel user;

    @Column
    private Date registerDate;

    @Column
    private Date deliveryDate;

    @Column
    private Double deliveryPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_vehicle_id")
    private VehicleModel vehicleModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_logistic_id")
    private LogisticTypeModel logisticTypeModel;

    @Column
    private String guideNumber;

}
