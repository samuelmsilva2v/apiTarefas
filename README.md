# API Tarefas
API RESTful desenvolvida em Spring Boot para o gerenciamento de tarefas. A aplicação permite criar, ler, atualizar e deletar tarefas e suas respectivas categorias.


## Funcionalidades
- **CRUD de Tarefas:** Criação, leitura, atualização e exclusão de tarefas.
- **CRUD de Categorias:** Criação, leitura, atualização e exclusão de categorias.
- **Associação de Tarefas com Categorias:** Cada tarefa pode ser associada a uma categoria específica.

## Tecnologias utilizadas:
- Java 17
- Spring Boot
- Maven
- JDBC
- MySQL
- Swagger

## Endpoints
### Tarefas
| Método | Endpoint             | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/tarefas`      | Registra uma nova tarefa       |
| GET    | `/api/tarefas`      | Consulta todas as tarefas   |
| GET    | `/api/tarefas/{dataMin}/{dataMax}` | Consulta uma tarefa através de duas datas |
| PUT    | `/api/tarefas/{id}` | Atualiza uma tarefa        |
| DELETE | `/api/tarefas/{id}` | Remove uma tarefa        |
```json
  {
    "nome": "Nome da Tarefa",
    "data": "YYYY-MM-DD",
    "descricao": "Descricao da Tarefa",
    "categoriaId": 0
  }
  ```

### Categorias
| Método | Endpoint             | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/categorias`      | Registra uma nova categoria       |
| GET    | `/api/categorias`      | Consulta todas as categorias   |
| GET    | `/api/categorias/{id}` | Consulta uma categoria através do ID |
| PUT    | `/api/categorias/{id}` | Atualiza uma categoria        |
| DELETE | `/api/categorias/{id}` | Remove uma categoria        |

## Instalação
1. Clone o repositório:
```bash
   git clone https://github.com/samuelmsilva2v/apiTarefas.git
   cd apiTarefas
```
2. Instalando as dependências e compilando o projeto com Maven:
```bash
./mvnw clean install
```
3. Executando a aplicação:
```bash
./mvnw spring-boot:run
```
A aplicação vai rodar em http://localhost:8080/swagger-ui/index.html#

### Script para criação do banco de dados no MySQL
```sql
CREATE DATABASE bd_apitarefas;

USE bd_apitarefas;

CREATE TABLE categoria(
	id			INTEGER			AUTO_INCREMENT,
	nome			VARCHAR(50)		NOT NULL,
	PRIMARY KEY(id));
	
CREATE TABLE tarefa(
	id			INTEGER			AUTO_INCREMENT,
	nome			VARCHAR(100)	NOT NULL,
	data			DATE			NOT NULL,
	descricao		VARCHAR(250)	NOT NULL,
	categoria_id	INTEGER			NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);

DESC categoria;
DESC tarefa;
    
