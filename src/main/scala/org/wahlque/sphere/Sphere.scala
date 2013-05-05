package org.wahlque.sphere

/**
 * trait Sphere
 *
 * Expression syntax: ...
 *
 * Points array layout: ...
 *
 * Value array layout: ...
 *
 * Data array layout: ...
 *
 * @author Mingli Yuan
 *
 */
trait Sphere {

  /**
   * Create a space for field calculating, the parameters describe the global
   * grid settings. The grid settings are applied to all calculated fields. If
   * it is in a distributed mode, even different node are with different size,
   * the global grid setting are also hold for all of them, especially the
   * level parameter.
   *
   * @param level
   *            the scale level ranging from 1 ~ 13
   * @param zscale
   *            the grid number along z-axis
   * @param zaxis
   *            the z-values of the grid along z-axis
   * @return success or error code
   */
  def mkspace(level: Int, zscale: Int, zaxis: Array[Double]): Int

  /**
   * Create a field. If it is in a distributed mode, the field settings for a
   * specific field is applied on all nodes.
   *
   * @param target
   *            the field name
   * @param compn
   *            the field component
   * @param dimn
   *            the field dimension
   * @param varblt
   *            the field variability
   * @param expression
   *            the initialization expression
   * @return success or error code
   */
  def mkfield(target: String, compn: Component, dimn: Dimension,
    varblt: Variability, expression: String): Int

  /**
   * Query the component type of the field
   *
   * @param target
   *            the field name
   * @return the type of the field
   */
  def compn(target: String): Component

  /**
   * Query the dimension of the field
   *
   * @param target
   *            the field name
   * @return the kind of the field
   */
  def dimn(target: String): Dimension

  /**
   * Query the variability of the field
   *
   * @param target
   *            the field name
   * @return the variability of the field
   */
  def varblt(target: String): Variability

  /**
   * Query values of the field on some specific space-time points. The layout
   * of points array and value array are specified as follow.
   *
   * @param target
   *            the field name
   * @param points
   *            the space-time points
   * @return the values of the field on these points
   */
  def get(target: String, points: Array[Double]): Array[Double]

  /**
   * Query values of the field on some specific condition.
   *
   * @param target
   *            the field name
   * @param condexpr
   *            the condition expression
   * @return the values of the field on these points
   */
  def query(target: String, condexpr: String): Array[Double]

  /**
   * Set data on some specific point of the field
   *
   * @param target
   *            the field name
   * @param data
   *            the data array
   * @return success or error code
   */
  def put(target: String, data: Array[Double]): Int

  /**
   * Evaluate an expression and set the result to a specific target
   *
   * @param target
   *            the field name
   * @param expression
   *            the expression to evaluate
   * @return success or error code
   */
  def eval(target: String, expression: String): Int

  def mkpart(level: Int): Int

  def mksubspace(parind: Int): Int

  def backup(target: String, parind: Int, data: Array[Double]): Int

  def exchange(target: String, parind: Array[Int], data: Array[Double]): Int

}

sealed abstract class Component
case object Scalar extends Component
case object Vector extends Component

sealed abstract class Dimension
case object Surficial extends Dimension
case object Spatial extends Dimension

sealed abstract class Variability
case object Constant extends Variability
case object Temporal extends Variability
