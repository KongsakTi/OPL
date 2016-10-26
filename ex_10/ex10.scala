def fib(n: Int): Long = {
	def fibHelper(n: Int, K: Long => Long): Long = {
		if (n <= 1) K(1) else fibHelper(n - 2, a => {
			fibHelper(n - 1, b => K(b + a))
			})
	}
	fibHelper(n, (r: Long) => r)
}


sealed trait Tree[+T] 
case object Empty extends Tree[Nothing]
case class Node[T](left: Tree[T], key: T, right: Tree[T]) extends Tree[T]


def walkPreorder[T](tree: Tree[T]): List[T] = {
	def walkPreorderHelper[T](tree: Tree[T], K: List[T] => List[T]): List[T] = tree match {
		case Empty => K(Nil)
		case Node(l, k, r) => walkPreorderHelper[T](l, leftList => {
			walkPreorderHelper[T](r, rightList => K((k :: leftList) ++ rightList))
			}) 
	}
	walkPreorderHelper[T](tree, (r: List[T]) => r)
}

