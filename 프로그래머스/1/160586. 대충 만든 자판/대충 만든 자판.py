def solution(keymap, targets):
    key = {}
    answer = []
    for i in range (len(keymap)):
        for j in range (len(keymap[i])):
            keyChar = keymap[i][j]
            if keyChar not in key:
                key[keyChar] = j+1
            else:
                if(key[keyChar] > j+1):
                    key[keyChar] = j+1
    
    for i in range (len(targets)):
        sum = 0
        for j in range(len(targets[i])):
            if(targets[i][j] in key):
                sum += key[targets[i][j]]
            else:
                sum = -1
                break
        answer.append(sum)
    return answer