package io.swagger.model;

public class Worker extends Element{
	
	private final String identifier = "worker";	
	
	public Worker(String id) {
		super(id);
	}
	
	@Override
	public String getIdentifier() {
		return identifier;
	}

	
	
}

