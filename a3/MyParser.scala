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
    def isHigherOp(p_op: Token, c_op: Token): Boolean = {
      (p_op, c_op) match {
        case (Expo, _) => false
        case (Times, Expo) => true
        case ()
      }
    }
    def parser(lst: List[Token]): Expression = {
      if (lst.length <= 1) lst.head match {
        case Const(x) => Constant(x)
        case Varr(x) => Var(x)
      } else if (lst.length >= 4){
        val val_1 = lst.head
        val ops_1 = lst.tail.head
        val val_2 = lst.tail.tail.head
        val ops_2 = lst.tail.tail.tail.head
        val theRest = lst.tail.tail.tail.tail
        
        // println(theRest)

        (ops_1, ops_2) match {

          case (Expo, _) => matchOp(Power(parser(List(val_1)), 
                                          parser(List(val_2))),
                                    parser(theRest), ops_2)

          case (Times, Expo) => Prod(parser(List(val_1)), parser(lst.tail.tail))
          
          case (Times, _) => matchOp(Prod(parser(List(val_1)), 
                                          parser(List(val_2))), 
                                     parser(theRest), ops_2)


          case (Plus, _) => Sum(parser(List(val_1)), parser(lst.tail.tail))

        }
      } else {
        val val_1 = lst.head
        val ops_1 = lst.tail.head
        val val_2 = lst.tail.tail.head
        matchOp(parser(List(val_1)), parser(List(val_2)), ops_1)
      }
      
    }
    Some(parser(tokenize(input).get))
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
