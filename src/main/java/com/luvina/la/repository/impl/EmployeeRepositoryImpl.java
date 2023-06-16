/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeRepositoryImpl.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.repository.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.luvina.la.entity.Employee;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.repository.EmployeeRepositoryCustom;

/**
 * Employee repository implement class
 * execute get data from database
 * */

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	@SuppressWarnings("unchecked")
	@Override

	/**
	 * @return : list employees (DTO)
	 * implement : get all employees
	 * */
	public List<EmployeeDTO> getAllEmp() {
		String sql = "SELECT e.employee_id AS employeeId, e.employee_name AS employeeName, e.employee_telephone AS employeeTelephone, d.department_name AS departmentName," +
				" e.employee_email AS employeeEmail, c.certification_name AS certificationName, ec.end_date AS endDate, ec.score AS score " +
				"FROM employees e " +
				" LEFT JOIN departments d ON e.department_id = d.department_id  " +
				" LEFT JOIN employees_certifications ec ON e.employee_id = ec.employee_id " +
				" LEFT JOIN certifications c ON ec.certification_id = c.certification_id ";
		Session session = getSession();
		Query query = session.createNativeQuery(sql);
		List<Object[]> result = query.getResultList();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Object[] row : result) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId((BigInteger) row[0]);
			employeeDTO.setEmployeeName((String) row[1]);
			employeeDTO.setEmployeeTelephone((String) row[2]);
			employeeDTO.setDepartmentName((String) row[3]);
			employeeDTO.setEmployeeEmail((String) row[4]);
			employeeDTO.setCertificationName((String) row[5]);
			employeeDTO.setEndDate((Date) row[6]);
			employeeDTO.setScore((BigDecimal) row[7]);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	/**
	 * @param : query name
	 * @return : list employees (DTO) match query
	 * implement : search employees has name match query
	 * */
	public List<EmployeeDTO> searchEmployeesByName(String name) {
		String sql = "SELECT e.employee_id AS employeeId, e.employee_name AS employeeName, e.employee_telephone AS employeeTelephone, d.department_name AS departmentName," +
				" e.employee_email AS employeeEmail, c.certification_name AS certificationName, ec.end_date AS endDate, ec.score AS score " +
				"FROM employees e " +
				" LEFT JOIN departments d ON e.department_id = d.department_id  " +
				" LEFT JOIN employees_certifications ec ON e.employee_id = ec.employee_id " +
				" LEFT JOIN certifications c ON ec.certification_id = c.certification_id " +
				"WHERE e.employee_name LIKE CONCAT('%', :name, '%')";
		Session session = getSession();
		Query query = session.createNativeQuery(sql);

		// paging
		query.setParameter("name", name);
		List<Object[]> result = query.getResultList();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Object[] row : result) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId((BigInteger) row[0]);
			employeeDTO.setEmployeeName((String) row[1]);
			employeeDTO.setEmployeeTelephone((String) row[2]);
			employeeDTO.setDepartmentName((String) row[3]);
			employeeDTO.setEmployeeEmail((String) row[4]);
			employeeDTO.setCertificationName((String) row[5]);
			employeeDTO.setEndDate((Date) row[6]);
			employeeDTO.setScore((BigDecimal) row[7]);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	/**
	 * @param : query department
	 * @return : list employees (DTO) match query
	 * implement : search employees has deaprtment
	 * */
	public List<EmployeeDTO> searchEmployeesByDepartment(String department) {
		String sql = "SELECT e.employee_id AS employeeId, e.employee_name AS employeeName, e.employee_telephone AS employeeTelephone, d.department_name AS departmentName," +
				" e.employee_email AS employeeEmail, c.certification_name AS certificationName, ec.end_date AS endDate, ec.score AS score " +
				"FROM employees e " +
				" LEFT JOIN departments d ON e.department_id = d.department_id  " +
				" LEFT JOIN employees_certifications ec ON e.employee_id = ec.employee_id " +
				" LEFT JOIN certifications c ON ec.certification_id = c.certification_id " +
				"WHERE d.department_name LIKE CONCAT('%', :department, '%')";
		Session session = getSession();
		Query query = session.createNativeQuery(sql);
		query.setParameter("department", department);
		List<Object[]> result = query.getResultList();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Object[] row : result) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId((BigInteger) row[0]);
			employeeDTO.setEmployeeName((String) row[1]);
			employeeDTO.setEmployeeTelephone((String) row[2]);
			employeeDTO.setDepartmentName((String) row[3]);
			employeeDTO.setEmployeeEmail((String) row[4]);
			employeeDTO.setCertificationName((String) row[5]);
			employeeDTO.setEndDate((Date) row[6]);
			employeeDTO.setScore((BigDecimal) row[7]);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	/**
	 * @param : query name and department
	 * @return : list employees (DTO) match query
	 * implement : search employees has deaprtment and name
	 * */
	public List<EmployeeDTO> searchEmployeesByNameAndDepartment(String name,String department) {
		String sql = "SELECT e.employee_id AS employeeId, e.employee_name AS employeeName, e.employee_telephone AS employeeTelephone, d.department_name AS departmentName," +
				" e.employee_email AS employeeEmail, c.certification_name AS certificationName, ec.end_date AS endDate, ec.score AS score " +
				"FROM employees e " +
				" LEFT JOIN departments d ON e.department_id = d.department_id  " +
				" LEFT JOIN employees_certifications ec ON e.employee_id = ec.employee_id " +
				" LEFT JOIN certifications c ON ec.certification_id = c.certification_id " +
				"WHERE d.department_name LIKE CONCAT('%', :department, '%') AND e.employee_name LIKE CONCAT('%', :name, '%')";
		Session session = getSession();
		Query query = session.createNativeQuery(sql);
		query.setParameter("department", department);
		query.setParameter("name", name);
		List<Object[]> result = query.getResultList();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Object[] row : result) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId((BigInteger) row[0]);
			employeeDTO.setEmployeeName((String) row[1]);
			employeeDTO.setEmployeeTelephone((String) row[2]);
			employeeDTO.setDepartmentName((String) row[3]);
			employeeDTO.setEmployeeEmail((String) row[4]);
			employeeDTO.setCertificationName((String) row[5]);
			employeeDTO.setEndDate((Date) row[6]);
			employeeDTO.setScore((BigDecimal) row[7]);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}
}
