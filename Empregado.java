import java.util.ArrayList;

public class Empregado {
    public int id;
    public String nome;
    public ArrayList<Ponto> pontos = new ArrayList<Ponto>();

    public Empregado() {}

    public Empregado(int id, String nome, ArrayList<Ponto> pontos) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
    }

    public Empregado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registrarPonto(Ponto ponto) {
        pontos.add(ponto);
    }

    public ArrayList<String> mostrarPontos() {
        ArrayList<String> instanced_return = new ArrayList<String>();

        for (Ponto ponto : pontos) {
            instanced_return.add(ponto.horario + " | " + ponto.localizacao);
        }

        return instanced_return;
    }
}
