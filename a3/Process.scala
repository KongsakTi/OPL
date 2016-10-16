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
      case Constant(_) => Constant(0)
      case Var(_) => Constant(1)
      case Sum(l, r) => Sum(differentiate(l, varName), differentiate(r, varName))

      // constant * x
      case Prod(l @ Constant(_), r @ Var(_)) => l
      case Prod(l @ Var(_), r @ Constant(_)) => r

      // constant * x^constant
      case Prod(l @ Constant(_), r @ Power(_, _)) => Prod(l, differentiate(r, varName))
      case Prod(l @ Power(_, _), r @ Constant(_)) => Prod(r, differentiate(l, varName))

      // exp * x^exp
      case Prod(l, r @ Power(_, _)) => Prod(l, differentiate(r, varName))
      case Prod(l @ Power(_, _), r) => Prod(r, differentiate(l, varName))

      // Product Rule
      case Prod(l @ Sum(_, _), r @ Sum(_, _)) => Sum(Prod(differentiate(l, varName), r), Prod(l, differentiate(r, varName)))

      // exp * x
      case Prod(l ,r @ Var(_)) => Prod(l, differentiate(r, varName))
      case Prod(l @ Var(_), r) => Prod(r, differentiate(l, varName))

      // exp * constant
      case Prod(l, r @ Constant(_)) => Prod(differentiate(l, varName), r)
      case Prod(l @ Constant(_), r) => Prod(differentiate(r, varName), l)

      // e * e
      case Prod(l, r) => Prod(differentiate(l, varName), differentiate(r, varName))
      
      // x^constant
      case Power(l @ Var(_), r) => Prod(r, Power(l, Sum(r, Constant(-1))))

      // Chain Rule
      case Power(l @ Sum(_, _), r) => Prod(r, Prod(differentiate(l, varName), Power(l, Sum(r, Constant(-1)))))
      case Power(l @ Prod(_, _), r) => Prod(r, Prod(differentiate(l, varName), Power(l, Sum(r, Constant(-1)))))
      
      // constant ^ exp
      case Power(l @ Constant(_), r) => Constant(0)
     
    }
    
  }



 // //  forms a new expression that simplifies the given expression e: Expression
 // //  the goal of this function is produce an expression that is easier to
 // //  evaluate and/or differentiate.  If there's a canonical form you'd like to
 // //  follow, use this function to put an expression in this form.
	// // you may leave this function blank if can't find any use. 
 //  def simplify(e: Expression): Expression = {
 //    e match {
 //      case Var(x) => Var(x)
 //      case Constant(x) => Constant(x)

 //      case Sum(l @ Constant(x), r @ Constant(y)) => Constant(x + y)
 //      case Sum(l, r) => Sum(simplify(l), simplify(r))

 //      // case Sum(l @ Constant(_), r) => Sum(l, simplify(r))
 //      // case Sum(l, r @ Constant(_)) => Sum(r, simplify(l))
      
 //      case Prod(l @ Constant(x), r @ Constant(y)) => Constant(x * y)
 //      case Prod(l, r) => Prod(simplify(l), simplify(r))
      
 //      // case Prod(l @ Constant(_), r) => Prod(l, simplify(r))
 //      // case Prod(l, r @ Constant(_)) => Prod(r, simplify(l))

 //      case Power(l @ Constant(x), r @ Constant(y)) => Constant(math.pow(x, y))
 //      case Power(l, r) => Power(simplify(l), simplify(r))

 //      // case Power(l @ Constant(_), r) => Power(l, simplify(r))
 //      // case Power(l, r @ Constant(_)) => Power(r, simplify(l))

 //    }
    
 //    // throw new Exception("Not yet implemented")
 //  }

}
