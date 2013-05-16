package org.wahlque.math.function

trait Variable[T] {

  def apply(time: Double): T

  def dot(): Variable[T]

}