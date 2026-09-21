package controller;

import java.util.List;
import model.Emprestimo;
import repository.BibliotecaRepository;

// GRASP Controller + Low Coupling.
public class EmprestimoController {
    private final BibliotecaRepository repo = BibliotecaRepository.getInstance();
    private final ValidacaoStrategy validacao = texto -> {
        if (texto == null || texto.isBlank()) throw new IllegalArgumentException("Descrição obrigatória.");
    };
    private int id = 1;

    public void criar(String descricao) { validacao.validar(descricao); repo.getEmprestimos().add(new Emprestimo(id++, descricao)); }
    public List<Emprestimo> listar() { return repo.getEmprestimos(); }
    public void atualizar(int id, String descricao) { validacao.validar(descricao); buscar(id).setDescricao(descricao); }
    public void excluir(int id) { repo.getEmprestimos().remove(buscar(id)); }
    public Emprestimo buscar(int id) { return repo.getEmprestimos().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(); }
}
