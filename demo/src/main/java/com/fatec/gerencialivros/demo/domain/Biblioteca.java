package com.fatec.gerencialivros.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<Livro>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void save(Livro livro) throws Exception {
        if (livro.getIsbn().equals("") || livro.getTitulo().equals("") || livro.getAutor().equals("") )  
            throw new Exception();

        for (Livro l : livros) {
            if (livro.equals(l))
                throw new Exception();
        }
        livros.add(livro);

    }

    public int size() {
        return livros.size();
    }
}
