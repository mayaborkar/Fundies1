fun main() {
    var threeFourths = Fraction(3, 4, FractionFormat.Vinculum)
    var half = Fraction(1, 2, FractionFormat.Solidus)

}

enum class FractionFormat(val strLine: String){
    Vinculum("\n_____\n"),
    Solidus( " / ")
}

fun fractionToString(
    numerator:Int,
    denominator:Int,
    format: FractionFormat
)= "$numerator${format.strLine}$denominator"

// if (format == FractionFormat.Vinculum){
//         "$numerator\n----\n$denominator"
//    }
//    else{
//         "$numerator / $denominator"
//    }


/**
 *  SEPTEMBER 12TH
 */

data class Fraction(
    val numerator:Int,
    val denominator:Int,
    val format: FractionFormat)

fun maxOfThree(x1: Int, x2:Int, x3:Int) =
    when {
        (x1 > x2) -> if (x1>x3) x1 else x3
        else      -> if (x2 > x3) x2 else x3
    }
//    when (x1>x2){
//        true -> if (x1 > x3) x1 else x3
//        false -> if (x2 > x3) x2 else x3
//    }




