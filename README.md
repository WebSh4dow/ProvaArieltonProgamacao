# Sistema de Agenda de Contatos em JavaFX com MySQL

## Descrição

Este é um sistema de agenda de contatos desenvolvido em JavaFX, utilizando MySQL como banco de dados. O sistema permite incluir, editar, remover, listar e pesquisar contatos.

## Requisitos

- Java 8 ou superior
- JavaFX
- MySQL
- Conexão com a internet para configurar o banco de dados

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL chamado `agenda_contatos`.
2. Execute o script SQL fornecido em `script_banco.sql` para criar a tabela `contatos`.
3. Configure as informações de conexão com o banco de dados no arquivo `src/main/resources/config.properties`.

## Execução do Sistema

1. Abra o projeto em sua IDE favorita.
2. Certifique-se de que as dependências estão configuradas corretamente.
3. Execute a classe `MainApp.java` para iniciar o aplicativo.

## Funcionalidades

### Incluir Contato

- [ ] Abra a aplicação.
- [ ] Clique no botão "Incluir Contato".
- [ ] Preencha os campos obrigatórios.
- [ ] Clique no botão "Salvar".

### Editar Contato

- [ ] Selecione um contato na lista com o botão direito do mouse.
- [ ] Clique no botão "Editar Contato".
- [ ] Faça as alterações desejadas.
- [ ] Clique no botão "Salvar".

### Remover Contato

- [ ] Selecione um contato na lista com o botão direito do mouse.
- [ ] Clique no botão "Remover Contato".
- [ ] Confirme a exclusão.

### Listar Contatos

- [ ] Abra a aplicação.
- [ ] Observe a lista de contatos exibida.

### Pesquisar Contato

- [ ] Digite o nome ou parte do nome na barra de pesquisa.
- [ ] Observe a lista de contatos filtrada.
