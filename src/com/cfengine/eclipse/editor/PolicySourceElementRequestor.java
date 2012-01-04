package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.declarations.FieldDeclaration;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.SourceElementRequestVisitor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.dltk.compiler.IElementRequestor.MethodInfo;
import org.eclipse.dltk.compiler.IElementRequestor.TypeInfo;

import com.cfengine.eclipse.dom.Policy;
import com.cfengine.eclipse.dom.PolicyElement;

public class PolicySourceElementRequestor extends SourceElementRequestVisitor
{
	public PolicySourceElementRequestor(IElementRequestor requesor)
	{
		super(requesor);
	}

	@Override
	public boolean visit(ASTNode node)
	{
		final PolicyElement element = PolicyElement.class.cast(node);

		final FieldInfo info = new FieldInfo();
		info.name = element.getName();
		info.nameSourceStart = element.sourceStart();
		info.nameSourceEnd = element.getNameSourceEnd();
		
		fRequestor.enterField(info);
		
		return true;
	}
	
	@Override
	public boolean endvisit(ASTNode node)
	{
		fRequestor.exitField(0);
		return true;
	}
}
