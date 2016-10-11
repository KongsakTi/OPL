import scala.io.Source

object WordCount extends App {
	def countPerLine(line: String): Int = 
		line.split("\\W+")
			.length
	val wordsPerLine = Source.stdin
							 .getLines
							 .map(countPerLine)
							 .toSeq

	val lineCount = wordsPerLine.length
	val WordCount = wordsPerLine.sum

	println(s"lineCount: $lineCount")
	println(s"wordsCount: $wordCount")
}