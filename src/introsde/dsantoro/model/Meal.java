package introsde.dsantoro.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String calories;
	
	public Meal() {		
	}
	
	public Meal(String name, String calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}
	
}
