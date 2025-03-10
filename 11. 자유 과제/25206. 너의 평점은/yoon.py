11 li = []

dic = {"A+" : 4.5, "A0" : 4.0, "B+" : 3.5, "B0" : 3.0, "C+" : 2.5, "C0" : 2.0, "D+" : 1.5, "D0" : 1.0, "F" : 0.0}

for i in range(20):
    object, credit, grade = map(str, input().split())
    credit = int(credit[0])
    li.append((credit, grade))

total_credit = 0
total_grade = 0.0
for i in range(20):
    if li[i][1] in dic:
        total_credit += li[i][0]
        total_grade += (li[i][0]*dic[li[i][1]])


if total_credit > 0:
    print(total_grade / total_credit)
else:
    print(0.0)
