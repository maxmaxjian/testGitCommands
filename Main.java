
class Main {
    
    public int nthElement(int[] arr, int nth) {
        return partition(arr, 0, arr.length-1, nth-1);
    }

    private int partition(int[] arr, int start, int end, int nth) {
        if (start < end) {
            int firsthigh = start;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[end]) {
                    if (i != firsthigh)
                        swap(arr, i, firsthigh);
                    firsthigh++;
                }
            }
            swap(arr, firsthigh, end);
//            System.out.println("s = "+start+", e = "+end+", nth = "+nth+", found = "+firsthigh);
            
            if (firsthigh == nth)
                return arr[firsthigh];
            else if (firsthigh < nth)
                return partition(arr, firsthigh+1, end, nth);
            else
                return partition(arr, start, firsthigh-1, nth);
        }
        return arr[start];
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] tobesorted = {3,2,1,4};
        int k = 4;
        
        Main soln = new Main();
        int found = soln.nthElement(tobesorted, k);
        System.out.println("The "+k+"-th largest element is: "+found);
        for (int i = 0; i < tobesorted.length; i++)
            System.out.print(tobesorted[i]+" ");
        System.out.println();
    }
}
