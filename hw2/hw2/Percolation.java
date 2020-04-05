package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : Samuel-Sorial
 */
public class Percolation {

    private boolean[][] xyElements;
    private WeightedQuickUnionUF opens;
    private int openedSites;
    private int widthAndHeight;

    /**
     *
     * @param N which gives N*N Percolation
     */
    public Percolation (int N){
        if(N < 0)
            throw new IllegalArgumentException("The width and height can't be negative");
        xyElements = new boolean[N][N];
        opens = new WeightedQuickUnionUF(N*N+1);
        widthAndHeight = N-1;
        openedSites = 0;
    }

    /**
     * Opens a specific point
     * @param row
     * @param col
     */
    public void open(int row, int col){
        xyElements[row][col] = true;
        connectOthers(row,col);
        openedSites++;
    }

    /**
     * Connect to other neighbours
     * @param row
     * @param col
     */
    private void connectOthers(int row, int col){
        int[] neighbours = findNeighbours(row, col);
        for(int i : neighbours){
            int[] place = findCurrentIndecies(i);
            if(isOpen(place[0],place[1]))
                makeSet(row,col,i);
        }
    }

    /**
     * Connect these two neighbours
     * @param row
     * @param col
     * @param otherNumber
     */
    private void makeSet(int row, int col, int otherNumber){
        int first = findNumberOfElement(row,col);
        opens.union(first,otherNumber);
    }

    /**
     * Find the row and col from the number
     * @param i
     * @return
     */
    private int[] findCurrentIndecies(int i){
        int col = i % (widthAndHeight+1);
        int row = (i - col) /(widthAndHeight+1);
        return new int[] {row,col};
    }

    /**
     * find the neighbours of this cell
     * @param row
     * @param col
     * @return the neighbours
     */
    private int[] findNeighbours(int row, int col){
        List<Integer> neighboursList = new ArrayList<>();
        if(row == 0){
            if(col == 0){
                neighboursList.add(findNumberOfElement(row,col+1));
                neighboursList.add(findNumberOfElement(row+1,col));
            }else if(col == widthAndHeight){
                neighboursList.add(findNumberOfElement(row,col-1));
                neighboursList.add(findNumberOfElement(row+1, col));
            }else{
                neighboursList.add(findNumberOfElement(row+1,col));
                neighboursList.add(row,col+1);
                neighboursList.add(row,col-1);
            }
        }else if(row == widthAndHeight){
            if(col == 0){
                neighboursList.add(findNumberOfElement(row,col+1));
                neighboursList.add(findNumberOfElement(row-1,col));
            }else if(col == widthAndHeight){
                neighboursList.add(findNumberOfElement(row,col-1));
                neighboursList.add(findNumberOfElement(row-1, col));
            }else{
                neighboursList.add(findNumberOfElement(row-1,col));
                neighboursList.add(findNumberOfElement(row,col+1));
                neighboursList.add(findNumberOfElement(row,col-1));
            }
        }else if(col == 0){
            neighboursList.add(findNumberOfElement(row+1,col));
            neighboursList.add(findNumberOfElement(row-1,col));
            neighboursList.add(findNumberOfElement(row,col+1));
        }else if(col == widthAndHeight){
            neighboursList.add(findNumberOfElement(row,col-1));
            neighboursList.add(findNumberOfElement(row-1,col));
            neighboursList.add(findNumberOfElement(row+1,col));
        }else{
            neighboursList.add(findNumberOfElement(row,col+1));
            neighboursList.add(findNumberOfElement(row,col-1));
            neighboursList.add(findNumberOfElement(row-1,col));
            neighboursList.add(findNumberOfElement(row+1,col));
        }
        int[] result = new int[neighboursList.size()];
        for(int i=0; i<result.length; i++){
            result[i] = neighboursList.get(i);
        }
        return result;
    }

    /**
     * @param row
     * @param col
     * @return  the state of this cell
     */
    public boolean isOpen(int row, int col){
        return xyElements[row][col];
    }

    /**
     *
     * @param row
     * @param col
     * @return if it has something in or not
     */
    public boolean isFull(int row, int col){
        if(!xyElements[row][col])
            return false;
        int numberOfElement = findNumberOfElement(row,col);
        for(int i = 0; i< xyElements.length; i++){
            if(opens.connected(findNumberOfElement(0,i),numberOfElement))
                return true;
        }
        return false;
    }

    /**
     *
     * @return number of opened sites, that is not the same number of full cells
     */
    public int numberOfOpenSites(){
        return openedSites;
    }

    /**
     *
     * @return if the total grid is percolating or not
     */
    public boolean percolates(){
        for(int i = 0; i<xyElements.length; i++){
            if(isFull(widthAndHeight,i))
                return true;
        }
        return false;
    }

    /**
     *
     * @param row
     * @param col
     * @return the number of the element calculated from it's position.
     */
    private int findNumberOfElement(int row, int col){
        return row*(widthAndHeight+1) + col;
    }
    public static void main(String[] args){

    }
}
