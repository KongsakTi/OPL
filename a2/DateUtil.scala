object DateUtil extends App {
  type Date = (Int, Int, Int)
  def normalMonths: List[Int] = List(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  def leapMonths:   List[Int] = List(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

  def isOlder(x: Date, y: Date): Boolean = {
    if (x._3 < y._3) true else
    if (x._3 > y._3) false else {
      if (x._2 < y._2) true else
      if (x._2 > y._2) false else {
        if (x._1 < y._1) true else false
      }
    } 
  }

  def numberInMonth(xs: List[Date], month: Int): Int = {
    def numberInMonthH(xs: List[Date], month:Int, n: Int): Int = {
      if (xs.isEmpty) n else {
        if (xs.head._2 == month) numberInMonthH(xs.tail, month, n + 1) else numberInMonthH(xs.tail, month, n)
      }
    }
    numberInMonthH(xs, month, 0)
  }

  def numberInMonths(xs: List[Date], months: List[Int]): Int = {
    def numberInMonthsH(xs: List[Date], months: List[Int], n:Int): Int = {
      if (months.isEmpty) n else  numberInMonthsH(xs, months.tail, n + numberInMonth(xs, months.head))
    }
    numberInMonthsH(xs, months, 0)
  }

  def datesInMonth(xs: List[Date], month: Int): List[Date] = {
    if (xs.isEmpty) Nil else {
      if (xs.head._2 == month) xs.head :: datesInMonth(xs.tail, month) else datesInMonth(xs.tail, month)
    }
  }

  def datesInMonths(xs: List[Date], months: List[Int]): List[Date] = {
    if (xs.isEmpty) Nil else {
      if (numberInMonths(List(xs.head), months) == 1) xs.head :: datesInMonths(xs.tail, months) else datesInMonths(xs.tail, months)
    }
  }

  def getMonth(month: Int, months: List[String]): String = if (month == 1) months.head else getMonth(month - 1, months.tail)

  def dateToString(d: Date): String = {
    var month: String = getMonth(d._2, List("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"))
    month + "-" + d._1 + "-" + d._3
  }
  def isLeapYear(yr: Int): Boolean = (yr % 4 == 0)

  def whatMonth(n: Int, yr: Int): Int = {
    def calMonth(d: Int, m: Int, ds: List[Int]): Int = {
      if (d <= 0) m else calMonth(d - ds.head, m + 1, ds.tail)
    }
    if (isLeapYear(yr)) calMonth(n, 0, leapMonths) else calMonth(n, 0, normalMonths)
  }

  def oldest(dates: List[Date]): Option[Date] = {
    def oldestH(dates: List[Date], oldDate: Date): Option[Date] = {
      if (dates.isEmpty) Some(oldDate) else {
        if (isOlder(oldDate, dates.head)) oldestH(dates.tail, oldDate) else oldestH(dates.tail, dates.head)
      }
    }
    if (dates.isEmpty) None else oldestH(dates.tail, dates.head)
  }

  def isReasonableDate(d: Date): Boolean = {
    def getMonthMax(m: Int, months: List[Int]): Int = if (m == 1) months.head else getMonthMax(m - 1, months.tail)
    var monthMax = getMonthMax(d._2, normalMonths)
    if (d._3 == 0) false else
    if (isLeapYear(d._3) && d._2 == 2) d._1 <= (monthMax + 1) else d._1 <= monthMax
  }
}
