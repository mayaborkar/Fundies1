# SUMMARY

Answer all the questions. Please put your answers _after_ the italicized
instructions.

## Logistics

### Did you successfully implement everything that was requested, to the best of your knowledge?

_Answer "Yes", or state here which parts did not work or which tests did not
pass._ [1 point]
Yes

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]
This assignment took much longer than the other ones, about 20 hours separated by a few days

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours._ [1 points]

I worked with Rhea for the first half of the assignment, up until makeSnippet. I did not attend office hours, but
there were some people that I asked just one question to when I was stuck. For example the makeSnippet function.
For this assignment I worked with a lot more people because I got stuck often, but I only worked with them for
short periods of time.

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which
ones were particularly helpful. State whether you used AI and, if so, which
tools you used and how you used them._ [2 points]

For learning how to check if something was a letter, I searched up a few Kotlin functions, namely isLetter(). In this
assignment there were quite a few times where I knew that there was a function in kotlin to achieve it, but I did not
quite know what it was. To find some of these functions I asked ChatGPT to help me. For example this was one
prompt that I gave to ChatGPT:

MY QUESTION: kotlin function to see if a list is not empty using require
ChatGPT said:

You can use the require function in Kotlin to check if a list is not empty.

Here's how you can implement a Kotlin function to enforce that a list is not empty using require:

Function Example
kotlin
Copy code
fun checkListNotEmpty(list: List<Any>) {
require(list.isNotEmpty()) { "The list cannot be empty." }
}
Explanation
require(list.isNotEmpty()): This checks if the list is not empty. If the condition is false (i.e., the list is empty),
it will throw an IllegalArgumentException.
The second argument, "The list cannot be empty.", is the error message that will be displayed if the condition fails.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

_Constructive and actionable suggestions for improving assignments, office
hours, and lecture are always welcome._
[5 points]

This assignment was a lot more difficult than all of the homework assignments so far. I have to really think about
the problem that needed to be solved and the functions that I had to use to solve it. As previously stated, the thing
that I struggle the most with is understanding what the actual problem is asking. Because I was not particularly
familiar with a web crawler it was a little bit harder for me to understand what the use case for this was. Also, after
understanding what the problem was it was hard to narrow down exactly what I had to do to solve it which is why this
assignment took much longer than the others.

The most rewarding part of this assignment was at the end when I ran the code after debugging and got the message
"All tests passed". Because I kept getting a lot of errors and had to change a variety of things, when I was finally
able to get all of my tests working, it was very rewarding. This assignment taught me a lot about researching different
functions in kotlin and using them to my advantage. It also taught me more about breaking down a problem into smaller
parts to make everything more manageable.

## Transcript

_Paste your required transcript below._ [5 points]

https://github.com/igorbrigadir/stopwords/blob/master/en/terrier.txt

/Users/mayaborkar/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar CrawlerKt
All tests passed
Enter your search query (or /quit to quit):
still
2 results were found:

O Captain! My Captain! by Walt Whitman
https://www.poetryfoundation.org/poems/45474/o-captain-my-captain
still,
My father does not feel my arm, he has no pulse nor will,
The ship is anc

Still I Rise by Maya Angelou
https://www.poetryfoundation.org/poems/46446/still-i-rise
Still I Rise
BY MAYA ANGELOU
You may write me down in history
With your bitter,

Enter your search query (or /quit to quit):
poetry
2 results were found:

10 Most Famous Poems in American Literature
https://learnodo-newtonic.com/famous-american-poems
Poetry in the United States arose first when colonists wrote poetry to add to th

Emily Dickinson
https://www.poetryfoundation.org/poets/emily-dickinson
poetry and the poet’s work. Like writers such as Ralph Waldo Emerson, Henry Davi

Enter your search query (or /quit to quit):
/quit

Process finished with exit code 0