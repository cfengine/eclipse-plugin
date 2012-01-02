package com.cfengine.eclipse.wizard;

import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.wizards.GenericDLTKProjectWizard;
import org.eclipse.dltk.ui.wizards.ProjectWizard;
import org.eclipse.dltk.ui.wizards.ProjectWizardFirstPage;
import org.eclipse.dltk.ui.wizards.ProjectWizardSecondPage;
import org.eclipse.jface.wizard.IWizardPage;

import com.cfengine.eclipse.Nature;

public class NewPolicyProject extends ProjectWizard
{
	public NewPolicyProject()
	{
		setDialogSettings(DLTKUIPlugin.getDefault().getDialogSettings());
		setWindowTitle("New CFEngine Policy Project");
	}
	
	@Override
	public void addPages()
	{
		super.addPages();
		
		final ProjectWizardFirstPage firstPage = new ProjectWizardFirstPage() {
			@Override
			protected boolean supportInterpreter() {
				return false;
			}
		};
		
		final ProjectWizardSecondPage secondPage = new ProjectWizardSecondPage(firstPage);
		
		addPage(firstPage);
		addPage(secondPage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page)
	{
		return null;
	}
	
	@Override
	public String getScriptNature() {
		return Nature.CFENGINE_NATURE;
	}

}
