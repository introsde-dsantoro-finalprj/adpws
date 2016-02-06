package introsde.dsantoro.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import introsde.dsantoro.foodessentials.FoodessentialsClient;
import introsde.dsantoro.model.Meal;

public class AdpDaoImpl implements AdpDao {

	@Override
	public Collection<Meal> searchMeals(String key, int start, int num) {
		List<Meal> meals = new ArrayList<Meal>();
		FoodessentialsClient foodClient = new FoodessentialsClient();
		JSONArray prodArray = foodClient.searchFoods(key, start, num).getJSONArray("productsArray");
		for (int i = 0 ; i < prodArray.length(); i++) {
			String prodCalories = null;
			String prodName = null;
			try {
				JSONObject obj = prodArray.getJSONObject(i);
		        prodName = obj.getString("product_name");
		        String prodUpc = obj.getString("upc");
		        obj = (JSONObject) foodClient.getFood(prodUpc).getJSONObject("product").getJSONArray("nutrients").getJSONObject(0);		        		       
		        if (obj.getString("nutrient_name").equals("Calories")) {
		        	prodCalories = obj.getString("nutrient_value").split("\\.")[0];
		        	//prodCalories = prodCalories.split(".")[0];
		        }		        
		     } catch (JSONException e) {
		         throw new RuntimeException(e);
		     }
			Meal m = new Meal(prodName, prodCalories);
			meals.add(m);			
	    }
		return meals;
	}

	@Override
	public String getMotivationalPhrase() {
		// TODO Auto-generated method stub		
		return null;
	}
}
