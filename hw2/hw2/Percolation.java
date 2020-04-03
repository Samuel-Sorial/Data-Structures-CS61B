package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author : Samuel-Sorial
 */
public class Percolation {

    private WeightedQuickUnionUF connections;
    private int[][] cells;
    private final int MAIN_CONNECTION;
    private int connectedSites;
    /**
     * Makes a grid N by N and intialize it with closed.
     * @param N
     */
    public Percolation(int N ){
        cells = new int[N][N];
        int numberInsideEachCell = 0;
        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++){
                cells[i][j] = numberInsideEachCell;
                numberInsideEachCell++;
            }
        }
        connections = new WeightedQuickUnionUF(N*N+1);
        MAIN_CONNECTION = N*N+1;
        connectedSites = 0;
    }

    /**
     * Opens a given point
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if (isFull(row, col)) {
            int currCell = cells[row][col];
            connections.union(currCell, MAIN_CONNECTION);
            connectedSites++;
        }
    }
    /**
     * @param row
     * @param col
     * @retur the state of a given point
     */
    public boolean isOpen(int row, int col){
        return connections.connected(MAIN_CONNECTION,cells[row][col]);
    }
    /**
     *
     * @param row
     * @param col
     * @return if the grid is full or not
     */
    public boolean isFull(int row, int col){
        return connections.connected(cells[row][col],MAIN_CONNECTION);
    }
    /**
     *
     * @return the number of the opened sites
     */
    public int numberOfOpensSites(){
        return connectedSites;
    }

    /**
     * @return if the mode percolates or not
     */
    public boolean percolates(){
        int bottomRow = cells.length;
        return isRowConnected(bottomRow-1) && isRowConnected(0);
    }

    private boolean isRowConnected(int row){
        for(int i : cells[row]){
            if(connections.connected(i,MAIN_CONNECTION))
                return true;
        }
        return false;
    }

    /**
     * Do nothing, it's just here to let the autograder do its mission.
     * @param args
     */
    public static void main(String[] args){
        Percolation test = new Percolation(4);
        test.numberOfOpensSites();
        test.percolates();
        test.isFull(1,2);
        test.isOpen(1,2);
        test.open(1,2);
        test.percolates();
        test.open(0,0);
        test.open(3,2);
        test.isOpen(3,2);
        test.isFull(3,2);
        test.percolates();
        test.open(2,3);
    }

}
