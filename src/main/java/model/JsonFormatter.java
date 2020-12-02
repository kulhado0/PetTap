/*
 * @author: Grupo Tutorias
 */

package model;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;


public interface JsonFormatter {
	public JSONObject toJson();
	
	public default JSONArray toJsonArray() {
		return new JSONArray().put(toJson());
	}
	
}