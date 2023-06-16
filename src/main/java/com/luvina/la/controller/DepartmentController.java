/*
 * Copyright (c) 2023 Luvina Software Company
 *               DepartmentController.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.controller;

import com.luvina.la.entity.Department;
import com.luvina.la.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller layer
 * */
@RestController
@RequestMapping("/list")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getListDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
}
