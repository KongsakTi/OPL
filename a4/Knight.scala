package a4

// TODO: Fix hasRouteHome, Add CycleTour

object Knight extends App {
  type Loc = (Int, Int)
  def moves = List((1,2), (1,-2), (-1,2), (-1,-2), (2,1), (2,-1), (-2,1), (-2,-1))
  def success = () => true
  def fail    = () => false

  def isValidMove(at: loc, n: Int, visited: Map[Loc, Int]): Boolean = {
    (at, n) match {
      case((row, col), n) =>  (row <= n) &&
                              (col <= n) &&
                              (row > 0) &&
                              (col > 0) &&
                              !visited.contains(at)
    }
  }

  // get all the possible and valid moves
  def getPossibleMoves(at: loc, n: Int, visited: Map[loc, Int]): List[Loc] = {
    moves.map(move => (at._1 + move._1, at._2 + move._2))
        .filter((move => isValidMove(move, n, visited)))
  }

  // Possible StackOverflow when false
  def hasRouteHome(at: loc, n: Int, visited: Map[loc, Int],
                    onSuccess: () => Boolean = success,
                    onFail: () => Boolean = fail): Boolean = {
    // println(at)
    at match {
      case (1,1) => onSuccess()
      case _ => {
        // val len = visited.size
        // println(at, n, len)

        val possibleMoves = getPossibleMoves(at, n, visited)

        // Die too, but not as miserable (Actually, this one is the guy below +1 size)
        val new_visited = possibleMoves.map(move => (move -> 1))
                                       .foldLeft(visited + (at -> 1))((acc, kv) => acc + kv)
        val trialCont = possibleMoves.foldLeft(onFail) ((cb, move) =>
          () => hasRouteHome(move, n, new_visited, onSuccess, cb)
        )

        // Die miserably
        // val trialCont = possibleMoves.foldLeft(onFail) ((cb, move) =>
        //   () => hasRouteHome(move, n, visited + (at -> 1), onSuccess, cb)
        // )

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
