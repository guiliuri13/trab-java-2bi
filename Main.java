public class Main {
    public static void main(String[] args) {
        Empregador empregador = new Empregador();
        Empregado empregado = new Empregado();
        Empregado empregado2 = new Empregado();
        Empregado empregado3 = new Empregado(3, "Ana");

        Ponto ponto = new Ponto();
        ponto.setHorario("08:00");
        ponto.setLocalizacao("Office");

        Ponto ponto2 = new Ponto();
        ponto2.setHorario("12:00");
        ponto2.setLocalizacao("Office");

        empregado.setId(1);
        empregado.setNome("Alex");
        empregado.registrarPonto(ponto);
        empregado.registrarPonto(ponto2);

        empregado2.setId(2);
        empregado2.setNome("Fernando");
        empregado2.registrarPonto(ponto);
        empregado2.registrarPonto(ponto2);

        empregado3.registrarPonto(ponto);
        empregado3.registrarPonto(ponto2);

        empregador.cadastraEmpregado(empregado);
        empregador.cadastraEmpregado(empregado2);
        empregador.cadastraEmpregado(empregado3);

        empregador.mostraEmpregados();
    }
}