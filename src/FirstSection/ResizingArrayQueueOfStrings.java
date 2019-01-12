package FirstSection;


public class ResizingArrayQueueOfStrings {

    private String [] array;
    private int N = 0;

    public ResizingArrayQueueOfStrings() {
        array = new String[1];
    }

    private void resize(int len){
        String [] newArray = new String[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void enqueue(String item){
        if (N == array.length)
            resize(2*N);
        array[N++] = item;
    }

    public String dequeue(){
        String item = array[0];
        for (int i = 0; i < N - 1; i++) {
            array[i] = array[i+1];
        }
        N--;
        if (N > 0 && array.length/4 == N){
            resize(array.length/2);
        }

        return item;
    }
}
