package Component;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String empId);
    boolean removeEmployeeById(String empId);
}
