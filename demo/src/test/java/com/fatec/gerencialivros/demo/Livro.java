package com.fatec.gerencialivros.demo;

import org.junit.Test;

public class Livro {
    @Test
    void cadastrado_com_sucesso() {
        Biblioteca b = new Biblioteca();
        Livro l = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(l);
        // entao o total de livros cadastrados igual 1
        assertEquals(1, biblioteca.size());
    }

}
