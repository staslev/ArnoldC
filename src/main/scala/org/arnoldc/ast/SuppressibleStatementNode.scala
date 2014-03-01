package org.arnoldc.ast

case class SuppressibleStatementNode(suppressed: Boolean, decorated: StatementNode)
  extends StatementNode with AstNodeDecorator[StatementNode] with SuppressibleAstNode {
}