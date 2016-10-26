object Queen3 {
  import NQueenMisc._

  def nQueens(n: Int): Option[PartialBoard] = {
    def place(board: PartialBoard, 
              nextTrial: () => Option[PartialBoard],
              onSuccess: PartialBoard => Option[PartialBoard]): Option[PartialBoard] = {
      val numRemaining = n - board.length
      numRemaining match {
        case 0 => onSuccess(board)
        case _ => {
          val possibleLocs = (1 to n).map(y => (numRemaining , y))
                .filter(loc => isSafe(loc, board))
                .toList

          val trialCont = possibleLocs.foldRight(nextTrial) ((loc, cb) =>
            () => place(loc::board, cb, onSuccess)
          )

          trialCont()
        }
      }
    }

    place(Nil, () => None, board => Some(board))
  }

  def main(args: Array[String]) {
    val n = if (args.length > 0) args(0).toInt else 13
    val sol = time { nQueens(n) }
    println("sol: "+ sol)
  }
}