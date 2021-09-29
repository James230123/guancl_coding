import java.util.Scanner;
/**
 * @Author guancl
 * @Date 2021/9/29 3:31 下午
 * @Version 1.0
 */
public class coding_test {
    public static void main(String[] args) {
        System.out.println("请输入排列数字总个数和翻转次数:");
        Scanner sc = new Scanner(System.in);
        String[] info = sc.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);     //排列数字个数n
        int k = Integer.parseInt(info[1]);     //翻转次数K
        //生成初始排列
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        String m = "";
        for (int i = 0; i < array.length - 1; i++) {
            m = m + array[i] + " ";
        }
        m = m + array[array.length - 1];
        System.out.println("初始排列为:"+m);

        //循环输入翻转区间起始点和终点
        for (int i = 0; i < k; i++) {
            int s=i+1;
            System.out.println("请输入第"+s+"次翻转区间：");
            String[] lr = sc.nextLine().split(" ");
            int l = Integer.parseInt(lr[0]);   //区间起始点l
            int r = Integer.parseInt(lr[1]);   //区间终点r

            //确保翻转区间起始点和终点非递减
            if (array[l - 1] < array[r - 1]) {
                int t = array[l - 1];
                array[l - 1] = array[r - 1];
                array[r - 1] = t;
            }
            if (l < r - 2){
                reverse(array, l, r - 2);  //翻转区间除起始点和终点意外的元素翻转
            }
        }
        //打印翻转后排列结果
        String s = "";
        for (int i = 0; i < array.length - 1; i++) {
            s = s + array[i] + " ";
        }
        s = s + array[array.length - 1];
        System.out.println("翻转后排列结果为:"+s);
    }

    //元素翻转方法
    public static void reverse(int[] array, int l, int r) {
        for (int i = l; i <= l + (r - l) / 2; i++) {
            int t = array[r + (l - i)];
            array[r + (l - i)] = array[i];
            array[i] = t;
        }
    }

}

