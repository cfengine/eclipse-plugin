package com.cfengine.eclipse;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.cfengine.eclipse.editor.PolicyTextTools;

public class Plugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.cfengine.eclipse";
	private static Plugin plugin;
	
	private PolicyTextTools textTools;
	
	public Plugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Plugin getDefault() {
		return plugin;
	}

	public synchronized ScriptTextTools getTextTools() {
		if (textTools == null)
			textTools = new PolicyTextTools(true);
		
		return textTools;
	}
}
