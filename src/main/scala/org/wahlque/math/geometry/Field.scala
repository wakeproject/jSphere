package org.wahlque.math.geometry

class ScalarField(val data: List[Double]) {

  def +(that: ScalarField): ScalarField =
    new ScalarField((for ((x, y) <- (this.data zip that.data)) yield x + y))

  def -(that: ScalarField): ScalarField =
    new ScalarField((for ((x, y) <- (this.data zip that.data)) yield x - y))

  def *(factor: Double): ScalarField =
    new ScalarField((for (x <- this.data) yield x * factor))

  def grad(): VectorField = ???

  def laplacian(): ScalarField = ???

}

class VectorField(val data: List[Double]) {

  private def group(): List[List[Double]] = List() ++ data.sliding(3, 3)
  private def vector(): List[Vector3] = (for (l <- group) yield new Vector3(l(0), l(1), l(2)))

  def +(that: VectorField): VectorField =
    new VectorField((for ((x, y) <- (this.data zip that.data)) yield x + y))

  def -(that: VectorField): VectorField =
    new VectorField((for ((x, y) <- (this.data zip that.data)) yield x - y))

  def *(factor: Double): VectorField =
    new VectorField((for (x <- this.data) yield x * factor))

  def &(that: ScalarField): VectorField =
    new VectorField((for ((x, y) <- group zip that.data) yield (x map (y *))).flatten)

  def $(that: VectorField): ScalarField =
    new ScalarField((for ((x, y) <- (this.vector zip that.vector)) yield x $ y))

  def ^(that: VectorField): VectorField =
    new VectorField((for (
      v <- (for ((x, y) <- (this.vector zip that.vector)) yield x ^ y)
    ) yield List(v.x, v.y, v.z)).flatten)

  def div(): ScalarField = ???

  def curl(): VectorField = ???

}