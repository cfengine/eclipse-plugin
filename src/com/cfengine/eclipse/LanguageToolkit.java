package com.cfengine.eclipse;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

public class LanguageToolkit extends AbstractLanguageToolkit {

	private static LanguageToolkit toolkit;
	
	@Override
	public String getLanguageContentType() {
		return "com.cfengine.eclipse.content-type";
	}

	@Override
	public String getLanguageName() {
		return "CFEngine";
	}

	@Override
	public String getNatureId() {
		return Nature.CFENGINE_NATURE;
	}

	public static IDLTKLanguageToolkit getDefault() {
		if (toolkit == null)
			toolkit = new LanguageToolkit();
		
		return toolkit;
	}

}
