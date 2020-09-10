package dynamicprogramming.other;

public class MinMax {
    private int min;
    private int max;
    private int globalMin;

    public MinMax(int min, int max, int globalMin) {
        this.min = min;
        this.max = max;
        this.globalMin = globalMin;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getGlobalMin() {
        return globalMin;
    }

    public void setGlobalMin(int globalMin) {
        this.globalMin = globalMin;
    }
}
