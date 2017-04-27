/*******************************************************************************
 * Copyright (c) 2010-2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.XtypeRuntimeModule;
import org.eclipse.xtext.xbase.XtypeStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class XtypeIdeSetup extends XtypeStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new XtypeRuntimeModule(), new XtypeIdeModule()));
	}
	
}
