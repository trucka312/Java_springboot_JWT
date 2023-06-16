/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeDTO.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;

import lombok.Data;

/**
 * Employee data tranfer object class
 * to convert data form db to view and view to data
 * */
@Data

public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 6868189362900231672L;

    private BigInteger employeeId;

    private String employeeName;
    private String employeeTelephone;

    private String employeeNameKana;
    @Temporal(TemporalType.DATE)
    private Date employeeBirthDate;
    private String employeeEmail;
    private String employeeLoginId;
    private String employeeLoginPassword;
    private String employeeRule;
    @Temporal(TemporalType.DATE)

    private Date startDate;
    private Date endDate;
    private BigDecimal score;

    private Long certificationId;
    private String certificationName;

    private Long departmentId;
    private String departmentName;

}
