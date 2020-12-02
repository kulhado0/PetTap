package DAO;

import java.sql.*;

import model.User;

public class DAOUser {
	private Connection conexao;
	
	public DAOUser( ) {
		conexao = null;
	}
	
	public boolean conectar ( ) {
		boolean status = false;
		try {
			Class.forName(CredenciaisDB.driverName);
			conexao = DriverManager.getConnection(CredenciaisDB.url, CredenciaisDB.username, CredenciaisDB.password);
			status = (conexao == null);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver nao encontrado - Conexao nao efetuada com o postgres");
		} catch (SQLException e) {
			System.err.println("Conexao nao efetuada com o postgres");
		}
		return status;
	}
	
	public boolean close ( ) {
		boolean status = false;
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
		}
		return status;
	}
	
	public boolean add (User us) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement( );
			st.executeUpdate(
					"INSERT INTO usuario (user_nome, user_id, user_email, user_senha, user_telefone, user_status)"
				+ 	"VALUES ("+us.getNome()+","+us.getId()+","+us.getEmail()+","+us.getSenha()+","+us.getTelefone()+","+us.getStatus()+");");
			st.close( );
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}
	
	public boolean delete (int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement( );
			st.executeUpdate("DELETE FROM usuario WHERE user_id = "+id+";");
			st.close( );
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}
	
	public User[] getAll ( ) {
		User[] us = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario ORDER BY user_id;");
			if (rs.next()) {
				rs.last();
				us = new User[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					us[i] = new User (rs.getInt("user_id"),rs.getInt("user_status"),rs.getString("usert_email"),rs.getString("user_senha"),
							rs.getString("user_telefone"),rs.getString("user_nome"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return us;
	}
}
