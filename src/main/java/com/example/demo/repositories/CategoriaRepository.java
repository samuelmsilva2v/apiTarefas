package com.example.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Categoria;
import com.example.demo.factories.ConnectionFactory;

public class CategoriaRepository {

	public void insert(Categoria categoria) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("INSERT INTO categoria(nome) VALUES(?)");
		statement.setString(1, categoria.getNome());
		statement.execute();
		
		connection.close();
	}

	public void update(Categoria categoria) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("UPDATE categoria SET nome=? WHERE id=?");
		statement.setString(1, categoria.getNome());
		statement.setInt(2, categoria.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("DELETE FROM categoria WHERE id=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public List<Categoria> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT nome, id FROM categoria"); 
		ResultSet resultSet = statement.executeQuery();
		
		List<Categoria> lista = new ArrayList<>();
		
		while(resultSet.next()) {
			
			Categoria categoria = new Categoria();
			
			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));
			
			lista.add(categoria);
		}

		connection.close();
		return lista;
	}

	public Categoria findById(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT id, nome FROM categoria WHERE id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		Categoria categoria = null;
		
		if(resultSet.next()) {
			
			categoria = new Categoria();
			
			categoria.setId(resultSet.getInt("id"));
			categoria.setNome(resultSet.getString("nome"));
		}

		connection.close();
		return categoria;
	}

}
