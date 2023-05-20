public class Ponto {
    public String horario;
    public String localizacao;

    public Ponto() {

    }

    public Ponto(String horario, String localizacao) {
        this.horario = horario;
        this.localizacao = localizacao;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
