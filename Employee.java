import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Employee {
    public int id;
    public String name;
    public ArrayList<Ponto> pontos = new ArrayList<Ponto>();

    public Employee() {}

    public Employee(int id, String name, ArrayList<Ponto> pontos) {
        this.id = id;
        this.name = name;
        this.pontos = pontos;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPonto(Ponto ponto) {
        pontos.add(ponto);
    }

    public ArrayList<String> listPontos() throws Exception {
        ArrayList<String> instanced_return = new ArrayList<String>();

        // formatter do java (luxon do JS)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        ArrayList<LocalTime> formatted_pontos = new ArrayList<LocalTime>();

        for (Ponto ponto : pontos) {
            instanced_return.add(ponto.time + " | " + ponto.location);

            // add a array dos formatados
            formatted_pontos.add(LocalTime.parse(ponto.time, formatter));
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

            instanced_return.add("Horas de almoço: " + horasAlmoco);
        } else if (numPontos == 2) {
            //pega a primeira e a ultima, faz o calculo da qtd entre elas
            LocalTime horaInicio = formatted_pontos.get(0);
            LocalTime horaTermino = formatted_pontos.get(1);
            long horasTrabalhadas = ChronoUnit.HOURS.between(horaInicio, horaTermino);

            instanced_return.add("Horas trabalhadas: " + horasTrabalhadas);
        } else if (numPontos % 2 != 0) {
            // exception para caso tenha algum ponto faltando, ou sobrando
            throw new Exception("Número ímpar de pontos encontrados!");
        }

        return instanced_return;
    }
}