// Simple server
import java.net._
import java.io._
import scala.io._

val server = new ServerSocket(9999)
while (true) {
    val s = server.accept()
    val in = new BufferedSource(s.getInputStream()).getLines()
    val out = new PrintStream(s.getOutputStream())

    out.println(in.next() + " Got you bruh")
    out.flush()
    s.close()
}
