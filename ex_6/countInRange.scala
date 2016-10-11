def countInRage_v1(xs: List[Int], lo: Int, hi: Int) = xs.filter(_ >= lo).filter(_ <= hi).length
def countInRage_v2(xs: List[Int], lo: Int, hi: Int) = xs.map(x => if (x >= lo && x <= hi) 1 else 0).sum
def countInRage_v3(xs: List[Int], lo: Int, hi: Int) = {
	xs.foldLeft(0) { (acc, num) =>
		if (num >= lo && num <= hi) acc+1 else acc
	}
}