package model;

import org.json.JSONObject;

public class User implements JsonFormatter {
	private int user_id;
	private int user_status;
	private String user_nome;
	private String user_telefone;
	private String user_email;
	private String user_senha;
	
	public User ( ) {
		this.user_id = -1;
		this.user_status = -1;
		this.user_nome = "";
		this.user_telefone = "";
		this.user_email = "";
		this.user_senha = "";
	}
	
	public User (int id, int status, String email, String senha, String telefone, String nome) {
		this.user_id = id;
		this.user_status = status;
		this.user_nome = nome;
		this.user_telefone = telefone;
		this.user_email = email;
		this.user_senha = senha;
	}
	
	public void setId (int id) {
		this.user_id = id;
	}
	
	public int getId ( ) {
		return user_id;
	}
	
	public void setStatus (int sta) {
		this.user_status = sta;
	}
	
	public int getStatus ( ) {
		return user_status;
	}
	
	public void setNome (String nombre) {
		this.user_nome = nombre;
	}
	
	public String getNome ( ) {
		return user_nome;
	}
	
	public void setTelefone (String tel) {
		this.user_telefone = tel;
	}
	
	public String getTelefone ( ) {
		return user_telefone;
	}
	
	public void setEmail (String eml) {
		this.user_email = eml;
	}
	
	public String getEmail ( ) {
		return user_email;
	}
	
	public void setSenha (String sen) {
		this.user_senha = sen;
	}
	
	public String getSenha ( ) {
		return user_senha;
	}
	
	/*
	 * Converte um Usuario para o formato JSON 
	*/
	public JSONObject toJson( ) {
		JSONObject obj = new JSONObject( );
		obj.put("id", this.getId());
		obj.put("nome", this.getNome());
		obj.put("email", this.getEmail());
		obj.put("telefone", this.getTelefone());
		obj.put("senha", this.getSenha());
		return obj;
	}
}
