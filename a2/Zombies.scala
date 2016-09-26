object Zombies extends App {
  def countBad(hs: List[Int]): Int = {
  	def mergeList(hs: List[Int], ts: List[Int]): List[Int] = {
  		if (hs.isEmpty) ts else hs.head :: mergeList(hs.tail, ts) 
  	}

	def splitList(hs: List[Int], n: Int): (List[Int], List[Int]) = {
		if (n == 0) (Nil, hs) else {
			var spltLst: (List[Int], List[Int]) = splitList(hs.tail, n - 1)
			(hs.head :: spltLst._1, spltLst._2)
		}
	}

	def countBadH(hs: List[Int], ts: List[Int], count:Int): (List[Int], Int) = {
		if (hs.isEmpty || ts.isEmpty) (mergeList(hs, ts), count) else {
			if (hs.head <= ts.head) {
				var lstCount: (List[Int], Int) = countBadH(hs.tail, ts, count)
				(hs.head :: lstCount._1, lstCount._2)
			} else { 
				var lstCount: (List[Int], Int) = countBadH(hs, ts.tail, count + hs.length)
				(ts.head :: lstCount._1, lstCount._2)
			}
		}
	}

	if (hs.length == 1) 0 else {
		var headTail: (List[Int], List[Int]) = splitList(hs, hs.length/2)
		var countHead: Int = countBad(headTail._1)

	}
  }
}
