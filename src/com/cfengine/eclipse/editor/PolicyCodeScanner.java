package com.cfengine.eclipse.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import com.cfengine.eclipse.Promises;

public class PolicyCodeScanner extends AbstractScriptScanner
{
	public PolicyCodeScanner(IColorManager manager, IPreferenceStore store) {
		super(manager, store);
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		return PolicyParts.CFENGINE_POLICY_PARTS;
	}

	@Override
	protected List<IRule> createRules() 
	{
		final List<IRule> rules = new ArrayList<IRule>();
				
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		
		final WordRule keywordRule = new WordRule(new IdentifierDetector());
		for (String keyword : Promises.keywords())
			keywordRule.addWord(keyword, getToken(PolicyParts.CFENGINE_KEYWORD));
		rules.add(keywordRule);
		
		final WordRule bundleTypeRule = new WordRule(new IdentifierDetector());
		for (String bundleType : Promises.bundleTypes())
			bundleTypeRule.addWord(bundleType, getToken(PolicyParts.CFENGINE_BUNDLE_TYPE));
		rules.add(bundleTypeRule);
		
		final WordRule bodyTypeRule = new WordRule(new IdentifierDetector());
		for (String bodyType : Promises.bodyTypes())
			bodyTypeRule.addWord(bodyType, getToken(PolicyParts.CFENGINE_BODY_TYPE));
		rules.add(bodyTypeRule);
		
		final WordRule promiseTypeRule = new WordRule(new IdentifierDetector());
		for (String promiseType : Promises.promiseTypes())
			promiseTypeRule.addWord(promiseType, getToken(PolicyParts.CFENGINE_PROMISE_TYPE));
		rules.add(promiseTypeRule);
		
		setDefaultReturnToken(getToken(PolicyParts.CFENGINE_DEFAULT));
		
		return rules;
	}
}
