import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employer empregador = new Employer();

        boolean logged= true;
        int idEmpregado = 0;
        int opcao;

        while(logged) {
            System.out.println("\nQual ação deseja realizar?");
            System.out.println("\n1: Listar Empregados \n2: Registrar Empregado \n3: Deletar Empregado \n4: Menu do Empregado \n5: Sair");

            opcao = input.nextInt();

            switch(opcao) {
                case 1: {
                    empregador.listEmployees();
                    break;
                }
                case 2: {
                    System.out.println("Será PJ? (s ou n): ");
                    Scanner is_pj = new Scanner(System.in);
                    if (is_pj.nextLine() == "s") {
                        EmployeePJ empregado = new EmployeePJ();

                        empregado.setId(empregador.employees.size() + 1);

                        System.out.println("Escreva o nome do empregado: ");

                        Scanner new_name = new Scanner(System.in);

                        empregado.setName(new_name.nextLine());

                        empregador.registerEmployee(empregado);

                        empregador.showEmployee(empregado.id);
                    } else {
                        Employee empregado = new Employee();

                        empregado.setId(empregador.employees.size() + 1);

                        System.out.println("Escreva o nome do empregado: ");

                        Scanner new_name = new Scanner(System.in);

                        empregado.setName(new_name.nextLine());

                        empregador.registerEmployee(empregado);

                        empregador.showEmployee(empregado.id);
                    }

                    break;
                }
                case 3: {
                    int id;

                    id = input.nextInt();
                    empregador.deleteEmployee(id);
                    break;
                }
                case 4: {
                    System.out.print("Insira o id do usuário desejado: ");
                    idEmpregado = input.nextInt();

                    while(idEmpregado != 0) {
                        System.out.println("\nQual ação deseja realizar? \n1: Mostrar Empregado \n2: Registrar Ponto \n3: Sair");
                        int opcaoMenuEmpregado = input.nextInt();

                        switch (opcaoMenuEmpregado) {
                            case 1: {
                                empregador.showEmployee(idEmpregado);
                                break;
                            }
                            case 2: {
                                Scanner hor = new Scanner(System.in);
                                System.out.println("Informe horário: ");

                                String new_hour = hor.nextLine();

                                Scanner loc = new Scanner(System.in);
                                System.out.println("Informe Localização: ");

                                String new_loc = hor.nextLine();

                                Ponto new_ponto = new Ponto();

                                new_ponto.setLocation(new_loc);
                                new_ponto.setTime(new_hour);

                                empregador.registrarPonto(idEmpregado, new_ponto);
                                break;
                            }
                            case 3: {
                                idEmpregado = 0;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    logged = false;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}