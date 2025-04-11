def oddappearing(arr):
    xors = 0  # This will hold the XOR of all elements in the array
    res1 = 0  # This will hold one of the results
    res2 = 0  # This will hold the other result
    
    # XOR all elements in the array
    for i in arr:
        xors = xors ^ i
    
    # Find the rightmost set bit in xors (which will be different in the two odd occurring numbers)
    sn = xors & -(xors - 1)
    
    # Divide elements in two groups and XOR them separately
    for i in arr:
        if i & sn != 0:
            res1 = res1 ^ i  # XOR of first group
        else:
            res2 = res2 ^ i  # XOR of second group
            
    # Print the two odd occurring numbers
    print(res1, res2)

if __name__ == "__main__":
    arr = [3, 4, 3, 4, 5, 4, 4, 6, 7, 7]
    oddappearing(arr)