package org.example;

public class kthElementOf2Arrays {
    /**
     * Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.
     *
     * Examples :
     *
     * Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
     * Output: 6
     * Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
     * Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
     * Output: 256
     * Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
     * Constraints:
     *
     * 1 <= a.size(), b.size() <= 106
     * 1 <= k <= a.size() + b.size()
     * 0 <= a[i], b[i] < 108
    */

    public static int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int n = b.length;

//        if (m < n) {
//            return kthElement(b, a, k);
//        }

        int l = 0;
        int r = m;

        while(l <= r) {
            int p1 = l + (r - l) / 2;
            int p2 = k - p1;
            if (p1 > k) {
                r = p1 - 1;
            } else if (p2 > n) {
                l = p1 + 1;
            } else {
                int leftMax1 = p1 == 0 ? Integer.MIN_VALUE : a[p1 - 1];
                int leftMax2 = p2 == 0 ? Integer.MIN_VALUE : b[p2 - 1];
                int rightMin1 = p1 == m ? Integer.MAX_VALUE : a[p1];
                int rightMin2 = p2 == n ? Integer.MAX_VALUE : b[p2];

                if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                    return Math.max(leftMax1, leftMax2);
                } else if (leftMax1 > rightMin2) {
                    r = p1 - 1;
                } else {
                    l = p1 + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5));
        System.out.println(kthElement(new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}, 7));
    }
}
