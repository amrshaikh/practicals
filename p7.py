import heapq
class Node:
    def __init__(self, x):
        self.data = x
        self.right = None
        self.left = None

    def __lt__(self, other):
        return self.data<other.data

def preorder(root, ans, cur):
        if root is None:
            return
        if root.left is None and root.right is None:
                    ans.append(cur)
                    return
        preorder(root.left, ans, cur + '0')
        preorder(root.right, ans, cur + '1')


def huffmanCodes(s, freq):
    n = len(s)
    pq = []
    for i in range(n):
        temp = Node(freq[i])
        heapq.heappush(pq, temp)
    while len(pq)>=2:
        l = heapq.heappop(pq)
        r = heapq.heappop(pq)
        newnode = Node(l.data + r.data)
        newnode.left = l
        newnode.right = r
        heapq.heappush(pq, newnode)
            
    root = heapq.heappop(pq)
    ans = []
    preorder(root, ans, "")
    return ans

if __name__ =="__main__":
    s = "abcdef"
    freq = [5, 9, 12, 13, 16, 45]
    ans = huffmanCodes(s, freq)
    for code in ans:
            print(code, end=" \n")
