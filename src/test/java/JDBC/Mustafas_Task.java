package JDBC;

import Utility.DBUtility;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Mustafas_Task extends DBUtility {
    @Test
    public void Test04() {
        ArrayList<ArrayList<String>> data =
                getListData("select d.dept_name, avg(s.salary) as averageSalary from employees.salaries s\n" +
                        "join employees.dept_emp de on s.emp_no=de.emp_no\n" +
                        "join employees.departments d on de.dept_no=d.dept_no\n" +
                        "group by d.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void Test09() {
        ArrayList<ArrayList<String>> data = getListData("select d.dept_name, avg(s.salary) as averageSalary from employees.salaries s\n" +
                "join employees.dept_emp de on s.emp_no=de.emp_no\n" +
                "join employees.departments d on de.dept_no=d.dept_no\n" +
                "group by d.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void Test14() {
        ArrayList<ArrayList<String>> data = getListData("select e.first_name, e.last_name, max(salary) from employees.employees e\n"
                + "join employees.dept_emp de on e.emp_no = de.emp_no\n" +
                "join employees.departments d on de.dept_no = d.dept_no\n" +
                "join employees.salaries s on e.emp_no = s.emp_no\n" +
                "where d.dept_name = 'Sales'\n" + "group by e.emp_no\n" +
                "order by max(salary) desc limit 1;");
        for (List<String> row : data) {
            System.out.println(row);

        }
    }

    @Test
    public void Test19() {
        ArrayList<ArrayList<String>> data = getListData("select first_name, last_name, hire_date from employees.employees\n" +
                "where hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by hire_date;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }
}