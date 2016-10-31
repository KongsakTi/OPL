object Reinvent extends App {
	def rev[T](lst: List[T]): List[T] = {
		def rev_helper[T](lst: List[T], r_lst: List[T]): List[T] = {
			lst match {
				case Nil => r_lst
				case h::t => rev_helper(t, h :: r_lst)
			}
		}
		rev_helper(lst, Nil)
	}

	def secondLast[T](lst: List[T]): Option[T] = {
		def secondLast_helper[T](lst: List[T], prev_1: T, prev_2: T): T = {
			lst match {
				case Nil => prev_1
				case h::t => secondLast_helper(t, prev_2, h)
			}
		}
		lst match {
			case a::b::c => Some(secondLast_helper(c, a, b))
			case _ => None
		}
	}
}