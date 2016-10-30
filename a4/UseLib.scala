package a4

object UseLib extends App {
  def onlyBeginsWithLower(xs: List[String]): List[String] = xs.filter( (x: String) => x.head == x.head.toString.toLowerCase.head)

  def longestString(xs: List[String]): Option[String] = if (xs.isEmpty) None else Some(xs.maxBy( (x: String) => x.length ))

  def longestLowercase(xs: List[String]): Option[String] = longestString(onlyBeginsWithLower(xs))
}
