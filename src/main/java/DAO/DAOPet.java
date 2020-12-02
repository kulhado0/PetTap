package DAO;

import java.sql.*;
import model.Pet;

public class DAOPet {
	private Connection conexao;
	
	public DAOPet( ) {
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
	
	public boolean add (Pet pt) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement( );
			st.executeUpdate(
					"INSERT INTO animal (pet_id, pet_nome, pet_cor, pet_tamanho, pet_especie, pet_localizacao, pet_carac_especial, pet_status)"
				+ 	"VALUES ("+pt.getId()+","+pt.getNome()+","+pt.getCor()+","+pt.getTamanho()+","+pt.getEspecie()+","+pt.getLocalizacao()+","+pt.getCE()+","+pt.getStatus()+");");
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
			st.executeUpdate("DELETE FROM animal WHERE pet_id = "+id+";");
			st.close( );
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return status;
	}
	
	public Pet[] getAll ( ) {
		Pet[] pt = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM animal ORDER BY pet_id;");
			if (rs.next()) {
				rs.last();
				pt = new Pet[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					pt[i] = new Pet (rs.getInt("pet_id"),rs.getString("pet_nome"),rs.getString("pet_cor"),rs.getString("pet_tamanho"),
									rs.getString("pet_localizacao"),rs.getString("pet_especie"),rs.getString("pet_carac_especial"),
									rs.getInt("pet_status"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pt;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PET/Animal perdido -> Status = 1
	public Pet[] getAllLost ( ) {
		Pet[] pt = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM animal WHERE pet_status = 1 ORDER BY pet_id;");
			if (rs.next()) {
				rs.last();
				pt = new Pet[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					pt[i] = new Pet (rs.getInt("pet_id"),rs.getString("pet_nome"),rs.getString("pet_cor"),rs.getString("pet_tamanho"),
									rs.getString("pet_especie"),rs.getString("pet_localizacao"),rs.getString("pet_carac_especial"),
									rs.getInt("pet_status"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pt;
	}
	
	// PET/Animal encontrado -> Status = 2
	public Pet[] getAllFound ( ) {
		Pet[] pt = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM animal WHERE pet_status = 2 ORDER BY pet_id;");
			if (rs.next()) {
				rs.last();
				pt = new Pet[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					pt[i] = new Pet (rs.getInt("pet_id"),rs.getString("pet_nome"),rs.getString("pet_cor"),rs.getString("pet_tamanho"),
									rs.getString("pet_especie"),rs.getString("pet_localizacao"),rs.getString("pet_carac_especial"),
									rs.getInt("pet_status"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pt;
	}
		
}