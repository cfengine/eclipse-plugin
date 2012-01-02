package com.cfengine.eclipse.dom;

import java.util.ArrayList;
import java.util.List;

public class PolicyElement
{
	private final int offset;
	private final List<PolicyElement> children = new ArrayList<PolicyElement>();
	
	public PolicyElement(int offset)
	{
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public List<PolicyElement> getChildren() {
		return children;
	}
}
