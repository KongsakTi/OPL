:load FuncSet.scala

FuncSet.singleton(1)(1) == true
FuncSet.singleton(1)(3) == false
FuncSet.singleton(1)(4) == false
FuncSet.singleton(1)(-1) == false
FuncSet.singleton(1)(0) == false

println("--------------------------------------------")

FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(1) == false
FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(10) == true
FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(20) == true
FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(15) == false
FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(19) == false
FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10))(21) == false

println("--------------------------------------------")

FuncSet.intersect(FuncSet.singleton(20), FuncSet.singleton(10))(10) == false
FuncSet.intersect(FuncSet.singleton(20), FuncSet.singleton(10))(20) == false

FuncSet.intersect(FuncSet.singleton(10), FuncSet.singleton(10))(15) == false
FuncSet.intersect(FuncSet.singleton(10), FuncSet.singleton(10))(19) == false
FuncSet.intersect(FuncSet.singleton(10), FuncSet.singleton(10))(10) == true

println("--------------------------------------------")

FuncSet.intersect(FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10)), FuncSet.singleton(10))(10) == true
FuncSet.intersect(FuncSet.union(FuncSet.singleton(20), FuncSet.singleton(10)), FuncSet.singleton(10))(20) == false
