:load Polling.scala
import Polling._

winner(List(("A", 1), ("A", 3), ("B", 4))) == ("A", 4)
winner(List(("A", 1), ("A", 2), ("B", 4))) == ("B", 4)
winner(List(("A", 1), ("A", 4), ("B", 4))) == ("A", 5)
winner(List(("B", 1), ("A", 2), ("B", 4), ("A", 3))) == ("A", 5)
winner(List(("Scala", 5), ("Java", 10), ("C", 2), ("Scala", 7), ("ZeroMQ", 12))) == ("Scala", 12)
winner(List(("Scala", 4), ("Java", 10), ("C", 2), ("Scala", 7), ("ZeroMQ", 12))) == ("ZeroMQ", 12)