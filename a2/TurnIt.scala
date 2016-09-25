// object TurnIt extends App {
//   def transpose(A: List[List[Int]]): List[List[Int]] = {
//     def transposeH(A: List[List[Int]], B:List[List[Int]]): (List[Int], List[List[Int]]) = {
//       // if (A.isEmpty && B.isEmpty) (Nil, Nil) else
//       if (A.isEmpty || A.head.isEmpty) (Nil, Nil) else {
//         var transPair:(List[Int], List[List[Int]]) = transposeH(A.tail, B)
//         println(transPair._1)
//         println(transPair._2) 
//         (A.head.head :: transPair._1, A.head.tail :: transPair._2)       
//       }
//     }
    
//     // var transPair:(List[Int], List[List[Int]]) = transposeH(A, Nil)
//     // if (transPair._2.isEmpty) 
//     transposeH(A, Nil)
//     // println(transposeH(A, Nil)._1)
//     // println(transposeH(A, Nil)._2)
//     List(Nil)
  
    // if A.head.isEmpty)
  // print(transposeH(A), "\n")
  // print(transposeH(chopHead(a)), "\n")
 //   print(transposeH(chopHead(chopHead(a))), "\n")
 //   print(transposeH(chopHead(chopHead(chopHead(a)))), "\n")
    // print(chopHead(chopHead(chopHead(a))).head.isEmpty, "\n")
    // print(chopHead(chopHead(chopHead(chopHead(a)))), "\n")
    // print(chopHead(A), "\n")
    // print(transposeH(A), "\n")
  // }
  // def th(N: Int, B: List[Int]): List[List[Int]] = if (N == 0) Nil else B :: th(N - 1, B)
  // val a: List[Int] = (1 to 2000).toList
  // val b: List[List[Int]] = th(2000, a)

  // // println(b)
  // println("hello1")
  // val _ = transpose(b)
  // println("Hello World")
// }
object TurnIt extends App {
  def transpose(A: List[List[Int]]): List[List[Int]] = {
  	def transposeH(A: List[List[Int]]): List[Int] = if (A.isEmpty || A.head.isEmpty) Nil else A.head.head :: transposeH(A.tail)
  	def chopHead(A: List[List[Int]]): List[List[Int]] = if (A.isEmpty || A.head.isEmpty) Nil else A.head.tail :: chopHead(A.tail)
  	if (A.head.length == 1) List(transposeH(A)) else transposeH(A) :: transpose(chopHead(A))
  	
  	// if A.head.isEmpty)
	// print(transposeH(A), "\n")
	// print(transposeH(chopHead(a)), "\n")
 //  	print(transposeH(chopHead(chopHead(a))), "\n")
 //  	print(transposeH(chopHead(chopHead(chopHead(a)))), "\n")
  	// print(chopHead(chopHead(chopHead(a))).head.isEmpty, "\n")
  	// print(chopHead(chopHead(chopHead(chopHead(a)))), "\n")
  	// print(chopHead(A), "\n")
  	// print(transposeH(A), "\n")
  }
  // def th(N: Int, B: List[Int]): List[List[Int]] = if (N == 0) Nil else B :: th(N - 1, B)
  // val a: List[Int] = (1 to 2000).toList
  // val b: List[List[Int]] = th(2000, a)

  // // println(b)
  // println("hello1")
  // val _ = transpose(b)
  // println("Hello World")
}
