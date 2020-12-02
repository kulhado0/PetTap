package services;

import DAO.DAOPet;
import model.*;

public class petService {
	private DAOPet conexao;
	
	public petService ( ) {
		conexao = new DAOPet();
	}
	
	public Object getAllPetLogs ( ) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar( );
		if (conexao.getAll() != null) {
			Pet[] pt = conexao.getAll();
			for (int i = 0; i < pt.length; i++) {
				if (i != pt.length - 1) {
					returnValue.append(pt[i].toJson()+",");
				} else {
					returnValue.append(pt[i].toJson());
				}
			}
		}
		returnValue.append("]");
		conexao.close( );
		return returnValue.toString( ); 
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Object getAllPetLostLogs ( ) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar( );
		if (conexao.getAllLost() != null) {
			Pet[] pt = conexao.getAll();
			for (int i = 0; i < pt.length; i++) {
				if (i != pt.length - 1) {
					returnValue.append(pt[i].toJson()+",");
				} else {
					returnValue.append(pt[i].toJson());
				}
			}
		}
		returnValue.append("]");
		conexao.close( );
		return returnValue.toString( ); 
	}
	
	public Object getAllPetFoundLogs ( ) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar( );
		if (conexao.getAllFound() != null) {
			Pet[] pt = conexao.getAll();
			for (int i = 0; i < pt.length; i++) {
				if (i != pt.length - 1) {
					returnValue.append(pt[i].toJson()+",");
				} else {
					returnValue.append(pt[i].toJson());
				}
			}
		}
		returnValue.append("]");
		conexao.close( );
		return returnValue.toString( ); 
	}
	
}
