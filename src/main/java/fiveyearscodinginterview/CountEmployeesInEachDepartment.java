package fiveyearscodinginterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an Employee class with Id, Name, Salary, and Department.
 * Count Employees in Each Department Using Stream API.
 */
public class CountEmployeesInEachDepartment {

    private static Map<String, Long> countEmployeesInEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e->e.department, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Employee em1 = new Employee();
        Employee em2 = new Employee();
        Employee em3 = new Employee();
        Employee em4 = new Employee();

        em1.id = 1;
        em1.name = "aaa";
        em1.department = "Sales";
        em1.salary = 123;

        employeeList.add(em1);

        em2.id = 2;
        em2.name = "bbb";
        em2.department = "R&D";
        em2.salary = 456;

        employeeList.add(em2);

        em3.id = 3;
        em3.name = "ccc";
        em3.department = "Sales";
        em3.salary = 789;

        employeeList.add(em3);

        em4.id = 4;
        em4.name = "ddd";
        em4.department = "HR";
        em4.salary = 101;

        employeeList.add(em4);

        Map<String, Long> result = countEmployeesInEachDepartment(employeeList);

        result.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}

class Employee {
    long id;
    String name;
    long salary;
    String department;

}
