# Declare list and variables
numbers = []
sum_total = 0

# Request input from user
print("Enter 10 numbers to calculate their mean:")
print()

for i in range(10):
    user_input = int(input(f"Enter number {i + 1}: "))
    numbers.append(user_input)
    sum_total += user_input

# Calculate mean
mean = sum_total / 10

# Sort numbers in ascending order
numbers.sort()

# Display results
print()
print("=== RESULTS ===")
print()

print("Numbers in order (lower to greater):")
for number in numbers:
    print(number)

print()
print(f"Sum of all numbers: {sum_total}")
print(f"Mean (Average): {mean}")