package Arrays;

public class rowColMAx {
    public static void main (String[]args){
        int arr [][]= {
            {1,1,1,1},
            {2,2,2,2},
            {3,3,3,3},
            {4,4,4,4}
        };
        System.out.println(arr.length +" " + arr[0].length);

        int rowmax =0;
        int colmax=0;
        for (int i=0; i<4; i++){
            int row=0;
            for (int j=0; j<4; j++){
                row+=arr[i][j];
            }
            rowmax = Math.max(rowmax , row);
        }

        System.out.println(rowmax);

         for (int i=0; i<4; i++){
            int col=0;
            for (int j=0; j<4; j++){
                col+=arr[j][i];
            }
            colmax = Math.max(colmax , col);
        }


        System.out.println(colmax);


        System.out.println(colmax+ rowmax);
    }
}


