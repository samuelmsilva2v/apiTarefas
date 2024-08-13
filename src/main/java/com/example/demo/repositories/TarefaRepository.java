package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.Tarefa;
import com.example.demo.factories.ConnectionFactory;

public class TarefaRepository {

	public void insert(Tarefa tarefa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO tarefa(nome, data, descricao, categoria_id) VALUES(?, ?, ?, ?)");
		statement.setString(1, tarefa.getNome());
		statement.setDate(2, new java.sql.Date(tarefa.getData().getTime()));
		statement.setString(3, tarefa.getDescricao());
		statement.setInt(4, tarefa.getCategoria().getId());
		statement.execute();

		connection.close();
	}

	public void update(Tarefa tarefa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("UPDATE tarefa SET nome=?, data=?, descricao=?, categoria_id=? WHERE id=?");
		statement.setString(1, tarefa.getNome());
		statement.setDate(2, new java.sql.Date(tarefa.getData().getTime()));
		statement.setString(3, tarefa.getDescricao());
		statement.setInt(4, tarefa.getCategoria().getId());
		statement.setInt(5, tarefa.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("DELETE FROM tarefa WHERE id=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public List<Tarefa> findAll(Date dataMin, Date dataMax) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String query = "SELECT t.id as idtarefa, t.nome as nometarefa, t.data, t.descricao, "
				+ "c.id as idcategoria, c.nome as nomecategoria "
				+ "FROM tarefa t INNER JOIN categoria c ON t.categoria_id = c.id WHERE t.data BETWEEN ? AND ? "
				+ "ORDER BY t.data DESC";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setDate(1, new java.sql.Date(dataMin.getTime()));
		statement.setDate(2, new java.sql.Date(dataMax.getTime()));
		ResultSet resultSet = statement.executeQuery();

		List<Tarefa> lista = new ArrayList<>();

		while (resultSet.next()) {

			Tarefa tarefa = new Tarefa();
			tarefa.setCategoria(new Categoria());

			tarefa.setId(resultSet.getInt("idtarefa"));
			tarefa.setNome(resultSet.getString("nometarefa"));
			tarefa.setData(new java.util.Date(resultSet.getDate("data").getTime()));
			tarefa.setDescricao(resultSet.getString("descricao"));
			tarefa.getCategoria().setId(resultSet.getInt("idcategoria"));
			tarefa.getCategoria().setNome(resultSet.getString("nomecategoria"));

			lista.add(tarefa);
		}

		connection.close();
		return lista;
	}

	public Tarefa findById(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		String query = "SELECT t.id as idtarefa, t.nome as nometarefa, t.data, t.descricao, "
				+ "c.id as idcategoria, c.nome as nomecategoria "
				+ "FROM tarefa t INNER JOIN categoria c ON t.categoria_id = c.id WHERE t.id = ?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		Tarefa tarefa = null;
		
		if(resultSet.next()) {
			
			tarefa = new Tarefa();
			tarefa.setCategoria(new Categoria());
			
			tarefa.setId(resultSet.getInt("idtarefa"));
			tarefa.setNome(resultSet.getString("nometarefa"));
			tarefa.setData(new java.util.Date(resultSet.getDate("data").getTime()));
			tarefa.setDescricao(resultSet.getString("descricao"));
			tarefa.getCategoria().setId(resultSet.getInt("idcategoria"));
			tarefa.getCategoria().setNome(resultSet.getString("nomecategoria"));
		}

		connection.close();
		return tarefa;
	}
}
