package other;//判断两个字符串是否互为变形词
//给定两个字符串，两个字符串str1和str2出现的字符种类一样且每种字符出现的次数也一样，则str1和str2互为变形词

public class IsDeformation {

    public boolean isDeformation(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() != str2.length()){
            return  false;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++){
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++){
            if (map[chas2[i]]-- == 0){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args){
        System.out.println(0.01+0.05);
    }
}
