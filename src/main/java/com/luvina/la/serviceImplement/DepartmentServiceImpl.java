/*
 * Copyright (c) 2023 Luvina Software Company
 *               DepartmentServiceImpl.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.serviceImplement;

import com.luvina.la.entity.Department;
import com.luvina.la.repository.DepartmentRepository;
import com.luvina.la.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service department impl class
 * */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
