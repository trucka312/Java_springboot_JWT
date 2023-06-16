package com.luvina.la.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 5771173953267484096L;

    @Id
    @Column(name = "employee_id", unique = true, nullable = false)
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_name_kana")
    private String employeeNameKana;

    @Temporal(TemporalType.DATE)
    @Column(name = "employee_birth_date")
    private Date employeeBirthDate;

    @Column(name = "employee_email",  nullable = false)
    private String employeeEmail;

    @Column(name = "employee_telephone", length = 50)
    private String employeeTelephone;

    @Column(name = "employee_login_id", length = 50,  nullable = false)
    private String employeeLoginId;

    @Column(name = "employee_login_password", length = 100)
    private String employeeLoginPassword;

    @Column(name = "Rule")
    private String employeeRule;

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private EmployeesCertification certificationId;

}
