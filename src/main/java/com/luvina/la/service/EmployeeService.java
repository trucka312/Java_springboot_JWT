/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeService.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.service;

import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.entity.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * employee service class
 * */
public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    List<EmployeeDTO> searchEmployees(@Param("name") String name, @Param("department") String department);


}
