package model;

import org.json.JSONObject;

public class Pet implements JsonFormatter {
	private int pet_id;
	private String pet_nome;
	private String pet_cor;
	private String pet_tamanho;
	private String pet_localizacao;
	private String pet_especie;
	private String pet_carac_especial;
	private int pet_status;
	
	public Pet ( ) {
		this.pet_id = -1;
		this.pet_nome = "";
		this.pet_cor = "";
		this.pet_tamanho = "";
		this.pet_localizacao = "";
		this.pet_especie = "";
		this.pet_carac_especial = "";
		this.pet_status = -1;
	}
	
	public Pet (int id, String nome, String cor, String size, String local, String esp, String CE, int status) {
		this.pet_id = id;
		this.pet_nome = nome;
		this.pet_cor = cor;
		this.pet_tamanho = size;
		this.pet_localizacao = local;
		this.pet_especie = esp;
		this.pet_carac_especial = CE;
		this.pet_status = status;
	}
	
	public int getId ( ) {
		return pet_id;
	}
	
	public void setId (int id) {
		this.pet_id = id;
	}
	
	public int getStatus ( ) {
		return pet_status;
	}
	
	public void setStatus (int sta) {
		this.pet_status = sta;
	}
	
	public String getNome ( ) {
		return pet_nome;
	}
	
	public void setNome (String nome) {
		this.pet_nome = nome;
	}
	
	public String getCor ( ) {
		return pet_cor;
	}
	
	public void setCor (String cor) {
		this.pet_cor = cor;
	}
	
	public String getTamanho ( ) {
		return pet_tamanho;
	}
	
	public void setTamanho (String size) {
		this.pet_tamanho = size;
	}
	
	public String getLocalizacao ( ) {
		return pet_localizacao;
	}
	
	public void setLocalizacao (String local) {
		this.pet_localizacao = local;
	}
	
	public String getEspecie ( ) {
		return pet_especie;
	}
	
	public void setEspecie (String esp) {
		this.pet_especie = esp;
	}
	
	public String getCE ( ) {
		return pet_carac_especial;
	}
	
	public void setCE (String ce) {
		this.pet_carac_especial = ce;
	}
	
	/*
	 * Converte um PET/Animal para o formato JSON 
	*/
	public JSONObject toJson( ) {
		JSONObject obj = new JSONObject( );
		obj.put("id", this.getId());
		obj.put("especie", this.getEspecie());
		obj.put("nome", this.getNome());
		obj.put("tamanho", this.getTamanho());
		obj.put("cor", this.getCor());
		obj.put("localizacao", this.getLocalizacao());
		obj.put("caracteristica_especial", this.getCE());
		obj.put("status", this.getStatus());
		return obj;
	}
	
	
}
