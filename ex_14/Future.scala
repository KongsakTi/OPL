import scala.util{Success, Failure}

val f = Future { fib(50) }

f.onComplete {
  case Success(v) => println("good $v")
  case Failure(e) => println("Error: " + e.getMessage)
}
