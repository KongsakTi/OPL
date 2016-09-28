// def findLast(xs: List[Int], key: Int) = {
// 	xs.foldLeft ()
// }

def unzip[A, B](xs: List[(A, B)]): (List[A], List[B]) = (xs) match {
	case (Nil) => (Nil, Nil)
	case h::t => {
		val pairList: (List[A], List[B]) = unzip(t)
		(h._1 :: pairList._1, h._2 :: pairList._2)
	}
}

