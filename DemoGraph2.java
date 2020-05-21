public class DemoGraph2 {

    public static void main(String[] args) {
        Graph2 g = new Graph2();

        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);
        g.addNode(6);
        g.addNode(7);
        g.addNode(8);

        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 2);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 2);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 4);
        g.addEdge(6, 5);
        g.addEdge(6, 8);
        g.addEdge(7, 8);
        g.addEdge(8, 6);

        if(g.hasPathDFS(6, 1)) {
            System.out.println("True - DFS");
        } else
            System.out.println("False - DFS");


        if(g.hasPathBFS(6, 1)) {
            System.out.println("True - BFS");
        } else
            System.out.println("False - BFS");
    }
}
