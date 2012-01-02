package com.cfengine.eclipse.editor;

import org.eclipse.jface.text.rules.ICharacterScanner;

public class CharacterMatcher 
{
	private final ICharacterScanner scanner;
	private int numRead = 0;
	private final IdentifierDetector idDetector = new IdentifierDetector();

	public CharacterMatcher(ICharacterScanner scanner)
	{
		this.scanner = scanner;
	}
	
	private int read()
	{
		numRead++;
		return scanner.read();
	}
	
	private void unread()
	{
		numRead--;
		scanner.unread();
	}
	
	private void unwind()
	{
		for (int i = 0; i < numRead; i++)
			unread();
	}
	
	public boolean matchIdentifier()
	{
		if (!idDetector.isWordStart((char)read()))
		{
			unread();
			return false;
		}
		
		while (idDetector.isWordPart((char)read()));

		return true;		
	}
	
	public boolean matchSequence(final String sequence)
	{
		numRead = 0;
		
		for (int i = 0; i < sequence.length(); i++)
		{
			if (sequence.charAt(i) != read())
			{
				unwind();
				return false;
			}
		}
		
		return true;
	}
}
