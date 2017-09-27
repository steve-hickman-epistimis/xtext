/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.domainmodel.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.example.domainmodel.ui.internal.DomainmodelActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class DomainmodelExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(DomainmodelActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		DomainmodelActivator activator = DomainmodelActivator.getInstance();
		return activator != null ? activator.getInjector(DomainmodelActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_DOMAINMODEL_DOMAINMODEL) : null;
	}

}
