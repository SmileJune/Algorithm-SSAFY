import sys
n, m, b = map(int, sys.stdin.readline().split())
field = []
for _ in range(n):
    field.extend(list(map(int, input().split())))

cnt = 0
minTime = 99999999999
avg = 0
for h in range(257):

    bigger = 0
    smaller = 0
    for i in field:
        if i - h > 0:
            bigger += i - h
        elif i - h < 0:
            smaller += h - i

    # 매꿀 때
    if smaller > bigger + b: #전부 채울 수 없으니 패스
        continue
    cnt = smaller + bigger * 2
    if cnt <= minTime:
        minTime = cnt
        avg = h

print(minTime, avg)

