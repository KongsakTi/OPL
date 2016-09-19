def firsts(xs: List[(Int, Int)]): List[Int] = if (xs.isEmpty) Nil else xs.head._1 :: firsts(xs.tail) 
def seconds(xs: List[(Int, Int)]): List[Int] = if (xs.isEmpty) Nil else xs.head._2 :: seconds(xs.tail) 

def sumPairList(xs: List[(Int, Int)]): Int = {
	def sumPair(xs:(Int, Int)) = xs._1 + xs._2
	if (xs.isEmpty) 0
	else sumPair(xs.head) + sumPairList(xs.tail)
}

// Good
// def pairSumList(xs: List[(Int, Int)]) = {
// 	def sumList(ys: List[Int]): Int = if (ys.isEmpty) 0 else ys.head + sumList(ys.tail)

// 	(sumList(firsts(xs)), sumList(seconds(xs)))
// }

// Bad
// def pairSumList(xs: List[(Int, Int)]): (Int, Int) = {
// 	if (xs.isEmpty) (0, 0)
// 	else (xs.head._1 + pairSumList(xs.tail)._1, xs.head._2 + pairSumList(xs.tail)._2)
// }

// Challenge
def pairSumList(xs: List[(Int, Int)]): (Int, Int) = {
	if (xs.isEmpty) (0, 0)
	else {
		val pairSum = pairSumList(xs.tail) 
		(xs.head._1 + pairSum._1, xs.head._2 + pairSum._2)
	}
}