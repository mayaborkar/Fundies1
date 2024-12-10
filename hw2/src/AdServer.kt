// Congratulations! You've been invited to do the following
// online assessment for a co-op with tech giant Oodle.
//
// 1. Add the 3+ constants from the pre-exercise to the Gender enum.
// 2. Define at least 2 age-based constants where indicated below to
//    make your later ad-serving code more readable and maintainable.
//    Choose general names, such as MIN_ADULT_AGE rather than ones that
//    refer to ads, such as MIN_AGE_FOR_DATING_AD. You can also use
//    numeric literals. (Look up terms if you don't understand them.
//    They may appear on tests!)
// 3. Add properties minAge and maxAge to Ad, and set values for each
//    ad. For example, minAge for the dating ad might be MIN_ADULT_AGE.
// 4. Implement the provided fetchAd() function. You must use both "if"
//    and "when". Paste in the tests from the pre-exercise. Uncomment
//    the call to runTests() in main(). Run the tests, and see if they
//    all pass. In your write-up, you will need to describe the testing
//    and debugging process, so take notes.
// 5. Create a new data class named "Person". A person should have an
//    age (Int), gender (Gender), and income (Int). Use your judgment
//    as to which properties should be changeable.
// 6. Write a new fetchAd() method (without removing the original one)
//    that takes a single parameter of type Person and returns an Ad.
//    Instead of duplicating the code in your original fetchAd() method,
//    have your new method call your old method, passing the appropriate
//    properties as arguments.
// 7. Create a new function named "testFetchAdPerson" that tests your
//    new fetchAd() method. Modify runTests() to call this new function.

/**
This class called Gender specifies 4 different types: Unspecified, Female, Male, and Nonbinary
It will return a list that has these four values in it. This is made so we can use this class later and
so it is listed out.
 */
enum class Gender {
    Unspecified,

    // 1. Add the 3+ constants from the pre-exercise to the Gender enum.
    Female,
    Male,
    Nonbinary
}

// Age-based constants
const val MIN_AGE_FOR_PERSONALIZATION = 13
const val MIN_ADULT_AGE = 18

// 2. Define at least 2 age-based constants where indicated below to
//    make your later ad-serving code more readable and maintainable.
//    Choose general names, such as MIN_ADULT_AGE rather than ones that
//    refer to ads, such as MIN_AGE_FOR_DATING_AD.
const val MAX_ADULT_AGE = 75
const val MIN_CHILD_AGE = 5
const val MAX_CHILD_AGE = 15

// 3. Add properties minAge and maxAge to Ad, and set values for each
//    ad. For example, minAge for the dating ad might be MIN_ADULT_AGE.
//    You can also use numeric literals. (Look up terms if you don't understand
//    them. They may appear on tests!) Be sure to update the KDoc.

/**
 * Ads that may be shown to users.
 *
 * @property text the text of the ad
 * @property revenue the number of cents earned per click
 */

/**
This class Ad takes in the parameter of text,revenue, minAge, and maxAge. It them returns the text that is
displayed in the body of the class. This will help us decide which Ad should be displayed based on their
revenue, minAge, and Max Age.
 */
enum class Ad(
    val text: String,
    val revenue: Int,
    val minAge: Int,
    val maxAge: Int
) {
    Diet("Lose weight now!", 5, 40, 60),
    Dating("Meet other singles!", 4, 20, 35),
    Lego("Fun to step on!", 1, MIN_CHILD_AGE, MAX_CHILD_AGE),
    Pet("You need a friend!", 1, 23, 31),
    PetToy("Amuse your pet!", 2, 50, 60),
    Pokemon("Gotta catch 'em all!", 2, 10, MAX_CHILD_AGE),
    Retirement("Join AARP", 2, 60, MAX_CHILD_AGE),
    Work("Apply for a job at Oodle!", 2, MAX_CHILD_AGE, 30),
}

/**
 * Fetches an ad based on the user's [gender], [age], and
 * [income], unless the age is under [MIN_AGE_FOR_PERSONALIZATION],
 * in which case no personalization is permitted.
 */
/**
This function takes in gender, age, and income as the parameter. It uses this to choose which type of Ad should be
displayed to the user. First it checks each of the income ranges and then it checks the corresponding ranges. Based
on this we use a when loop to during which Ad is preferable. Because we need to account for each of the cases, we
take into account if the age is less than the minimum allowed age and just set a default variable.  It goes through
a loop for each of the genders and checks each of the corresponding income.
 */
