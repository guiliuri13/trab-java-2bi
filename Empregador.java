import java.util.*;

public class Empregador implements emp {
    private int id;
    private ArrayList<Empregado> empregados = new ArrayList<Empregado>();

    public Empregador() {

    }

    public Empregador(int id, ArrayList<Empregado> empregados) {
        this.id = id;
        this.empregados = empregados;
    }

    public void cadastraEmpregado(Empregado empregado) {
        empregados.add(empregado);
    }

    public void mostraEmpregado(int id) {
        empregados.forEach(functionary -> {
            if (id == functionary.id) {
                System.out.println(functionary.nome);
                System.out.println(functionary.mostrarPontos());
            }
        });
    }

    public void mostraEmpregados() {
        empregados.forEach(functionary -> {
            System.out.println(functionary.nome);
            System.out.println(functionary.mostrarPontos());
        });
    }
}
