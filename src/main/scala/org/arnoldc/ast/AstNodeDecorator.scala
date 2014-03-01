package org.arnoldc.ast

trait AstNodeDecorator[+T<:AstNode] {
  val decorated: T
}

