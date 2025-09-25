package com.hexagon.schoolservice.dal.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class InvoiceEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invId;
    private String invName;
    private Double invAmount;

    // TODO: Как мы можем сохранять id
    // @Id
    // @Column(name = "id")
    // @UuidGenerator
    // private String id;
}
