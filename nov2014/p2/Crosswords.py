def readin():
    f = open("crosswords.in",'r')
    s = f.read()
    bleh = s.split("\n")
    #s = "5 3\n...\n#..\n...\n..#\n.##".split("\n")
    print s
    f.close()
    return bleh

l = readin()
N = int(l[0].split()[0])
M = int(l[0].split()[1])
possible = []
cross = l
i = 1
j = 0
counter = 0
while i <= N:
    while j < M:
        if cross[i][j] == ".": #Checks for blank space
            if ((i == 1 or cross[i-1][j] == "#") and (i < N - 1 and cross[i+1][j] == "." and cross[i+2][j] == ".")) or ((j == 0 or cross[i][j-1] == "#") and (j < M - 2 and cross[i][j+1] == "." and cross[i][j+2] == ".")): #Checks neighboring blocks and the next two blocks
                possible += [str(i) + " " + str(j+1)]
                counter += 1
        j+= 1
    i+= 1
    j = 0
g = open("crosswords.out",'w')
g.write(str(counter) + "\n" + "\n".join(possible) + "\n")
g.close()


