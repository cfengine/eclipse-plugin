package com.cfengine.eclipse.editor;

import org.eclipse.dltk.compiler.SourceElementRequestVisitor;
import org.eclipse.dltk.core.AbstractSourceElementParser;

import com.cfengine.eclipse.Nature;

public class PolicySourceElementParser extends AbstractSourceElementParser
{
	protected SourceElementRequestVisitor createVisitor() {
		return new PolicySourceElementRequestor(getRequestor());
	}
	
	@Override
	protected String getNatureId() 
	{
		return Nature.CFENGINE_NATURE;
	}

}
