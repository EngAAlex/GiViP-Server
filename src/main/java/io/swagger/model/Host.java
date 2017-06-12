package io.swagger.model;

public class Host extends Element{

	public Host(String id) {
		super(id);
	}

	private final String identifier = "host";
	
	@Override
	public String getIdentifier() {
		return identifier;
	}
}

