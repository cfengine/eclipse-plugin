package com.cfengine.eclipse.dom;

public class Promise extends PolicyElement
{
	public Promise(int start, int end, String promiser)
	{
		super(start, end, promiser);
	}
	
	@Override
	public int getNameSourceEnd()
	{
		return sourceStart() + getName().length() + 1;
	}
}
