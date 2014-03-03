package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.arnoldc.SymbolTable

trait SuppressibleAstNode[+T<:AstNode] extends AstNodeDecorator[T]{

  val suppressed: Boolean

  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    if(!suppressed) decorated.generate(mv, symbolTable)
  }

}
