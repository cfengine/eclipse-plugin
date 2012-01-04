package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.AbstractSourceParser;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

import com.cfengine.eclipse.PolicyParser;
import com.cfengine.eclipse.Promises;
import com.cfengine.eclipse.dom.Policy;
import com.cfengine.eclipse.dom.PolicyElement;

public class PolicySourceParser extends AbstractSourceParser 
{

	@Override
	public IModuleDeclaration parse(IModuleSource source, IProblemReporter reporter) 
	{
		final String workspacePath = source.getModelElement().getResource().getWorkspace().getRoot().getLocation().toOSString();

		final Policy policy = PolicyParser.parse(Promises.parsePolicy(workspacePath + source.getFileName()));
		
		ModuleDeclaration module = new ModuleDeclaration(source.getSourceContents().length());
		for (PolicyElement element : policy.getChilds())
		{
			module.addStatement(element);
		}
		
		return module;
	}

}
