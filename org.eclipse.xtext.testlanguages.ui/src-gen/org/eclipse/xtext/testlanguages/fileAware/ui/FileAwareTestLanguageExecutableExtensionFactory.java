/*
 * generated by Xtext
 */
package org.eclipse.xtext.testlanguages.fileAware.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.testlanguages.ui.internal.TestlanguagesActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class FileAwareTestLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(TestlanguagesActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		TestlanguagesActivator activator = TestlanguagesActivator.getInstance();
		return activator != null ? activator.getInjector(TestlanguagesActivator.ORG_ECLIPSE_XTEXT_TESTLANGUAGES_FILEAWARE_FILEAWARETESTLANGUAGE) : null;
	}

}
