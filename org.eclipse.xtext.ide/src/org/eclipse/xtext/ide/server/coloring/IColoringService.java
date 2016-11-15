/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.coloring;

import org.eclipse.lsp4j.ColoringParams;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * Representation of a generic, IDE independent coloring service. Provides
 * coloring and highlighting information for clients based on the underlying
 * model.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@ImplementedBy(IColoringService.Noop.class)
public interface IColoringService {

	/**
	 * Provides all available coloring information for the resource.
	 * 
	 * @param resource
	 *            the resource that will be highlighted. May be {@code null} in
	 *            some rare cases.
	 * @param document
	 *            the IDE and Xtext independent document that can be used to
	 *            convert the document based offsets to line based positions.
	 * @return the coloring and highlighting proposal for the resource.
	 */
	ColoringParams getColoring(XtextResource resource, Document document);

	/**
	 * NOOP {@link IColoringService coloring service} implementation. Always
	 * provides an {@link IColoringService#EMPTY empty} instance.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	public static class Noop implements IColoringService {

		@Override
		public ColoringParams getColoring(final XtextResource resource, final Document document) {
			return ColoringParamsExtensions.emptyColoringParams(resource);
		}

	}
}
