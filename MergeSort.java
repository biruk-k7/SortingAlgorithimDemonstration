public class MergeSort {
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
            System.exit(2);
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

        mergeSort(arr);
    }

    public static void mergeSort(Element[] elements) {
        double n =  elements.length+0.0;
        StdDraw.clear(StdDraw.PRINCETON_ORANGE);
        StdDraw.setScale(0, n);
        mergesortHelper(elements, 0, elements.length);

    }

    public static void mergesortHelper(Element[] arr, int low, int high) {
        double n = arr.length+0.0;

        if (high - low <= 1) {
            for (int e = 0; e < arr.length; e++) {
                if (e == low) {
                    StdDraw.setPenColor(213, 33, 33);
                }
                else {
                    StdDraw.setPenColor(33, 33, 213);
                }

                arr[e].draw(e+ 0.8, (n+1)/2, arr[e].getValue() - (0.95* arr[e].getValue()));
                StdAudio.play(arr[e].getSound());
            }

        }
        else {
            int mid = low + (high - low) / 2;
            mergesortHelper(arr, low, mid);
            mergesortHelper(arr, mid, high);
            merge(arr, low, high);
            for (int element = 0; element < arr.length; element++) {
                if (element >= low && element < high) {
                    StdDraw.setPenColor(233, 33, 33);
                }
                else {
                    StdDraw.setPenColor(33, 33, 233);
                }

                arr[element].draw(element + 0.9, (n+1)/2, arr[element].getValue() - (0.95* arr[element].getValue()));
                StdAudio.play(arr[element].getSound());
            }
            StdDraw.clear(StdDraw.PRINCETON_ORANGE);
        }
    }

    public static void merge(Element[] arr, int low, int high) {
        int n =  arr.length;
        int mid = low + (high - low) / 2;
        Element[] merged = new Element[high - low];
        int lowi = low;
        int uppi = mid;
        for (int meri = 0; meri < merged.length; meri++) {
            if (lowi == mid) {
                while (uppi < high) {
                    merged[meri] = arr[uppi];
                    uppi++;
                    meri++;
                }
                break;

            }
            else if (uppi == high) {
                while (lowi < mid) {
                    merged[meri] = arr[lowi];
                    lowi++;
                    meri++;
                }

                break;
            }
            else if (arr[lowi].compareTo(arr[uppi]) < 0) {
                merged[meri] = arr[lowi];
                lowi++;
            }
            else {
                merged[meri] = arr[uppi];
                uppi++;
            }
            StdDraw.clear(StdDraw.PRINCETON_ORANGE);

        }

        for (int i = 0; i < merged.length; i++) {
            arr[low + i] = merged[i];
        }
    }
}