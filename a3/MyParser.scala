package solver

object MyParser {

  sealed trait Token
  case class Const(x: Double) extends Token
  case object Times extends Token
  case object Plus extends Token
  case object Minus extends Token
  case object Expo extends Token
  case object LParen extends Token
  case object RParen extends Token
  case class Varr(x: String) extends Token

  // your implementation of a parser that takes in an input String
  // and returns an option: None if the input is not a well-formed
  // expression. Otherwise, it evaluates to Some(e) where e is an
  // Expression which encodes the input string.
  def parse(input: String): Option[Expression] = {
    def matchOp(left: Expression, right: Expression, op: Token): Expression = {
      op match {
        case Plus => Sum(left, right)
        case Minus => Sum(left, Prod(Constant(-1), right))
        case Times => Prod(left, right)
        case Expo => Power(left, right)
      }
    }
    // Prev op is Higher than Curr op
    def isHigherOp(prev: Token, curr: Token): Boolean = {
      (prev, curr) match {
        case (Expo, _) => true
        case (_, Expo) => false
        case (Times, _) => true
        case (_, Times) => false
        case (_, _) => false
      }
    }

    def unStack(exp: List[Expression], tks: List[Token]): Expression = {
      if (!tks.isEmpty) unStack(matchOp(exp.tail.head, exp.head, tks.head) :: exp.tail.tail, tks.tail) else exp.head
    }

    def findParen(exp: List[Expression], tks: List[Token]): (List[Expression], List[Token]) = {
      if (tks.head == LParen) (exp, tks.tail) else findParen(matchOp(exp.tail.head, exp.head, tks.head) :: exp.tail.tail, tks.tail)
    }

    def parser(lst: List[Token], exp: List[Expression], tks: List[Token]): Expression = {
      if (lst.isEmpty) {
        return unStack(exp, tks)
      } else {
        lst.head match {
          case Const(x) => parser(lst.tail, Constant(x) :: exp, tks)
          case Varr(x) => parser(lst.tail, Var(x) :: exp, tks)
          case LParen => parser(lst.tail, exp, lst.head :: tks)
          case RParen => {
            val tmp = findParen(exp, tks)
            parser(lst.tail, tmp._1, tmp._2)
            }
          case _ => if (!tks.isEmpty && isHigherOp(tks.head, lst.head)) {
                      parser(lst, matchOp(exp.tail.head, exp.head, tks.head) :: exp.tail.tail, tks.tail)
                    } else {
                      parser(lst.tail, exp, lst.head :: tks)
                    }

        }
      }
    }
    Some(parser(tokenize(input).get, Nil, Nil))
  }

  def tokenize(input:String): Option[List[Token]] = {
    val const = """(\d+(\.\d+){0,1})""".r
    val vari = "([a-z])".r
    val (lparen, rparen, plus, minus, time, expo) =
      ("\\(".r, "\\)".r, "\\+".r, "\\-".r, "\\*".r, "\\^".r)

    val TOKEN_PATTERN = "(\\(|\\)|\\d+(\\.\\d+){0,1}|[\\+\\-/]|\\*|\\^|[a-z])".r
    case object BadToken extends Exception

    try {
      val tokens = TOKEN_PATTERN.findAllMatchIn(input)
        .toList
        .map {
          case const(number,_*) => Const(number.toDouble)
          case lparen(_*) => LParen
          case rparen(_*) => RParen
          case plus(_*) => Plus
          case minus(_*) => Minus
          case time(_*) => Times
          case expo(_*) => Expo
          case vari(name) => Varr(name.trim)
          case _ => throw BadToken
        }

        Some(tokens)
      } catch { case BadToken => None }
  }
  def apply(input: String): Option[Expression] =
    parse(input)
}
