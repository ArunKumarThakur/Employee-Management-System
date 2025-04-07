package Component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class EmpManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");

        EmployeeService empl = (EmployeeService) context.getBean("empService");
        int choice = 1;
        Scanner sc = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("1. Add Employee\n2. view Employee\n3. getEmployeeById" +
                    "\n4. Remove EmployeeById\n5. View departmental employee");

            System.out.println("Enter Your choice");
            int query = sc.nextInt();

            switch (query){
                case 1:
                    System.out.println("Enter employee id");
                    String empId = sc.next();
                    System.out.println("Enter employee Name");
                    String empName = sc.next();

                    Department dept = context.getBean(Department.class);
                    Employee employee = context.getBean(Employee.class);
                    employee.setEmpId(empId);
                    employee.setName(empName);

                    System.out.println("Enter department id");
                    String deptId = sc.next();

                    System.out.println("enter department Name");
                    String deptName = sc.next();

                    dept.setDeptId(deptId);
                    dept.setDeptName(deptName);
                    employee.setDepartment(dept);
                    empl.addEmployee(employee);
                    System.out.println("Employee added successfully");
                    break;
                case 2:
                    List<Employee> empList = empl.getAllEmployees();
                    if(empList.isEmpty()) {
                        System.out.println("No Employee found");
                        break;
                    }
                    for(Employee emp : empList) {
                        System.out.println(emp);
                    }
                    break;
                case 3:
                    System.out.println("Enter employee id");
                    String emp = sc.next();
                    Employee employee1 = empl.getEmployeeById(emp);
                    if(employee1 == null) {
                        System.out.println("Employee not found");
                        break;
                    }
                    System.out.println(empl.getEmployeeById(emp));
                    break;
                case 4:
                    System.out.println("Enter employee id");
                    String empId1 = sc.next();

                    Employee employee2 = empl.getEmployeeById(empId1);

                    if(employee2 == null) {
                        System.out.println("Employee not found");
                        break;
                    }
                    empl.removeEmployeeById(empId1);
                    System.out.println("Employee removed from database");
                    break;
                case 5:
                    System.out.println("Enter departmental id");
                    String deptId2 = sc.next();
                    List<Employee> eList = empl.getEmployeeByDept(deptId2);

                    if(eList == null) {
                        System.out.println("Id not Found");
                        break;
                    }

                    for(Employee employee3 : eList) {
                        System.out.println(employee3);
                    }
                    break;
                default:
                    System.exit(1);
            }
            System.out.println("Do you want to continue 1 for Yes and 0 for No");
            choice = sc.nextInt();
        }


        // Dependency Injection is handled by Spring IOC container
        // via xml configuration
        // Hence no need to inject manually

        // ways to inject dependencies :
        // 1. Constructor Injection
        // 2. Setter Injection
        // 3. Annotation (Field)
        // emp.setDepartment(dept);

    }
}
