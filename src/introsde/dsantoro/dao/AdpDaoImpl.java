package introsde.dsantoro.dao;

import org.json.JSONObject;

import introsde.dsantoro.foodessentials.FoodessentialsClient;

public class AdpDaoImpl implements AdpDao {

	@Override
	public JSONObject searchMeals(String key, int start, int num) {
		FoodessentialsClient foodClient = new FoodessentialsClient();
		return foodClient.searchFoods(key, start, num);
//		return null;
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
