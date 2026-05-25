package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.Livro;
import model.DAO;

@WebServlet("/excluirLivro") // Conexão com o Servlet

//Método para excluir livros

public class ExcluirLivro extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    String isbn = request.getParameter("isbn");
	    
	    if (isbn == null || isbn.trim().isEmpty()) {
	        response.sendRedirect("index.html?erro=isbn_vazio");
	        return;
	    }
	    
	    DAO dao = new DAO();
	    boolean excluidoComSucesso = dao.excluirLivro(isbn);
	    
	    if (excluidoComSucesso) {
	        response.sendRedirect("index.html?sucesso=excluido");
	    } else {
	        response.sendRedirect("index.html?erro=livro_nao_encontrado");
	    }
	}
}

