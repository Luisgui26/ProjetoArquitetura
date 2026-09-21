package controller;

import java.util.List;
import model.Livro;
import repository.BibliotecaRepository;

// GRASP Controller + Low Coupling.
public class LivroController {
    private final BibliotecaRepository repo = BibliotecaRepository.getInstance();
    private final ValidacaoStrategy validacao = texto -> {
        if (texto == null || texto.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
    };
    private int id = 1;

    public void criar(String nome) { validacao.validar(nome); repo.getLivros().add(new Livro(id++, nome)); }
    public List<Livro> listar() { return repo.getLivros(); }
    public void atualizar(int id, String nome) { validacao.validar(nome); buscar(id).setNome(nome); }
    public void excluir(int id) { repo.getLivros().remove(buscar(id)); }
    public Livro buscar(int id) { return repo.getLivros().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(); }
}
