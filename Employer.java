import java.util.*;

public class Employer implements EmployerInterface {
    private int id;
    public ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employer() {

    }

    public Employer(int id, ArrayList<Employee> employees) {
        this.id = id;
        this.employees = employees;
    }

    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        employees.forEach(employee -> {
            if (employee.id == id) {
                employees.remove(employee);
            }
        });
    }

    public void showEmployee(int id) {
        employees.forEach(functionary -> {
            if (id == functionary.id) {
                System.out.println(functionary.id);
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
        if(employees.size() == 0) {
            System.out.println("Não há empregados registrados");
        } else {
            employees.forEach(functionary -> {
                System.out.println(functionary.id);
                System.out.println(functionary.name);
                try {
                    System.out.println(functionary.listPontos());
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        }
    }

    public void registrarPonto(int id, Ponto ponto) {
        employees.forEach(employee -> {
            if (employee.id == id) {
                employee.setPonto(ponto);
            }
        });
    }
}