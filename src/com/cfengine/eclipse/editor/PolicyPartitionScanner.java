package com.cfengine.eclipse.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class PolicyPartitionScanner extends RuleBasedPartitionScanner
{
	public PolicyPartitionScanner()
	{
		IToken string = new Token(PolicyPartitions.CFENGINE_STRING);
		IToken comment = new Token(PolicyPartitions.CFENGINE_COMMENT);

		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();

		rules.add(new EndOfLineRule("#", comment));
		rules.add(new SingleLineRule("\'", "\'", string, '\\'));
		rules.add(new SingleLineRule("\"", "\"", string, '\\'));

		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}	
}
