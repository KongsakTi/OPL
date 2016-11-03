// package a4
//
// // TODO: Fix CycleTour StackOverflow
//
// object Knight extends App {
//   type Loc = (Int, Int)
//   def home = (1,1)
//   def moves = List((1,2), (1,-2), (-1,2), (-1,-2), (2,1), (2,-1), (-2,1), (-2,-1))
//   def success = (map: Map[Loc, Int]) => {
//     println("YEAH")
//     map
//   }
//   def fail    = () => Map[Loc, Int]()
//
//   def isValidMove(at: Loc, n: Int, visited: Map[Loc, Int]): Boolean = {
//     (at, n) match {
//       case((row, col), n) =>  (row <= n) &&
//                               (col <= n) &&
//                               (row > 0) &&
//                               (col > 0) &&
//                               !visited.contains(at)
//     }
//   }
//
//   // get all the possible and valid moves
//   def getPossibleMoves(at: Loc, n: Int, visited: Map[Loc, Int]): List[Loc] = {
//     moves.map(move => (at._1 + move._1, at._2 + move._2))
//         .filter((move => isValidMove(move, n, visited)))
//   }
//
//   // DFS -> StackOverflow
//   // BFS -> Good Life =)
//   def hasRouteHome(at: Loc, n: Int, visited: Map[Loc, Int]): Boolean = {
//     def hasRouteHome_helper(ats: List[Loc], visited: Map[Loc, Int]): Boolean = {
//       ats match {
//         case Nil => false
//         case _ => if (ats.contains(home)) true else {
//           val next_ats = ats.map(at => getPossibleMoves(at, n, visited))
//                             .flatten
//           val new_visited = next_ats.foldLeft(visited)((acc, at) => acc + (at -> 1))
//           hasRouteHome_helper(next_ats, new_visited)
//         }
//       }
//     }
//     hasRouteHome_helper(List(at), visited)
//   }
//
//   def findAllCycles(n: Int): List[List[(Int,Int)]] = ???
//
//   // StackOverflow Again !!!
//   // PS: Always end with (1, 1) since guarantee to have route home
//   def findOneCycle(n: Int): Option[List[(Int,Int)]] = {
//     val totalLocs = n * n - 1
//     def nextMove(at: Loc, visited: Map[Loc, Int],
//                 onSuccess: (Map[Loc, Int]) => Map[Loc, Int],
//                 onFail: () => Map[Loc, Int]): Map[Loc, Int] = {
//
//       println(at, visited.keys.toList, visited.size)
//
//       (at, visited.isEmpty, visited == totalLocs) match {
//         case ((1,1), false, true) => onSuccess(visited)
//         case ((1,1), false, _) => {
//           println("----------------")
//           onFail()
//         }
//         case _ => {
//           val new_visited = if (at != home) visited + (at -> 1) else visited
//           val possibleMoves = getPossibleMoves(at, n, new_visited)
//                               .filter(move => hasRouteHome(move, n, new_visited))
//           // println(new_visited, possibleMoves)
//           val trialCont = possibleMoves.foldLeft(onFail)((cb, move) =>
//             () => nextMove(move, new_visited, onSuccess, cb)
//           )
//           trialCont()
//         }
//       }
//     }
//     val cycleTour = nextMove(home, Map(), success, fail)
//     println(cycleTour)
//     if (cycleTour.isEmpty) None else Some(cycleTour.keys.toList)
//   }
//
// }

package a4

// TODO: Fix CycleTour StackOverflow

object Knight extends App {
  type Loc = (Int, Int)
  def home = (1,1)
  def moves = List((1,2), (1,-2), (-1,2), (-1,-2), (2,1), (2,-1), (-2,1), (-2,-1))
  def success = (map: Map[Loc, Int]) => {
    println("YEAH")
    Some(map.keys.toList)
  }
  def fail    = () => None

  def isValidMove(at: Loc, n: Int, visited: Map[Loc, Int]): Boolean = {
    (at, n) match {
      case((row, col), n) =>  (row <= n) &&
                              (col <= n) &&
                              (row > 0) &&
                              (col > 0) &&
                              !visited.contains(at)
    }
  }

  // get all the possible and valid moves
  def getPossibleMoves(at: Loc, n: Int, visited: Map[Loc, Int]): List[Loc] = {
    moves.map(move => (at._1 + move._1, at._2 + move._2))
        .filter((move => isValidMove(move, n, visited)))
  }

  // DFS -> StackOverflow
  // BFS -> Good Life =)
  def hasRouteHome(at: Loc, n: Int, visited: Map[Loc, Int]): Boolean = {
    def hasRouteHome_helper(ats: List[Loc], visited: Map[Loc, Int]): Boolean = {
      ats match {
        case Nil => false
        case _ => if (ats.contains(home)) true else {
          val next_ats = ats.map(at => getPossibleMoves(at, n, visited))
                            .flatten
          val new_visited = next_ats.foldLeft(visited)((acc, at) => acc + (at -> 1))
          hasRouteHome_helper(next_ats, new_visited)
        }
      }
    }
    hasRouteHome_helper(List(at), visited)
  }

  def findAllCycles(n: Int): List[List[(Int,Int)]] = ???

  // StackOverflow Again !!!
  // PS: Always end with (1, 1) since guarantee to have route home
  def findOneCycle(n: Int): Option[List[(Int,Int)]] = {
    val totalLocs = n * n - 1
    def nextMove(at: Loc, visited: Map[Loc, Int],
                onSuccess: (Map[Loc, Int]) => Option[List[Loc]],
                onFail: () => Option[List[Loc]]): Option[List[Loc]] = {

      (at, visited.isEmpty, visited == totalLocs) match {
        case ((1,1), false, true) => onSuccess(visited)
        case ((1,1), false, _) => {
          println("----------------")
          onFail()
        }
        case _ => {
          val new_visited = if (at != home) visited + (at -> 1) else visited
          val possibleMoves = getPossibleMoves(at, n, new_visited)
                              .filter(move => hasRouteHome(move, n, new_visited))
          println(new_visited.keys.toList, possibleMoves)
          val trialCont = possibleMoves.foldRight(onFail)((move, cb) =>
            () => nextMove(move, new_visited, onSuccess, cb)
          )
          trialCont()
        }
      }
    }
    nextMove(home, Map(), success, fail)
  }
}
