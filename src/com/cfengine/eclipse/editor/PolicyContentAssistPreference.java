package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;

import com.cfengine.eclipse.Plugin;

public class PolicyContentAssistPreference extends ContentAssistPreference
{
	private static PolicyContentAssistPreference instance;
	
	public static ContentAssistPreference getDefault()
	{
		if (instance == null)
			instance = new PolicyContentAssistPreference();
		
		return instance;
	}
	
	@Override
	protected ScriptTextTools getTextTools() {
		return Plugin.getDefault().getTextTools();
	}

}
