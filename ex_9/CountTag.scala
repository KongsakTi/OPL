// input: url = "http://pantip.com"
// html tag: <em> <html> <body> <table>
// tagFreq(url: String, tag: String)


import scala.io.Source
import java.net.URL

def tagFreq(url: String) = {
	def fetchTags = {
		val lines = Source.fromURL(new URL(url), "ISO-8859-1")
						.getLines
		// RegEx
		// + : 1+
		// * : 0+
		// ? : 0 or 1
		val pattern = """<[a-zA-Z]+\s*/?>"""r
		def findAllTags(st: String) = pattern.findAllIn(st).toList
		val tags = lines.flatMap(findAllTags)
						.map(_.toLowercase)
						.toList
		tags
	}

	val allTags = fetchTags

	(tagName: String) => allTags.count(_ == tagName)
}