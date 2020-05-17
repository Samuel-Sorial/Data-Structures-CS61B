package bearmaps.hw4;

import bearmaps.proj2ab.DoubleMapPQ;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {

private SolverOutcome outcome;
    private double solutionWeight;
    private int statesExplored;
    private LinkedList<Vertex> solution;
    private double timeSpent;

    public AStarSolver(AStarGraph<Vertex> G, Vertex start, Vertex goal, double timeout) {
        Stopwatch sw = new Stopwatch();
        solution = new LinkedList<>();

        Map<Vertex, Double> distTo = new HashMap<>();
        Map<Vertex, Vertex> edgeTo = new HashMap<>();
        DoubleMapPQ<Vertex> pq = new DoubleMapPQ<>();
        distTo.put(start, 0.0);
        pq.add(start, distTo.get(start) + G.estimatedDistanceToGoal(start, goal));

        performAStar(G, goal, timeout, sw, distTo, edgeTo, pq);

        if (pq.size() == 0) {
            outcome = SolverOutcome.UNSOLVABLE;
        } else if (pq.getSmallest().equals(goal)) {
            outcome = SolverOutcome.SOLVED;
            Vertex p = pq.getSmallest();
            solutionWeight = distTo.get(p);
            while (p != null) {
                solution.addFirst(p);
                p = edgeTo.get(p);
            }
        } else {
            outcome = SolverOutcome.TIMEOUT;
        }
        timeSpent = sw.elapsedTime();
    }

    private void performAStar(AStarGraph<Vertex> G, Vertex goal, double timeout, Stopwatch sw, Map<Vertex, Double> distTo, Map<Vertex, Vertex> edgeTo, DoubleMapPQ<Vertex> pq) {
        while (pq.size() > 0 && !pq.getSmallest().equals(goal) && sw.elapsedTime() < timeout) {
            Vertex p = pq.removeSmallest();
            statesExplored += 1;
            for (WeightedEdge<Vertex> e : G.neighbors(p)) {
                relaxEdge(G, goal, distTo, edgeTo, pq, p, e);
            }
        }
    }

    private void relaxEdge(AStarGraph<Vertex> G, Vertex goal, Map<Vertex, Double> distTo, Map<Vertex, Vertex> edgeTo, DoubleMapPQ<Vertex> pq, Vertex p, WeightedEdge<Vertex> e) {
        Vertex q = e.to();
        double w = e.weight();
        if (!distTo.containsKey(q) || distTo.get(p) + w < distTo.get(q)) {
            distTo.put(q, distTo.get(p) + w);
            edgeTo.put(q, p);
            addToFringe(G, goal, distTo, pq, q);
        }
    }

    private void addToFringe(AStarGraph<Vertex> G, Vertex goal, Map<Vertex, Double> distTo, DoubleMapPQ<Vertex> pq, Vertex q) {
        if (pq.contains(q)) {
            pq.changePriority(q, distTo.get(q) + G.estimatedDistanceToGoal(q, goal));
        } else {
            pq.add(q, distTo.get(q) + G.estimatedDistanceToGoal(q, goal));
        }
    }

    public SolverOutcome outcome(){
        return outcome;
    }
    public List<Vertex> solution(){
        return solution;
    }
    public double solutionWeight(){
        if(outcome.equals(SolverOutcome.SOLVED))
            return solutionWeight;
        else
            return 0;
    }
    public int numStatesExplored(){
        return statesExplored ;
    }
    public double explorationTime(){
        return timeSpent;
    }
}
