package com.cfengine.eclipse.dom;

public class StringRVal implements RVal 
{
	private final String value;
	
	public StringRVal(String value)
	{
		this.value = value;
	}
}
