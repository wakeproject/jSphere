package org.wahlque.math.geometry

trait TangentBundle[T, B <: Manifold[T]] {
  def at(point: B): Basis[T]
}