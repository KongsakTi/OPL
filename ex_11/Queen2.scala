object Queen2 {
  import NQueenMisc._

  def nQueens(n: Int): List[PartialBoard] = {
    // a list of all possible solutions extending
    // from the board (which is a partial board)
    def place(board: PartialBoard): List[PartialBoard] = {
      val numRemaining = n - board.length
      numRemaining match {
        case 0 => List(board)
        case _ => {
          // possibleLocs: List[QueenLoc]
          val possibleLocs = (1 to n).map(y => (numRemaining , y))
                .filter(loc => isSafe(loc, board))
                .toList

          possibleLocs.flatMap(loc => place(loc :: board))

          // Version 1.0
          // // trailResults: List[List[PartialBoard]]
          // val trialResults = possibleLocs.map (loc =>
          //   place(loc::board)
          // )

          // trialResults.flatten
        }
      }
    }

    place(Nil)
  }

  def main(args: Array[String]) {
    val n = if (args.length > 0) args(0).toInt else 13
    val sol = time { nQueens(n) }
    println("sol count: "+ sol.length)
  }
}