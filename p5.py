class PriorityQueue:
    def __init__(self):
        self.queue = []

    def insert(self, val, priority):
        if not self.queue:
            self.queue.append((priority,val))
        else:
            inserted = False
            for i in range(len(self.queue)):
                if priority < self.queue[i][0]:
                    self.queue.append(i,(priority, val))
                    inserted = True
                    break
                if not inserted:
                    self.queue.append((priority, val))
            print("elements added successfully")

    def remove(self):
        if self.queue:
            removed = self.queue.pop(0)
            print(f"removed element: {removed[1]} with priority {removed[0]}")
        else:
            print("queue is empty")

    def display(self):
        if not self.queue:
            print("queue is empty")
        else:
            print("\n current queue: ")
            for priority,val in self.queue:
                print(f"value: {val}, prioroty: {priority}")

def menu():
    pq = PriorityQueue()
    while True:
        print("\n priority queue")
        print("1. insert element")
        print("2. delete element")
        print("3. display queue")
        print("4. exit")

        choice = input("select an option 1-4: ")
        if choice == '1':
            val = int(input("enter value: "))
            priority = int(input("enter priority: "))
            pq.insert(val, priority)

        elif choice == '2':
            pq.remove()

        elif choice == '3':
            pq.display()

        elif choice == '4':
            print("exit program")
            break
        else:
            print("invalid choice")

if __name__ == "__main__":
    menu()
