:load Currying.scala

def f(x: Int): Option[Boolean] = if (x>100) Some(true) else if (x > 50) Some(false) else None
Currying.firstAnswer(f)(List(100,20,300))
Currying.firstAnswer(f)(List(100,200,300))
Currying.firstAnswer(f)(List(400,200,300))
Currying.firstAnswer(f)(List(20,10,30))
Currying.firstAnswer(f)(List(60,10,30))
Currying.firstAnswer(f)(List(20,10,30, 200))
Currying.firstAnswer(f)(Nil)

def g(x: Int): Option[List[Int]] = { if (x >= 0) Some((0 to x).toList) else None }

Currying.allAnswers(g)(List(1,2))
Currying.allAnswers(g)(List(1,2,-3))
Currying.allAnswers(g)(Nil)