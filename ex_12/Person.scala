class Person(name: String) {
  private val tmp = name.split(" ")
  val firstName = tmp(0)
  val lastName = tmp(1)
}
