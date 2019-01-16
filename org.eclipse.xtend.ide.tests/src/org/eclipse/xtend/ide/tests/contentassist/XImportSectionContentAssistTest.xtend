/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jdt.ui.PreferenceConstants
import org.junit.Test
import org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XImportSectionContentAssistTest extends AbstractXtendContentAssistBugTest {
	
	@Test def void testMemberName() {
		val builder = newBuilder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.")
		.assertTextAtCursorPosition("Foo.", "Foo.".length, "publicStaticMethod", "publicStaticField")
		
		builder.applyProposal("publicStaticMethod")
		.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod")
		
		builder.applyProposal("publicStaticField")
		.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField")
	}
	
	@Test def void testMemberName_2() {
		newBuilder.append('''
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticM
			
			class Bar {}''')
		.assertTextAtCursorPosition("publicStaticM", "publicStaticM".length, "publicStaticMethod")
	}
	
	@Test def void testMemberName_3() {
		val builder = newBuilder.append('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.''')
		.assertText("publicStaticMethod", "defaultStaticMethod", "protectedStaticMethod",
			"publicStaticField", "defaultStaticField", "protectedStaticField")
		
		builder.applyProposal("publicStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod''')
		
		builder.applyProposal("defaultStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticMethod''')
		
		builder.applyProposal("protectedStaticMethod").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticMethod''')
		
		builder.applyProposal("publicStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField''')
		
		builder.applyProposal("defaultStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticField''')
		
		builder.applyProposal("protectedStaticField").expectContent('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticField''')
	}
	
	@Test def void testMemberName_4() {
		newBuilder.append('''
			package org.eclipse.xtend.ide.tests.data.contentassist
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.default
			
			class Bar {}''')
		.assertTextAtCursorPosition("default", "default".length, "defaultStaticMethod", "defaultStaticField")
	}
	
	@Test 
	def void testStaticFavoriteImports_operation(){
		
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS,StaticClassExample.name + ".*")
		
		newBuilder.append('''
			package mypack
			class Bar{
				def void foo(){
					''')
		.applyProposal("staticMethod()")
		.expectContent('''
			package mypack
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
			
			class Bar{
				def void foo(){
			staticMethod()''')
	}
	@Test 
	def void testStaticFavoriteImports_field(){
		
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS,StaticClassExample.name + ".*")
		
		newBuilder.append('''
			package mypack
			class Bar{
				def void foo(){
					''')
		.applyProposal("STATICFIELD")
		.expectContent('''
			package mypack
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD
			
			class Bar{
				def void foo(){
			STATICFIELD''')
	}
	@Test 
	def void testStaticFavoriteImports_no_constructor(){
		
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
		
		newBuilder.append('''
			package mypack
			class Bar{
				def void foo(){
					<|>''')
		.assertNoProposalAtCursor("StaticClassExample")
	}
	@Test 
	def void testStaticFavoriteImports_field_No_additional_import(){
		
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
		
		newBuilder.append('''
			package mypack
			class Bar{
				def void foo(){
					STATICFIELD
					''')
		.applyProposal("STATICFIELD")
		.expectContent('''
			package mypack
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.STATICFIELD
			
			class Bar{
				def void foo(){
					STATICFIELD
			STATICFIELD''')
	}
	@Test 
	def void testStaticFavoriteImports_No_additional_import(){
		
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, StaticClassExample.name + ".*")
		
		newBuilder.append('''
			package mypack
			class Bar{
				def void foo(){
					staticMethod()
					''')
		.applyProposal("staticMethod()")
		.expectContent('''
			package mypack
			
			import static org.eclipse.xtend.ide.tests.data.contentassist.StaticClassExample.staticMethod
			
			class Bar{
				def void foo(){
					staticMethod()
			staticMethod()''')
	}
	
}