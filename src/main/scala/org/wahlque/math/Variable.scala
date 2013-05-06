package org.wahlque.math

trait Variable[T] {

  def apply(time: Double): T

  def dot(): Variable[T]

}