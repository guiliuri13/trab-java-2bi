import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    public Integer id;
    public String name;
    public List<Ponto> pontos = new ArrayList<>();
    public EEmployee tipoEmployer;

    public Employee() {}

    public Employee(Integer id, String name, List<Ponto> pontos, EEmployee tipoEmployer) {
        this.id = id;
        this.name = name;
        this.pontos = pontos;
        this.tipoEmployer = tipoEmployer;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public EEmployee getTipoEmployer() {
        return tipoEmployer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPonto(Ponto ponto) {
        pontos.add(ponto);
    }

    public void setTipoEmployer(EEmployee tipoEmployer) {
        this.tipoEmployer = tipoEmployer;
    }


    public ArrayList<String> listPontos(int max_hours_per_day) throws Exception {
        ArrayList<String> instanced_return = new ArrayList<String>();

        // formatter do java (luxon do JS)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        ArrayList<LocalTime> formatted_pontos = new ArrayList<LocalTime>();

        for (Ponto ponto : this.pontos)  {
            instanced_return.add(ponto.getTime() + " | " + ponto.getLocation());

            // add a array dos formatados
            formatted_pontos.add(LocalTime.parse(ponto.getTime(), formatter));
        }

        int numPontos = formatted_pontos.size();
        // entrada + entrada alm. + saida alm. + saida trampo
        if (numPontos == 4) {
            //primeira
            LocalTime horaInicio = formatted_pontos.get(0);
            //uiltima
            LocalTime horaTermino = formatted_pontos.get(3);
            //conta a qtd de horas ENTRE a primeira e a ultima
            long horasTotais = ChronoUnit.HOURS.between(horaInicio, horaTermino);

            // mesma coisa pro almoço
            LocalTime horaAlmocoInicio = formatted_pontos.get(1);
            LocalTime horaAlmocoTermino = formatted_pontos.get(2);
            long horasAlmoco = ChronoUnit.HOURS.between(horaAlmocoInicio, horaAlmocoTermino);

            //talvez precise de mais um validator pra exception. mas ta claro oq faz
            instanced_return.add("Horas totais: " + (horasTotais - horasAlmoco));

            if (max_hours_per_day < (horasTotais - horasAlmoco)) {
                instanced_return.add("LIMITE CONTRATUAL EXTRAPOLADO");
            }

            instanced_return.add("Horas de almoço: " + horasAlmoco);
        } else if (numPontos == 2) {
            //pega a primeira e a ultima, faz o calculo da qtd entre elas
            LocalTime horaInicio = formatted_pontos.get(0);
            LocalTime horaTermino = formatted_pontos.get(1);
            long horasTrabalhadas = ChronoUnit.HOURS.between(horaInicio, horaTermino);

            instanced_return.add("Horas trabalhadas: " + horasTrabalhadas);

            if (max_hours_per_day < horasTrabalhadas) {
                instanced_return.add("LIMITE CONTRATUAL EXTRAPOLADO");
            }
        } else if (numPontos % 2 != 0) {
            // exception para caso tenha algum ponto faltando, ou sobrando
            throw new Exception("Número ímpar de pontos encontrados!");
        }

        return instanced_return;
    }
}