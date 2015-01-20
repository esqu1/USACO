#########
# USACO CONTEST 2 PROBLEM 3
# SOLUTION BY BRANDON LIN
# PYTHON 2.7.6
#########

def readin():
    f = open("whatbase.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

def brute(a,b,c,d,e,f): # will attempt to look for the pair of bases
    x = 10
    y = 10
    while x <= 15000:
        while y <= 15000:
            if a*(x**2) + b*x + c == d*(y**2) + e*y + f: # If they're equal, great.
                return [x,y]
            elif a*(x**2) + b*x + c < d*(y**2) + e*y + f: #If f(y) > g(x), stop.
                break;
            y+= 1
        x+= 1

l = readin()[1:]
m = [i.split() for i in l]
f = open("whatbase.out",'w')
for j in m:
    if(len(j) > 0):
        el1 = int(j[0])
        el2 = int(j[1])
        pair = brute(el1 / 100, (el1 - ((el1 / 100)*100)) / 10, el1 % 10, el2 / 100, (el2 - ((el2 / 100)*100)) / 10, el2 % 10)
        # Split up the number
        f.write(str(pair[0]) + " " + str(pair[1]) + "\n")

f.close()
    

