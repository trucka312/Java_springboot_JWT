/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeServiceImpl.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.serviceImplement;

import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.entity.Certification;
import com.luvina.la.entity.Employee;
import com.luvina.la.entity.EmployeesCertification;
import com.luvina.la.repository.EmployeeRepository;
import com.luvina.la.repository.EmployeeRepositoryCustom;
import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implement logic employee service
 * */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoryCustom employeeRepository;

    /**
     * get all employee
     * */
    @Override
    public  List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.getAllEmp();
    }

    /**
     * implement logic search
     * search 1 param, 2 params
     * */
    public List<EmployeeDTO> searchEmployees(String name, String department){
       if(name != null && department == null){
           return employeeRepository.searchEmployeesByName(name);
       } else if (name == null && department != null){
           return employeeRepository.searchEmployeesByDepartment(department);
       } else if (name != null && department != null){
           return employeeRepository.searchEmployeesByNameAndDepartment(name, department);
       } else {
           return null;
       }
    }

    /**
     * add employee
     * */
//    public EmployeeDTO create(EmployeeDTO employeeDTO){
//
//        Employee employee = toDoEmployee(employeeDTO);
//
//
//        return employeeRepository.save(employee);
//    }

    public Employee toDoEmployee(EmployeeDTO employeeDTO){
        Employee employee =new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        //....

        EmployeesCertification employeesCertification =new EmployeesCertification();
        employeesCertification.setStartDate(employeeDTO.getStartDate());
        //...

        Certification certification = new Certification();
        certification.setCertificationId(employeeDTO.getCertificationId());
        certification.setCertificationName(employeeDTO.getCertificationName());


        employeesCertification.setCertification(certification);

        employee.setCertificationId(employeesCertification);


        return employee;
    }
}
