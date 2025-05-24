package JDBC;

import Utility.DBUtility;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class Telmans_Task extends DBUtility {

    @Test
    public void Task1() throws SQLException {

        String sorgu="select first_name,last_name from employees";

        ArrayList<ArrayList<String>>donenData=getListData(sorgu);

        for (ArrayList<String> satır :donenData){
            for (String kolon: satır)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }

    @Test
    public void Task6() throws SQLException {

        String sorgu="SELECT e.first_name, e.last_name, d.dept_name, s.salary\n" +
                "FROM employees e\n" +
                "LEFT JOIN dept_emp de ON e.emp_no = de.emp_no\n" +
                "LEFT JOIN departments d ON de.dept_no = d.dept_no\n" +
                "LEFT JOIN (\n" +
                "    SELECT emp_no, salary\n" +
                "    FROM salaries\n" +
                "    WHERE to_date = '9999-01-01' -- genellikle en güncel maaşı gösterir\n" +
                ") s ON e.emp_no = s.emp_no\n" +
                "WHERE d.dept_name LIKE 'S%' AND s.salary > 70000\n";

        ArrayList<ArrayList<String>>donenData=getListData(sorgu);

        for (ArrayList<String> satır :donenData){
            for (String kolon: satır)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }

    @Test
    public void Task11() throws SQLException {

        String sorgu="SELECT e.first_name, e.last_name, s.salary, s.from_date, s.to_date\n" +
                "FROM employees e\n" +
                "LEFT JOIN salaries s ON s.emp_no = e.emp_no\n" +
                "WHERE e.emp_no = 10102\n" +
                "ORDER BY s.from_date";

        ArrayList<ArrayList<String>>donenData=getListData(sorgu);

        for (ArrayList<String> satır :donenData){
            for (String kolon: satır)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }

    @Test
    public void Task16() throws SQLException {

        String sorgu="SELECT e.first_name, e.last_name, d.dept_name, s.salary, s.from_date, s.to_date\n" +
                "FROM employees e\n" +
                "JOIN dept_emp de ON e.emp_no = de.emp_no\n" +
                "JOIN departments d ON de.dept_no = d.dept_no\n" +
                "JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE (d.dept_no, s.salary) IN (\n" +
                "    SELECT de.dept_no, MAX(s.salary)\n" +
                "    FROM dept_emp de\n" +
                "    JOIN salaries s ON de.emp_no = s.emp_no\n" +
                "    GROUP BY de.dept_no\n" +
                ")\n" +
                "ORDER BY s.salary desc";

        ArrayList<ArrayList<String>>donenData=getListData(sorgu);

        for (ArrayList<String> satır :donenData){
            for (String kolon: satır)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }
}
