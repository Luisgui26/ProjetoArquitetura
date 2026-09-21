# Sistema de Biblioteca — versão mínima

Projeto Java para trio com 3 CRUDs: **Livros, Usuários e Empréstimos**.

## Executar
```bash
javac -d out src/model/*.java src/repository/*.java src/controller/*.java src/view/*.java
java -cp out view.Main
```

## Texto curto para o documento
O sistema de biblioteca foi desenvolvido em Java para realizar o cadastro de **livros, usuários e empréstimos**. Cada cadastro possui as operações CRUD: criar, listar, atualizar e excluir. O sistema possui uma interface gráfica simples em Java Swing e armazena os dados em memória. O principal usuário é o responsável pela biblioteca.

### Padrões usados
Em todos os três cadastros foram usados os mesmos padrões:

- **GoF Singleton:** `BibliotecaRepository` garante um único local de armazenamento.
- **GoF Strategy:** `ValidacaoStrategy` separa a regra de validação do CRUD.
- **GRASP Controller:** cada cadastro possui seu próprio Controller.
- **GRASP Low Coupling:** a tela usa os Controllers e não acessa diretamente o repositório.

Assim, cada cadastro possui **2 padrões GoF e 2 GRASP**, como solicitado.
