package com.cfengine.eclipse.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.utils.CorePrinter;

public abstract class PolicyElement extends ASTNode
{
	private final String name;
	private final List<PolicyElement> children = new ArrayList<PolicyElement>();
	
	public PolicyElement(int start, int end, String name)
	{
		super(start, end);
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public List<PolicyElement> getChilds()
	{
		return children;
	}
	
	@Override
	public void traverse(ASTVisitor visitor) throws Exception 
	{
		visitor.visit(this);

		for (PolicyElement child : getChilds())
			child.traverse(visitor);
		
		visitor.endvisit(this);
	}
	
	@Override
	public void printNode(CorePrinter printer)
	{
		printer.formatPrintLn(name);
	}

	public int getNameSourceEnd() {
		return sourceStart() + name.length() - 1;
	}
}
