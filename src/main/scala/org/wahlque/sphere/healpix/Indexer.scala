package org.wahlque.sphere.healpix

import scala.math.{ floor, rint, sqrt }

object Indexer {

  /* Base parameters for cell of tessellation */
  val NTHETA: Int = 3
  val NPHI: Int = 4

  /* Numbers of power 2 */
  val P0: Int = 1
  val P1: Int = 2
  val P2: Int = 4
  val P3: Int = 8
  val P4: Int = 16
  val P5: Int = 32
  val P6: Int = 64
  val P7: Int = 128
  val P8: Int = 256
  val P9: Int = 512
  val P10: Int = 1024
  val P11: Int = 2048
  val P12: Int = 4096
  val P13: Int = 8192

  /* Scale numbers */
  val N0: Int = 12
  val N1: Int = 48
  val N2: Int = 192
  val N3: Int = 768
  val N4: Int = 3072
  val N5: Int = 12288
  val N6: Int = 49152
  val N7: Int = 196608
  val N8: Int = 786432
  val N9: Int = 3145728
  val N10: Int = 12582912
  val N11: Int = 50331648
  val N12: Int = 201326592
  val N13: Int = 805306368

  def power(level: Int): Int = {
    level match {
      case 0 => P0
      case 1 => P1
      case 2 => P2
      case 3 => P3
      case 4 => P4
      case 5 => P5
      case 6 => P6
      case 7 => P7
      case 8 => P8
      case 9 => P9
      case 10 => P10
      case 11 => P11
      case 12 => P12
      case 13 => P13
      case _ => -1
    }
  }

  def all(level: Int): Int = {
    level match {
      case 0 => N0
      case 1 => N1
      case 2 => N2
      case 3 => N3
      case 4 => N4
      case 5 => N5
      case 6 => N6
      case 7 => N7
      case 8 => N8
      case 9 => N9
      case 10 => N10
      case 11 => N11
      case 12 => N12
      case 13 => N13
      case _ => -1
    }
  }

  def ringByRind(level: Int, index: Int): Int = {
    var ring: Int = -1
    var size: Int = power(level)
    var ncap: Int = 2 * size * (size - 1)
    var nblt: Int = ncap + 4 * size * size
    var equt: Int = nblt + 4 * size
    var sblt: Int = 12 * size * size - ncap
    var scap: Int = 12 * size * size

    if (index < 0) {
      return -1
    } else if (index < ncap) {
      var half = (index + 1.0) / 2.0
      return 1 + floor(sqrt(half - sqrt(floor(half)))).toInt
    } else if (index < nblt) {
      return size + floor((index - ncap) / 4.0 / size).toInt
    } else if (index < equt) {
      return size + floor((index - ncap) / 4.0 / size).toInt
    } else if (scap < index) {
      return -1
    } else if (sblt < index) {
      var half = (scap - index - 1 + 1.0) / 2.0
      return 4 * size - 1 - floor(sqrt(half - sqrt(floor(half)))).toInt
    } else if (equt <= index) {
      return 2 * size + 1 + floor((index - equt) / 4.0 / size).toInt
    } else {
      return -1
    }

  }

  def pxirByRind(level: Int, index: Int): Int = {
    var pxir: Int = -1
    var size: Int = power(level)
    var ncap: Int = 2 * size * (size - 1)
    var scap: Int = 12 * size * size
    var ring: Int = ringByRind(level, index)

    var ind = index
    var dual: Int = -1

    if (ring < 0) {
      return -1
    } else if (ring <= size) {
      pxir = ind + 1 - 2 * ring * (ring - 1)
      return pxir
    } else if (ring <= 3 * size) {
      ind = ind - ncap
      pxir = 1 + ind % (4 * size)
      return pxir
    } else if (ring < 4 * size) {
      dual = 4 * size - ring
      pxir = 4 * dual - (scap - index - 1 - 2 * dual * (dual - 1))
      return pxir
    } else {
      return -1
    }

  }

}
