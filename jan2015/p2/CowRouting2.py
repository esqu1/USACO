#########
# USACO CONTEST 1 PROBLEM 2
# SOLUTION BY BRANDON LIN
# PYTHON 2.7.6
#########
import sys

def readin():
    f = open("cowroute.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

def find(list,el):
    if el in list:
        return list.index(el)
    else:
        return -1
l = readin()
min = sys.maxint
firstline = l[0].split()
count = 2
count = 2
while count < len(l):
    if int(l[count - 1].split()[0]) < min and find(l[count].split(),firstline[0]) != -1 and find(l[count].split(),firstline[1]) != -1 and find(l[count].split(),firstline[0]) < find(l[count].split(),firstline[1]): # Same code from Cow Routing 1
        min = int(l[count - 1].split()[0])
    count += 2
count = 2
while count < len(l):
    inc = 2
    while inc < len(l) - count:
        if find(l[count].split(),firstline[0]) == -1 and find(l[count].split(),firstline[1]) == -1: # Break if neither of them has the cities
            break;
        count2 = count + inc
        if find(l[count].split(),firstline[0]) != -1: # If we can find first city in first line
            listofone = l[count][find(l[count].split(),firstline[0]):] # Make a list of everything afterwards
            if find(l[count2].split(),firstline[1]) != -1: # If we can find second city in second line
                listoftwo = l[count2][:find(l[count2].split(),firstline[1])] # make a list of everything beforehand
                if len([i for i in listofone if i in listoftwo]) > 0 and int(l[count-1].split()[0]) + int(l[count2-1].split()[0]) < min:
                    min = int(l[count-1].split()[0]) + int(l[count2-1].split()[0]) # If we find a common city, make this the new min
        if find(l[count2].split(),firstline[0]) != -1: # Likewise
            listofone = l[count2][find(l[count2].split(),firstline[0]):]
            if find(l[count].split(),firstline[1]) != -1:
                listoftwo = l[count][:find(l[count].split(),firstline[1])]
                if len([i for i in listofone if i in listoftwo]) > 0 and int(l[count-1].split()[0]) + int(l[count2-1].split()[0]) < min:
                    min = int(l[count-1].split()[0]) + int(l[count2-1].split()[0])
        
        inc += 2
    count += 2

if min == sys.maxint:
    min = -1

g = open("cowroute.out",'w')
g.write(str(min) + "\n")
g.close()
