#########
# USACO CONTEST 3 PROBLEM 1
# BY BRANDON LIN
# PYTHON 2.7.6
#########

def readin():
    f = open("censor.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

def rid(tofind,string):
    loc = string.find(tofind)
    if(loc == -1):
        return string
    else:
        return rid(tofind,string[0:loc] + string[loc+len(tofind):])

l = readin()
string = l[0]
censor = l[1]
newstring = rid(censor,string)


#count = 0
#while count < len(string) - len(censor):
#    if string[count:count+len(censor)] == censor:
#        count += len(censor) - 1
 #   else:
  #      newstring += string[count]
   # count += 1
#newstring += string[-3:]

g = open("censor.out",'w')
g.write(newstring + "\n")
print newstring
g.close()

