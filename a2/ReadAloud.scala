object ReadAloud extends App {
  def readAloud(lst: List[Int]): List[Int] = {
  	def readAloudH(lst: List[Int], prev: Int, count: Int): List[Int] = {
  		if (lst.isEmpty) List(count, prev) else
  		if (lst.head == prev) readAloudH(lst.tail, prev, count + 1) else
  		count :: prev :: readAloudH(lst.tail, lst.head, 1)
  	}
  	if (lst.isEmpty) Nil else readAloudH(lst.tail, lst.head, 1)

  }
  def unreadAloud(lst: List[Int]): List[Int] = {
  	def unreadAloudH(lst: List[Int], num: Int, count: Int): List[Int] = {
  		if (lst.isEmpty && count == 0) Nil else
  		if (count > 0) num :: unreadAloudH(lst, num, count-1) else
  		unreadAloudH(lst.tail.tail, lst.tail.head, lst.head)
  	}
  	if (lst.isEmpty) Nil else unreadAloudH(lst.tail.tail, lst.tail.head, lst.head)
  }
}
