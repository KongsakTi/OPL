object TurnIt extends App {
  def transpose(A: List[List[Int]]): List[List[Int]] = {
  	def transposeH(A: List[List[Int]]): List[Int] = if (A.isEmpty || A.head.isEmpty) Nil else A.head.head :: transposeH(A.tail)
  	def chopHead(A: List[List[Int]]): List[List[Int]] = if (A.isEmpty || A.head.isEmpty) Nil else A.head.tail :: chopHead(A.tail)
  	if (A.head.length == 1) List(transposeH(A)) else transposeH(A) :: transpose(chopHead(A))
  }
}
