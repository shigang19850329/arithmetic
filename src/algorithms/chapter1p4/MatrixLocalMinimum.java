package algorithms.chapter1p4;

import java.util.Arrays;

/**
 * 矩阵的局部最小元素。给定一个含有N^2个不同整数的N*N数组a[]。设计一个运行时间和N成正比的算法来
 * 找出一个局部最小元素：满足a[i][j]<a[i+1][j],a[i][j]<a[i][j+1],a[i][j]<a[i-1][j]以及
 * a[i][j]<a[i][j-1]的索引i和j。程序的运行时间在最坏情况下应该和N成正比。
 */
public class MatrixLocalMinimum {
    private static class IndexPath {
        int row;
        int column;
    }

    private IndexPath miniMumIndexPathOfItem(int[][] matrix,IndexPath indexPath){
        IndexPath resultItem = new IndexPath();
        resultItem.column = indexPath.column;
        resultItem.row = indexPath.row;

        int currentItem = matrix[indexPath.row][indexPath.column];
        int left  = matrix[indexPath.row][(indexPath.column - 1) >= 0 ? (indexPath.column - 1) : indexPath.column  ];
        int right = matrix[indexPath.row][(indexPath.column + 1) <= matrix.length ? (indexPath.column + 1) : indexPath.column  ];
        int top    = matrix[(indexPath.row - 1 ) >= 0 ? (indexPath.row - 1 ) : indexPath.row][indexPath.column];
        int bottom = matrix[(indexPath.row + 1 ) <= matrix.length ? (indexPath.row + 1 ) : indexPath.row][indexPath.column];

        int[] rounder = {left,right,top,bottom,currentItem};
        Arrays.sort(rounder);
        if (rounder[0] == currentItem){
            System.out.print("row:"+resultItem.row + "column:" + resultItem.column);
            return resultItem;
        }else if (rounder[0] == left){
            resultItem.column = (indexPath.column - 1);
            miniMumIndexPathOfItem(matrix,resultItem);
        }else if (rounder[0] == right){
            resultItem.column = (indexPath.column + 1);
            miniMumIndexPathOfItem(matrix,resultItem);
        }else if (rounder[0] == top) {
            resultItem.row = (indexPath.row - 1);
            miniMumIndexPathOfItem(matrix,resultItem);
        }else if (rounder[0] == bottom) {
            resultItem.row = (indexPath.row + 1);
            miniMumIndexPathOfItem(matrix,resultItem);
        }else{

        }
        return resultItem;
    }

    /**
     * 找出数组中的最小值的index
     */
    private static int miniumOfArray(int[] x) {
        int indexOfMinium = 0;
        int itemOfMinium = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < itemOfMinium) {
                itemOfMinium = x[i];
                indexOfMinium = i;
            }
        }
        return indexOfMinium;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 11,  2,  3,  4, 102 },
                { 53,  6,  7, 18, 101 },
                { 12, 11, 10, 89, 100 },
                { 14,  1,  8,  5,   0 },
                { 114,51, 58, 55,  99 }
        };
        int middleRow = matrix.length / 2;
        int[] row = matrix[middleRow];
        int index = miniumOfArray(row);
        MatrixLocalMinimum localMinimum = new MatrixLocalMinimum();
        IndexPath indexPath = new IndexPath();
        indexPath.row = middleRow;
        indexPath.column = index;
        IndexPath resultIndexPath = localMinimum.miniMumIndexPathOfItem(matrix,indexPath);
        System.out.println(resultIndexPath.row);
        System.out.println(resultIndexPath.column);
    }

}

