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

println("1: ", v_1 == a_1)
println("2: ", v_2 == a_2)
println("3: ", v_3 == a_3)
println("4: ", v_4 == a_4) 
println("5: ", v_5 == a_5) 
println("6: ", v_6 == a_6) 
println("7: ", v_7 == a_7)
println("8: ", v_8 == a_8)  
println("9: ", v_9 == a_9) 

