import sys
cnt = int(sys.stdin.readline())
yuk = "666"
num = 1

while cnt != 0:
    if yuk in str(num):
        cnt -= 1
    num += 1

print(num - 1)