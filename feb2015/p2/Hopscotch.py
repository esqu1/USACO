#########
# USACO CONTEST 3 PROBLEM 1
# BY BRANDON LIN
# PYTHON 2.7.6
#########



def readin():
    f = open("hopscotch.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

CACHE = []
l = readin()
R = int(readin()[0].split()[0])
C = int(readin()[0].split()[1])
grid = []
count = 1
while count < R+1:
    grid.append( l[count].split())
    CACHE.append([0] * len(l[count].split()))
    count += 1

CACHE[0][0] = 1
for i in range(len(grid)):
    for j in range(len(grid[0])):
        for k in range(i+1,len(grid)):
            for m in range(j+1,len(grid[0])):
                if grid[i][j] != grid[k][m]:
                    CACHE[k][m] += CACHE[i][j]
                    CACHE[k][m] %= 1000000007

#ways = counter(grid,0,0,R,C,str(0), CACHE) % 1000000007

ways = CACHE[len(CACHE) - 1][len(CACHE[0]) - 1] % 1000000007
g = open("hopscotch.out",'w')
g.write(str(ways) + "\n")

g.close()
