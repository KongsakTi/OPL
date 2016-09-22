def find(xs: List[(Int, String)], key: Int): Option[String] = {
	if (xs.isEmpty) None else
	if (xs.head._1 == key) Some(xs.head._2) else find(xs.tail, key)
}

def rev(xs: List[Int]): List[Int] = {
	def tailRev(ys: List[Int], zs: List[Int]): List[Int] = {
		if (ys.isEmpty) zs else tailRev(ys.tail, ys.head :: zs)
	}
	tailRev(xs, Nil)
}

def fib(n: Int): Long = {
	def fibTail(m: Int, pv: (Long, Long)): Long = {
		if (m > n) pv._1 else fibTail(m + 1, (pv._1 + pv._2, pv._1))
	}
	fibTail(2, (1, 1))
}