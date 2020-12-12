from collections import Counter
import sys

m = int(input())
for t in range(m):
    k = int(input())
    arr = str(input()).split(' ')
    c = Counter(arr)
    min = int(sys.maxsize)
    index = -1
    for i in range(len(arr)):
        num = int(arr[i])
        if c[arr[i]] == 1 and num < min:
            min = num
            index = i+1
    print(index)

