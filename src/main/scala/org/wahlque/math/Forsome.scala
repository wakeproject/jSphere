package org.wahlque.math

trait Forsome[T] {

  def apply(predicate: T => Boolean): Boolean

}