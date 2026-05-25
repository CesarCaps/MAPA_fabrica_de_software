package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.Livro;
import model.DAO;

@WebServlet("/cadastrarLivro") // Conexão com o Servlet

public class CadastroLivro extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    request.setCharacterEncoding("UTF-8");
	    
	    // 1. Captura os dados
	    String titulo = request.getParameter("titulo");
	    String autor = request.getParameter("autor");
	    String anoRaw = request.getParameter("anoPublicacao");
	    String isbn = request.getParameter("isbn");
	    
	    // 2. Validação de Campos Vazios (Anti-espaços em branco)
	    if (titulo == null || titulo.trim().isEmpty() ||
	        autor == null || autor.trim().isEmpty() ||
	        anoRaw == null || anoRaw.trim().isEmpty() ||
	        isbn == null || isbn.trim().isEmpty()) {
	        
	        // Se algo estiver vazio, envia um código de erro ou mensagem de aviso
	        response.sendRedirect("index.html?erro=campos_vazios");
	        return; // Para a execução aqui!
	    }
	    
	    // 3. Validação do Ano (Evita que o Integer.parseInt quebre caso digitem letras)
	    int anoPublicacao;
	    try {
	        anoPublicacao = Integer.parseInt(anoRaw);
	        if (anoPublicacao < 0 || anoPublicacao > 2026) {
	            response.sendRedirect("index.html?erro=ano_invalido");
	            return;
	        }
	    } catch (NumberFormatException e) {
	        response.sendRedirect("index.html?erro=ano_nao_numerico");
	        return;
	    }
	    
	    // 4. Validação Básica do ISBN no Java (Remove hífens e checa o tamanho)
	    String isbnLimpo = isbn.replace("-", "").replace(" ", "");
	    if (isbnLimpo.length() != 10 && isbnLimpo.length() != 13) {
	        response.sendRedirect("index.html?erro=isbn_invalido");
	        return;
	    }
	    
	    // Se passou por todas as validações, cria e salva!
	    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, isbn);
	    DAO dao = new DAO();
	    dao.cadastrarLivro(novoLivro);
	    
	    response.sendRedirect("index.html?sucesso=cadastrado");
	}
}


