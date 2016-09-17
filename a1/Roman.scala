object Roman extends App {
  // todo: implement it
  def toRoman(n: Int): String = {
  	if (n >= 1000)	"M"		+ toRoman(n - 1000)		else
  	if (n >= 900)	"CM" 	+ toRoman(n - 900)		else
  	if (n >= 500)	"D"		+ toRoman(n - 500)		else
  	if (n >= 400)	"CD"	+ toRoman(n - 400)		else 
  	if (n >= 100)	"C"		+ toRoman(n - 100)		else
  	if (n >= 90)	"XC"	+ toRoman(n - 90) 		else
  	if (n >= 50)	"L"		+ toRoman(n - 50) 		else
  	if (n >= 40)	"XL"	+ toRoman(n - 40)		else
  	if (n >= 10)	"X" 	+ toRoman(n - 10)		else 
  	if (n == 9)		"IX" 							else
  	if (n >= 5)		"V" 	+ toRoman(n - 5)  		else  
  	if (n == 4)		"IV" 				  			else
  	if (n >= 1)		"I" 	+ toRoman(n - 1) 		else ""
  }
}
