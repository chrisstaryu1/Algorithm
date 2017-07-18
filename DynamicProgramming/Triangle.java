public class Triangle {
    
/**DP From public: bottom-top**/
/**Concise and smart**/
/**Need to practice this approach more and do research on the core thoughts**/
    public int minimumTotal(List<List<Integer>> triangle) {
        //注意: 第n层有n个元素在三角形里
        int size = triangle.size();
        int[] f = new int[triangle.size()];
        
        //Initialize f[0];
        //Initialize for bottom elements
        for (int i = 0; i < size; i++) {
            f[i] = triangle.get(size - 1).get(i);
        }
        
        for (int layer = size - 2; layer >= 0; layer--) {       //此处layer代表行的index, 从size - 2即倒数第二行开始往上((size -                                                         1) - 1), 一直到最上面一层的index为0，故为>=0
            for (int i = 0; i <= layer; i++) {        //Not i < size, 应该使用i <= layer
                f[i] = Math.min(f[i], f[i + 1]) + triangle.get(layer).get(i);
            }
        }
        return f[0];
    }
    
/**My DP Solution: Top-Down**/
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     //注意: 第n层有n个元素在三角形里, 但我们定义二维数组只能定义成矩形，所以每行还是有triangle.size()个元素，只是不在三角形内的元素为0罢了
    //     int[][] f = new int[triangle.size()][triangle.size()];   //注意后面不可以用triangle.get(0).size(), 
    //                                                                      //因为第一行只有一个数
        
    //     f[0][0] = triangle.get(0).get(0);
        
    //     for (int i = 1; i < triangle.size(); i++) {
    //         f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
    //     }
        
    //     for (int i = 1; i < triangle.size(); i++) {
    //         f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
    //     }
        
    //     for (int i = 2; i < triangle.size(); i++) {
    //         for (int j = 1; j < triangle.get(i).size() - 1; j++) {
    //             f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
    //         }
    //     }
        
    //     int min = f[triangle.size() - 1][0];
    //     for (int i = 0; i < triangle.size(); i++) {
    //         min = Math.min(f[triangle.size() - 1][i], min);
    //     }
        
    //     return min;
    // }
}
