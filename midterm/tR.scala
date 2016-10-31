:load Reinvent.scala

Reinvent.rev(List(1,3,4)) == List(1,3,4).reverse
Reinvent.rev(List(1,9,4)) == List(1,9,4).reverse
Reinvent.rev(List(1,3,4,100)) == List(1,3,4,100).reverse
Reinvent.rev(List(12,1,3,4)) == List(12,1,3,4).reverse

println("--------------------------------------------")

Reinvent.secondLast(List(3)) == None
Reinvent.secondLast(List()) == None
Reinvent.secondLast(List(3, 1)) == Some(3)
Reinvent.secondLast(List(3,1,2)) == Some(1)
Reinvent.secondLast(List(3,1,2,3,4,1)) == Some(4)