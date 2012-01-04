package com.cfengine.eclipse.dom;

import java.util.List;

public class StringListRVal implements RVal
{
	private final List<String> value;
	
	public StringListRVal(List<String> value)
	{
		this.value = value;
	}
}
