def computeE = {
	def goodEnough(x: Double): Boolean = math.abs(math.log(x) - 1) < 1e-10
	def improve(x: Double): Double = x - x * (math.log(x) - 1)
	def repeat(x: Double): Double = if (goodEnough(x)) x else repeat(improve(x))
	repeat(1.0)
}