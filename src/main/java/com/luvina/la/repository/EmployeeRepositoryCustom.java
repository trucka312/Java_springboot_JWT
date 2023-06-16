/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeRepositoryCustom.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.repository;

import com.luvina.la.dto.EmployeeDTO;

import java.util.List;

/**
 * Employee repository custom class
 * To declare method of employee repository implemnt class has
 * */
public interface EmployeeRepositoryCustom {

    List<EmployeeDTO> getAllEmp();

    List<EmployeeDTO> searchEmployeesByName(String name);

    List<EmployeeDTO> searchEmployeesByDepartment(String department);

    List<EmployeeDTO> searchEmployeesByNameAndDepartment(String name, String department);
}
