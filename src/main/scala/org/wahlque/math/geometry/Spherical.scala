package org.wahlque.math.geometry

import scala.math.acos
import scala.math.atan
import scala.math.cos
import scala.math.sin

/**
 * Ref:
 *
 *   http://en.wikipedia.org/wiki/Spherical_coordinates
 *   http://en.wikipedia.org/wiki/Vector_fields_in_cylindrical_and_spherical_coordinates
 *   http://en.wikipedia.org/wiki/Del
 *   http://en.wikipedia.org/wiki/Del_in_cylindrical_and_spherical_coordinates
 *
 */

object Spherical {

  def position(lambda: Double, theta: Double, r: Double): Vector3 = new Vector3(r * sin(theta) * cos(lambda), r * sin(theta) * sin(lambda), r * cos(theta))

  def coordinate(v: Vector3): (Double, Double, Double) = {
    val norm = v.norm
    if (norm == 0.0) (0, 0, 0) else (atan(v.y / v.x), acos(v.x / norm), norm)
  }

  def local(lambda: Double, theta: Double, r: Double): Vector3 => Vector3 = (v: Vector3) =>
    new Vector3(v.x * sin(theta) * cos(lambda) + v.y * sin(theta) * sin(lambda) + v.z * cos(theta),
      v.x * cos(theta) * cos(lambda) + v.y * cos(theta) * sin(lambda) - v.z * sin(theta),
      -v.x * sin(lambda) + v.y * cos(lambda))

  def global(lambda: Double, theta: Double, r: Double): Vector3 => Vector3 = (v: Vector3) =>
    new Vector3(
      v.x * sin(theta) * cos(lambda) + v.y * cos(theta) * cos(lambda) - v.z * sin(theta),
      v.x * sin(theta) * sin(lambda) + v.y * cos(theta) * sin(lambda) + v.z * cos(theta),
      v.x * cos(lambda) - v.y * sin(lambda))

}
