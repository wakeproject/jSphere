package org.wahlque.math

/**
 * Relation
 *
 * A relation under some representation in T
 *
 */

trait Relation[T, A <: Set[T], B <: Set[T]] {

  def hold(a: A, b: B): Boolean

}