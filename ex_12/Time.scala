class a(h: Int, m: Int) extends Ordered[Time] {

  val hm = normalize(h, m)
  val hour = hm._1
  val minute = hm._2

  private def normalize(h: Int, m: Int): (Int, Int) = {
    val total = h*60 + m
    ((total/60)%24, total%60)
  }

  def compare(that: Time) = (hour*60 + minute) - (that.hour*60 + that.minute)
}
