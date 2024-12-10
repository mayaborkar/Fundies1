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

This project took between 10 and 15 hours over the course of a few days.

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours._ [1 points]

I worked with Rhea on the first few questions of the project. We worked together
more on discussing the smaller details of the code, for example if a term was there we
would discuss if it should be a val or a var. We also discussed the syntax for a mutable
list because it was a new concept for the two of us. We both used separate computers, but
discussed with each other if there was a concept that was unfamiliar to us.

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which
ones were particularly helpful. State whether you used AI and, if so, which
tools you used and how you used them._ [2 points]

For this project I used AI, specifically ChatGPT to help me write my tests. I first
ensured all of the runTest5() function worked and I understood how that worked. After
doing that, I prompted ChatGPT to construct a similar testing for the rest of the word
lengths (4,3,2,1). After this I wrote the code to ensure the code I wrote fit and worked
with the tests I was given.

## Testing and debugging

_Describe your testing and debugging experience, including the following._

* What did you think of writing tests?
* Did you think of edge cases when writing tests that caused you to go back
  and change your implementation?
* Did your tests uncover bugs?
* Were there bugs (mistakes) in your tests?
* What was your debugging process like?
* How confident are you in the correctness of your code?

_Your answer should be at least one full paragraph._ [5 points]

This project was a bit more difficult than the others we have encountered mainly because
of understanding the instructions. Previously, we were always told exactly what we had
to do; while this was somewhat true for this homework, I had to consider exactly what
needed to be done and in what order. One thing I had to explictly check was the way I
checked what to do if the word had already been guessed. Namely, if we had already guessed
a word I did not want to add it to the guesses list and so I had to not have an else
condition. I also had to include a count variable to get an index instead of a char for
the loop of checking if each of the secret word and the guessed work was the same. Those
were the two main problems I encountered. I used the error message to help me debug my
code. I am fairly confident in the correctness of my code because I did test it out
multiple times.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

_Constructive and actionable suggestions for improving assignments, office
hours, and lecture are always welcome._
[5 points]

I worked using a lot of resources with this assignment. I looked at a lot of the links
that were provided in the canvas assignment, ChatGPT, and my friends. There were quite
a few instances where I had to stop and think about what I wanted the actual code to
do and understand what tools I had to figure everything out. Since there were significantly
less specific instructions this time, I had to work more on decoding what the actual
use case was in that what I wanted my code to do. I also had to look more throughly in
my code to completely understand everything that was being done.

The most rewarding part of this assignment to me was running it for the first time. I
was actually able to play the wordle game with my computer in the code that I wrote
which was really cool. I used to play wordle a lot and the fact that I was able to
write the code for it was super rewarding for me. I learnt a lot of some of the small
details that needed to go into a game that seems so simple.

## Transcript

_Paste your required transcript below._ [5 points]

/Users/mayaborkar/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar WordleKt
All tests pass.
Please enter your guess:
ABCDE
.....
Please enter your guess:
SHOUT
.+..*
Please enter your guess:
ALERT
....*
Please enter your guess:
SPLIT
...+*
Please enter your guess:
DIVOT
.*..*
Please enter your guess:
FIGHT
.****
Please enter your guess:
MIGHT
*****
Congratulations you guessed the word!
It took you: 7 guesses
Your guesses were: [ABCDE, SHOUT, ALERT, SPLIT, DIVOT, FIGHT, MIGHT]
Would you like to play again? (Y/N)
Y
Please enter your guess:
ADIEU
+..+.
Please enter your guess:
FLAME
..+.*
Please enter your guess:
BRAKE
..+.*
Please enter your guess:
SPACE
+++.*
Please enter your guess:
SPADE
+++.*
Please enter your guess:
PARSE
**.+*
Please enter your guess:
PASTE
*****
Congratulations you guessed the word!
It took you: 7 guesses
Your guesses were: [ADIEU, FLAME, BRAKE, SPACE, SPADE, PARSE, PASTE]
Would you like to play again? (Y/N)
N
