package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.ast.parser.ISourceParserFactory;

public class PolicySourceParserFactory implements ISourceParserFactory
{
	@Override
	public ISourceParser createSourceParser()
	{
		return new PolicySourceParser();
	}

}
