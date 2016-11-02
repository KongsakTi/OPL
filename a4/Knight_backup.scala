package a4

// TODO: Fix hasRouteHome, Add CycleTour

object Knight extends App {
  type loc = (Int, Int)
  def moves = List((1,2), (1,-2), (-1,2), (-1,-2), (2,1), (2,-1), (-2,1), (-2,-1))
  def success = () => true
  def fail    = () => false

  def isValidMove(at: loc, n: Int, visited: Set[loc]): Boolean = {
    (at, n) match {
      case((row, col), n) =>  (row <= n) &&
                              (col <= n) &&
                              (row > 0) &&
                              (col > 0) &&
                              !visited.contains(at)
    }
  }

  // get all the possible and valid moves
  def getPossibleMoves(at: loc, n: Int, visited: Set[loc]): List[loc] = {
    moves.map(move => (at._1 + move._1, at._2 + move._2))
        .filter((move => isValidMove(move, n, visited)))
  }

  // Possible StackOverflow when false
  def hasRouteHome(at: loc, n: Int, visited: Set[loc],
                    onSuccess: () => Boolean = success,
                    onFail: () => Boolean = fail): Boolean = {
    at match {
      case (1,1) => onSuccess()
      case _ => {
        val len = visited.size
        // println(at, n, len)
        val new_visited = visited + at
        val possibleMoves = getPossibleMoves(at, n, new_visited)

        val trialCont = possibleMoves.foldLeft(onFail) ((cb, move) =>
          () => hasRouteHome(move, n, new_visited, onSuccess, cb)
        )
        trialCont()
      }
    }
  }

    // val trialCont = possibleLocs.foldRight(nextTrial) ((loc, cb) =>
    //   () => place(loc::board, cb, onSuccess)
    // )

  def findAllCycles(n: Int): List[List[(Int,Int)]] = ???

  def findOneCycle(n: Int): Option[List[(Int,Int)]] = ???
}
