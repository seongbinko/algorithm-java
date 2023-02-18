import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
   array.append(int(input()))

result = sorted(array)
for i in result:
    print(i)
