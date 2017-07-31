package com.coderising.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Picture implements Shape{

	List<Shape> shapes = new ArrayList<>();
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for(Shape shape : shapes) {
			shape.draw();
		}
	}
	
	public void add(Shape shape) {
		shapes.add(shape);
	}
	
	public static void main(String[] args) {
		Picture aPicture = new Picture();
		aPicture.add(new Rectangle());
		aPicture.add(new Line());
		
		Picture p = new Picture();
		p.add(new Text());
		p.add(new Line());
		p.add(new Square());
		aPicture.add(p);
		aPicture.draw();
	}
	
}
