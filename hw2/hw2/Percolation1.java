package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Samuel-Sorial
 */
public class Percolation1 {

    private WeightedQuickUnionUF connections;
    private WeightedQuickUnionUF fulls;
    private int[][] cells;
    private final int MAIN_CONNECTION;
    private int openedSites;
    private int widthAndHeight;
    /**
     * Makes a grid N by N and intialize it with closed.
     * @param N
     */
    public Percolation1(int N ){
        if(N < 0 )
            throw new IllegalArgumentException("The width and height can't be negative");
        widthAndHeight = N-1;
        cells = new int[N][N];
        int numberInsideEachCell = 0;
        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++){
                cells[i][j] = numberInsideEachCell;
                numberInsideEachCell++;
            }
        }
        connections = new WeightedQuickUnionUF(N*N+1);
        fulls = new WeightedQuickUnionUF(N*N+1);
        MAIN_CONNECTION = N*N;
        openedSites = 0;
    }


    /**
     * Opens a given point
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if(row > widthAndHeight || col > widthAndHeight || row < 0 || col < 0 )
            throw new IndexOutOfBoundsException();

        connections.union(MAIN_CONNECTION,cells[row][col]);
        NeighbourCell[] myNeighbours = findOpenedNeighbours(row,col);
        if(row == 0 )
            fulls.union(MAIN_CONNECTION,cells[row][col]);
        if(anyFullNeighbour(myNeighbours))
            fullNeighbours(myNeighbours);
    }

    private NeighbourCell[] findOpenedNeighbours(int row, int col){
        List<NeighbourCell> neighbours = new ArrayList<>();
        for (int nr = Math.max(0, row - 1); nr <= Math.min(row + 1, cells.length - 1); ++nr){
            for (int nc = Math.max(0, col - 1); nc <= Math.min(col + 1, cells[0].length - 1); ++nc) {
                if (!(nr==row && nc==col && connections.connected(cells[nr][nc],MAIN_CONNECTION)))  {  // don't process board[r][c] itself
                    neighbours.add(new NeighbourCell(nr,nc));
                }
            }
        }
        NeighbourCell[] result = new NeighbourCell[neighbours.size()];
        for(int i = 0; i<result.length; i++)
            result[i] = neighbours.get(i);
        return result;
    }
    private class NeighbourCell{
        int row;
        int col;
        private NeighbourCell(int x, int y){
            row= x;
            col = y;
        }
    }
    private void fullNeighbours(NeighbourCell[] neighbours){
        if(neighbours.length == 1)
            fulls.union(MAIN_CONNECTION,cells[neighbours[1].row][neighbours[1].col]);
        for(NeighbourCell i : neighbours){
            fullNeighbours(findOpenedNeighbours(i.row,i.col));
        }
    }

    private boolean anyFullNeighbour(NeighbourCell[] neighbours){
        for(NeighbourCell i : neighbours){
            if(fulls.connected(MAIN_CONNECTION, cells[i.row][i.col]))
                return true;
        }
        return false;
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
        return 1;
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
        test.open(0,0);
        test.open(1,0);
//        test.numberOfOpensSites();
//        test.percolates();
//        test.isFull(1,2);
//        test.isOpen(1,2);
//        test.open(1,2);
//        test.percolates();
//        test.open(0,0);
//        test.open(3,2);
//        test.isOpen(3,2);
//        test.isFull(3,2);
//        test.percolates();
//        test.open(2,3);
    }

}
