package solver

object Solver {
  // solves expString == 0 for the variable in varName with an initial guess
  // specified. We'll assume that the given expression has a root.

  def solve(expString: String, varName: String, guess: Double): Double = {
    val ex = Parser(expString)
    val df = Process.differentiate(ex.get, varName)
    
    def wrapper(exp: Expression): Double => Double = {
	    (x: Double) => Process.eval(exp, Map(varName -> x))
	}

	def loop(n: Integer, guess: Double): Double = {
		if (n == 0) guess else loop(n - 1, Newton.solve(wrapper(ex.get), wrapper(df), guess).get)
	}

	loop(100, guess)

    // TODO: complete the implementation. This will construct the 
    // appropriate functions and call Newton.solve

    // 0
    // throw new Exception("Not yet completed") // <- remove me when you're done
  }
}
