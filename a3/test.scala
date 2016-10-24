val s_1 = "x^2 + 3 * x - 2"
val e_1 = Parser(s_1).get
val p_1 = Process.differentiate(e_1, "x")
val x_1 = 5
val v_1 = Process.eval(p_1, Map("x" -> x_1))
val r_1 = "2 * x + 3"
val a_1 = 13

println(s_1, x_1)
println(r_1, v_1)

// --------------------------------------------------------

val s_2 = "(3 * 6) * x - 2"
val e_2 = Parser(s_2).get
val p_2 = Process.differentiate(e_2, "x")
val x_2 = 5
val v_2 = Process.eval(p_2, Map("x" -> x_2))
val r_2 = "18"
val a_2 = 18

println(s_2, x_2)
println(r_2, v_2)

// --------------------------------------------------------

val s_3 = "3 * x^5 + 7 * x"
val e_3 = Parser(s_3).get
val p_3 = Process.differentiate(e_3, "x")
val x_3 = 2
val v_3 = Process.eval(p_3, Map("x" -> x_3))
val r_3 = "15 * x^4 + 7"
val a_3 = 247

println(s_3, x_3)
println(r_3, v_3)

// --------------------------------------------------------

val s_4 = "(x^2 + 2) * (x + 1)"
val e_4 = Parser(s_4).get
val p_4 = Process.differentiate(e_4, "x")
val x_4 = 17
val v_4 = Process.eval(p_4, Map("x" -> x_4))
val r_4 = "2 * x * (x + 1) + x^2 + 2"
val a_4 = 903

println(s_4, x_4)
println(r_4, v_4)

// --------------------------------------------------------

val s_5 = "(x^2 + 2) * (2 + 1)"
val e_5 = Parser(s_5).get
val p_5 = Process.differentiate(e_5, "x")
val x_5 = 29
val v_5 = Process.eval(p_5, Map("x" -> x_5))
val r_5 = "6 * x"
val a_5 = 174

println(s_5, x_5)
println(r_5, v_5)

// --------------------------------------------------------

val s_6 = "(4 + 2) * (5 + 1)"
val e_6 = Parser(s_6).get
val p_6 = Process.differentiate(e_6, "x")
val x_6 = 17
val v_6 = Process.eval(p_6, Map("x" -> x_6))
val r_6 = "0"
val a_6 = 0

println(s_6, x_6)
println(r_6, v_6)

// --------------------------------------------------------

val s_7 = "(x^2 + 2)^4"
val e_7 = Parser(s_7).get
val p_7 = Process.differentiate(e_7, "x")
val x_7 = 5
val v_7 = Process.eval(p_7, Map("x" -> x_7))
val r_7 = "8 * (x^2 + 2)^3 * x"
val a_7 = 787320

println(s_7, x_7)
println(r_7, v_7)

// --------------------------------------------------------

val s_8 = "(x * 2) * 3"
val e_8 = Parser(s_8).get
val p_8 = Process.differentiate(e_8, "x")
val x_8 = 17
val v_8 = Process.eval(p_8, Map("x" -> x_8))
val r_8 = "6"
val a_8 = 6

println(s_8, x_8)
println(r_8, v_8)

// --------------------------------------------------------

val s_9 = "(x^2 * 7)^2 * 3"
val e_9 = Parser(s_9).get
val p_9 = Process.differentiate(e_9, "x")
val x_9 = 11
val v_9 = Process.eval(p_9, Map("x" -> x_9))
val r_9 = "2 * x * (x + 1) + x^2 + 2"
val a_9 = 782628

println(s_9, x_9)
println(r_9, v_9)

// --------------------------------------------------------

val s_10 = "(2 * 3) * x"
val e_10 = Parser(s_10).get
val p_10 = Process.differentiate(e_10, "x")
val x_10 = 17
val v_10 = Process.eval(p_10, Map("x" -> x_10))
val r_10 = "6"
val a_10 = 6

println(s_10, x_10)
println(r_10, v_10)

// --------------------------------------------------------

val s_11 = "(x^2 + 7)^2 * (x + 1)"
val e_11 = Parser(s_11).get
val p_11 = Process.differentiate(e_11, "x")
val x_11 = 11
val v_11 = Process.eval(p_11, Map("x" -> x_11))
val r_11 = "4 * (x^2 + 7) * (x + 1) * x + (x^2 + 7)^2"
val a_11 = 83968

println(s_11, x_11)
println(r_11, v_11)

// --------------------------------------------------------

val s_12 = "(7 * 3) * x^4"
val e_12 = Parser(s_12).get
val p_12 = Process.differentiate(e_12, "x")
val x_12 = 11
val v_12 = Process.eval(p_12, Map("x" -> x_12))
val r_12 = "84 * x^3"
val a_12 = 111804

