# API Tarefas
Uma aplicação desenvolvida em Spring Boot que fornece uma API REST para gerenciar tarefas e suas respectivas categorias. A aplicação permite criar, ler, atualizar e deletar tarefas e categorias.

##  :clipboard:  Funcionalidades
- **CRUD de Tarefas:** Criação, leitura, atualização e exclusão de tarefas.
- **CRUD de Categorias:** Criação, leitura, atualização e exclusão de categorias.
- **Associação de Tarefas com Categorias:** Cada tarefa pode ser associada a uma categoria específica.

## :wrench: Tecnologias utilizadas:
- Spring Boot
- Maven
- JDBC
- MySQL
- Swagger

## Endpoints
### Tarefas
- **Cadastrar tarefa**:
  *POST /api/tarefas*
  ```json
  {
    "nome": "Nome da Tarefa",
    "data": "YYYY-MM-DD",
    "descricao": "Descricao da Tarefa",
    "categoriaId": 0
  }
  ```
- **Buscar tarefa por ID**:
    *GET /api/tarefas/{id}*  
- **Buscar tarefas por data**:
    *GET /api/tarefas/{dataMin}{dataMax}*  
- **Excluir uma tarefa**:
    *DELETE /api/tarefas/{id}*
- **Atualizar tarefa**:
    *PUT /api/tarefas/{id}*
  ```json
  {
    "nome": "Nome da Tarefa",
    "data": "YYYY-MM-DD",
    "descricao": "Descricao da Tarefa",
    "categoriaId": 0
  }
  ``` 

### Categorias
- **Cadastrar categoria**:
  *POST /api/categorias*
  ```json
  {
    "nome": "string"
  }
  ```
- **Buscar categoria por ID**:
  *GET /api/categorias/{id}*
- **Buscar todas as categorias**:
  *GET /api/categorias*
- **Excluir uma categoria**:
  *DELETE /api/categorias/{id}*
- **Atualizar uma categoria**:
  *PUT /api/categorias/{id}*
  ```json
  {
    "nome": "string"
  }
  ```
  
    
