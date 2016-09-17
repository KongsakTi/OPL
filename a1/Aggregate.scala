object Aggregate extends App {

  def myMin(p: Double, q: Double, r: Double): Double = if (p <= q && p <= r) p else myMin(q, r, p) 									 										

  def myMean(p: Double, q: Double, r: Double): Double = (p + q + r)/3

  def myMed(p: Double, q: Double, r: Double): Double = if (p <= q && p >= r) p else myMed(q, r, p)

}
