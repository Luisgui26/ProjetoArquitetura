package view;

import controller.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {
    private final LivroController livros = new LivroController();
    private final UsuarioController usuarios = new UsuarioController();
    private final EmprestimoController emprestimos = new EmprestimoController();

    public Main() {
        setTitle("Biblioteca");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Livros", painel("Livro", livros));
        abas.add("Usuários", painel("Usuário", usuarios));
        abas.add("Empréstimos", painel("Empréstimo", emprestimos));
        add(abas);
    }

    private JPanel painel(String tipo, Object controller) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome/Descrição"}, 0);
        JTable tabela = new JTable(model);
        JButton novo = new JButton("Novo"), editar = new JButton("Editar"), excluir = new JButton("Excluir");
        JPanel botoes = new JPanel(); botoes.add(novo); botoes.add(editar); botoes.add(excluir);
        JPanel painel = new JPanel(new BorderLayout());
        painel.add(new JScrollPane(tabela), BorderLayout.CENTER); painel.add(botoes, BorderLayout.SOUTH);

        Runnable atualizar = () -> {
            model.setRowCount(0);
            if (controller instanceof LivroController c) c.listar().forEach(x -> model.addRow(new Object[]{x.getId(), x.getNome()}));
            if (controller instanceof UsuarioController c) c.listar().forEach(x -> model.addRow(new Object[]{x.getId(), x.getNome()}));
            if (controller instanceof EmprestimoController c) c.listar().forEach(x -> model.addRow(new Object[]{x.getId(), x.getDescricao()}));
        };

        novo.addActionListener(e -> executar(() -> {
            String texto = JOptionPane.showInputDialog(this, tipo + ":");
            if (texto == null) return;
            if (controller instanceof LivroController c) c.criar(texto);
            if (controller instanceof UsuarioController c) c.criar(texto);
            if (controller instanceof EmprestimoController c) c.criar(texto);
            atualizar.run();
        }));

        editar.addActionListener(e -> executar(() -> {
            int linha = tabela.getSelectedRow();
            if (linha < 0) throw new IllegalArgumentException("Selecione um item.");
            int id = (int) model.getValueAt(linha, 0);
            String texto = JOptionPane.showInputDialog(this, "Novo valor:", model.getValueAt(linha, 1));
            if (texto == null) return;
            if (controller instanceof LivroController c) c.atualizar(id, texto);
            if (controller instanceof UsuarioController c) c.atualizar(id, texto);
            if (controller instanceof EmprestimoController c) c.atualizar(id, texto);
            atualizar.run();
        }));

        excluir.addActionListener(e -> executar(() -> {
            int linha = tabela.getSelectedRow();
            if (linha < 0) throw new IllegalArgumentException("Selecione um item.");
            int id = (int) model.getValueAt(linha, 0);
            if (controller instanceof LivroController c) c.excluir(id);
            if (controller instanceof UsuarioController c) c.excluir(id);
            if (controller instanceof EmprestimoController c) c.excluir(id);
            atualizar.run();
        }));
        return painel;
    }

    private void executar(Runnable acao) {
        try { acao.run(); }
        catch (Exception e) { JOptionPane.showMessageDialog(this, e.getMessage()); }
    }

    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Main().setVisible(true)); }
}
