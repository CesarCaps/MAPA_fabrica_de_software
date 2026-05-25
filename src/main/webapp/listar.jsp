<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Livro" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livros Cadastrados - Gerenciador</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <header>
        <h1>Livros no Acervo</h1>
    </header>

    <main class="container">
        <section class="card">
            <h2>Lista de Livros</h2>
            
            <table class="tabela-livros">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Ano</th>
                        <th>ISBN</th>
                    </tr>
                </thead>
                <tbody>
    <% 
        // 1. Recupera a lista que o Servlet enviou
        java.util.List<Livro> acervo = (java.util.List<Livro>) request.getAttribute("meusLivros");
        
        // 2. Verifica se a lista não está vazia para evitar erros
        if (acervo != null) {
            // 3. Faz um laço 'for' para cada livro da lista
            for (Livro livro : acervo) {
    %>
                <tr>
                    <td><%= livro.getTitulo() %></td>
                    <td><%= livro.getAutor() %></td>
                    <td><%= livro.getAnoPublicacao() %></td>
                    <td><%= livro.getIsbn() %></td>
                </tr>
    <% 
            }
        } else { 
    %>
            <tr>
                <td colspan="4" style="text-align: center;">Nenhum livro cadastrado ainda.</td>
            </tr>
    <% 
        } 
    %>
</tbody>
            </table>

            <br>
            <!-- Botão para voltar à página de cadastro/exclusão -->
            <a href="index.html" class="btn btn-secondary">Voltar ao Menu Principal</a>
        </section>
    </main>

    <footer>
        <p>&copy; 2026 - Trabalho AcadÃªmico Sistema de Livros</p>
    </footer>

</body>
</html>