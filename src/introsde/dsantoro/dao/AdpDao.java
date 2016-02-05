package introsde.dsantoro.dao;

import java.util.Collection;
import introsde.dsantoro.model.Meal;

public interface AdpDao {

	// Foodessentials adapter
	public Collection<Meal> searchMeals(String key, int start, int num);

	// XXXXXXXX adapter
	public String getMotivationalPhrase();
}
