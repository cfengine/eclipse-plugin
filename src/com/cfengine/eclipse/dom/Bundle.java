package com.cfengine.eclipse.dom;

public class Bundle extends PolicyElement 
{
	private final String type;
	
	public Bundle(int start, int end, String name, String type)
	{
		super(start, end, name);
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
}
