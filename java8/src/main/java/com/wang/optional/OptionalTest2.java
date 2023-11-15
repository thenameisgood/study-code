package com.wang.optional;

import java.util.*;
import java.util.function.Function;

public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee1 = new Employee();
        employee1.setName("wangwu");

        Company company = new Company();
        // company.setEmployee(Arrays.asList(employee, employee1));

        List<Employee> list = company.getEmployee();

        // if (null != list) {
        //     System.out.println(list);
        // } else {
        //     new ArrayList<Employee>();
        // }

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map((Function<Company, Object>) Company::getEmployee).orElse(Collections.emptyList()));
    }
}
