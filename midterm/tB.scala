:load Blast.scala

Blast.merge(List(1.2, 3.4, 5.9), List(2.2, 2.4, 5.4, 10)) == List(1.2, 2.2, 2.4, 3.4, 5.4, 5.9, 10)
Blast.merge(List[Double](6,213,124125,9123124), List[Double](1,2)) == List(1.0, 2.0, 6.0, 213.0, 124125.0, 9123124.0)
Blast.merge(List[Double](), List(1.2, 3.4)) == List(1.2, 3.4)
Blast.merge(List(1.2, 6.9), List[Double]()) == List(1.2, 6.9)
Blast.merge(List(1.2, 6.9), List(1.3,5.9,7.1)) == List(1.2, 1.3, 5.9, 6.9,7.1)