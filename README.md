# API Tarefas
[🇺🇸 Read in English](#task-api) 

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

### Categorias
| Método | Endpoint             | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/categorias`      | Registra uma nova categoria       |
| GET    | `/api/categorias`      | Consulta todas as categorias   |
| GET    | `/api/categorias/{id}` | Consulta uma categoria através do ID |
| PUT    | `/api/categorias/{id}` | Atualiza uma categoria        |
| DELETE | `/api/categorias/{id}` | Remove uma categoria        |

## Instalação

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
```

### 1. Clone o repositório:
```bash
   git clone https://github.com/samuelmsilva2v/apiTarefas.git
   cd apiTarefas
```
### 2. Instalando as dependências e compilando o projeto com Maven:
```bash
./mvnw clean install
```
### 3. Executando a aplicação:
```bash
./mvnw spring-boot:run
```
#### A aplicação vai rodar em http://localhost:8080/swagger-ui/index.html#



## API rodando integrada com o front-end
![Cadastro de categoria](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225229.png)
![Consulta de categorias](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225312.png)
![Cadastro de tarefa](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225329.png)
![Consulta de tarefas](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225420.png)
<br>
<br>
[Repositório do front-end](https://github.com/samuelmsilva2v/webTarefas)

---

# Task API  
[🇧🇷 Leia em Português](#api-tarefas) 

A RESTful API developed in Spring Boot for task management. The application allows you to create, read, update, and delete tasks and their respective categories.  

## Features  
- **Task CRUD:** Create, read, update, and delete tasks.  
- **Category CRUD:** Create, read, update, and delete categories.  
- **Task-Category Association:** Each task can be associated with a specific category.  

## Technologies Used  
- Java 17  
- Spring Boot  
- Maven  
- JDBC  
- MySQL  
- Swagger  

## Endpoints  

### Tasks  
| Method | Endpoint                        | Description                                  |  
|--------|---------------------------------|----------------------------------------------|  
| POST   | `/api/tarefas`                  | Registers a new task                         |  
| GET    | `/api/tarefas`                  | Retrieves all tasks                          |  
| GET    | `/api/tarefas/{dataMin}/{dataMax}` | Retrieves tasks within a specific date range  |  
| PUT    | `/api/tarefas/{id}`             | Updates a task                               |  
| DELETE | `/api/tarefas/{id}`             | Removes a task                               |  

### Categories  
| Method | Endpoint                        | Description                                  |  
|--------|---------------------------------|----------------------------------------------|  
| POST   | `/api/categorias`               | Registers a new category                     |  
| GET    | `/api/categorias`               | Retrieves all categories                     |  
| GET    | `/api/categorias/{id}`          | Retrieves a category by ID                   |  
| PUT    | `/api/categorias/{id}`          | Updates a category                           |  
| DELETE | `/api/categorias/{id}`          | Removes a category                           |  

## Installation  

### Script to Create the Database in MySQL  
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
```

### 1. Clone the Repository:
```bash
   git clone https://github.com/samuelmsilva2v/apiTarefas.git
   cd apiTarefas
```

### 2. Install Dependencies and Build the Project with Maven:
```bash
./mvnw clean install
```

### 3. Run the Application:
```bash
./mvnw spring-boot:run
```

#### The application will be available at: http://localhost:8080/swagger-ui/index.html#

## API Running Integrated with the Front-End
![Cadastro de categoria](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225229.png)
![Consulta de categorias](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225312.png)
![Cadastro de tarefa](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225329.png)
![Consulta de tarefas](https://github.com/samuelmsilva2v/assets/blob/main/apiTarefas/Captura%20de%20tela%202024-10-31%20225420.png)
<br>
<br>
[Front-end Repository](https://github.com/samuelmsilva2v/webTarefas)
