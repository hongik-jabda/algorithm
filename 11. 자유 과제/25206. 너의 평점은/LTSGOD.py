grade_mapping = {
    "A+": 4.5, "A0": 4.0,
    "B+": 3.5, "B0": 3.0,
    "C+": 2.5, "C0": 2.0,
    "D+": 1.5, "D0": 1.0,
    "F": 0.0
}

def calculate_gpa(course_data):
    total_weighted_score = 0.0
    total_credits = 0.0
    
    for course in course_data:
        _, credit, grade = course.split()
        credit = float(credit)
        
        if grade == "P":
            continue  # P 등급 과목 제외
        
        total_weighted_score += credit * grade_mapping[grade]
        total_credits += credit
    
    if total_credits == 0:
        return 0.0  # 학점이 없을 경우 예외 처리
    
    return total_weighted_score / total_credits


course_list = []

for _ in range(20):
    course_list.append(input())
# GPA 계산 및 출력
result = calculate_gpa(course_list)
print(f"{result:.6f}")
