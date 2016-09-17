object ex1 extends App {
	def loop: Boolean = loop
	def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false
	def or(x: Boolean, y: => Boolean): Boolean = if (x) true else y

	println(and(true, true))
	println(and(true, false))
	println(and(false, true))
	println(and(false, false))
	println("---------------")
	println(and(false, loop))

	println("===============")

	println(or(true, true))
	println(or(true, false))
	println(or(false, true))
	println(or(false, false))
	println("---------------")
	println(or(true, loop))
}