fun fetchAd(
    gender: Gender,
    age: Int,
    income: Int,
): Ad {
    // 4a. Implement the provided fetchAd() function. You must use
    //     both "if" and "when".
    if (age < MIN_AGE_FOR_PERSONALIZATION) {
        return Ad.Lego
    }
    when (gender) {
        Gender.Male -> {
            return when {
                income in 25..30 && age in 40..60 -> Ad.Diet
                income in 45..50 && age in 20..35 -> Ad.Dating
                income in 85..90 && age in 5..15 -> Ad.Lego
                income in 105..110 && age in 50..60 -> Ad.PetToy
                income in 125..130 && age in 10..15 -> Ad.Pokemon
                income in 145..150 && age in 50..75 -> Ad.Retirement
                else -> Ad.Dating // This is just a temporary default return value.

            }
        }

        Gender.Female -> {
            return when {
                income in 10..20 && age in 40..60 -> Ad.Diet
                income in 45..50 && age in 20..35 -> Ad.Dating
                income in 75..80 && age in 5..15 -> Ad.Lego
                income in 95..100 && age in 23..31 -> Ad.Pet
                income in 135..140 && age in 50..75 -> Ad.Retirement
                income in 155..160 && age in 15..30 -> Ad.Work
                else -> Ad.Work // This is just a temporary default return value.
            }

        }

        else -> {
            return when {
                income in 35..40 && age in 40..60 -> Ad.Diet
                income in 65..80 && age in 20..35 -> Ad.Dating
                income in 115..120 && age in 10..15 -> Ad.Pokemon
                else -> Ad.Work // This is just a temporary default return value.
            }

        }
    }

}

// 4b. Paste in the tests from the pre-exercise.
/**
this is the first function to test the cases for different ages and incomes for diet.
 */
fun testDiet1() {
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 40, 10))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 40, 20))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 40, 15))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 60, 10))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 60, 20))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 60, 15))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 50, 10))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 50, 20))
    assertEquals(Ad.Diet, fetchAd(Gender.Female, 50, 15))
}

/**
this is the second function to test the cases for different ages and incomes for diet.
 */
fun testDiet2() {
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 40, 25))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 40, 30))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 40, 27))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 60, 25))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 60, 30))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 60, 27))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 50, 25))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 50, 30))
    assertEquals(Ad.Diet, fetchAd(Gender.Male, 50, 27))
}

/**
this is the third function to test the cases for different ages and incomes for diet.
 */
fun testDiet3() {
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 40, 35))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 40, 40))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 40, 37))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 60, 35))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 60, 40))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 60, 37))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 50, 35))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 50, 40))
    assertEquals(Ad.Diet, fetchAd(Gender.Nonbinary, 50, 37))
}

/**
this is the first function to test the cases for different ages and incomes for dating.
 */
fun testDating4() {
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 20, 45))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 20, 50))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 20, 47))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 35, 45))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 35, 50))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 35, 47))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 27, 45))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 27, 50))
    assertEquals(Ad.Dating, fetchAd(Gender.Female, 27, 47))
}

/**
this is the second function to test the cases for different ages and incomes for dating.
 */
fun testDating5() {
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 20, 55))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 20, 60))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 20, 57))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 35, 55))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 35, 60))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 35, 57))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 55))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 60))
    assertEquals(Ad.Dating, fetchAd(Gender.Male, 27, 57))
}

/**
this is the third function to test the cases for different ages and incomes for dating.
 */
fun testDating6() {
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 20, 65))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 20, 70))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 20, 67))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 35, 65))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 35, 70))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 35, 67))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 65))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 70))
    assertEquals(Ad.Dating, fetchAd(Gender.Nonbinary, 27, 67))
}

/**
this is the first function to test the cases for different ages and incomes for legos.
 */
fun testLego8() {
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 5, 85))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 5, 90))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 5, 87))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 15, 85))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 15, 90))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 15, 87))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 10, 85))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 10, 90))
    assertEquals(Ad.Lego, fetchAd(Gender.Male, 10, 87))
}

/**
this is the first function to test the cases for different ages and incomes for pets.
 */
fun testPet9() {
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 23, 95))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 23, 100))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 23, 97))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 31, 95))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 31, 100))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 31, 97))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 27, 95))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 27, 100))
    assertEquals(Ad.Pet, fetchAd(Gender.Female, 27, 97))
}

/**
this is the first function to test the cases for different ages and incomes for pet toys.
 */
