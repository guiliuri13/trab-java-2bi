import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employer empregador = new Employer();

        boolean logged = true;
        int idEmpregado = 0;
        int opcao;

        while(logged) {
            System.out.println("\nQual ação deseja realizar?");
            System.out.println("\n1: Listar Empregados \n2: Registrar Empregado \n3: Deletar Empregado \n4: Menu do Empregado \n5: Sair");

            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Voce quer listar qual  \n1: Clt \n2: Pj");
                    switch (input.nextInt()) {
                        case 1 -> empregador.listEmployeesClt();
                        case 2 -> empregador.listEmployeesPj();
                    }
                }
                case 2 -> {
                    System.out.println("Será PJ? (s ou n): ");
                    Scanner is_pj = new Scanner(System.in);
                    if (is_pj.next().equalsIgnoreCase( "s")) {
                        EmployeePJ empregado = new EmployeePJ();

                        empregado.setId(empregador.getEmployeesPj().size() + 1);

                        System.out.println("Escreva o nome do empregado: ");
                        Scanner new_name = new Scanner(System.in);

                        empregado.setName(new_name.nextLine());
                        empregado.setTipoEmployer(EEmployee.PJ);
                        empregador.registerEmployeePj(empregado);

                        empregador.showEmployeePj(empregado.getId());
                    } else {
                        EmployeeClt empregado = new EmployeeClt();

                        empregado.setId(empregador.getEmployeesClts().size() + 1);

                        System.out.println("Escreva o nome do empregado: ");

                        Scanner new_name = new Scanner(System.in);

                        empregado.setName(new_name.nextLine());

                        empregado.setTipoEmployer(EEmployee.CLT);
                        empregador.registerEmployeeClt(empregado);

                        empregador.showEmployeeClt(empregado.getId());
                    }

                }
                case 3 -> {
                    System.out.println("Qual tipo de funcionario voçê deletar \n1: Clt \n2: Pj");
                    System.out.println("Digite o id do funcionario");
                    var id = input.nextInt();
                    switch (input.nextInt()) {
                        case 1 -> empregador.deleteEmployeeClt(id);
                        case 2 -> empregador.deleteEmployeePj(id);
                    }
                }
                case 4 -> {
                    System.out.print("Insira o id do usuário desejado: ");
                    idEmpregado = input.nextInt();

                    while (idEmpregado != 0) {
                        System.out.println("\nQual ação deseja realizar? \n1: Mostrar Empregado \n2: Registrar Ponto \n3: Sair");
                        int opcaoMenuEmpregado = input.nextInt();

                        switch (opcaoMenuEmpregado) {
                            case 1 -> {
                                System.out.println("Voce quer listar qual  \n1: Clt \n2: Pj");
                                switch (input.nextInt()) {
                                    case 1 -> empregador.showEmployeeClt(idEmpregado);
                                    case 2 -> empregador.showEmployeePj(idEmpregado);
                                }
                            }
                            case 2 -> {
                                Scanner hor = new Scanner(System.in);
                                System.out.println("Informe horário: ");

                                String new_hour = hor.nextLine();

                                Scanner loc = new Scanner(System.in);
                                System.out.println("Informe Localização: ");

                                String new_loc = hor.nextLine();

                                Ponto new_ponto = new Ponto();

                                new_ponto.setLocation(new_loc);
                                new_ponto.setTime(new_hour);

                                System.out.println("Qual tipo de funcionario voçê quer incluir \n1: Clt \n2: Pj");
                                switch (input.nextInt()) {
                                    case 1 -> empregador.registrarPontoClt(idEmpregado, new_ponto);
                                    case 2 -> empregador.registrarPontoPj(idEmpregado, new_ponto);
                                }
                            }
                            case 3 -> {
                                idEmpregado = 0;
                            }
                        }
                    }
                }
                case 5 -> {
                    logged = false;
                }
                default -> {
                }
            }
        }
    }
}