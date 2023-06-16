/*
 * Copyright (c) 2023 Luvina Software Company
 *               DepartmentService.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.service;

import com.luvina.la.entity.Department;

import java.util.List;

/**
 * department service interface
 * */
public interface DepartmentService {
    public List<Department> getAllDepartments();
}
