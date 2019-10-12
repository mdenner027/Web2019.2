package br.com.agenda.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.modelo.Contato;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public void adicionaContato(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("Insert into "
					+ "contatos(nome, email, endereco, dataNascimento) "
					+ "Values(?,?,?,?)");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Contato> getListaContatos() {
		List<Contato> contatos = new ArrayList<>();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("endereco"));
				Date data = rs.getDate("dataNascimento");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
				contato.setDataNascimento(dataNascimento);
				contatos.add(contato);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contatos;
	}

	public void alterarContato(Contato contato) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE Contatos " + "SET "
							+ "	nome = ?, " + "	endereco = ?, "
							+ "	email = ?, " + "	dataNascimento = ? "
							+ "WHERE id = ?");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			stmt.setString(3, contato.getEmail());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirContato(String id) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM CONTATOS " + "WHERE id = ?");
			stmt.setLong(1, Long.parseLong(id));
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Contato getContatoById(String id) {
		Contato contato = new Contato();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM Contatos WHERE id = ?");
			stmt.setLong(1, Long.parseLong(id));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("Email"));
				contato.setEndereco(rs.getString("endereco"));
				Date data = rs.getDate("dataNascimento");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
				contato.setDataNascimento(dataNascimento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}
}
