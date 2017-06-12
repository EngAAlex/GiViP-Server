package io.swagger.model;

import java.util.ArrayList;

public abstract class Element {
	
	String id;
//	String name;
	ArrayList<Element> children;

	public Element(String id) {
		children = new ArrayList<Element>();
//		this.name = name;
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
		
	public abstract String getIdentifier();
	
	public void addChild(Element child){
		children.add(child);		
	}
	
	public ArrayList<Element> getChildren(){
		return children;
	}
	
	

}
