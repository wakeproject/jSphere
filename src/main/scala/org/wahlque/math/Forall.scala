package org.wahlque.math

trait Forall[T] {

  def apply(predicate: T => Boolean): Boolean

}
