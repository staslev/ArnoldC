package org.arnoldc.ast

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes._
import org.arnoldc.SymbolTable


case class IgnorableStatementNode(ignore: Option[Boolean], operand: StatementNode) extends StatementNode {
  def generate(mv: MethodVisitor, symbolTable: SymbolTable) {
    ignore match {
      case None =>
        operand.generate(mv, symbolTable)
      case _ =>
    }
  }
}

