package com.cfengine.eclipse;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.jface.preference.IPreferenceStore;

public class UILanguageToolkit extends AbstractDLTKUILanguageToolkit
{
	@Override
	public IDLTKLanguageToolkit getCoreToolkit() {
		return LanguageToolkit.getDefault();
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return Plugin.getDefault().getPreferenceStore();
	}
}
