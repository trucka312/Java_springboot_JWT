package com.luvina.la.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "certifications")
public class Certification implements Serializable {

    @Id
    @Column(name = "certification_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @Column(name = "certification_name", length = 50, nullable = false)
    private String certificationName;

    @Column(name = "certification_level", nullable = false)
    private String certificationLevel;

    @JsonIgnore
    @OneToOne(mappedBy = "certification")
    @JoinColumn(name = "certification")
    private EmployeesCertification employeesCertification;

}
