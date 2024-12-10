# SUMMARY

Answer all the questions. Please put your answers _after_ the italicized instructions
and point values.

## Homework 1

### Conversation transcript

_Paste in the transcript of your conversation between the triple back-quotes._ [3 points]

```
"/Applications/IntelliJ IDEA CE.app/Contents/jbr/Contents/Home/bin/java" -Dkotlin.repl.ideMode=true -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 @/private/var/folders/rd/gfpg9gkn19n_0plnchflzsnm0000gn/T/idea_arg_file1144586505 org.jetbrains.kotlin.cli.jvm.K2JVMCompiler -jvm-target 1.8 -kotlin-home /Applications/IntelliJ IDEA CE.app/Contents/plugins/Kotlin/kotlinc
Kotlin IDE REPL support is experimental. It may be slow or unstable. Please, report problems to https://youtrack.jetbrains.com/issues/KTIJ.
Welcome to Kotlin version 1.9.24-release-822 (JRE 21.0.3+13-b509.11)
Type :help for help, :quit for quit

converse()
What is your name? Maya
Hello, Maya!What is your major? comp sci
I was doingcomp sciWhat is your start year? 2024
Graduation year: 2028What is your name? Maya
It was nice talking to you, Maya!
```

### Debugging

_How did you find the bug in the original `CharacterGenerator.kt`? Was it by
looking at the code, running the code, or talking with another student?_ [1 point]

While I was looking at the code I saw that the rollBiasedDice function was multiplied by 3. Because
of this the same random value was being repeated, instead of 3 separate values being added together.

### CharacterGenerator transcript

_Paste in the transcript of your conversation between the triple back-quotes._ [6 points]

```
"/Applications/IntelliJ IDEA CE.app/Contents/jbr/Contents/Home/bin/java" -Dkotlin.repl.ideMode=true -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 @/private/var/folders/rd/gfpg9gkn19n_0plnchflzsnm0000gn/T/idea_arg_file911661257 org.jetbrains.kotlin.cli.jvm.K2JVMCompiler -jvm-target 1.8 -kotlin-home /Applications/IntelliJ IDEA CE.app/Contents/plugins/Kotlin/kotlinc
Kotlin IDE REPL support is experimental. It may be slow or unstable. Please, report problems to https://youtrack.jetbrains.com/issues/KTIJ.
Welcome to Kotlin version 1.9.24-release-822 (JRE 21.0.3+13-b509.11)
Type :help for help, :quit for quit

makeCharacter()
Enter your character's name:Maya
res1: kotlin.String = Maya has charisma 14, agility 6, and speed 13.

makeCharacter()
Enter your character's name:Sophie
res2: kotlin.String = Sophie has charisma 11, agility 8, and speed 9.

makeHero()
Enter your character's name:Maya
res3: kotlin.String = Maya has charisma 13, agility 12, and speed 12.

makeHero()
Enter your character's name:sophie
res4: kotlin.String = sophie has charisma 12, agility 12, and speed 12.

makeAdventurer()
Enter your character's name:maya
Enter your character's min die value:10
Enter your character's max die value:20
res5: kotlin.String = maya has charisma 43, agility 44, and speed 49.

makeAdventurer()
Enter your character's name:ashley
Enter your character's min die value:1
Enter your character's max die value:500
res6: kotlin.String = ashley has charisma 1163, agility 350, and speed 457.
```

## Logistics

This section is usually the same for every assignment.

### Did you successfully implement everything that was requested, to the best of your knowledge?

_Answer "Yes", or state here which parts did not work or which tests did not pass._ [1 point]
Yes

### How long did the assignment take?

_Rather than giving a range, if you are unsure, give the average of the range._
[1 point]

5 hours

### Who did you work with and how?

_Discussing the assignment with people not on your team is fine as long as you
don't share code. Please state whether you attended any office hours._ [1 points]

I attended office hours

### What resources did you use?

_Please give specific URLs (not "Stack Overflow" or "Google") and state which ones were
particularly helpful. State whether you used AI and, if so, which tools you used and how
you used them._ [2 points]

I just used Piazza for any IntelliJ problems

## Reflections

_Give **one or more paragraphs** reflecting on your experience with the
assignment, including answers to all of these questions:_

* How did the assignment go?
* What was the most difficult part of the assignment?
* What was the most rewarding part of the assignment?
* What did you learn doing the assignment? Were there any learning outcomes
  (shown near the top of the Canvas page) you did not achieve?

_Constructive and actionable suggestions for improving assignments, office hours,
and lecture are always welcome._
[5 points]

The beginning part of the assignment was difficult because I had a hard time installing IntelliJ. 
I was able to come to office hours and get it working which was helpful. The most rewarding part
of the assignment was probably when the code started running correctly and I was able to see all
of the outputs. I learnt a lot about Kotlin and that database since I did not know it before.
I think I learnt how to work more closely with the Professor and ask for help instead of trying
to figuring it out by myself. 