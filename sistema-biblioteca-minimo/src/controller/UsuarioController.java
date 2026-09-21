package controller;

import java.util.List;
import model.Usuario;
import repository.BibliotecaRepository;

// GRASP Controller + Low Coupling.
public class UsuarioController {
    private final BibliotecaRepository repo = BibliotecaRepository.getInstance();
    private final ValidacaoStrategy validacao = texto -> {
        if (texto == null || texto.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
    };
    private int id = 1;

    public void criar(String nome) { validacao.validar(nome); repo.getUsuarios().add(new Usuario(id++, nome)); }
    public List<Usuario> listar() { return repo.getUsuarios(); }
    public void atualizar(int id, String nome) { validacao.validar(nome); buscar(id).setNome(nome); }
    public void excluir(int id) { repo.getUsuarios().remove(buscar(id)); }
    public Usuario buscar(int id) { return repo.getUsuarios().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(); }
}
