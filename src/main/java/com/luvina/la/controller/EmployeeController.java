/*
 * Copyright (c) 2023 Luvina Software Company
 *               EmployeeController.java, Jun 10, 2023 LA31-AM
 */

package com.luvina.la.controller;

import com.luvina.la.common.Message;
import com.luvina.la.dto.EmployeeDTO;
import com.luvina.la.entity.Certification;
import com.luvina.la.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * employee controller layer
 * */
@RestController
@RequestMapping("/list")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/user")
    public ResponseEntity<List<EmployeeDTO>> getListEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<EmployeeDTO> searchEmployeesByName(
//                                                   @RequestParam(defaultValue = "0") int pageNo,
//                                                   @RequestParam(defaultValue = "10") int pageSize,
                                                   @RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "department", required = false) String department ){
       return employeeService.searchEmployees(name, department);
    }

    /**
     * add user controller
     * */
//    @PostMapping("/add")
//    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        // implement validate param
////        ValidationErrors errors = validateEmployeeRequest(employeeDTO);
////
////        if (errors.hasErrors()) {
////            // return error if has error
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
////        }
//        return EmployeeService.create(employeeDTO);
//    }

//    // func validate info employee
//    private ValidationErrors validateEmployeeRequest(EmployeeDTO employeeDTO) {
//       List<Message> messageList = new ArrayList<>();
//
//        // 1.1 Validate parameter [employeeLoginId]
//        if (employeeDTO.getEmployeeLoginId().equals("")) {
//            // check null
//            messageList.add(new Message("ER001" , "[アカウント名]「画面項目名」を入力してください"));
//        } else {
//            // validate
//            if (employeeDTO.getEmployeeLoginId().length() > 50) {
//                messageList.add(new Message("ER006", "[アカウント名]「画面項目名」を入力してください"));
//            } else if (!employeeDTO.getEmployeeLoginId().matches("[^A-Za-z0-9_.]")) {
//                messageList.add(new Message("ER019", "[アカウント名]は(a-z, A-Z, 0-9 と _)の桁のみです。最初の桁は数字ではない。"));
//            } else if (is_existing_employee_login_id(employeeDTO.getEmployeeLoginId())) {
//                messageList.add(new Message("ER003", "[アカウント名]「画面項目名」を入力してください"));
//            }
//        }
//
//
//        // 1.2 Validate parameter [employeeName]
//        if (employeeDTO.getEmployeeName().equals("")) {
//            //check null
//            messageList.add(new Message("ER001" , "[氏名] 「画面項目名」を入力してください"));
//        } else {
//            // validate
//             if (employeeDTO.getEmployeeName().length() > 125 ){
//                 messageList.add(new Message("ER006", "[氏名]「画面項目名」を入力してください"));
//             }
//        }
//
//        // 1.3 Validate parameter [employeeNameKana]
//        if (employeeDTO.getEmployeeNameKana().equals("")) {
//            // null
//            messageList.add(new Message("ER001" , "[カタカナ氏名]"));
//        } else {
//            // validate
//            if (!employeeDTO.getEmployeeNameKana().matches("[ァ-ヴーｦ-ﾟ]*")){
//                messageList.add(new Message("ER009" , "[カタカナ氏名] 「画面項目名」をカタカナで入力してください"));
//            } else if (employeeDTO.getEmployeeNameKana().length() > 125) {
//                messageList.add(new Message("ER006" , "[カタカナ氏名] 「画面項目名」をカタカナで入力してください"));
//            }
//
//        }
//
//        // 1.4 Validate parameter [employeeBirthDate]
//        if (employeeDTO.getEmployeeBirthDate().equals("")) {
//
//            //check null
//            messageList.add(new Message("ER001" , "生年月日"));
//        } else {
//            boolean isValid = DateValidator.isValidDate(employeeDTO.getEmployeeBirthDate().toString());
//            // check a both format and reality
//            if (!isValid) {
//                messageList.add(new Message("ER005","[生年月日] yyyy/MM/dd 「画面項目名」をxxx形式で入力してください"));
//            }
//        }
//
//        // 1.5 Validate parameter [employeeEmail]
//        if (employeeDTO.getEmployeeEmail().equals("")) {
//
//            //check null
//            messageList.add(new Message("ER001" , "メールアドレス"));
//        } else {
//
//            //validate length
//            if(employeeDTO.getEmployeeEmail().length() > 125 ){
//                messageList.add(new Message("ER006" , "[メールアドレス] 「画面項目名」をカタカナで入力してください"));
//            }
//        }
//
//        // 1.6 Validate parameter [employeeTelephone]
//        if (employeeDTO.getEmployeeTelephone().equals("")) {
//            //check null
//            messageList.add(new Message("ER001" , "電話番号"));
//        } else {
//
//            //validate
//            if(employeeDTO.getEmployeeTelephone().length() > 50){
//                messageList.add(new Message("ER006", "[電話番号] 「画面項目名」をカタカナで入力してください"));
//            }
//            // check only a byte character
//            String phoneNumber = employeeDTO.getEmployeeTelephone();
//            boolean checkPhone = isByteCharactersOnly(phoneNumber);
//            if(!checkPhone){
//                messageList.add(new Message("ER008", "[電話番号] 「画面項目名」に半角英数を入力してください"));
//            }
//        }
//
//        // 1.7 Validate parameter [employeeLoginPassword]
//        if (employeeDTO.getEmployeeLoginPassword().equals("")) {
//            messageList.add(new Message("ER001" , "パスワード"));
//        } else {
//            if (employeeDTO.getEmployeeLoginPassword().length() < 8 || employeeDTO.getEmployeeLoginPassword().length() < 50){
//                messageList.add(new Message("ER007", "[パスワード] 「画面項目名」をxxx＜＝桁数、＜＝xxx桁で入力してください"));
//            }
//        }
//
//        // 1.8 Validate parameter [departmentId]
//        if (employeeDTO.getDepartmentId().equals("")) {
//            messageList.add(new Message("ER002" , "グループ"));
//        } else {
//            Long departmentId = employeeDTO.getDepartmentId();
//            if ( departmentId < 0 || Math.floor(departmentId) == departmentId) {
//                messageList.add(new Message("ER018", "[グループ] 「画面上の項目名」は半角で入力してください。"));
//            }
//        }
//
//        // 1.9 Validate parameter [certifications]
//        if (employeeDTO.getCertificationName().equals("") || employeeDTO.getCertificationName().isEmpty()) {
//            messageList.add(new Message("ER001" , "アカウント名"));
//        } else {
//
//        }
//        return validationErrors(messageList);
//    }
//
//    //func check loginid of employee
//    private boolean is_existing_employee_login_id(String loginId) {
//        // Kiểm tra sự tồn tại của employee login ID trong cơ sở dữ liệu
//        // Implement logic truy vấn cơ sở dữ liệu
//        return false;
//    }
//
//    // func validate date format
//    public class DateValidator {
//        private static final String DATE_FORMAT = "yyyy/MM/dd";
//
//        public static boolean isValidDate(String input) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
//            try {
//                LocalDate.parse(input, formatter);
//                return true;
//            } catch (DateTimeParseException e) {
//                return false;
//            }
//        }
//    }
//
//    // find 1 byte character func
//    public boolean isByteCharactersOnly(String phoneNumber) {
//        for (char c : phoneNumber.toCharArray()) {
//            if (c > 0xFF) {
//                return false;
//            }
//        }
//        return true;
//    }
}





