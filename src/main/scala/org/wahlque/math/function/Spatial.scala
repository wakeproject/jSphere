package org.wahlque.math.function

import org.wahlque.math.geometry.Vector3

trait Spatial[T] {

  def apply(lambda: Double, theta: Double, r: Double): T

}