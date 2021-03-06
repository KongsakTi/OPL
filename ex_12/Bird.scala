abstract class Bird {
    def squeak() = println("Gtrtyuikmjnbgf")
}

trait Flying {
    def flyMessage: String
    def fly() = println(flyMessage)
}
trait Swimming {
    def swim() = println("I can swim")
}

class Pigeon extends Bird with Flying with Swimming{ // not the same as Swimming Flying, might overide
    val flyMessage = "Pigeonn"
}
class Hawk extends Bird with Flying with Swimming{
    val flyMessage = "Hawkk"
}
class Penguin extends Bird with Swimming
class Kiwi extends Bird
