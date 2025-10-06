from abc import ABC, abstractmethod
class StackADT(ABC):
    @abstractmethod
    def push(self, item):
        pass

    @abstractmethod
    def pop(self):
        pass

    @abstractmethod
    def peek(self):
        pass

    @abstractmethod
    def is_empty(self):
        pass

    @abstractmethod
    def size(self):
        pass

class Stack(StackADT):
    def __init__(self):
        self._items = []

    def push(self, item):
        self._items.append(item)

    def pop(self):
        if self.is_empty():
            raise IndexError("stack is empty")
        return self._items.pop()

    def peek(self):
        if self.is_empty():
            raise IndexError("stack is empty")
        return self._items[-1]

    def is_empty(self):
        return len(self._items) == 0

    def size(self):
        return len(self._items)

if __name__ == "__main__":
    stack = Stack()
    value = int(input("enter number of elements: "))
    for i in range(value):
        elem = int(input("enter element: "))
        stack.push(elem)

    print(f"top element: {stack.peek()}")
    print(f"stack size: {stack.size()}")
    print(f"pop element: {stack.pop()}")
    print(f"top element: {stack.peek()}")
    print(f"stack size: {stack.size()}")
    print(f"stack empty: {stack.is_empty()}")
    
