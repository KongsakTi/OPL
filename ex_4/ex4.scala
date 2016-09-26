def rev(xs: List[Int]): List[Int] = {
	def revH(xs: List[Int], ys: List[Int]): List[Int] = xs match{
		case Nil => ys
		case head::tail => revH(tail, head :: ys)
	}
	revH(xs, Nil)
}

def zip(xs: List[Int], ys: List[Int]): List[(Int, Int)] = (xs, ys) match {
	case (Nil, Nil) => Nil
	case (head1::tail1, head2::tail2) => (head1, head2) :: zip(tail1, tail2)
}