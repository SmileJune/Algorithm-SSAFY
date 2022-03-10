from collections import deque

N = int(input())
MAP = [list(map(int, input().split())) for i in range(N)]
shark = [[0, 0], 2, 0]
fish = []
times = 0
dy = [-1, 0, 0, 1]
dx = [0, -1, 1, 0]


def BFS(shark_info):
    visited = [[False] * N for i in range(N)]
    y, x = shark_info[0], shark_info[1]
    fish_q = deque()
    q = deque()
    q.append([y, x, 0])
    visited[y][x] = True

    while q:
        cur_y, cur_x, dis = q.popleft()
        for i in range(4):

            ny = cur_y + dy[i]
            nx = cur_x + dx[i]
            if 0 <= ny < N and 0 <= nx < N and MAP[ny][nx] <= shark[1] and visited[ny][nx] == False:
                visited[ny][nx] = True

                if 0 < MAP[ny][nx] < shark[1]:
                    fish_q.append([ny, nx, dis + 1])
                q.append([ny, nx, dis + 1])

    if len(fish_q):
        min_dis = fish_q[0][2]
        min_fish = fish_q[0]
        for fish in fish_q:

            if fish[2] > min_dis:
                break

            if min_fish[0] > fish[0]:
                min_fish = fish

        return min_fish
    else:
        return -1

def move(fish):

    ny, nx, dis = fish
    global shark, times

    MAP[ny][nx] = 9
    MAP[shark[0][0]][shark[0][1]] = 0

    shark[0] = [ny, nx]
    shark[2] += 1
    if shark[2] == shark[1]:
        shark[1] += 1
        shark[2] = 0
    times += dis

for i in range(N):
    for j in range(N):
        if MAP[i][j] > 0:
            if MAP[i][j] == 9:
                shark[0][0], shark[0][1] = i, j
            else:
                fish.append([i, j])

while True:

    fish = BFS(shark[0]) #가장 가까운 물고기 위치 찾기
    if fish == -1:
        break
    move(fish) # 물고기 먹기 and 값 update

print(times)