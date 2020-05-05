package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author Josh Hug , edited by Samuel Sorial
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> pq;
    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX,sourceY);
        t = maze.xyTo1D(targetX,targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        pq = new LinkedList<>();
        pq.add(s);
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        while (!pq.isEmpty()) {
            int curr = pq.remove();
            marked[curr] = true;
            announce();
            if( curr == t)
                return;
            for(int w : maze.adj(curr)) {
                if(!marked[w]) {
                    edgeTo[w] = curr;
                    announce();
                    distTo[w] = distTo[curr] + 1;
                    pq.add(w);
                }
            }
        }
    }


    @Override
    public void solve() {
         bfs();
    }
}

