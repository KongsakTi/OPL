object Queen1 {
  import NQueenMisc._

  def nQueens(n: Int): Option[PartialBoard] = {
    def place(board: PartialBoard): Option[PartialBoard] = {
      val numRemaining = n - board.length
      numRemaining match {
        case 0 => Some(board)
        case _ => {
          val possibleLocs = (1 to n).map(y => (numRemaining , y))
                .filter(loc => isSafe(loc, board))
                .toList

          val trialResults = possibleLocs.map (loc =>
            place(loc::board)
          )
          trialResults.find(_.nonEmpty)
            .flatten
        }
      }
    }

    place(Nil)
  }

  def main(args: Array[String]) {
    val n = if (args.length > 0) args(0).toInt else 13
    val sol = time { nQueens(n) }
    println("sol: "+ sol)
  }
}