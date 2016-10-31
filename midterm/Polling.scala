object Polling extends App {

	def winner(xs: List[(String, Int)]): (String, Int) = {
		def winner_helper(xs: List[(String, Int)], map:  scala.collection.mutable.Map[String,Int]): scala.collection.mutable.Map[String,Int] = {
			xs match {
				case Nil => map
				case h::t => {
					map.contains(h._1) match {
						case false => winner_helper(t, map + (h._1 -> h._2))
						case true => winner_helper(t, map + (h._1 -> (map.get(h._1).get + h._2)))
					}	
				}
			}			
		}
		val scores = winner_helper(xs, scala.collection.mutable.Map[String,Int]())
		val theWinner = scores.keys.toList.sorted.maxBy((x: String) => scores.get(x))
		(theWinner, scores.get(theWinner).get)
	}
}