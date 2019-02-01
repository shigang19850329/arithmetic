package algorithms.chapter4p1;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;

/**
 * 间隔的度数
 */
public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg =new SymbolGraph(args[0],args[1]);
        Graph G =sg.G();
        String source=args[2];
        if (!sg.contains(source)){
            StdOut.println(source+"not in database.");
            return;
        }
        int s=sg.index(source);
        BreadthFirstPaths bfs=new BreadthFirstPaths(G,s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)){
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v :bfs.pathTo(t))
                        StdOut.println(" "+sg.name(v));
                    else StdOut.println("Not connected");

            }
            else StdOut.println("Not in database");
        }
    }
}
