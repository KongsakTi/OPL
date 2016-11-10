import scala.util.Random
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

type CoffeeBeans = String
type GroundCoffee = String
case class Water(temperature: Int)
type Milk = String
type FrothedMilk = String
type Espresso = String
type Cappuccino = String

// some exceptions for things that might go wrong in the individual steps
// (we'll need some of them later, use the others when experimenting
// with the code):
case class GrindingException(msg: String) extends Exception(msg)
case class FrothingException(msg: String) extends Exception(msg)
case class WaterBoilingException(msg: String) extends Exception(msg)
case class BrewingException(msg: String) extends Exception(msg)


// dummy implementations of the individual steps (with wait and potential errors)
def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
  println("start grinding...")
  Thread.sleep(Random.nextInt(2000))
  if (beans == "baked beans") throw GrindingException("are you joking?")
  println("finished grinding...")
  s"ground coffee of $beans"
}

def heatWater(water: Water): Future[Water] = Future {
  println("heating the water now")
  Thread.sleep(Random.nextInt(2000))
  println("hot, it's hot!")
  water.copy(temperature = 85)
}

def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
  println("milk frothing system engaged!")
  Thread.sleep(Random.nextInt(2000))
  println("shutting down milk frothing system")
  s"frothed $milk"
}

def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
  println("happy brewing :)")
  Thread.sleep(Random.nextInt(2000))
  println("it's brewed!")
  "espresso"
}

def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"


def prepareCappuccino(): Future[Cappuccino] = {
  // Doesn't wait for each others
  // ------------------------------------------------
  val groundCoffee = grind("arabica beans")
  val hotWater = heatWater(Water(28))
  val frothedMilk = frothMilk("skim milk")
  // ------------------------------------------------

  for { ground <- groundCoffee
        water <- hotWater
        foam <- frothedMilk
        // Needs above to continue
        espresso <- brew(ground, water) }
      yield combine(espresso, foam)
}

prepareCappuccino().onComplete {
  case Success(v) => println("I'm Done =)")
  case Failure(e) => println("Shit happened =(: " + e.getMessage)
}
