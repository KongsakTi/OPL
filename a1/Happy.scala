object Happy extends App {
  // todo: write these functions!
  def sumOfDigitsSquared(n: Int): Int = if (n == 0) 0 else scala.math.pow((n % 10), 2).toInt + sumOfDigitsSquared(n/10)
  def isHappy(n: Int): Boolean = if (n / 10 == 0 && (n == 1 || n == 4)) (n == 1) else isHappy(sumOfDigitsSquared(n))
  def kThHappy(k: Int): Int = if (k == 1) 1 else findHappy(kThHappy(k - 1) + 1)
  def findHappy(n: Int): Int = if (isHappy(n)) n else findHappy(n + 1)

  // println(sumOfDigitsSquared(7))
  // println(sumOfDigitsSquared(145))
  // println(sumOfDigitsSquared(199))

  // println(isHappy(100))
  // println(isHappy(111))
  // println(isHappy(1234))
  // println(isHappy(989))

  // println(findHappy(1))
  // println(findHappy(2))
  // println(findHappy(3))
  // println(findHappy(7))
  // println(findHappy(8))
  // println(findHappy(9))

  // println(kThHappy(1))
  // println(kThHappy(3))
  // println(kThHappy(11))
  // println(kThHappy(19))

  // println(test(0))
  // println(test(1))
  // println(test(2))
 }


