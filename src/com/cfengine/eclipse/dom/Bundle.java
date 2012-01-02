package com.cfengine.eclipse.dom;

public class Bundle extends PolicyElement 
{
	private final String name;
	private final String type;
	
	public Bundle(int offset, String name, String type)
	{
		super(offset);
		this.name = name;
		this.type = type;
	}

	public String getName() 
	{
		return name;
	}

	public String getType() 
	{
		return type;
	}
}
