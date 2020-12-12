class Test:
    m = int(input())
    for k in range(m):
        n = int(input())
        res = []
        i = 1
        while i <= n:
            res.append(n-i+1)
            i = i+1
        if n % 2 != 0:
            mid = int(n/2)
            tmp = res[0]
            res[0] = res[mid]
            res[mid] = tmp
        print(' '.join(map(str,res)))
