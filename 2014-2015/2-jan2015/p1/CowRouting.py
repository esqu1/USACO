#########
# USACO CONTEST 2 PROBLEM 1
# SOLUTION BY BRANDON LIN
# PYTHON 2.7.6
#########
import sys

def readin(): #Read in the file
    f = open("cowroute.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

def find(list,el): # A modified linear search for lists
    if el in list:
        return list.index(el)
    else:
        return -1
l = readin()
min = sys.maxint
firstline = l[0].split()
count = 2
while count < len(l):
    if int(l[count - 1].split()[0]) < min and find(l[count].split(),firstline[0]) != -1 and find(l[count].split(),firstline[1]) != -1 and find(l[count].split(),firstline[0]) < find(l[count].split(),firstline[1]): # Check to see if the two cities occur in the same order
        min = int(l[count - 1].split()[0]) 
    count += 2

if min == sys.maxint: # If we haven't touched the minimum, make it -1
    min = -1

print str(min)
    
g = open("cowroute.out",'w')
g.write(str(min) + "\n")
g.close()
