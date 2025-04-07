package Component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EmpManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");

        //extracting objects(beans) from spring container;
        Employee emp = context.getBean(Employee.class);
        Department dept = context.getBean(Department.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id");
        String empId = sc.next();
        System.out.println("Enter Employee Name");
        String empName = sc.next();

        emp.setEmpId(empId);
        emp.setName(empName);

        System.out.println("Enter department id");
        String deptId = sc.next();

        System.out.println("Enter department Name");
        String deptName = sc.next();

        dept.setDeptId(deptId);
        dept.setDeptName(deptName);

//        emp.setDepartment(dept);

        System.out.println(emp);
    }
}
