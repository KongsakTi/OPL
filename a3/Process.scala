package solver

object Process {
  // gives a "pretty-print" string form of the expression
  def stringify(e: Expression): String = e match {
    case Constant(c) => c.toString
    case Var(name) => name
    case Sum(l, r) => stringify(l) + " + " + stringify(r)
    case Prod(l @ Sum(_, _), r @ Sum(_, _)) => "(" + stringify(l) + ") * (" + stringify(r) + ")"
    case Prod(l @ Sum(_, _), r) => "(" + stringify(l) + ") * " + stringify(r)
    case Prod(l, r @ Sum(_, _)) => stringify(l) + " * (" + stringify(r) + ")"
    case Prod(l, r) => stringify(l) + " * " + stringify(r)
    case Power(b, e) => stringify(b) + "^" + stringify(e)
  }

  // evaluates a given expression e: Expression using
  // the variable settings in varAssn: Map[String, Double],
  // returning the evaluation result as a Double.

  // Example: eval(e, Map("x" -> 4.0)) evaluates the expression 
  // with the variable "x" set to 4.0.
  def eval(e: Expression, varAssn: Map[String, Double]): Double =  {
    e match {
      case Constant(c) => c
      case Var(x) => varAssn.get(x).get
      case Sum(l, r) => eval(l, varAssn) + eval(r, varAssn)
      case Prod(l, r) => eval(l, varAssn) * eval(r, varAssn)
      case Power(l, r) => math.pow(eval(l, varAssn),eval(r, varAssn))
    }
  }

  // symbolically differentiates an expression e: Expression with 
  // respect to the variable varName: String
  def differentiate(e: Expression, varName: String): Expression = {
    e match {
      case Constant(c) => Constant(0)
      case Var(x) => Constant(1)
      case Sum(l, r) => Sum(differentiate(l, varName), differentiate(r, varName))
      case Prod(l @ Var(x), r ) => Prod(differentiate(l, varName), differentiate(r, varName)) 
      case Prod(l, r) => Prod(differentiate(l, varName), differentiate(r, varName))
      case Power(l @ Var(x), r) => Prod(r, Power(l, Sum(r, Constant(-1))))
    }
    
  }

  // forms a new expression that simplifies the given expression e: Expression
  // the goal of this function is produce an expression that is easier to
  // evaluate and/or differentiate.  If there's a canonical form you'd like to
  // follow, use this function to put an expression in this form.
	// you may leave this function blank if can't find any use. 
  def simplify(e: Expression): Expression = {
    e match {
      // case Constant(x) => if (x == 0) None else Constant(x)
      case Constant(x) => 
      case Var(x) => Var(x)
      case Sum(l @ Constant(x), r @ Constant(y)) => Constant(x + y)
      case Sum(l @ Var(x), r @ Constant(y)) => Sum(Var(x), r)
      case Sum(l @ Constant(x), r @ Var(y)) => Sum(l, Var(y))
      case Sum(l, r) => Sum(simplify(l), simplify(r))
      case Prod(l @ Constant(x), r @ Constant(y)) => Constant(x * y)
      case Prod(l, r) => Prod(l, r)
      case Power(l, r) => Power(l, r)
    }
    
    // throw new Exception("Not yet implemented")
  }

}
