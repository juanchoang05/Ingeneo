package com.api.transportservices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logistic_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogisticTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logistic_type_id")
    private Long logisticTypeId;

    @Column
    private String logisticTypeName;

    @Column
    private String wineryOrPortName;


}
