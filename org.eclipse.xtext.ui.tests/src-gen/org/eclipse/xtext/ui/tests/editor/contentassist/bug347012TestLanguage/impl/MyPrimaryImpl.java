/**
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPrimary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Primary</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MyPrimaryImpl extends MinimalEObjectImpl.Container implements MyPrimary
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyPrimaryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Bug347012TestLanguagePackage.Literals.MY_PRIMARY;
  }

} //MyPrimaryImpl