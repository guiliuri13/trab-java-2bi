import java.util.Collections;
import java.util.List;

public class EmployeePJ extends Employee {

    private Integer id;
    private Integer max_hours_per_day;

    public EmployeePJ() {
    }

    public EmployeePJ(Integer id, Integer max_hours_per_day) {
        this.id = id;
        this.max_hours_per_day = max_hours_per_day;
    }

    public EmployeePJ(Integer id, String name, List<Ponto> pontos, EEmployee tipoEmployer, Integer id1, Integer max_hours_per_day) {
        super(id, name, pontos, tipoEmployer);
        this.id = id1;
        this.max_hours_per_day = max_hours_per_day;
    }

    public EmployeePJ(Integer id, String name, Integer id1, Integer max_hours_per_day) {
        super(id, name);
        this.id = id1;
        this.max_hours_per_day = max_hours_per_day;
    }

    public static EmployeePJ of(Employee employee) {
        var employeePj = new EmployeePJ();
        employeePj.setId(employee.getId());
        employeePj.setTipoEmployer(EEmployee.PJ);
        employeePj.setName(employee.getName());
        employeePj.setMax_hours_per_day(24);
        employeePj.setPontos(employee.getPontos() != null
                ? employee.getPontos() : Collections.emptyList());
        return employeePj;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMax_hours_per_day() {
        return max_hours_per_day;
    }

    public void setMax_hours_per_day(Integer max_hours_per_day) {
        this.max_hours_per_day = max_hours_per_day;
    }
}
