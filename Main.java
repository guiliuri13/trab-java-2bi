import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	Employer empregador = new Employer();
    	boolean logged= true;
    	boolean isMenuEmployee = false;
    	int opcao;
    	
    	while(logged) {
        	System.out.println("Qual açâo deseja realizar?");
        	System.out.println("\n1: Listar Empregados \n2: Registrar Empregado \n3: Deletar Empregado \n4: Menu do Empregado \n5: Sair");
        	
        	opcao = input.nextInt();
        	
        	switch(opcao) {
        		case 1: {
        			empregador.listEmployees();
        			opcao = input.nextInt();
        			break;
        		}
        		case 2: {
        			Employee empregado = new Employee();
        			
        			empregado.setId(empregador.employees.size() + 1);
        			empregado.setName(input.nextLine());
        			empregador.registerEmployee(empregado);
        			break;
        		}
        		case 3: {
        			int id;
        			
        			id = input.nextInt();
        			empregador.deleteEmployee(id);
        			break;
        		}
        		case 4: {
        			isMenuEmployee = true;
        			Scanner inputEmployee = new Scanner(System.in);
        			int optionEmployee;
        			
        			System.out.println("Qual ação deseja realizar?");
        			System.out.println("\n1: Mostrar Empregado \n2: Registrar Ponto \n3: Sair");
        			
        			optionEmployee = inputEmployee.nextInt();        			
        			while(isMenuEmployee) {
        				switch(optionEmployee) {
        					case 1: {
        						int id = inputEmployee.nextInt();
        						empregador.showEmployee(id);
        						break;
        					}
        					case 3: {
        						isMenuEmployee = false;
        						break;
        					}
        				}
        			}
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