package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.arnoldc.SymbolTable


case class CommentTextLineNode(commentText: String) extends AstNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {

  }
}

