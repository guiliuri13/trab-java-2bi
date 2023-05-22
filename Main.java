public class Main {
    public static void main(String[] args) {
        Employer empregador = new Employer();
        Employee empregado = new Employee();
        Employee empregado2 = new Employee();
        Employee empregado3 = new Employee(3, "Ana");

        Ponto ponto = new Ponto();
        ponto.setTime("08:00");
        ponto.setLocation("Office");

        Ponto ponto2 = new Ponto();
        ponto2.setTime("12:00");
        ponto2.setLocation("Office");

        Ponto ponto3 = new Ponto();
        ponto3.setTime("13:00");
        ponto3.setLocation("Office");

        Ponto ponto4 = new Ponto();
        ponto4.setTime("18:00");
        ponto4.setLocation("Office");

        empregado.setId(1);
        empregado.setName("Alex");
        empregado.setPonto(ponto);
        empregado.setPonto(ponto2);

        empregado2.setId(2);
        empregado2.setName("Fernando");
        empregado2.setPonto(ponto);
        empregado2.setPonto(ponto2);
        empregado2.setPonto(ponto3);
        empregado2.setPonto(ponto4);

        empregado3.setPonto(ponto);
        empregado3.setPonto(ponto2);

        empregador.registerEmployee(empregado);
        empregador.registerEmployee(empregado2);
        empregador.registerEmployee(empregado3);

        empregador.listEmployees();
    }
}