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

        if(arr1==null || arr2==null || arr1.length==0 || arr2.length==0) return -1; //edge cases, null or empty arrays. Exploit lazy validation to check for null first, before checking length (will result in exception)

        for(int i = 0; i < arr1.length; i++) { //iterate through all nums in arr1

            int j = i, k = 0; // create two new pointers, one to start at i(to continue interating through arr1 but not touching i) and k (to iterate through arr2)
            while(arr1[j++]==arr2[k++]) {
                if(k==arr2.length) { //if we get to the end of arr2, then we've found the full array within arr1!
                    return i; //return i (original index untouched, thanks to 'j' being created)
                }
            }
        }

        return -1; //if we get through the whole array then we haven't found it
    }
}
