package com.luvina.la.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees_certifications")
@Data
public class EmployeesCertification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_certification_id",unique = true , nullable = false)
    private Long employeeCertificationId;

    @JsonIgnore
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @JsonIgnore
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "certification_id", referencedColumnName = "certification_id")
    private Certification certification;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "score", precision = 10, scale = 2, nullable = false )
    private BigDecimal score;
}
