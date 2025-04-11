def printPowSet(s):
    n=len(s)
    pSize=(1<<n)
    for i in range(pSize):
        for j in range(n):
            if((i&(1<<j))!=0):
                print(s[j], end=" ")
        print()
        
s="abc"
printPowSet(s)