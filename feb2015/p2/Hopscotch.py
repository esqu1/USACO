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

def counter(grid,x,y,R,C,current):
    ways = 0
    if x == R-1 and y == C-1:
        return 1
    for i in range(x+1,R):
        for j in range(y+1,C):
            if not (i > R or j > C or grid[i][j] == grid[x][y]):
                ways += counter(grid,i,j,R,C,grid[x][y])
    return ways
ways = 0
l = readin()
R = int(readin()[0].split()[0])
C = int(readin()[0].split()[1])
grid = []
count = 1
while count < R+1:
    grid.append( l[count].split())
    count += 1

ways = counter(grid,0,0,R,C,str(0))

g = open("hopscotch.out",'w')
g.write(str(ways) + "\n")

g.close()
