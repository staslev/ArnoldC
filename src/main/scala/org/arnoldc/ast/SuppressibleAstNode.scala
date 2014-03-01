package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.arnoldc.SymbolTable

trait SuppressibleAstNode { this: AstNodeDecorator[_ <: AstNode] =>

  val suppressed: Boolean

  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    if(!suppressed) decorated.generate(mv, symbolTable)
  }

}
