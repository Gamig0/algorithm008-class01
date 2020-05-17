## BFS 代码模版

Java

```java
public void bfs(Graph graph, Node start, Node end) {
    Set<Node> visited = new HashSet<>();
    Deque<Node> current = new Deque<>();
    current.add(start);
    
    while (current != null) {
        Node temp = current.remove();
        visited.add(temp);
        // process(temp);
        nodes = temp.next;
        current.add(nodes);
    }
}
```



Python

```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...

```

