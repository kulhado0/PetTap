package app;
import static spark.Spark.*;
import services.*;

public class Main {

	private final static petService  ptService = new petService( );
	private final static userService usService = new userService( );
	
	public static void main(String[] args) {
		
		port(5432);
		
		options ("/*", (request, response) -> {
			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}
			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Method", accessControlRequestMethod);
			}
			return "ok";
		});
		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// CONEXOES DE ANIMAL/PET
		// Todos
		get("/animal/getAll", (resquest, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return ptService.getAllPetLogs();
		});
		// Apenas os perdidos
		get("/animal/getAllLost", (resquest, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return ptService.getAllPetLostLogs();
		});
		// Apenas os encontrados
		get("/animal/getAllFound", (resquest, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return ptService.getAllPetFoundLogs();
		});
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// CONEXOES DE USUARIO
		get("/usuario/getAll", (resquest, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return usService.getAllUserLogs();
		});
		
	}

}
