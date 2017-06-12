package io.swagger.model;

public class Rack extends Element{

	private final String identifier = "rack";
	
	public Rack(String id) {
		super(id);
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}
	
	

}

