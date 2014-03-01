package org.arnoldc.ast

case class SuppressibleMethodNode(suppressed: Boolean, decorated: MethodNode)
  extends AbstractMethodNode with AstNodeDecorator[MethodNode] with SuppressibleAstNode {

  override val returnsValue: Boolean = decorated.returnsValue
  override val methodName: String = decorated.methodName
  override val arguments: List[VariableNode] = decorated.arguments
  override val statements: List[StatementNode] = decorated.statements
}
