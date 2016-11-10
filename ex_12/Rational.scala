package rmath

class Rational(n: Int,d:Int){
// class Rational(val n: Int,val d:Int){            will make object call .n, .d possible
    require(d>0," denominator must be > 0")
    private val g = gcd(n,d).abs
    val numer = n/g //val will evaluate now, def will leave the expr like that (by value / by name)
    val denom = d/g
    def this(n: Int) = this(n,1)        // overload the constructor, same as
    override def toString = numer + "/" + denom

    private def gcd(a: Int, b: Int):Int = {
        if(b==0) a else gcd(b,a%b)
    }

    //def add(that: Rational): Rational = {
    def +(that: Rational): Rational = {
        new Rational(this.numer*that.denom + this.denom*that.numer , this.denom * that.denom)
    }
    //def mult(that: Rational): Rational = {
    def *(that: Rational): Rational = {
        new Rational(this.numer*that.numer , this.denom * that.denom)
    }
    def unary_- = {
    // def neg(): Rational = {
        new Rational( -numer,denom)
    }

    def less(that: Rational):Boolean = {
        this.numer*that.denom < that.numer*this.denom
    }


}
