object Zombies extends App {
  def countBad(hs: List[Int]): Int = {
	def splitList(hs: List[Int], n: Int): (List[Int], List[Int]) = {
		if (n == 0) (Nil, hs) else {
			var spltLst: (List[Int], List[Int]) = splitList(hs.tail, n - 1)
			(hs.head :: spltLst._1, spltLst._2)
		}
	}

	def countBadH(hs: List[Int], count: Int): (List[Int], Int) = {
		if (hs.length == 1) (hs, count) else {
			var pairLst: (List[Int], List[Int]) = splitList(hs, hs.length/2)
			var leftLst: (List[Int], Int) = countBadH(pairLst._1, 0)
			var rightLst: (List[Int], Int) = countBadH(pairLst._2, 0)
			// println(leftLst, rightLst)
			merge(leftLst._1, rightLst._1, leftLst._2 + rightLst._2)
		}
	}

	def merge(hs: List[Int], ts: List[Int], count:Int): (List[Int], Int) = {
		if (hs.isEmpty) (ts, count) else
		if (ts.isEmpty) (hs, count) else {
			if (hs.head >= ts.head) {
				var lstCount: (List[Int], Int) = merge(hs.tail, ts, count)
				(hs.head :: lstCount._1, lstCount._2)
			} else { 
				var lstCount: (List[Int], Int) = merge(hs, ts.tail, count + hs.length)
				(ts.head :: lstCount._1, lstCount._2)
			}
		}
	}
	if (hs.length <= 1) 0 else {
		var ans: (List[Int], Int) = countBadH(hs, 0)
		// println(ans)
		ans._2
	}
  }


}

