# 2A
'''
def create_stack():
    stack = []
    return stack

def check_empty(stack):
    return len(stack) == 0

def push(stack, item):
    stack.append(item)
    print("pushed item: " + item)

def pop(stack):
    if check_empty(stack):
        print("empty stack")
    return stack.pop()

stack = create_stack()
push(stack, str(1))
push(stack, str(4))
push(stack, str(16))
push(stack, str(33))
push(stack, str(47))
push(stack, str(81))
print("Popped Item: " + pop(stack))
print("Stack after popping an element: " + str(stack))
'''

# 2B

def balance_check(expression):
    stack = []
    opening = ['(', '[', '{']
    closing = [')', ']', '}']

    for char in expression:
        if char in opening:
            stack.append(char)
        elif char in closing:
            pos = closing.index(char)
            if len(stack) > 0 and opening[pos] == stack[len(stack) - 1]:
                stack.pop()
            else:
                return False
    if len(stack) == 0:
        return True
    else:
        return False

print("1st expression: ([{}])")
print(balance_check('([{}])'))
print("2nd expression: ([)]")
print(balance_check('([)]'))
