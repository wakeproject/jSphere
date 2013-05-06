package org.wahlque.sphere

import scala.collection.mutable.{ LinkedList => MutableList }

class SphereEngine extends Sphere {

  val spaces: MutableList[SphereSpace] = MutableList()

  def mkspace(level: Int, zscale: Int, zaxis: Array[Double]): Int = {
    spaces :+ (new SphereSpace(level, zscale, zaxis))
    spaces.length - 1
  }

  def mkfield(target: String, compn: Component, dimn: Dimension,
    varblt: Variability, expression: String): Int = ???

  def compn(target: String): Component = ???

  def dimn(target: String): Dimension = ???

  def varblt(target: String): Variability = ???

  def get(target: String, points: Array[Double]): Array[Double] = ???

  def query(target: String, condexpr: String): Array[Double] = ???

  def put(target: String, data: Array[Double]): Int = ???

  def eval(target: String, expression: String): Int = ???

  def mkpart(level: Int): Int = ???

  def mksubspace(parind: Int): Int = ???

  def backup(target: String, parind: Int, data: Array[Double]): Int = ???

  def exchange(target: String, parind: Array[Int], data: Array[Double]): Int = ???

}