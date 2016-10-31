object FuncSet extends App {
	type Set = Int => Boolean

	def singleton(x: Int): Set = (num: Int) => (num == x)
	def union(A: Set, B: Set): Set = (num: Int) => (A(num) || B(num))
	def intersect(A: Set, B: Set): Set = (num: Int) => (A(num) && B(num))
}