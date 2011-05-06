/*
* generated by Xtext
*/
package org.eclipse.xtext.xbase.ui.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.conversion.StaticQualifierValueConverter;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class XbaseProposalProvider extends AbstractXbaseProposalProvider implements RepeatedContentAssistProcessor.ModeAware {
	
	private final static Logger log = Logger.getLogger(XbaseProposalProvider.class);
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private ValidFeatureDescription featureDescriptionPredicate;
	
	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	private QualifiedNameValueConverter qualifiedNameValueConverter;
	
	@Inject
	private StaticQualifierValueConverter staticQualifierValueConverter;
	
	@Inject
	private StaticQualifierPrefixMatcher staticQualifierPrefixMatcher;
	
	public String getNextCategory() {
		return getXbaseCrossReferenceProposalCreator().getNextCategory();
	}
	
	public void nextMode() {
		getXbaseCrossReferenceProposalCreator().nextMode();
	}
	
	public void reset() {
		getXbaseCrossReferenceProposalCreator().reset();
	}
	
	public boolean isLastMode() {
		return getXbaseCrossReferenceProposalCreator().isLastMode();
	}
	
	public XbaseReferenceProposalCreator getXbaseCrossReferenceProposalCreator() {
		return (XbaseReferenceProposalCreator) super.getCrossReferenceProposalCreator();
	}
	
	public static class ValidFeatureDescription implements Predicate<IEObjectDescription> {

		@Inject
		private OperatorMapping operatorMapping;
		
		public boolean apply(IEObjectDescription input) {
			if (input instanceof JvmFeatureDescription) {
				if (!((JvmFeatureDescription) input).isValid())
					return false;
				// filter operator method names from CA
				return operatorMapping.getOperator(input.getName()) == null;
			}
			return true;
		}
		
	}
	
	@Override
	public void completeJvmParameterizedTypeReference_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals()) {
			completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
		}
	}
	
	@Override
	public void completeXRelationalExpression_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION__TYPE, acceptor);
	}

	protected void completeJavaTypes(ContentAssistContext context, EReference reference, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, reference, qualifiedNameValueConverter, TypeMatchFilters.all(), acceptor);
	}
	
	protected void completeJavaTypes(ContentAssistContext context, EReference reference, ITypesProposalProvider.Filter filter, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, reference, qualifiedNameValueConverter, filter, acceptor);
	}
	
	protected void completeJavaTypes(ContentAssistContext context, EReference reference, IValueConverter<String> valueConverter, ITypesProposalProvider.Filter filter, ICompletionProposalAcceptor acceptor) {
		if (context.getPrefix().length() > 0) {
			if (Character.isJavaIdentifierStart(context.getPrefix().charAt(0))) {
				typeProposalProvider.createTypeProposals(this, context, reference, filter, valueConverter, acceptor);
			}
		} else {
			typeProposalProvider.createTypeProposals(this, context, reference, filter, valueConverter, acceptor);
		}
	}
	
	@Override
	public void completeXTypeLiteral_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, acceptor);
	}
	
	@Override
	public void completeXFeatureCall_DeclaringType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals()) {
			ContentAssistContext modifiedContext = context.copy().setMatcher(staticQualifierPrefixMatcher).toContext();
			completeJavaTypes(modifiedContext, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, staticQualifierValueConverter, TypeMatchFilters.all(), acceptor);
		}
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		if (isKeywordWorthyToPropose(keyword)) { 
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}

	protected boolean isKeywordWorthyToPropose(Keyword keyword) {
		return keyword.getValue().length() > 1 && Character.isLetter(keyword.getValue().charAt(0));
	}
	
	@Override
	protected boolean doCreateIntProposals() {
		return false;
	}
	
	@Override
	protected boolean doCreateIdProposals() {
		return false;
	}
	
	@Override
	protected boolean doCreateStringProposals() {
		return false;
	}
	
	@Override
	public XbaseScopeProvider getScopeProvider() {
		return (XbaseScopeProvider) super.getScopeProvider();
	}
	
	@Override
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor, getFeatureDescriptionPredicate(contentAssistContext));
	}
	
	@Override
	public void completeXAssignment_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (assignment == grammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1())
			super.completeXAssignment_Feature(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeXMemberFeatureCall_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.completeXMemberFeatureCall_Feature(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeXFeatureCall_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) model;
			if (!block.getExpressions().isEmpty()) {
				EObject previousModel = context.getPreviousModel();
				if (context.getPreviousModel() == model) {
					for(XExpression expression: block.getExpressions()) {
						ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
						if (node.getOffset() >= context.getOffset())
							break;
						previousModel = expression;
					}
				} else {
					while(previousModel.eContainer() != block) {
						previousModel = previousModel.eContainer();
					}
				}
				int idx = block.getExpressions().indexOf(previousModel);
				createLocalVariableAndImplicitProposals(block, idx + 1, context, acceptor);
				return;
			}
		} 
		if (model instanceof XForLoopExpression) {
			ICompositeNode node = NodeModelUtils.getNode(model);
			boolean eachExpression = false;
			for(INode leaf: node.getLeafNodes()) {
				if (leaf.getOffset() >= context.getOffset())
					break;
				if (leaf.getGrammarElement() == grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6()) {
					eachExpression = true;
					break;
				}
			}
			if (!eachExpression) {
				createLocalVariableAndImplicitProposals(model, false, -1, context, acceptor);
				return;
			}
		}
		if (model instanceof XFeatureCall && ((XFeatureCall) model).getDeclaringType() != null) {
			super.completeXFeatureCall_Feature(model, assignment, context, acceptor);
		}
		if (model == null || model instanceof XExpression || model instanceof XCatchClause)
			createLocalVariableAndImplicitProposals(model, context, acceptor);
	}
	
	@Override
	public void completeXBlockExpression_Expressions(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeXBlockExpression_Expressions(model, assignment, context, acceptor);
		if (!(model instanceof XBlockExpression)) {
			EObject local = model;
			while(!(local.eContainer() instanceof XBlockExpression)) {
				local = local.eContainer();
				if (local == null)
					return;
			}
			XBlockExpression block = (XBlockExpression) local.eContainer();
			int idx = block.getExpressions().indexOf(local);
			createLocalVariableAndImplicitProposals(block, idx + 1, context, acceptor);
		}
	}
	
	/**
	 * Customized to be able to treat binary operations in a special way with respect to scoping.
	 * Since the operator is a cross reference, we have to be careful to choose the right context for
	 * the scope provider. On the other hand it's important to filter "impossible" syntactical situations.
	 */
	@Override
	protected void lookupCrossReference(CrossReference crossReference, EReference reference,
			ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
			completeJavaTypes(contentAssistContext, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
			return;
		}
		// guard for feature call scopes
		if (!getScopeProvider().isFeatureCallScope(reference)) {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		EObject model = contentAssistContext.getCurrentModel();
		if (model == contentAssistContext.getPreviousModel() || 
				!(contentAssistContext.getPreviousModel() instanceof XExpression)) {
			// check whether we have a binary operation that was already linked
			if (model instanceof XBinaryOperation) {
				XBinaryOperation binaryOperation = (XBinaryOperation) model;
				if (doNotProposeFeatureOfBinaryOperation(contentAssistContext, binaryOperation)) {
					return;
				}
			} else if (model instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall memberFeatureCall = (XAbstractFeatureCall) model;
				List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(memberFeatureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
				if (!nodesForFeature.isEmpty()) {
					INode node = nodesForFeature.get(0);
					if (node.getOffset() + node.getLength() <= contentAssistContext.getOffset() - contentAssistContext.getPrefix().length()) {
						createReceiverProposals(memberFeatureCall, crossReference, reference, contentAssistContext,	acceptor, filter);
						return;
					}
				} 
			}
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		if (model instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) model;
			if (contentAssistContext.getPreviousModel() == binaryOperation.getRightOperand()) {
				createReceiverProposals(binaryOperation.getRightOperand(), crossReference, reference, contentAssistContext,	acceptor, filter);
				return;
			}
		}
		if (model instanceof XAbstractFeatureCall) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(model);
			int offset = node.getOffset();
			int length = node.getLength();
			if (offset + length >= contentAssistContext.getOffset()) {
				super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
				return;
			}
		}
		if (model != null && !(model instanceof XExpression)) {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		
		if(contentAssistContext.getPreviousModel() instanceof XExpression) {
			createReceiverProposals((XExpression) contentAssistContext.getPreviousModel(), crossReference, reference, contentAssistContext,	acceptor, filter);
		} else {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
		}
	}
	
	protected void createLocalVariableAndImplicitProposals(EObject context, int idx, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(context, true, idx, contentAssistContext, acceptor);
	}
	
	protected void createLocalVariableAndImplicitProposals(EObject context, boolean includeCurrentObject, int idx, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		Function<IEObjectDescription, ICompletionProposal> proposalFactory = getProposalFactory("ID", contentAssistContext);
		IScope scope = getScopeProvider().createSimpleFeatureCallScope(context, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, contentAssistContext.getResource(), includeCurrentObject, idx);
		getCrossReferenceProposalCreator().lookupCrossReference(scope, context, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor, getFeatureDescriptionPredicate(contentAssistContext), proposalFactory);
	}
	
	/**
	 * Create proposal for {@link XAbstractFeatureCall#getFeature() simple feature calls} that use an <code>ID</code>
	 * as concrete syntax.
	 */
	protected void createLocalVariableAndImplicitProposals(EObject context, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(context, -1, contentAssistContext, acceptor);
	}

	protected void createReceiverProposals(XExpression receiver, CrossReference crossReference,
			EReference reference, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		String ruleName = null;
		if (crossReference.getTerminal() instanceof RuleCall) {
			ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
		}
		Function<IEObjectDescription, ICompletionProposal> proposalFactory = getProposalFactory(ruleName, contentAssistContext);
		IScope scope = getScopeProvider().createFeatureCallScopeForReceiver(receiver, receiver, reference);
		getCrossReferenceProposalCreator().lookupCrossReference(scope, receiver, reference, acceptor, filter, proposalFactory);
	}

	protected boolean doNotProposeFeatureOfBinaryOperation(ContentAssistContext contentAssistContext,
			XBinaryOperation binaryOperation) {
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(binaryOperation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (!nodesForFeature.isEmpty()) {
			INode node = nodesForFeature.get(0);
			if (node.getOffset() < contentAssistContext.getOffset() - contentAssistContext.getPrefix().length()) {
				XExpression rightOperand = binaryOperation.getRightOperand();
				if (rightOperand == null)
					return true;
				ICompositeNode rightOperandNode = NodeModelUtils.findActualNodeFor(rightOperand);
				if (rightOperandNode.getOffset() >= contentAssistContext.getOffset())
					return true;
				if (isParentOf(rightOperandNode, contentAssistContext.getLastCompleteNode()))
					return true;
			}
		}
		return false;
	}
	
	protected boolean isParentOf(INode node, INode child) {
		if (node == null)
			return false;
		while(child != null && node.equals(child)) {
			child = child.getParent();
		}
		return node.equals(child);
	}

	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(final String ruleName,
			final ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter()) {
			@Override
			public ICompletionProposal apply(IEObjectDescription candidate) {
				if (candidate instanceof JvmFeatureDescription && "ID".equals(ruleName)) {
					ICompletionProposal result = null;
					String key = ((JvmFeatureDescription) candidate).getKey();
					boolean withParenths = key.endsWith(")");
					String proposal = getQualifiedNameConverter().toString(candidate.getName());
					if (ruleName != null) {
						try {
							proposal = getValueConverter().toString(proposal, ruleName);
						} catch (ValueConverterException e) {
							log.debug(e.getMessage(), e);
							return null;
						}
					}
					if (withParenths) {
						proposal = proposal + "()";
					}
					EObject objectOrProxy = candidate.getEObjectOrProxy();
					StyledString displayString = getStyledDisplayString((JvmFeature)objectOrProxy,
							withParenths,
							getQualifiedNameConverter().toString(candidate.getQualifiedName()),
							getQualifiedNameConverter().toString(candidate.getName()));
					result = createCompletionProposal(proposal, displayString, null, contentAssistContext);
					if (result instanceof ConfigurableCompletionProposal) {
						ConfigurableCompletionProposal casted = (ConfigurableCompletionProposal) result;
						casted.setAdditionalProposalInfo(objectOrProxy);
						casted.setHover(getHover());
						if (withParenths) {
							casted.setSelectionStart(casted.getReplacementOffset() + proposal.length() - 1);
							casted.setSelectionLength(0);
							casted.setAutoInsertable(false);
							casted.setSimpleLinkedMode(contentAssistContext.getViewer(), '\t', '\n');
						}
					}
					getPriorityHelper().adjustCrossReferencePriority(result, contentAssistContext.getPrefix());
					return result;
				}
				return super.apply(candidate);
			}
		};
	}
	
	protected StyledString getStyledDisplayString(JvmFeature feature, boolean withParenths, String qualifiedNameAsString, String shortName) {
		StyledString result = new StyledString(shortName);
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (withParenths) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature);
				result.append(')');
			}
			if (operation.getReturnType() != null) {
				result.append(" : ");
				result.append(operation.getReturnType().getSimpleName());
			}
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(feature.getDeclaringType().getSimpleName(), StyledString.QUALIFIER_STYLER);
			if (!withParenths) {
				result.append(".", StyledString.QUALIFIER_STYLER);
				result.append(feature.getSimpleName(), StyledString.QUALIFIER_STYLER);
				result.append("()", StyledString.QUALIFIER_STYLER);
			}
		} else if (feature instanceof JvmField) {
			result.append(" : ");
			result.append(((JvmField) feature).getType().getSimpleName());
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(feature.getDeclaringType().getSimpleName(), StyledString.QUALIFIER_STYLER);
		} else if (feature instanceof JvmConstructor) {
			if (withParenths) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature);
				result.append(')');
			}
		}
		return result;
	}

	protected void appendParameters(StyledString result, JvmExecutable executable) {
		boolean first = true;
		for(JvmFormalParameter parameter: executable.getParameters()) {
			if (!first)
				result.append(", ");
			first = false;
			result.append(parameter.getParameterType().getSimpleName());
			result.append(' ');
			result.append(notNull(parameter.getName()));
		}
	}
	
	protected Predicate<IEObjectDescription> getFeatureDescriptionPredicate(ContentAssistContext contentAssistContext) {
		return featureDescriptionPredicate;
	}
}
