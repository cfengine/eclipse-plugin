package com.cfengine.eclipse.dom;

public class Body extends PolicyElement 
{
	private final String type;
	
	public Body(int start, int end, String name, String type) {
		super(start, end, name);
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
}
