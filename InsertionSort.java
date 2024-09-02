public class InsertionSort {

    public static void main(String[] args) {
        if ( args.length != 1) {
            System.err.print("Please pass one positive integer as an argument!");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        if (n < 0 ) {
            System.err.print("Please pass one positive integer as an argument!");
            System.exit(1);
        }
        if(n==1){
            System.out.println("Sorted by default.");

        }
        Element[] arr = new Element[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Element((int)(Math.random()*n)+1);
        }
        Element min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(min.getValue() > arr[i].getValue()){
            min = arr[i];
        }
            for (int element = 0; element < n; element++) {
                int x = arr[element].getValue();
                arr[element].setSound((int) (440 * (Math.pow(2, (x - min.value) / 12.0))));
            }

        }

        insertionSort(arr);

    }

    public static void insertionSort(Element[] arr) {
        double n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                StdDraw.clear(StdDraw.PRINCETON_ORANGE);
                StdDraw.setScale(0, n);
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    Element tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    //StdDraw.setScale(0, n);
                    for (int k = 0; k < n; k++) {
                        if (k == j - 1) {
                            StdDraw.setPenColor(213, 33, 33);
                        } else {
                            StdDraw.setPenColor(33, 33, 213);
                        }
                        arr[k].draw(k + 0.8, (n+1)/2, arr[k].getValue() - (0.95* arr[k].getValue()));
                        StdAudio.play(arr[k].getSound());
                    }
                } else {
                    break;
                }
                StdDraw.clear();
            }
        }
    }

}
