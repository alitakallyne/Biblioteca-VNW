package App;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Aluguel;
import Models.Livro;
import Models.Usuario;
import Service.Servicos;

public class App {

	public static void main(String[] args) {
			
	    ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        
        Servicos servico = new Servicos();

	        int opcao;
	        do {
	            opcao = exibirMenu();

	            switch (opcao) {
	                case 1:
	                 servico.cadastrarLivro(livros);
	                    break;
	                case 2:
	                	servico.cadastrarUsuario(usuarios);
	                	 
	                    break;
	                case 3:
	                	servico.listarLivros(livros);
	                	 
	                    break;
	                case 4:
	                	servico.listarUsuarios(usuarios);
	                	 
	                    break;
	                case 5:
	                	servico.realizarAluguel(livros, usuarios, alugueis);
	                	
	                    break;
	                case 6:
	                	servico.devolverLivro(alugueis, usuarios, livros);
	                case 7:
	                	servico.renovarAluguel(livros, usuarios, alugueis);
	                	 
	                    break;
	                case 0:
	                    JOptionPane.showMessageDialog(null, "Saindo do sistema. Até logo!");
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
	                    break;
	            }
	        } while (opcao != 0);

	}
	
	private static int exibirMenu() {
        String menu = "Biblioteca - Menu Principal\n" +
                "1. Cadastrar Livro\n" +
                "2. Cadastrar Usuário\n" +
                "3. Listar Livros\n" +
                "4. Listar Usuários\n" +
                "5. Realizar Aluguel\n" +
                "6. Devolver Livro\n" +
                "7. Renovar Livro\n" +
                "0. Sair";

        String input = JOptionPane.showInputDialog(null, menu + "\nEscolha uma opção:");
        return Integer.parseInt(input);
    }

}
