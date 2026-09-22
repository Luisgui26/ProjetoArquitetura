# Sistema de Gerenciamento de Biblioteca

Projeto acadêmico desenvolvido em Java com o objetivo de implementar um sistema simples de gerenciamento de biblioteca utilizando conceitos de Programação Orientada a Objetos, CRUD e padrões de projeto GoF e GRASP.

O sistema possui três cadastros principais:

* Livros
* Usuários
* Empréstimos

Cada cadastro possui as operações de Create, Read, Update e Delete (CRUD).

## Funcionalidades

### Livros

Permite realizar o gerenciamento dos livros da biblioteca.

Operações disponíveis:

* Cadastrar livro
* Listar livros
* Atualizar livro
* Excluir livro

### Usuários

Responsável pelo gerenciamento dos usuários da biblioteca.

Operações disponíveis:

* Cadastrar usuário
* Listar usuários
* Atualizar usuário
* Excluir usuário

### Empréstimos

Responsável pelo registro dos empréstimos realizados.

Operações disponíveis:

* Cadastrar empréstimo
* Listar empréstimos
* Atualizar empréstimo
* Excluir empréstimo

## Tecnologias utilizadas

* Java
* Java Swing
* Programação Orientada a Objetos

A interface gráfica foi desenvolvida utilizando Java Swing.

Os dados são armazenados em memória durante a execução do programa. Por esse motivo, ao fechar a aplicação, os registros cadastrados são apagados.

## Estrutura do projeto

O código foi separado em quatro partes principais:

```text
src/
├── model/
│   ├── Livro.java
│   ├── Usuario.java
│   └── Emprestimo.java
│
├── controller/
│   ├── LivroController.java
│   ├── UsuarioController.java
│   └── EmprestimoController.java
│
├── repository/
│   └── BibliotecaRepository.java
│
└── view/
    └── MainView.java
```

### Model

Contém as classes que representam os dados utilizados pelo sistema.

`Livro.java` representa os livros cadastrados.

`Usuario.java` representa os usuários cadastrados.

`Emprestimo.java` representa os empréstimos cadastrados.

### Controller

Os Controllers são responsáveis por coordenar as operações CRUD.

Existe um Controller para cada cadastro:

* `LivroController`
* `UsuarioController`
* `EmprestimoController`

Eles recebem as solicitações feitas pela interface e realizam as operações necessárias.

### Repository

O `BibliotecaRepository` é responsável pelo armazenamento dos livros, usuários e empréstimos durante a execução da aplicação.

### View

A classe `MainView` contém a interface gráfica do sistema, desenvolvida com Java Swing.

É através dela que o usuário pode acessar os três cadastros e realizar as operações disponíveis.

O fluxo principal da aplicação pode ser representado da seguinte forma:

```text
Usuário
   |
   v
MainView
   |
   v
Controller
   |
   v
BibliotecaRepository
```

## Padrões utilizados

Para atender aos requisitos do projeto foram utilizados dois padrões GoF e dois padrões GRASP.

Os mesmos padrões são aplicados aos três cadastros.

### GoF Singleton

O Singleton é utilizado no `BibliotecaRepository`.

Ele garante que exista apenas uma instância do repositório durante a execução do programa. Dessa forma, todos os Controllers utilizam o mesmo local de armazenamento.

### GoF Strategy

O Strategy é utilizado na validação dos dados.

A `ValidacaoStrategy` permite separar a validação das demais operações realizadas pelos Controllers.

### GRASP Controller

O padrão Controller é aplicado através das classes `LivroController`, `UsuarioController` e `EmprestimoController`.

Cada Controller fica responsável por receber e coordenar as operações relacionadas ao seu cadastro.

### GRASP Low Coupling

O princípio de Low Coupling, ou baixo acoplamento, é aplicado através da separação das responsabilidades.

A interface gráfica utiliza os Controllers para realizar as operações e não acessa diretamente o armazenamento dos dados.

Isso reduz a dependência entre as partes do sistema e facilita a compreensão do código.

## Padrões utilizados por cadastro

| Cadastro   | GoF                  | GRASP                     |
| ---------- | -------------------- | ------------------------- |
| Livro      | Singleton e Strategy | Controller e Low Coupling |
| Usuário    | Singleton e Strategy | Controller e Low Coupling |
| Empréstimo | Singleton e Strategy | Controller e Low Coupling |

Dessa forma, cada cadastro utiliza pelo menos dois padrões GoF e dois padrões GRASP.

## Como executar

É necessário possuir o Java JDK instalado no computador.

Para compilar o projeto, execute:

```bash
javac -d out src/model/*.java src/repository/*.java src/controller/*.java src/view/*.java
```

Depois da compilação, execute:

```bash
java -cp out view.MainView
```

A interface gráfica do sistema será aberta e os cadastros poderão ser utilizados.

## Objetivo acadêmico

Este projeto foi desenvolvido para demonstrar a implementação de três cadastros completos utilizando Java e Programação Orientada a Objetos.

A implementação foi mantida simples para facilitar a compreensão do funcionamento do CRUD, da divisão de responsabilidades entre as classes e da utilização dos padrões de projeto solicitados.
