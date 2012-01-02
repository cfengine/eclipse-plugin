package com.cfengine.eclipse;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.ui.editors.text.EditorsUI;

import com.cfengine.eclipse.editor.Colors;
import com.cfengine.eclipse.editor.PolicyPartitions;
import com.cfengine.eclipse.editor.PolicyParts;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences()
	{
		final IPreferenceStore store = Plugin.getDefault().getPreferenceStore();
		
		EditorsUI.useAnnotationsPreferencePage(store);
		EditorsUI.useQuickDiffPreferencePage(store);
		
		PreferenceConstants.initializeDefaultValues(store);
		
		PreferenceConverter.setDefault(store, PolicyPartitions.CFENGINE_COMMENT, Colors.GREEN);
		PreferenceConverter.setDefault(store, PolicyPartitions.CFENGINE_STRING, Colors.GREEN);
		PreferenceConverter.setDefault(store, PolicyParts.CFENGINE_KEYWORD, Colors.BLUE);
		PreferenceConverter.setDefault(store, PolicyParts.CFENGINE_BUNDLE_TYPE, Colors.BLUE);
		PreferenceConverter.setDefault(store, PolicyParts.CFENGINE_BODY_TYPE, Colors.BLUE);
		PreferenceConverter.setDefault(store, PolicyParts.CFENGINE_PROMISE_TYPE, Colors.BLUE);
		
		
		store.setDefault(PolicyParts.CFENGINE_KEYWORD + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
		store.setDefault(PolicyParts.CFENGINE_BUNDLE_TYPE + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
		store.setDefault(PolicyParts.CFENGINE_BODY_TYPE + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
	}
}
