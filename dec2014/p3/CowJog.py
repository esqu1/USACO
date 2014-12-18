def readin():
    f = open("cowjog.in",'r')
    s = f.read().split("\n")
    f.close()
    return s


f = readin()
if f[-1] == "":
    l = f[:-1]
else:
    l = f
l.pop(0)
print l
cows = []
for el in l:
    cows.append(int(el.split()[1])) #For some reason, the position is not necessary to use in the problem

i = len(cows) - 2
counter = 1
marker = cows[-1]
while i >= 0:
    if cows[i] <= marker: #if we find a "more left" cow that is slower than the cow that is slowing down everyone, then that cow becomes the new laggard.
        counter += 1
        marker = cows[i]        
    i -= 1

g = open("cowjog.out",'w')
g.write(str(counter) + "\n")
g.close()
    
