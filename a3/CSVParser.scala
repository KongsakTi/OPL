def parseCSV(s: String, acc: String, isQoute: Boolean, thisLine: List[String]): List[List[String]] = {
	if (s.length <= 1) return if (s == "\"") List((acc :: thisLine).reverse) else List(((acc + s) :: thisLine).reverse)
	val firChar = s.charAt(0)
	val secChar = s.charAt(1)
	(firChar, secChar) match {
		case ('"', '"')		=> if (isQoute) parseCSV(s.substring(2), acc + "\"", isQoute, thisLine) else parseCSV(s.tail, acc, true, thisLine)
		case ('"', _) 		=> if (isQoute) parseCSV(s.tail, acc, false, thisLine) else parseCSV(s.tail, acc, true, thisLine)
		case (',', _)		=> if (isQoute) parseCSV(s.tail, acc + ",", isQoute, thisLine) else parseCSV(s.tail, "", isQoute, acc :: thisLine)
		case (' ', _)		=> if (isQoute) parseCSV(s.tail, acc + " ", isQoute, thisLine) else parseCSV(s.tail, acc, isQoute, thisLine)
		case ('\n', _) 		=> if (isQoute) parseCSV(s.substring(2), acc + "\r\n", isQoute, thisLine) else (acc :: thisLine).reverse :: parseCSV(s.tail, "", isQoute, List())
		case ('\r', '\n') 	=> if (isQoute) parseCSV(s.substring(2), acc + "\r\n", isQoute, thisLine) else (acc :: thisLine).reverse :: parseCSV(s.tail, "", isQoute, List())
		case ('\n', '\r') 	=> if (isQoute) parseCSV(s.substring(2), acc + "\r\n", isQoute, thisLine) else (acc :: thisLine).reverse :: parseCSV(s.tail, "", isQoute, List())
		case (_, _) 		=> parseCSV(s.tail, acc + firChar, isQoute, thisLine)
	}
}
