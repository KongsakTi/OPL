object Blast extends App {
	def merge(xs: List[Double], ys: List[Double]): List[Double] =
		(xs, ys) match {
			case (Nil, ys) => ys
			case (xs, Nil) => xs
			case (x::xt, y::yt) => {
				if (x < y) x :: merge(xt, ys) else y :: merge(xs, yt)
			}
		}		
}