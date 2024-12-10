fun toDecimal(numerator : Int, denominator: Int) : Double{
    if (denominator != 0){
        return ((numerator  * 1.0) / denominator)
    }
   println("Denominator is zero")
    return numerator * 1.0
}

/**
 * var result =
 *      if (denominator != 0){
 *         return ((numerator  * 1.0) / denominator)
 *     } else{
 *          println("Denominator is zero")
 *          numerator * 1.0
 *  return result
 */