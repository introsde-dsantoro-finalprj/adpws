package introsde.dsantoro.test;

import introsde.dsantoro.dao.AdpDaoImpl;

public class FoodApiTester {
	public static void main(String[] args) {
		AdpDaoImpl adpDao = new AdpDaoImpl();
		System.out.println(
				adpDao.searchMeals("orange juice", 20, 50).toString()
				);
		
	}
}
