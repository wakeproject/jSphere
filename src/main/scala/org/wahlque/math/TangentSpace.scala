package org.wahlque.math

trait TangentSpace[T, B <: Manifold[T]] {
  def at(point: B): T
}