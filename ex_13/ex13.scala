def isPrime(n: Int) = (2 until n) forall (d => n%d != 0)
//
// def toN(n: Int) Stream[Int] = {
//   def next(i: Int): Stream[Int] = if (i > n) Stream.empty else i #:: next(i+1)
//   next(1)
// }

def SecondPrimeBetween(a: Int, b: Int) = {
  def between_helper(i: Int): Stream[Int] = if (i > b) Stream.empty else i #:: between_helper(i + 1)
  between_helper(a).filter(isPrime(_))(1)
}

def fib: Stream[Long] = {
  def next(prev: Long, twoPrev: Long): Stream[Long] = {
    val f = prev + twoPrev
    f #:: next(f, prev)
 }
 1 #:: next(1, 0)
}

def prime(upto: Int) = {
  val primeList = (2 to upto).foldLeft(Nil: List[Int]) ( (primeSoFar, num) => {
      val numIsPrime = primeSoFar.forall {p => num % p != 0}
      if (numIsPrime) num :: primeSoFar
      else primeSoFar
    }
  )
  primeList.reverse
}

def allPrimes: Stream[Long] = {
  def from(n: Long): Stream[Long] = n #:: from(n + 1)
  def next(psf: List[Long], start: Long): Stream[Long] = {
    def primeWrtPSF(num: Long) = psf.forall(d => num % d != 0)
    (from(start) find primeWrtPSF) match {
      case Some(p) => p #:: next(p :: psf, p + 1)
      case None => throw new Exception("impossible")
    }
  }
  next(List(), 2)
}
