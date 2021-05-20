package com.fatec.gerencialivros.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.fatec.gerencialivros.demo.domain.Biblioteca;
import com.fatec.gerencialivros.demo.domain.Livro;

import org.junit.Test;

public class TestesCadastroDeLivro {
    Biblioteca biblioteca = new Biblioteca();

    @Test
    public void cadastrado_com_sucesso() {
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        try {
            biblioteca.save(umLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Livro> lista = biblioteca.getLivros();
        Livro re = new Livro();
        re.setAutor("Pressman");
        re.setIsbn("1111");
        re.setTitulo("Engenharia de Software");
        assertTrue(re.equals(lista.get(0)));
    }

    @Test
    public void cadastrar_livro_com_isbn_já_cadastrado() {
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        try {
            biblioteca.save(umLivro);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        Livro outroLivro = new Livro();

        outroLivro.setAutor("Pressman");
        outroLivro.setIsbn("1111");
        outroLivro.setTitulo("Engenharia de Software");
        try {
            biblioteca.save(outroLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(biblioteca.size() >= 2);

    }

    @Test
    public void cadastrar_livro_com_isbn_em_branco() {
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("");
        umLivro.setTitulo("Engenharia de Software");
        try {
            biblioteca.save(umLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(biblioteca.size() >= 1);
    }

    @Test
    public void cadastrar_livro_com_título_em_branco() {
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");
        umLivro.setIsbn("2222");
        umLivro.setTitulo("");
        try {
            biblioteca.save(umLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(biblioteca.size() >= 1);
    }

    @Test
    public void cadastrar_livro_com_autor_em_branco() {
        Livro umLivro = new Livro();
        umLivro.setAutor("");
        umLivro.setIsbn("2222");
        umLivro.setTitulo("Engenharia 3");
        try {
            biblioteca.save(umLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertFalse(biblioteca.size() >= 1);
    }

}
