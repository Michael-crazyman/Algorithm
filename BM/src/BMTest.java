import java.util.*;
public class BMTest{

    //先算出Bad table
    private static Map<Character,Integer> generateBadTable(String target){

        if("".equals(target)||target == null){
            return null;
        }

        int length = target.length();
        Map<Character,Integer> badMap = new HashMap<>();

        for(int i = 0;i < length;i++ ){
            char ch = target.charAt(i);
            if(i == length-1){
                if(badMap.get(ch) == null){
                    badMap.put(ch,length);
                }
            }else{
                Integer value = length-1-i;
                badMap.put(ch,value);
            }

        }


        return badMap;
    }

    //写好如何计算BadTable之后需要开始比较，并且根据BadTable来判断需要移动的距离

    private static boolean compare(String src,String target){
        //1.先比较src与target的最后一位
        int srcLength = src.length();
        Map<Character,Integer> badMap = generateBadTable(target);
        int targetLength = target.length();
        int i = targetLength-1;

        while(i < srcLength) {
            for (int j = targetLength - 1; j > 0; --j) {
                char srcTemp = src.charAt(i);
                char targetTemp = target.charAt(j);
                if (srcTemp != targetTemp) {
                    if(badMap.get(srcTemp)!=null){
                        Integer offSet = badMap.get(srcTemp);
                        i += offSet;
                    }else{
                        i += srcLength;
                    }
                }else{
                    i--;
                }
            }

        }


        return false;
    }

    public static void main(String[] args){
        String test = "Tooth";
        Map<Character,Integer> map = generateBadTable(test);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.print(" Key = "+entry.getKey()+" value = "+entry.getValue());
        }
        compare("afsdatooth","tooth");
    }

}