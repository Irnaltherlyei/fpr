public class Bubblesort<T> {
    public static void main(String[] args) throws Exception {
        Integer[] array = {3,1,62,7,4,2};
        bubblesort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static <T extends Comparable<? super T>> void bubblesort(T[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j].compareTo(array[j+1]) > 0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                } 
            }
        }
    }
}
