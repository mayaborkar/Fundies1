# SUMMARY

Answer all the questions. Please put your answers _after_ the
italicized instructions, as shown in the
[video](https://northeastern.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=d327c168-e0e8-4f70-9f3f-b12f0048baac).

## Logistics

### Did you successfully implement everything that was requested, to the best of your knowledge?

_Answer "Yes", or state here which parts did not work or which tests did not
pass._ [1 point]

Yes

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]

I worked on this assignment between 10 and 20 hours, it took me a bit longer than the previous assignments.

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours._ [1 points]

I did not attend any office hours, but I worked with Tim from my class on places that I got stuck on. I
often tried to write the code myself and then compared my answers to his to ensure correctness. I also
took his help with the battle() function because it was harder for me to understand the directions and what
to do with them

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which
ones were particularly helpful. State whether you used AI and, if so, which
tools you used and how you used them._ [2 points]

The main tool I used for this was my friends, I was able to talk to them directly and so it was a bit
more helpful for me. I also used a lot of the kotlin databases to know how to implement a get().

## Testing and debugging

_Describe your testing and debugging experience, including the following._

* What did you think of writing tests?
* Did you think of edge cases when writing tests that caused you to go back
  and change your implementation?
* Did your tests uncover bugs?
* What was your debugging process like?
* How confident are you in the correctness of your code?

_Your answer should be at least one full paragraph._ [5 points]

It was interesting to think about which numbers I should pick for the maxHearts and values like that. It
was important to pick the correct values in order to accurately test all of the cases in terms of Healthy,
Injured, and Dead. One of the tests I chose to do was if the number of hearts was less than 0 to ensure
all of the cases were handled properly. It helped to think about some of the edge cases to remind myself
if I had to check for an equal sign. My testing did not uncover any bugs, but I did need to change some
of the tests that I checked to ensure it was responding correctly to the edge cases. I also needed
to change some of my tests to ensure all of the outputs were being displayed. I used a lot of prints
to ensure my outputs were correct and I used a lot of comments to ensure I was keeping track of what
I was doing. I am fairly confident with the correctness of my code, the battle function was a bit hard
for me to implement and so I am a bit unsure of that one.

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment?

_Constructive and actionable suggestions for improving assignments, office
hours, and lecture are always welcome._
[5 points]

I took a lot more time on this assignment in that I was more careful in my code and my comments. This
project also prompted us to use almost everything that we had learned which was a bit hard to implement.
It allowed me to try and use get methods, assertEquals, and while loops which were more new to me and
so I needed to look at a lot of the syntax on that.

The most rewarding part of this assignment was probably when the battle function worked for me.
Interpreting the instructions for me are normally what is the most difficult for me. And this was the case
especially for the battle method. It was hard for me to actually understand what the code I had to write
and decoding the problem. And because of this, the more rewarding part was when the output of my function
did not contain any errors and it was printing what was expected.

I learnt a lot more about the get methods as well as different types of while loops. I also learnt a lot
more about interpreting the directions and how to construct the tests to actually make sure what was
being asked was being satisfied. I was also able to learn how to use the this. method in the battle class
to ensure both people in the battle were fighting

## Transcript

_Paste your required transcript below._ [5 points]

/Users/mayaborkar/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar MobKt
The villager took 1 heart of damage.
It is now Injured.
The creeper took 2 hearts of damage.
It is now Injured.
The creeper wins the battle
The villager took 2 hearts of damage.
It is now Injured.
The creeper took 2 hearts of damage.
It is now Injured.
The creeper wins the battle
The villager took 5 hearts of damage.
It is now Injured.
The creeper took 3 hearts of damage.
It is now Injured.
The creeper wins the battle
The villager took 5 hearts of damage.
It is now Injured.
The creeper took 1 heart of damage.
It is now Injured.
The creeper wins the battle
The villager took 2 hearts of damage.
It is now Dead.
The creeper wins the battle
