object Happy extends App {
  def sumOfDigitsSquared(n: Int): Int = if (n == 0) 0 else scala.math.pow((n % 10), 2).toInt + sumOfDigitsSquared(n/10)
  def isHappy(n: Int): Boolean = if (n / 10 == 0 && (n == 1 || n == 4)) (n == 1) else isHappy(sumOfDigitsSquared(n))
  def kThHappy(k: Int): Int = if (k == 1) 1 else findHappy(kThHappy(k - 1) + 1)
  def findHappy(n: Int): Int = if (isHappy(n)) n else findHappy(n + 1)
 }


