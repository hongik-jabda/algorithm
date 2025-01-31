def solution(board, skill):
    answer = 0
    
    new = [[0 for i in range(len(board[0])+1)] for j in range(len(board)+1)]
    for s in skill:
        new = turn(s, new)
    
    for i in range(len(new)-1):
        for j in range(len(new[0])-1):
            new[i][j+1] += new[i][j]
    
    for i in range(len(new)-1):
        for j in range(len(new[0])-1):
            new[i+1][j]+= new[i][j]
            
    board = add_list(board, new)
        
    for row in board:
        for i in range(len(board[0])):
            if row[i] > 0:
                answer += 1
        
    return answer
    
        
def add_list(a, b):
    li = [[0 for i in range(len(a[0]))] for j in range(len(a))]
    for i in range(len(a)):
        for j in range(len(a[0])):
            li[i][j] = a[i][j] + b[i][j]
            
    return li
    
def turn(s,new):
    t, r1, c1, r2, c2, degree = s
    
    if t == 1:
        degree *= -1
    
    
    new[r1][c1] += degree
    new[r2+1][c1] += degree * (-1)
    new[r1][c2+1] += degree * (-1)
    new[r2+1][c2+1] += degree
    

    return new
