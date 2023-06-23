import java.util.ArrayList;
import java.util.List;

public class Employer implements EmployerInterface {
    private Integer id;
    private ArrayList<EmployeePJ> employeesPj = new ArrayList<>();
    private ArrayList<EmployeeClt> employeesClts = new ArrayList<>();


    public Employer() {

    }

    public Employer(Integer id, ArrayList<EmployeePJ> employeesPj, ArrayList<EmployeeClt> employeesClts) {
        this.id = id;
        this.employeesPj = employeesPj;
        this.employeesClts = employeesClts;
    }

    public Employer(Integer id, ArrayList<Employee> employees) {
        this.id = id;
    }

    public void registerEmployeePj(Employee employee) {
        employeesPj.add(EmployeePJ.of(employee));
    }

    public void registerEmployeeClt(Employee employee) {
        employeesClts.add(EmployeeClt.of(employee));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EmployeeClt> getEmployeesClts() {
        return employeesClts;
    }

    public List<EmployeePJ> getEmployeesPj() {
        return employeesPj;
    }

    public void setEmployeesPj(ArrayList<EmployeePJ> employeesPj) {
        this.employeesPj = employeesPj;
    }

    public void deleteEmployeeClt(Integer id) {
        employeesClts.forEach(employee -> {
            if (employee.getId().equals(id)) {
                employeesClts.remove(employee);
            }
        });
    }

    public void deleteEmployeePj(Integer id) {
        employeesPj.forEach(employee -> {
            if (employee.getId().equals(id)) {
                employeesPj.remove(employee);
            }
        });
    }

    public void showEmployeeClt(int id) {
        employeesClts.forEach(functionary -> {
            if (id == functionary.getId()) {
                System.out.println("Identificador: " + functionary.getId());
                System.out.println("Nome: " + functionary.getName());
                try {
                    var pontos = functionary.listPontos(functionary.getMax_hours_per_day());

                    if (pontos.size() > 0) {
                        for (String ponto : pontos) {
                            System.out.println(ponto);
                        }
                    } else {
                        System.out.println("Não há pontos registrados");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public void showEmployeePj(int id) {
        employeesPj.forEach(functionary -> {
            if (id == functionary.getId()) {
                System.out.println("Identificador: " + functionary.getId());
                System.out.println("Nome: " + functionary.name);
                try {
                    var pontos = functionary.listPontos(functionary.getMax_hours_per_day());

                    if (pontos.size() > 0) {
                        for (String ponto : pontos) {
                            System.out.println(ponto);
                        }
                    } else {
                        System.out.println("Não há pontos registrados");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    public void listEmployeesClt() {
        if (employeesClts.size() == 0) {
            System.out.println("Não há empregados registrados");
        } else {
            employeesClts.forEach(functionary -> {
                System.out.println(functionary.getId());
                System.out.println(functionary.getName());
                try {
                    ArrayList<String> pontos = functionary.listPontos(functionary.getMax_hours_per_day());

                    if (pontos.size() > 0) {
                        for (String ponto : pontos) {
                            System.out.println(ponto);
                        }
                    } else {
                        System.out.println("Não há pontos registrados");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        }
    }

    public void listEmployeesPj() {
        if (employeesPj.size() == 0) {
            System.out.println("Não há empregados registrados");
        } else {
            employeesPj.forEach(functionary -> {
                System.out.println(functionary.getId());
                System.out.println(functionary.getName());
                try {
                    ArrayList<String> pontos = functionary.listPontos(functionary.getMax_hours_per_day());

                    if (pontos.size() > 0) {
                        for (String ponto : pontos) {
                            System.out.println(ponto);
                        }
                    } else {
                        System.out.println("Não há pontos registrados");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        }
    }

    public void registrarPontoClt(Integer id, Ponto ponto) {
        employeesClts.forEach(employee -> {
            if (employee.getId().equals(id)) {
                employee.setPonto(ponto);
            }
        });
    }

    public void registrarPontoPj(Integer id, Ponto ponto) {
        employeesPj.forEach(employee -> {
            if (employee.getId().equals(id)) {
                employee.setPonto(ponto);
            }
        });
    }
}