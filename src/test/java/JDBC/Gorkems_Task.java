package JDBC;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static Utility.DBUtility.getListData;

public class Gorkems_Task {

    @Test
    public void Task2() throws SQLException {

        String sorgu = "SELECT e.first_name, e.last_name, d.dept_name " +
                "FROM employees e " +
                "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "JOIN departments d ON de.dept_no = d.dept_no " +
                "WHERE d.dept_name = 'Human Resources'";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolon : satir)
                System.out.print(kolon + "\t");
            System.out.println();
        }
    }

    @Test
    public void Task7() throws SQLException {

        String sorgu = "SELECT e.first_name, e.last_name, s.salary " +
                "FROM employees e " +
                "JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE s.salary BETWEEN 50000 AND 100000";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolon : satir)
                System.out.print(kolon + "\t");
            System.out.println();
        }
    }

    @Test
    public void Task12() throws SQLException {

        String sorgu = "SELECT e.first_name, e.last_name, s.salary " +
                "FROM employees e " +
                "JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE s.salary = (SELECT MAX(salary) FROM salaries)";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolon : satir)
                System.out.print(kolon + "\t");
            System.out.println();
        }
    }

    @Test
    public void Task17() throws SQLException {

        String sorgu =
                "SELECT d.dept_name, e.first_name, e.last_name, ROUND(AVG(s.salary), 2) AS avg_salary " +
                        "FROM employees e " +
                        "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                        "JOIN departments d ON de.dept_no = d.dept_no " +
                        "JOIN salaries s ON e.emp_no = s.emp_no " +
                        "GROUP BY d.dept_name, e.emp_no " +
                        "HAVING AVG(s.salary) = ( " +
                        "    SELECT MAX(avg_salary) FROM ( " +
                        "        SELECT de2.dept_no, AVG(s2.salary) AS avg_salary " +
                        "        FROM dept_emp de2 " +
                        "        JOIN salaries s2 ON de2.emp_no = s2.emp_no " +
                        "        GROUP BY de2.dept_no, de2.emp_no " +
                        "        HAVING de2.dept_no = de.dept_no " +
                        "    ) AS subquery " +
                        ") " +
                        "ORDER BY avg_salary DESC";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolon : satir)
                System.out.print(kolon + "\t");
            System.out.println();
        }
    }
}
