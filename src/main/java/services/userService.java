package services;

import DAO.DAOUser;
import model.*;

public class userService {
	private DAOUser conexao;
	
	public userService ( ) {
		conexao = new DAOUser();
	}
	
	public Object getAllUserLogs ( ) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar( );
		if (conexao.getAll() != null) {
			User[] us = conexao.getAll();
			for (int i = 0; i < us.length; i++) {
				if (i != us.length - 1) {
					returnValue.append(us[i].toJson()+",");
				} else {
					returnValue.append(us[i].toJson());
				}
			}
		}
		returnValue.append("]");
		conexao.close( );
		return returnValue.toString( ); 
	}
}
