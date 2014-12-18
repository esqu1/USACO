import sys

# Reads in the file marathon.in.
def readin():
    f = open("marathon.in",'r')
    s = f.read().split("\n")
    f.close()
    return s

# Checks the supposedly "Manhattan" distance of the list.
def checkSum(L):
    sum = 0
    i = 0
    while i < len(L) - 1:
        sum += abs(L[i][0] - L[i+1][0]) + abs(L[i][1] - L[i+1][1])
        i+= 1
    return sum

#Main function
def main():
    l = readin()
    checkpoints = []
    i = 1
    while i <= int(l[0]): #makes checkpoints into a 2D list
        temp = l[i].split()
        temp = [int(el) for el in temp]
        checkpoints.append(temp)
        i+= 1
    i = 1
    total = checkSum(checkpoints)
    min = total
    while i < int(l[0]) - 1:
        total1 = total
        total1 -= (abs(checkpoints[i][0] - checkpoints[i-1][0]) + abs(checkpoints[i][1] - checkpoints[i-1][1]) + abs(checkpoints[i+1][0] - checkpoints[i][0]) + abs(checkpoints[i+1][1] - checkpoints[i][1]))
        total1 += (abs(checkpoints[i+1][0] - checkpoints[i-1][0]) + abs(checkpoints[i+1][1] - checkpoints[i-1][1]))
        # The way this works: take the original total, and subtract the distances to and from a certain checkpoint. Then add the distance between the checkpoints before and after. This will take care of the missing checkpoint Bessie skips.
        if total1 < min:
            min = total1
        i+= 1
    g = open("marathon.out",'w')
    g.write(str(min) + "\n")
    g.close()
        
main()

    
    
        
        
