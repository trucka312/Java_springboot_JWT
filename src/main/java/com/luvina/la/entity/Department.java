package com.luvina.la.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @Column(name = "department_id", unique = true, nullable = false)
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name = "department_name", length = 50, nullable = false)
    private String departmentName;

}
