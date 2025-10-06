class Graph:
    def __init__(self):
        self.graph = {}

    def insertvertex(self, v):
        if v not in self.graph:
            self.graph[v] = []
            print(f"Vertex {v} inserted")
        else:
            print(f"Vertex {v} already exists")

    def insertedge(self, u, v):
        if u not in self.graph:
            self.insertvertex(u)
        if v not in self.graph:
            self.insertvertex(v)
        if v not in self.graph[u]:
            self.graph[u].append(v)
        if u not in self.graph[v]:
            self.graph[v].append(u)
        print(f"Edge ({u}, {v}) inserted")

    def deletevertex(self, v):
        if v in self.graph:
            for node in list(self.graph.keys()):
                if v in self.graph[node]:
                    self.graph[node].remove(v)
            del self.graph[v]
            print(f"Vertex {v} deleted")
        else:
            print(f"Vertex {v} not found")

    def deleteedge(self, u, v):
        if u in self.graph and v in self.graph[u]:
            self.graph[u].remove(v)
        if v in self.graph and u in self.graph[v]:
            self.graph[v].remove(u)
        print(f"Edge ({u}, {v}) deleted")

    def searchvertex(self, v):
        return v in self.graph

    def searchedge(self, u, v):
        return u in self.graph and v in self.graph[u]

    def display(self):
        print(self.graph)

if __name__ == "__main__":
    g = Graph()
    while True:
        print("----------graph operations-----------")
        print("1. Insert vertex")
        print("2. Insert edge")
        print("3. Delete vertex")
        print("4. Delete edge")
        print("5. Search vertex")
        print("6. Search edge")
        print("7. Display graph")
        print("8. Exit")

        try:
            choice = int(input("Enter your choice: "))
        except ValueError:
            print("Invalid input! Please enter a number.")
            continue

        if choice == 1:
            v = input("Enter vertex: ")
            g.insertvertex(v)
        elif choice == 2:
            u = input("Enter first vertex: ")
            v = input("Enter second vertex: ")
            g.insertedge(u, v)
        elif choice == 3:
            v = input("Enter vertex to delete: ")
            g.deletevertex(v)
        elif choice == 4:
            u = input("Enter first vertex: ")
            v = input("Enter second vertex: ")
            g.deleteedge(u, v)
        elif choice == 5:
            v = input("Enter vertex to search: ")
            print("Vertex found!" if g.searchvertex(v) else "Vertex not found.")
        elif choice == 6:
            u = input("Enter first vertex: ")
            v = input("Enter second vertex: ")
            print("Edge exists!" if g.searchedge(u, v) else "Edge does not exists.")
        elif choice == 7:
            g.display()
        elif choice == 8:
            print("Exiting program.")
            break
        else:
            print("Invalid choice! Try again")
