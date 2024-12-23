n, m = map(int, input().split())

pokemon_li = []
pokemon_dic = {}
for i in range(n):
    pokemon = input()
    pokemon_li.append(pokemon)
    pokemon_dic[pokemon] = i+1

questions = []

for i in range(m):
    questions.append(input())

for question in questions:
    if question.isdigit():
        print(pokemon_li[int(question)-1])
    else:
        print(pokemon_dic[question])
