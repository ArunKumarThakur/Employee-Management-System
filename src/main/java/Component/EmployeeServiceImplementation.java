package Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImplementation implements EmployeeService{

    List<Employee> employeeList = new ArrayList<>();
    Map<String, Employee> empIdToEmp = new HashMap<>();
    Map<String, List<Employee>> deptToEmpMap = new HashMap<>();
    Map<String, Department> empToDepartment = new HashMap<>();
    @Override
    public void addEmployee(Employee employee) {
        empIdToEmp.put(employee.getEmpId(), employee);
        employeeList.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        return empIdToEmp.get(empId);
    }

    public boolean removeEmployeeById(String id) {
        Employee employee = empIdToEmp.get(id);
        employeeList.remove(employee);
        empIdToEmp.remove(id);
        return empIdToEmp.get(id) == null;
    }

}
