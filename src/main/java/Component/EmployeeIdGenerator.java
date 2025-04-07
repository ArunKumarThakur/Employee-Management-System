package Component;

public class EmployeeIdGenerator {
    static int key = 100;
    static int dept = 1000;
    String getGeneratedEmpId(){
        return "EMP" + (key++);
    }

}
