package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import model.Livro;
import model.DAO;

@WebServlet("/ListarLivros") // Conexão com o Servlet

// Método para listar livros

public class ListarLivros extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Pega a lista atualizada da memória
    	DAO dao = new DAO();
        List<Livro> livros = dao.getAcervo();
        
        request.setAttribute("meusLivros", livros);
        
        // Encaminha a requisição para a página JSP renderizar
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }
}
