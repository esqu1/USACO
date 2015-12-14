USACO 2014-2015 CONTEST 2
==

My second programming competition. This time I was (hopefully) prepared for the events beforehand. I had procrastinated the entire weekend to do this contest, so I started at 10:00 PM EST on January 19, the final day of the contest (Good thing the times on the website were in UTC-12!)

I looked at #1. Wow, this is trivial, I thought. Just look at every other line and see if the second city appears after the first. Simple. Unfortunately, two of my test cases were not working. At least I had most of them, so I moved onto #2.

How convenient #2 was a variation on #1! Only now I accounted for the two route case. This one looked in every pair of lines for a possible route. This one also had 2 cases not working. Once again, I moved onto #3.

I can't loop through 15000? No problem! Just stop the loop early if I discover the pair! If one of the numbers is greater than the other number, break the loop. (I had two loops of the two base conversions). Heh, that was easy, all the cases were working.

Now onto #4. This was a pain for me, since it involved looking for the shortest path on a graph. I ended up resorting to a recursive solution after an hour of coding and debugging. 5 of my test cases timed out, and one was wrong. Disappointed, I moved back to #1.

1 was supposed to be easy... Heh, wasn't that easy the way I initially programmed it. I initially looked for the value within a string, using the find() function. Turns out I didn't account for when values like 245 and 2459 appear in the same list. After fixing that, I got all the caes, banged my head against my desk, and continued.

I looked at #2 and fixed the same issue, but I could not fix those test cases no matter what I did.

Finally I struggled to find a better solution for #4, when suddenly, I realized my time would be shortened if I just removed my print statements... yeah. I still had that last one, but it was only 1 case vs 6 cases, so I was fine.

At this point I had a 933, which I was happy with, since that would definitely make Silver (and indeed, I did). I screwed the contest from there and finished my belated homework.

Turns out my problem from #2 was that I didn't change everything completely...
I'm still not sure about my problem for #4, however.