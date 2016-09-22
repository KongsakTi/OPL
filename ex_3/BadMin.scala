def badMin(xs: List[Int]): Int = {
	if (xs.isEmpty) 2147483647 else 
	if (xs.tail.isEmpty) xs.head else
	if (xs.head < badMin(xs.tail)) xs.head else badMin(xs.tail)
}

def betterMin(xs: List[Int]): Int = {
	if (xs.isEmpty) 2147483647 else 
	if (xs.tail.isEmpty) xs.head else {
		val tailMin = betterMin(xs.tail)
		if (xs.head < tailMin) xs.head else tailMin
	}
	
}

// def betterMin__(xs: List[Int]) = {
// 	def betterMin_(xs: List[Int]): Int = {
// 		if (xs.tail.isEmpty) xs.head else {
// 			val tailMin = betterMin(xs.tail)
// 			if (xs.head < tailMin) xs.head else tailMin
// 		}
// 	}
// 	if (xs.isEmpty) Nil else betterMin(xs)
// }