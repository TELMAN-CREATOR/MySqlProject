package JDBC;

import Utility.DBUtility;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hilals_Task extends DBUtility {

    @Test
    public void Task3() {
        String sorgu = "select avg(salary) from salaries;";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData)
            for (String kolonItem : satir)
                System.out.println(kolonItem);
    }

    @Test
    public void Task8() {
        String sorgu = "select dept_name, avg(salary)\n" +
                "from dept_emp\n" +
                "left join salaries on salaries.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "group by dept_emp.dept_no;";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir :donenData){
            for (String kolonItem : satir)
                System.out.print(kolonItem + "\t");

            System.out.println();
        }
    }

    @Test
    public void Task13() {
        String sorgu = "select emp_no, max(salary) from salaries group by emp_no;";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolonItem : satir)
                System.out.print(kolonItem + "\t");

            System.out.println();
        }
    }

    @Test
    public void Task18() {
        String sorgu = "select first_name, last_name, hire_date\n" +
                " from employees\n" +
                " where date(hire_date) < '1990-01-01'\n" +
                " order by first_name;";

        ArrayList<ArrayList<String>> donenData = getListData(sorgu);

        for (ArrayList<String> satir : donenData) {
            for (String kolonItem : satir)
                System.out.print(kolonItem + "\t");

            System.out.println();
        }
    }
}
