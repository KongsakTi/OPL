package a4

object Currying extends App {

  // the exception NoAnswer that you will refer to
  case object NoAnswer extends Exception

  // declare your firstAnswer method here
  // it should be of type (A => Option[B]) => List[A] => B
  def firstAnswer[A, B](func: A => Option[B])(lst: List[A]): B = {
  	lst.map(func).find( x => x != None).flatten match {
  		case None => throw NoAnswer
  		// Avoid error warning [ case _ => _.get ]
  		case (x @ _) => x.get
  	}
  }

  // declare your allAnswers method here
  // it should be of type (A => Option[List[B]]) => List[A] => Option[List[B]]
  def allAnswers[A, B](func: A => Option[List[B]])(lst: List[A]): Option[List[B]] = {
  	val ans = lst.map(func)
  	ans.contains(None) match {
  		case true => None
  		case _ => Some(ans.flatten.flatten)
  	}
  }
}
