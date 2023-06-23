import java.util.Collections;
import java.util.List;

public class EmployeeClt extends Employee{

    private Integer id;

    private Integer max_hours_per_day;

    public EmployeeClt() {
    }

    public EmployeeClt(Integer id, Integer max_hours_per_day) {
        this.id = id;
        this.max_hours_per_day = max_hours_per_day;
    }

    public EmployeeClt(int id, String name, List<Ponto> pontos, EEmployee tipoEmployer, Integer id1, Integer max_hours_per_day) {
        super(id, name, pontos, tipoEmployer);
        this.id = id1;
        this.max_hours_per_day = max_hours_per_day;
    }

    public EmployeeClt(int id, String name, Integer id1, Integer max_hours_per_day) {
        super(id, name);
        this.id = id1;
        this.max_hours_per_day = max_hours_per_day;
    }

    public static EmployeeClt of (Employee employee) {
        var employeeClt = new EmployeeClt();
        employeeClt.setId(employee.getId());
        employeeClt.setTipoEmployer(EEmployee.PJ);
        employeeClt.setName(employee.getName());
        employeeClt.setMax_hours_per_day(8);
        employeeClt.setPontos(employee.getPontos() != null
                ? employee.getPontos() : Collections.emptyList());
        return employeeClt;
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
