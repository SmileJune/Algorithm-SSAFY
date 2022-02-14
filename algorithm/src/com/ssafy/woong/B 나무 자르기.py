def binary_search(trees, start, end, goal):

    if start > end:
        return end

    pivot = (start + end) // 2
    n = treeCut(trees, pivot)
    if n >= goal:
        return binary_search(trees, pivot+1, end, goal)
    elif n < goal:
        return binary_search(trees, start, pivot-1, goal)


def treeCut(trees, height):
    sum = 0
    for tree in trees:
        if tree > height:
            sum += tree - height
    return sum


N, M = map(int, input().split(" "))
trees = list(map(int, input().split()))
print(binary_search(trees, 0, max(trees), M))

