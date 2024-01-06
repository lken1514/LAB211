package Model;

public class Model {
    private int[] array;
    private int size;

    public Model() {
    }
    public Model(int[] array, int size){
        this.array = array;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
