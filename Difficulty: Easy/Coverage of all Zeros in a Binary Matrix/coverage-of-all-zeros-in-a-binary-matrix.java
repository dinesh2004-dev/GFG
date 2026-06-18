class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int r = mat.length;
        int c = mat[0].length;

        int res = 0;

        //  looping for all rows of matrix
        for (int i = 0; i < r; i++)
        {
            boolean isOne = false;  // 1 is not seen yet

            // looping in columns from left to right
            // direction to get left ones
            for (int j = 0; j < c; j++)
            {
                // If one is found from left
                if (mat[i][j] == 1)
                    isOne = true;

                // If 0 is found and we have found
                // a 1 before.
                else if (isOne)
                    res++;
            }

            // Repeat the above process for right to
            // left direction.
            isOne = false;

            for (int j = c - 1; j >= 0; j--)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }
        }

        // Traversing across columns for up and down
        // directions.
        for (int j = 0; j < c; j++)
        {
            boolean isOne = false;  // 1 is not seen yet

            for (int i = 0; i < r; i++)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }

            isOne = false;

            for (int i = r - 1; i >= 0; i--)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }
        }

        return res;
        
    }
}