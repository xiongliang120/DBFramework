package com.example.user.test;

public class Apple {
	@FruitName(value="Apple")
	public String name;
	
	@FruitColor(getColor=FruitColor.Color.GREEN)
	public String fruitColor;
	
	@FruitProvider(id=1,name="xiongliang",address="北京")
	public String provider;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFruitColor() {
		return fruitColor;
	}

	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}

	public void display(){
	}

}
