package tzl.com.java.ThreadPool.forkjoin;

import android.annotation.SuppressLint;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * author: tangzenglei
 * created on: 2018/11/5 上午11:04
 * description:RecursiveAction 无返回值
 */
@SuppressLint("NewApi")
public class SortTask extends RecursiveAction {


    final long[] array;
    final int lo;
    final int hi;
    private int THRESHOLD = 30;

    public SortTask(long[] array) {
        this.array = array;
        this.lo = 0;
        this.hi = array.length - 1;
    }

    public SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }


    protected void compute() {
        if (hi - lo < THRESHOLD)
            sequentiallySort(array, lo, hi);
        else {
            int pivot = partition(array, lo, hi);
            invokeAll(new SortTask(array, lo, pivot - 1), new SortTask(array,
                    pivot + 1, hi));
            merge(lo, pivot, hi);
        }
    }

    void merge(int lo, int mid, int hi) {
        long[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++)
            array[j] = (k == hi || buf[i] < array[k]) ?
                    buf[i++] : array[k++];
    }


    private int partition(long[] array, int lo, int hi) {
        long x = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        return i + 1;
    }

    private void swap(long[] array, int i, int j) {
        if (i != j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void sequentiallySort(long[] array, int lo, int hi) {
        Arrays.sort(array, lo, hi + 1);
    }


}
