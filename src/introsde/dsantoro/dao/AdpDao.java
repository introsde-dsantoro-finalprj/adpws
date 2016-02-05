package introsde.dsantoro.dao;

import org.json.JSONObject;

public interface AdpDao {

	// Foodessentials adapter
	public JSONObject searchMeals(String key, int start, int num);

	// XXXXXXXX adapter
	public String getMotivationalPhrase();
}
