package aon;
public class FindArrayMain {
    public static void main(String[] args) {
        // typically I would want to do this in a framework like JUnit or NUnit / XUnit but for simplicity I'm just doing it in a main method
        // assuptions not given in question: 
        // if not able to find the array then return -1
        // array 2 will always be smaller than array 1
        // negative values allowed
        // values of array will not exceed that of a regular signed integer (min or max)
        // null and empty arrays are allowed, but will result in not finding anything
        System.out.println("RESULT: " + findArrayIndex(new int[]{4, 9, 3, 7, 8}, new int[]{3, 7}) + " EXPECTED: " + 2);
        System.out.println("RESULT: " + findArrayIndex(new int[]{4, 9, 3, 7, 8, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9, 9, 9}) + " EXPECTED: " + 5);
        System.out.println("RESULT: " + findArrayIndex(new int[]{1, 2, 3}, new int[]{}) + " EXPECTED: " + -1);
        System.out.println("RESULT: " + findArrayIndex(new int[]{1, 2, 3, -4, -5}, new int[]{-4, -5}) + " EXPECTED: " + 3);
        System.out.println("RESULT: " + findArrayIndex(new int[]{1, 2, 3, Integer.MIN_VALUE, Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}) + " EXPECTED: " + 3);
        System.out.println("RESULT: " + findArrayIndex(null, new int[]{1}) + " EXPECTED: " + -1);
        System.out.println("RESULT: " + findArrayIndex(new int[]{1}, null) + " EXPECTED: " + -1);
    }

    private static int findArrayIndex(int[] arr1, int[] arr2) {

        if(arr1==null || arr2==null || arr1.length==0 || arr2.length==0) return -1;

        for(int i = 0; i < arr1.length; i++) {

            int j = i;
            int k = 0;
            while(arr1[j]==arr2[k]) {
                k++;
                j++;
                if(k==arr2.length) {
                    return i;
                }
            }
        }

        return -1;
    }
}