fun testPetToy10() {
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 50, 105))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 50, 110))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 50, 107))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 60, 105))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 60, 110))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 60, 107))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 55, 105))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 55, 110))
    assertEquals(Ad.PetToy, fetchAd(Gender.Male, 55, 107))
}

/**
this is the first function to test the cases for different ages and incomes for pokemon.
 */
fun testPokemon11() {
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 10, 115))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 10, 120))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 10, 117))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 15, 115))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 15, 120))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 15, 117))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 12, 115))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 12, 120))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Nonbinary, 12, 117))
}

/**
this is the second function to test the cases for different ages and incomes for pokemon.
 */
fun testPokemon12() {
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 10, 125))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 10, 130))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 10, 127))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 15, 125))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 15, 130))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 15, 127))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 12, 125))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 12, 130))
    assertEquals(Ad.Pokemon, fetchAd(Gender.Male, 12, 127))
}

/**
this is the first function to test the cases for different ages and incomes for retirement.
 */
fun testRetirement13() {
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 60, 135))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 60, 140))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 60, 137))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 135))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 140))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 75, 137))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 67, 135))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 67, 140))
    assertEquals(Ad.Retirement, fetchAd(Gender.Female, 67, 137))
}

/**
this is the second function to test the cases for different ages and incomes for retirement.
 */
fun testRetirement14() {
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 60, 145))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 60, 150))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 60, 147))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 145))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 150))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 75, 147))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 67, 145))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 67, 150))
    assertEquals(Ad.Retirement, fetchAd(Gender.Male, 67, 147))
}

/**
this is the first function to test the cases for different ages and incomes for work.
 */
fun testWork15() {
    assertEquals(Ad.Work, fetchAd(Gender.Female, 15, 155))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 15, 160))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 15, 157))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 30, 155))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 30, 160))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 30, 157))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 22, 155))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 22, 160))
    assertEquals(Ad.Work, fetchAd(Gender.Female, 22, 157))
}

/**
This function calls all the previous functions in one place, so that it is easier to call it in the main. If all of
these tests pass then the statement at the end is printed.
 */
fun testAll() {
    testDiet1()
    testDiet2()
    testDiet3()
    testDating4()
    testDating5()
    testDating6()
    // testLego7()
    testLego8()
    testPet9()
    testPetToy10()
    testPokemon11()
    testPokemon12()
    testRetirement13()
    testRetirement14()
    testWork15()
    print("All tests pass.")
}


// 4c. Uncomment the call to runTests() in main(). Run the tests, and see
//     if they all pass. In your write-up, you will need to describe the
//     testing and debugging process, so take notes.
/**
This is where the actual function to test all of our cases is run.
Main function
 */
fun main() {
    testAll()
}

// 5. Create a new data class named "Person". A person should have an
//    age (Int), gender (Gender), and income (Int). Use your judgment
//    as to which properties should be changeable.
/**
Creates a new class called person
 */
data class Person(val gender: Gender, val age: Int, var income: Int)

// 6. **** Write a new fetchAd() method (without removing the original one)
//    that takes a single parameter of type Person and returns an Ad.
//    Instead of duplicating the code in your original fetchAd() method,
//    have your new method call your old method, passing the appropriate
//    properties as arguments.
/**
This is the new fetch Ad function which returns an Ad. It takes in a person which has a gender, age, and income.
 */
fun fetchAd(person: Person): Ad {
    return (fetchAd(person.gender, person.age, person.income))
}

// 7. *** Create a new function named "testFetchAdPerson" that tests your
//    new fetchAd() method. Modify runTests() to call this new function.
/**
This function is used to test the new fetchAd function. In this case we make three different people and store it in
a variable and then we use the last function to execute them.
 */
fun testFetchAdPerson() {
    val person1 = Person(Gender.Female, 40, 10)
    assertEquals(Ad.Diet, fetchAd(person1)) // use this function to call it when you are running

    val person2 = Person(Gender.Male, 20, 45)
    assertEquals(Ad.Dating, fetchAd(person2))

    val person3 = Person(Gender.Nonbinary, 15, 125)
    assertEquals(Ad.Pokemon, fetchAd(person3))

}
// Do not modify the following code.

/**
 * Verifies that [actual] is equal to [expected].
 *
 * @throws AssertionError if they are not equal
 */
fun assertEquals(
    expected: Any,
    actual: Any,
) {
    if (expected != actual) {
        throw AssertionError("Expected $expected, got $actual")
    }
    // testFetchAdPerson()
}
