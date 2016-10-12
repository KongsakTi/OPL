// sealed trait Expr
// case class Constant(n: Double) extends Expr
// case class Negate(e: Expr) extends Expr
// case class Sum(e1: Expr, e2: Expr) extends Expr
// case class Prod(e1: Expr, e2: Expr) extends Expr

// def mapConst(e: Expr, f: Double => Double): Expr = {
// 	e match {
// 		case Constant(n) => Constant(f(n))
// 		case Negate(e_) => Negate(mapConst(e_, f))
// 		case Sum(e1, e2) => Sum(mapConst(e1, f), mapConst(e2, f))
// 		case Prod(e1, e2) => Prod(mapConst(e1, f), mapConst(e2, f))
// 	}
// }


// // ###########################################################################


// val xs = "true, false, true, true, false, false"

// def convertBool(st: String): List[Boolean] = {
// 	def mkBool(tok: String): Boolean = tok.toLowerCase match {
// 		case "true" => true
// 		case "false" => false
// 	}

// 	val entries = st.split(",")
// 					.map(mkBool)
// 					.toList
// 	entries
// }

// // ---------------------------------------

// case class InvalidToken(s: String) extends Exception

// def convertBool(st: String): List[Boolean] = {
// 	def mkBool(tok: String): Boolean = tok.toLowerCase match {
// 		case "true" => true
// 		case "false" => false
// 		case _ => throw InvalidToken(tok)
// 	}

// 	val entries = st.split(",")
// 					.map(mkBool)
// 					.toList
// 	entries
// }

// // ---------------------------------------

// case class InvalidToken(s: String) extends Exception

// def convertBool(st: String): Option[List[Boolean]] = {
// 	def mkBool(tok: String): Boolean = tok.toLowerCase match {
// 		case "true" => true
// 		case "false" => false
// 		case _ => throw InvalidToken(tok)
// 	}

// 	try {
// 		val entries = st.split(",")
// 						.map(mkBool)
// 						.toList
// 		Some(entries)
// 	} catch {
// 		case InvalidToken(_) => None
// 	}
// }

// // ###########################################################################

// def longerThan(xs: List[String], s: String) = xs.filter(t => t.length > s.length)

// def betterLongerThan(xs: List[String], s: String) = {
// 	val lenOfS = s.length
// 	xs.filter(t => t.length > lenOfS)
// }

// // ###########################################################################

// def fib(n: Int) Long = if (n <= 2) 1 else fib(n - 1) + fib(n - 2)

// def mkFibFoo(t: Int) = (x: Long) => fib(t) + x
// def mkBetterFibFoo(t: Int) = {
// 	val fibt = fib(t)
// 	(x: Long) => fibt + x
// }
// def mkWeirdFibFoo(t: Int) = {
// 	lazy val fibt = fib(t)
// 	(x: Long) => fibt + x
// }

// // ###########################################################################

// // ****
// def exists(p: Double => Boolean, e: Expr): Boolean = {
// 	e match {
// 		case Constant(n) => p(n)
// 		case Negate(e_) => exists(p, e_)
// 		case Sum(e1, e2) => exists(p, e1) || exists(p, e2)
// 		case Prod(e1, e2) => exists(p, e1) || exists(p, e2)
// 	}
// }
// ****

import scala.io.Source

object uniqueWordCount extends App {
	def wordsInLine(line: String): List[String] = 
		line.split("\\W+")
			.toList
	val wordsPerLine = Source.stdin
							 .getLines
							 .map(wordsInLine)
							 .toList

	println(wordsPerLine)
}