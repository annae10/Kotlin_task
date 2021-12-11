class Fraction {
    var numerator: Int
        private set
    var denominator: Int
        private set

    internal constructor(numerator: Int) {
        this.numerator = numerator
        denominator = 1
    }

    constructor(numerator: Int, denominator: Int) {
        this.numerator = numerator
        this.denominator = denominator
    }

    fun sumF(fraction: Fraction): Fraction {
        return sumF(fraction, this)
    }

    fun subF(fraction: Fraction): Fraction {
        return subF(fraction, this)
    }
    fun mulF(fraction: Fraction): Fraction {
        return mulF(fraction, this)
    }
    fun divF(fraction: Fraction): Fraction {
        return divF(fraction, this)
    }

    fun redF(a: Fraction): Fraction {
        val cDenominator: Int = a.denominator / Math.nod(a.numerator, a.denominator)
        val cNumerator = a.numerator / Math.nod(a.numerator, a.denominator)
        return Fraction(cNumerator, cDenominator)
    }

    fun comF(a: Fraction, b: Fraction): Int {
        var i =0
        if(a.denominator!=b.denominator)
        {
            a.denominator*=b.denominator
            b.denominator=a.denominator
            val temp =0
            a.numerator= temp
            a.numerator*=b.denominator
            b.numerator=b.numerator*temp
        }
        var result =""
        if(a.denominator==b.denominator)
        {

            if(a.numerator>b.numerator)
            {
                result="first>second"
                i = 1
            }
            if(a.numerator<b.numerator)
            {
                result="second>first"
                i = -1
            }
            if(a.numerator==b.numerator)
            {
                result="first=second"
                i = 0
            }
        }
        return i
    }
    fun nok(a: Int, b: Int): Int {
        return a * b / nod(a, b)
    }

    fun nod(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else nod(b, a % b)
    }
    override fun toString(): String {
        return "" + numerator +
                "/" + denominator

    }

    companion object {
        fun sumF(a: Fraction, b: Fraction): Fraction {

            val cDenominator: Int = Math.nok(a.denominator, b.denominator)
            val cNumerator = a.numerator * (cDenominator / a.denominator) +
                    b.numerator * (cDenominator / b.denominator)
            return Fraction(cNumerator, cDenominator).redF(Fraction(cNumerator, cDenominator))
        }
        fun subF(a: Fraction, b: Fraction): Fraction {

            val cDenominator: Int = Math.nok(a.denominator, b.denominator)
            val cNumerator = a.numerator * (cDenominator / a.denominator) -
                    b.numerator * (cDenominator / b.denominator)
            return Fraction(cNumerator, cDenominator).redF(Fraction(cNumerator, cDenominator))
        }
        fun mulF(a: Fraction, b: Fraction): Fraction {
            val cDenominator: Int = a.denominator* b.denominator
            val cNumerator = a.numerator * b.numerator
            return Fraction(cNumerator, cDenominator).redF(Fraction(cNumerator, cDenominator))
        }
        fun divF(a: Fraction, b: Fraction): Fraction {

            val cDenominator: Int = a.numerator * b.denominator
            val cNumerator = a.denominator* b.numerator
            return Fraction(cNumerator, cDenominator).redF(Fraction(cNumerator, cDenominator))
        }

    }
}

fun main() {


    val first =Fraction(6, 9)
    val second =Fraction(-2, 9)
    val third =Fraction(1,3)

    val ab =6
    val abc =9

    println("First fraction: $first")
    println("Second fraction: $second")
    println("Third fraction: $third")
    println("First + second: " + first.sumF( second).toString())
    println("First - second: " +second.subF( first).toString())
    println("First + first: " +first.sumF( first).toString())
    println("First * third: " +first.mulF( third).toString())
    println("First/third: " +first.divF( third).toString())
    println("NOK: "+first.nok(ab, abc)).toString()
    println("NOD: "+first.nod(ab, abc)).toString()
    println("The reduction of first/third: " +first.redF(first.divF( third)).toString())
    println("The reduction of first: " +first.redF(first).toString())
    if(first.comF(first, second)==1)
    {println("first>second")}
    if(first.comF(first, second)==0)
    {println("first=second")}
    if(first.comF(first, second)==-1)
    {println("second>first")}

    println("This is The scheme of Gorner!")

    println("x^4-4/9x^2=(x^2-4/9)*x^2=(x+2/3)(x-2/3)*x^2")
    //println("4x^5-24*x^4+45x^3-45*x^2+117/2*x-27/2=1/2(x-3)(4*ч:2-12*x+3)(2*x^2+3)")
    var p1 = Fraction(1,1)  //polynomial value
    ////////
    val e = Fraction(1,1)
    val f = Fraction(0,1)
    val g = Fraction(-4,9)
    val h = Fraction(0,1)
    val i = Fraction(0,1)
    ////////
    val k= Fraction(4,1)
    val l=Fraction(-24,1)
    val m=Fraction(45,1)
    val o=Fraction(-45,1)
    val r=Fraction(117,2)
    val a: Array<Fraction> = arrayOf(e, f, g, h, i) //array of coefficients
    //val a: Array<Fraction> = arrayOf(k, l, m, o, r) //array of coefficients

    val n=a.size
    println("Input nominator:(2)") //x=2/3, x=-2/3, x=0
    val q1:Int = readLine()!!.toInt()
    println("Input denominator:(3)") //x=2/3, x=-2/3, x=0
    val q2:Int=readLine()!!.toInt()
    val Q1 =Fraction(q1, q2) //first coefficient

    for(i in 1 until n){

        p1= p1.mulF( Q1).sumF( a[i])
        println(p1)
    }
    val firstV: Fraction =p1 //Pn(q1)
    println("Pn(q1)=$firstV")
    println("Input nominator:(-2)") //x=2/3, x=-2/3, x=0
    val q3:Int = readLine()!!.toInt()
    println("Input denominator:(3)") //x=2/3, x=-2/3, x=0
    val q4:Int = readLine()!!.toInt()
    val Q2 =Fraction(q3, q4) //second coefficient
    var p2 = Fraction(1,1)  //polynomial value
    for(i in 1 until n){
        p2= p2.mulF( Q2).sumF( a[i])
        println(p2)
    }
    val secondV: Fraction =p2 //Pn(q2)
    println("Pn(q1)=$firstV; Pn(q2)=${secondV.toString()};")
    if(first.comF(firstV, secondV)==1)
    {println("Pn(q1)>Pn(q2)")}
    if(first.comF(firstV, secondV)==0)
    {println("Pn(q1)=Pn(q2)")}
    if(first.comF(firstV, secondV)==1)
    {println("Pn(q2)>Pn(q1)")}
    println()

}