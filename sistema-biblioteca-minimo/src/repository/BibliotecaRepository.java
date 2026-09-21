package repository;

import java.util.ArrayList;
import java.util.List;
import model.*;

// GoF Singleton: um único repositório para todo o sistema.
public class BibliotecaRepository {
    private static final BibliotecaRepository INSTANCE = new BibliotecaRepository();
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    private BibliotecaRepository() {}
    public static BibliotecaRepository getInstance() { return INSTANCE; }
    public List<Livro> getLivros() { return livros; }
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}
