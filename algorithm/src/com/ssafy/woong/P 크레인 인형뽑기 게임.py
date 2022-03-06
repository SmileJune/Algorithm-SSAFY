"""
def solution(board, moves):

    answer = 0
    pick = 0
    stack = []
    heights = [0]*len(board[0])

    for i in range(len(board)):

        for j in range(len(board[0])):

            if board[i][j] != 0 and heights[j] == 0:
                heights[j] = i

    for move in moves:
        if heights[move-1] < len(board):

            pick = board[heights[move-1]][move-1]
            heights[move-1] += 1
            if len(stack) != 0 and stack[-1] == pick:
                stack.pop()
                answer += 2
            else:
                stack.append(pick)

    return answer
"""
def solution(board, moves):
    answer = 0
    basket = []

    for i in moves:
        for j in range(len(board)):
            if board[j][i - 1] == 0:
                pass
            else:
                basket.append(board[j][i - 1])
                board[j][i - 1] = 0
                break

        if len(basket) >= 2 and basket[len(basket) - 1] == basket[len(basket) - 2]:
            basket.pop(-1)
            basket.pop(-1)
            answer += 1

    return answer * 2

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[2,2,5,3,5,4,1,2]))

