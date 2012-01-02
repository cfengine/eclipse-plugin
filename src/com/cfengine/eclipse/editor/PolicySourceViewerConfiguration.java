package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.ScriptPresentationReconciler;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.SingleTokenScriptScanner;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

public class PolicySourceViewerConfiguration extends ScriptSourceViewerConfiguration
{
	private AbstractScriptScanner commentScanner;
	private AbstractScriptScanner stringScanner;
	private AbstractScriptScanner codeScanner;

	public PolicySourceViewerConfiguration(IColorManager colorManager,
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		super(colorManager, preferenceStore, editor, partitioning);
		
		commentScanner = new SingleTokenScriptScanner(colorManager, preferenceStore, PolicyPartitions.CFENGINE_COMMENT);
		stringScanner = new SingleTokenScriptScanner(colorManager, preferenceStore, PolicyPartitions.CFENGINE_STRING);
		codeScanner = new PolicyCodeScanner(colorManager, preferenceStore);
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) 
	{
		PresentationReconciler reconciler = new ScriptPresentationReconciler();
		reconciler.setDocumentPartitioning(this.getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(this.codeScanner);
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		dr = new DefaultDamagerRepairer(this.stringScanner);
		reconciler.setDamager(dr, PolicyPartitions.CFENGINE_STRING);
		reconciler.setRepairer(dr, PolicyPartitions.CFENGINE_STRING);

		dr = new DefaultDamagerRepairer(this.commentScanner);
		reconciler.setDamager(dr, PolicyPartitions.CFENGINE_COMMENT);
		reconciler.setRepairer(dr, PolicyPartitions.CFENGINE_COMMENT);

		return reconciler;
	}

	@Override
	protected ContentAssistPreference getContentAssistPreference() {
		return PolicyContentAssistPreference.getDefault();
	}
}
