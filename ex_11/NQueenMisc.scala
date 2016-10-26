object NQueenMisc {
  def time[A](a: => A) = {
    val now = System.nanoTime
    val result = a
    val micros = (System.nanoTime - now) / 1000
    println("%f seconds".format(micros/1.0e6))
    result
  }

  type QueenLoc = (Int, Int)
  type PartialBoard = List[QueenLoc]

  def isSafe(queen: QueenLoc, queens: PartialBoard) =
    queens.forall(q => !inCheck(queen, q))

  def inCheck(q1: QueenLoc, q2: QueenLoc) = (q1, q2) match {
    case ((x1,y1),(x2,y2)) => (x1 == x2) || // same col
                         (y1 == y2) || // same row
                         ((x1 - x2).abs == (y1 - y2).abs) // on diag
  }
}