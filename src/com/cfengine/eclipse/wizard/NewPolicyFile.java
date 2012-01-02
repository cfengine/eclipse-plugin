package com.cfengine.eclipse.wizard;

import org.eclipse.dltk.ui.wizards.NewSourceModulePage;
import org.eclipse.dltk.ui.wizards.NewSourceModuleWizard;

import com.cfengine.eclipse.Nature;

public class NewPolicyFile extends NewSourceModuleWizard
{	
	@Override
	protected NewSourceModulePage createNewSourceModulePage() {
		
		final NewSourceModulePage firstPage = new NewSourceModulePage() {
			
			@Override
			protected String getFileName()
			{
				if (getFileText().endsWith(".cf"))
					return getFileText();
				else
					return getFileText() + ".cf";
			}
			
			@Override
			protected String getRequiredNature() {
				return Nature.CFENGINE_NATURE;
			}
			
			@Override
			protected String getPageTitle() {
				return "New CFEngine Policy File";
			}
			
			@Override
			protected String getPageDescription() {
				return "Create a new CFEngine Policy File";
			}
		};
		
		return firstPage;
	}

}
