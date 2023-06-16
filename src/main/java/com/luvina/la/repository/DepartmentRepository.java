/*
 * Copyright (c) 2023 Luvina Software Company
 *               DepartmentRepository.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.repository;

import com.luvina.la.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * department repo class
 * */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();
}
