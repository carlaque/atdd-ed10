package com.fatec.gerencialivros.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.fatec.gerencialivros.demo.domain.Biblioteca;
import com.fatec.gerencialivros.demo.domain.Livro;

import org.junit.Test;

public class TestesLivros {
    @Test
    public void cadastrado_com_sucesso() {
        Biblioteca biblioteca = new Biblioteca();
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(umLivro);
        
        List<Livro> lista = biblioteca.getLivros();
        Livro re = new Livro();
        re.setAutor("Pressman");
        re.setIsbn("1111");
        re.setTitulo("Engenharia de Software");
        assertTrue(re.equals(lista.get(0)));
    }

}
