#########
# USACO CONTEST 2 PROBLEM 4
# SOLUTION BY BRANDON LIN
# PYTHON 2.7.6
#########

def readin():
    f = open("meeting.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

l = readin()
num_fields = l[0].split()[0]

def add(num,list):
    i = 0
    while i < len(list):
        if list == ["null"]:
            return ["null"]
        list[i] += num
        i+= 1
    return list

def ways(numstr, mat, num): # A recursive function
    available = []
    if int(numstr) == num_fields:
        return [0]
    for i in mat:
        if len(i) > 0 and i[0] == numstr:
            available.append(i)
    if len(available) == 0:
        return ["null"]
    tobe = []
    for j in available:
        tobe += add(int(j[num]),ways(j[1],mat,num))
    return tobe
        
            

l = sorted(l[1:])
for el in l:
    print el + "\n"
mat = [i.split() for i in l]
print mat
bessie = []
elsie = []
i = 1
bessie += ways(str(i),mat,2)
elsie += ways(str(i),mat,3)
print bessie
print elsie
bessie.sort()
elsie.sort()
print bessie
print elsie
common = "IMPOSSIBLE"
for i in bessie:
    if i in elsie:
        common = str(i)
        break
g = open("meeting.out",'w')
g.write(common + "\n")
g.close()


