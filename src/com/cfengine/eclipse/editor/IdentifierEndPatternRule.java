package com.cfengine.eclipse.editor;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class IdentifierEndPatternRule implements IPredicateRule
{
	private final String endPattern;
	private final IToken token;
	
	public IdentifierEndPatternRule(String endPattern, IToken token)
	{
		this.endPattern = endPattern;
		this.token = token;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		return evaluate(scanner, false);
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume)
	{
		final CharacterMatcher matcher = new CharacterMatcher(scanner);
		
		if (!matcher.matchIdentifier())
			return Token.UNDEFINED;
		
		if (!matcher.matchSequence(endPattern))
			return Token.UNDEFINED;
		
		return token;
	}

	@Override
	public IToken getSuccessToken() 
	{
		return token;
	}

}
