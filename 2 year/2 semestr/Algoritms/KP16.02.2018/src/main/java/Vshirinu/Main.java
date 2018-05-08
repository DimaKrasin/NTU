package Vshirinu;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex("1a");
        graph.addVertex("2b");
        graph.addVertex("3c");
        //graph.addVertex("10j");
        graph.addVertex("4d");
        graph.addVertex("5e");
        graph.addVertex("6f");
        graph.addVertex("7g");
        graph.addVertex("8h");
        graph.addVertex("9i");
//        graph.addVertex("11jj");
        //graph.addVertex("12k");
        //graph.addVertex("13L");
        //graph.addVertex("14m");
        //graph.addVertex("15n");


        graph.addEdge(1,2);
        graph.addEdge(1,3);

        graph.addEdge(2,4);
        graph.addEdge(2,5);

        //graph.addEdge(3,10);

        graph.addEdge(4,6);
        graph.addEdge(4,7);

        graph.addEdge(5,8);
        graph.addEdge(5,9);

       // graph.addEdge(10,12);
       // graph.addEdge(10,13);

       // graph.addEdge(11,14);
       // graph.addEdge(11,15);


        graph.bfs(2);


    }


}