println(s_12, x_12)
println(r_12, v_12)

// --------------------------------------------------------

val s_13 = "2 * x"
val e_13 = Parser(s_13).get
val p_13 = Process.differentiate(e_13, "x")
val x_13 = 17
val v_13 = Process.eval(p_13, Map("x" -> x_13))
val r_13 = "2"
val a_13 = 2

println(s_13, x_13)
println(r_13, v_13)

// --------------------------------------------------------

val s_14 = "(x + 1) * (x + 2) * (x + 3)"
val e_14 = Parser(s_14).get
val p_14 = Process.differentiate(e_14, "x")
val x_14 = 7
val v_14 = Process.eval(p_14, Map("x" -> x_14))
val r_14 = "too lazy to type"
val a_14 = 242

println(s_14, x_14)
println(r_14, v_14)

// --------------------------------------------------------

val s_15 = "(x^2 + 1) * (x + 2) * (x + 3)"
val e_15 = Parser(s_15).get
val p_15 = Process.differentiate(e_15, "x")
val x_15 = 7
val v_15 = Process.eval(p_15, Map("x" -> x_15))
val r_15 = "too lazy to type"
val a_15 = 2210

println(s_15, x_15)
println(r_15, v_15)

// --------------------------------------------------------

val s_16 = "(x^2 + 1) * (x + 2) * (x + 3)^2"
val e_16 = Parser(s_16).get
val p_16 = Process.differentiate(e_16, "x")
val x_16 = 7
val v_16 = Process.eval(p_16, Map("x" -> x_16))
val r_16 = "too lazy to type"
val a_16 = 26600

println(s_16, x_16)
println(r_16, v_16)

// --------------------------------------------------------

val s_17 = "(x^2 + 1)^3 * (x + 2) * (x + 3)^2"
val e_17 = Parser(s_17).get
val p_17 = Process.differentiate(e_17, "x")
val x_17 = 3
val v_17 = Process.eval(p_17, Map("x" -> x_17))
val r_17 = "too lazy to type"
val a_17 = 420000

println(s_17, x_17)
println(r_17, v_17)

// --------------------------------------------------------

val s_18 = "(x^2 + 7)^2 * (x + 1) * (3 * x^4 - 2)^2"
val e_18 = Parser(s_18).get
val p_18 = Process.differentiate(e_18, "x")
val x_18 = 2
val v_18 = Process.eval(p_18, Map("x" -> x_18))
val r_18 = "too lazy to type"
val a_18 = 4020676

println(s_18, x_18)
println(r_18, v_18)

// --------------------------------------------------------

val s_19 = "2^x + 4 * x"
val e_19 = Parser(s_19).get
val p_19 = Process.differentiate(e_19, "x")
val x_19 = 3
val v_19 = Process.eval(p_19, Map("x" -> x_19))
val r_19 = "2^x * ln(2) + 4"
val a_19 = 8*math.log(2) + 4

println(s_19, x_19)
println(r_19, v_19)

// --------------------------------------------------------

val s_20 = "2^2 + 4 * x"
val e_20 = Parser(s_20).get
val p_20 = Process.differentiate(e_20, "x")
val x_20 = 3
val v_20 = Process.eval(p_20, Map("x" -> x_20))
val r_20 = "4"
val a_20 = 4

println(s_20, x_20)
println(r_20, v_20)

// --------------------------------------------------------

val s_21 = "2^(3*x^2) + 4 * x"
val e_21 = Parser(s_21).get
val p_21 = Process.differentiate(e_21, "x")
val x_21 = 2.1
val v_21 = Process.eval(p_21, Map("x" -> x_21))
val r_21 = "too lazy"
val a_21 = 6 * math.pow(2, 3 * math.pow(2.1,2)) * 2.1 * math.log(2) + 4

println(s_21, x_21)
println(r_21, v_21)

// --------------------------------------------------------

println("1: ", v_1 == a_1)
println("2: ", v_2 == a_2)
println("3: ", v_3 == a_3)
println("4: ", v_4 == a_4) 
println("5: ", v_5 == a_5) 
println("6: ", v_6 == a_6) 
println("7: ", v_7 == a_7)
println("8: ", v_8 == a_8)  
println("9: ", v_9 == a_9) 
println("10: ", v_10 == a_10) 
println("11: ", v_11 == a_11) 
println("12: ", v_12 == a_12) 
println("13: ", v_13 == a_13) 
println("14: ", v_14 == a_14) 
println("15: ", v_15 == a_15) 
println("16: ", v_16 == a_16) 
println("17: ", v_17 == a_17) 
println("18: ", v_18 == a_18) 
println("19: ", v_19 == a_19) 
println("20: ", v_20 == a_20) 
println("21: ", (math.floor(v_21 * 1e5))/1e5 == (math.floor(a_21 * 1e5))/1e5) 