package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Livro;
import Models.Usuario;
import Models.Aluguel;


public class Servicos {
	
	private Usuario usuarioLogado;

	
	public void cadastrarLivro(ArrayList<Livro> livros) {
        
		 String nomeLivro = JOptionPane.showInputDialog("Informe o nome do livro:");;
		 String nomeAutor = JOptionPane.showInputDialog("Informe o nome do autor do livro:");;
		 String dataPublicacaoStr = JOptionPane.showInputDialog("Informe a data de publicação (no formato yyyy-MM-dd):");
	     LocalDate dataPublicacao = LocalDate.parse(dataPublicacaoStr, DateTimeFormatter.ISO_LOCAL_DATE); // para indicar que a data deve ser fornecida no formato "yyyy-MM-dd"

		
		 Livro novoLivro = new Livro(nomeLivro,nomeAutor,dataPublicacao,false);
	
        livros.add(novoLivro);
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }

    public  void cadastrarUsuario(ArrayList<Usuario> usuarios) {
        
   	 String nome = JOptionPane.showInputDialog("Informe o nome do usuário:");
	 String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário:");;
	 String email = JOptionPane.showInputDialog("Informe o email do usuário:");;
	 String telefone = JOptionPane.showInputDialog("Informe o telefone do usuário:");;
	 String login = JOptionPane.showInputDialog("Informe o login do usuário:");
	 String senha = JOptionPane.showInputDialog("Informe a senha do usuário:");
	    
	    Usuario novoUsuario = new Usuario(nome, cpf, email, telefone, login, senha);
	 
	 usuarios.add(novoUsuario);
     JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
     
    }
    
    public void autenticarUsuario(ArrayList<Usuario> usuarios) {
        String login = JOptionPane.showInputDialog("Informe o login:");
        String senha = JOptionPane.showInputDialog("Informe a senha:");

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                JOptionPane.showMessageDialog(null, "Usuário autenticado com sucesso!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Tente novamente.");
    }

    public  void listarLivros(ArrayList<Livro> livros) {
    	
    	if(livros.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
    		return;
    	}
    	
    	StringBuilder mensagem = new StringBuilder();
    	
    	for(Livro livro : livros) {
    		mensagem.append(String.format("Nome do livro: %s\n Nome do Autor: %s\nData publicação:%s\n Status Alugado: %s", 
    				livro.getNomeLivro(),livro.getNomeAutor(),livro.getDataPublicacao(),livro.isAlugado()));
    		JOptionPane.showMessageDialog(null, mensagem);
    	}
    	
    
    }

    public  void listarUsuarios(ArrayList<Usuario> usuarios) {
    	if(usuarios.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
    		return;
    	}

    	StringBuilder mensagem = new StringBuilder();
    	
    	for(Usuario user : usuarios) {
    		mensagem.append(String.format("Nome do usuario: %s\n CPF: %s\nemail:%s\n Telefone: %s", 
    				user.getNome(),user.getCpf(),user.getEmail(),user.getTelefone()));
    		JOptionPane.showMessageDialog(null, mensagem);
    	}
    }

    public  void realizarAluguel(ArrayList<Livro> livros, ArrayList<Usuario> usuarios, ArrayList<Aluguel> alugueis) {
    	checagemDataLivros(livros, usuarios, alugueis);
    	
    	if(usuarioLogado == null) {
    		autenticarUsuario(usuarios);
    		return;
    	}
    	
    	
    	 if (livros.isEmpty()) {
    	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
    	        return;
    	    }
        
    
    	    StringBuilder livrosDisponiveis = new StringBuilder("Livros Disponíveis para Aluguel:\n");
    	    for (Livro livro : livros) {
    	        if (!livro.isAlugado()) {
    	            livrosDisponiveis.append("- ").append(livro.getNomeLivro()).append("\n");
    	        }
    	    }
    	    if (livrosDisponiveis.length() == 0) {
    	        JOptionPane.showMessageDialog(null, "Nenhum livro disponível para aluguel.");
    	        return;
    	    }
    	    String livroSelecionado = JOptionPane.showInputDialog(livrosDisponiveis.toString(), "Selecione o livro para alugar:");

    	 
    	    Livro livroAluguel = null;
    	    for (Livro livro : livros) {
    	        if (livro.getNomeLivro().equalsIgnoreCase(livroSelecionado)) {
    	            livroAluguel = livro;
    	            break;
    	        }
    	    }
    	    if (livroAluguel == null || livroAluguel.isAlugado()) {
    	        JOptionPane.showMessageDialog(null, "Livro selecionado não está disponível para aluguel.");
    	        return;
    	    }
    	    
    	    StringBuilder usuariosCadastrados = new StringBuilder("Usuários Cadastrados:\n");
    	    for (Usuario usuario : usuarios) {
    	        usuariosCadastrados.append("- ").append(usuario.getNome()).append("\n");
    	    }
    	    String usuarioSelecionado = JOptionPane.showInputDialog(usuariosCadastrados.toString(), "Selecione o usuário para alugar:");

    	    
    	    Usuario usuarioAluguel = null;
    	    for (Usuario usuario : usuarios) {
    	        if (usuario.getNome().equalsIgnoreCase(usuarioSelecionado)) {
    	            usuarioAluguel = usuario;
    	            break;
    	        }
    	    }
    	    if (usuarioAluguel == null) {
    	        JOptionPane.showMessageDialog(null, "Usuário selecionado não encontrado.");
    	        return;
    	    }

    	   
    	    Aluguel aluguel = new Aluguel(usuarioAluguel, livroAluguel, LocalDate.now());
    	    alugueis.add(aluguel);
    	    livroAluguel.setAlugado(true);

    	    JOptionPane.showMessageDialog(null, "Livro alugado com sucesso!");
    	    
    	    
    }

