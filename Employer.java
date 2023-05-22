import java.util.*;

public class Employer implements EmployerInterface {
    private int id;
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employer() {

    }

    public Employer(int id, ArrayList<Employee> employees) {
        this.id = id;
        this.employees = employees;
    }

    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showEmployee(int id) {
        employees.forEach(functionary -> {
            if (id == functionary.id) {
                System.out.println(functionary.name);
                try {
                    System.out.println(functionary.listPontos());
                } catch (Exception e) {
                    System.out.println(e);
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void listEmployees() {
        employees.forEach(functionary -> {
            System.out.println(functionary.name);
            try {
                System.out.println(functionary.listPontos());
            } catch (Exception e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }
        });
    }
}
