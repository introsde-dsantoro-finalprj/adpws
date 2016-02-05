package introsde.dsantoro.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import introsde.dsantoro.foodessentials.FoodessentialsClient;

public class AdpDaoImpl implements AdpDao {

	@Override
	public JSONObject searchMeals(String key, int start, int num) {
		FoodessentialsClient foodClient = new FoodessentialsClient();
		JSONArray prodArray = foodClient.searchFoods(key, start, num).getJSONArray("productsArray");
				
		for (int i = 0 ; i < prodArray.length(); i++) {
	        JSONObject obj = prodArray.getJSONObject(i);
	        String prodName = obj.getString("product_name");
	        String prodUpc = obj.getString("upc");
	        obj = (JSONObject) getMeal(prodUpc).getJSONObject("product").getJSONArray("nutrients").getJSONObject(0);
	        System.out.println(prodName);
	        System.out.println(prodUpc);
	        System.out.println(obj.getString("nutrient_value"));	        
	    }
		return null;
	}

	@Override
	public String getMotivationalPhrase() {
		// TODO Auto-generated method stub		
		return null;
	}
	
	private JSONObject getMeal(String mealId) {
		FoodessentialsClient foodClient = new FoodessentialsClient();
		return foodClient.getFood(mealId);
//		return null;
	}

}