    public  void devolverLivro(ArrayList<Aluguel> alugueis,ArrayList<Usuario> usuarios,ArrayList<Livro> livros) {
        
    	if(usuarioLogado == null) {
    		autenticarUsuario(usuarios);
    		return;
    	}
    	
    	if(alugueis.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Nenhum livro alugado no momento.");
            return;
    	}
    	
    	 StringBuilder livrosAlugadosPeloUsuario = new StringBuilder("Livros Alugados pelo Usuário:\n");
    	 for (Aluguel aluguel : alugueis) {
    	        if (aluguel.getUsuario().equals(usuarioLogado)) {
    	            livrosAlugadosPeloUsuario.append("- ").append(aluguel.getLivro().getNomeLivro()).append("\n");
    	        }
    	    }
    	    if (livrosAlugadosPeloUsuario.length() == 0) {
    	        JOptionPane.showMessageDialog(null, "Você não tem nenhum livro alugado no momento.");
    	        return;
    	    }
    	    
    	    String livroDevolucaoSelecionado = JOptionPane.showInputDialog(livrosAlugadosPeloUsuario.toString(), "Selecione o livro para devolver:");

     	    
    	    	    
    	    Livro livroDevolucao = null;
    	    for (Livro livro : livros) {
    	        if (livro.getNomeLivro().equalsIgnoreCase(livroDevolucaoSelecionado)) {
    	        	livroDevolucao = livro;
    	            break;
    	        }
    	    }
    	    if (livroDevolucao == null || !livroDevolucao.isAlugado()) {
    	        JOptionPane.showMessageDialog(null, "Livro selecionado não está alugado.");
    	        return;
    	    }
    	    

    	   
    	    livroDevolucao.setAlugado(false);
    	    alugueis.remove(livroDevolucao);

    	    JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
    	
    	
    }
    
    public void renovarAluguel (ArrayList<Livro> livros, ArrayList<Usuario> usuarios, ArrayList<Aluguel> alugueis) {
    	
    	checagemDataLivros(livros, usuarios, alugueis);
    	
    	if(usuarioLogado == null) {
    		autenticarUsuario(usuarios);
    		return;
    	}
    	
    	if(alugueis.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Nenhum livro alugado no momento.");
            return;
    	}
    	
 
        StringBuilder alugueisUsuario = new StringBuilder("Aluguéis realizados pelo usuário:\n");
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getUsuario().equals(usuarioLogado)) {
                alugueisUsuario.append("- Livro: ").append(aluguel.getLivro().getNomeLivro()).append(", Data de Devolução: ").append(aluguel.getDataDevolucao()).append("\n");
            }
        }
        if (alugueisUsuario.length() == 0) {
            JOptionPane.showMessageDialog(null, "Você não tem nenhum aluguel realizado.");
            return;
        }
    	
        
        String livroRenovacao = JOptionPane.showInputDialog(alugueisUsuario.toString(), "Selecione o livro para renovar o aluguel:");
    
    
        Aluguel aluguelRenovacao = null;
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getUsuario().equals(usuarioLogado) && aluguel.getLivro().getNomeLivro().equalsIgnoreCase(livroRenovacao)) {
                aluguelRenovacao = aluguel;
                break;
            }
        }
        if (aluguelRenovacao == null) {
            JOptionPane.showMessageDialog(null, "Livro selecionado não está alugado por você.");
        }
    
    
        aluguelRenovacao.setDataDevolucao(LocalDate.now().plusDays(7));

        JOptionPane.showMessageDialog(null, "Aluguel renovado com sucesso!\nNova data de devolução prevista: " + aluguelRenovacao.getDataDevolucao());
    }
    
    
    public void checagemDataLivros (ArrayList<Livro> livros, ArrayList<Usuario> usuarios, ArrayList<Aluguel> alugueis) {
    	

    	if(usuarioLogado == null) {
    		autenticarUsuario(usuarios);
    		return;
    	}
    	
    	if(alugueis.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Nenhum livro alugado no momento.");
            return;
    	}
    	
       StringBuilder alugueisUsuario = new StringBuilder("Aluguéis realizados pelo usuário:\n");
    	
       LocalDate hoje = LocalDate.now();
 
       for (Aluguel aluguel : alugueis) {
           if (aluguel.getUsuario().equals(usuarioLogado)) {
               alugueisUsuario.append("- Livro: ").append(aluguel.getLivro().getNomeLivro())
                   .append(", Data de Devolução: ").append(aluguel.getDataDevolucao()).append("\n");

               if (aluguel.getDataDevolucao().isBefore(hoje)) {
                   alugueisUsuario.append("   ** Livro com a devolução atrasada **\n");
               }
           }
       }

       JOptionPane.showMessageDialog(null, alugueisUsuario.toString());
    }

}
