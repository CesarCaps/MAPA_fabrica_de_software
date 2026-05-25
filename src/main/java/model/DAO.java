package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import model.Livro;
import java.util.Iterator;

public class DAO {
	private static List<Livro> acervo = new ArrayList<>(Arrays.asList(
			new Livro("Dom Casmurro", "Machado de Assis", 1899, "9788594318602"),
			new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, "9788520938362"),
			new Livro("O Homem Mais Rico da Babilônia", "George S. Clason", 1926, "9788574169736"))); // dados para inicialização como exemplo
	
	public void cadastrarLivro(Livro livro) {
		acervo.add(livro);
	}
	
	public boolean excluirLivro(String isbn) {
	    Iterator<Livro> iterator = acervo.iterator();
	    while (iterator.hasNext()) {
	        Livro livro = iterator.next();
	        String isbnAcervo = livro.getIsbn().replace("-", "").replace(" ", ""); // Remove hífens de ambos para comparar só os números
	        String isbnBusca = isbn.replace("-", "").replace(" ", "");
	        
	        if (isbnAcervo.equals(isbnBusca)) {
	            iterator.remove(); 
	            return true; // Encontrou e excluiu!
	        }
	    }
	    return false; // Não encontrou nenhum livro
	}
	
    public List<Livro> getAcervo() {
        return acervo;
    }

	
}
