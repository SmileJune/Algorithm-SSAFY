
def palin(str):
    half = len(str) // 2
    if str == "0":
        exit()
    for i in range(1, half + 1):
        if len(str) % 2 == 0:
            if str[half - i] != str[half -1 + i]:
                return False
        else:
            if str[half - i] != str[half + i]:
                return False
    return True

while True:
    if palin(input()):
        print("yes")
    else:
        print("no")
