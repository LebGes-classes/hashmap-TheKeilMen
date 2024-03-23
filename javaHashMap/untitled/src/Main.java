import pkg.prettystreet.hashmap.HashMap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("3223", "Time");
        hashMap.put("5", "fasfa");
        hashMap.put("432", "afsdf");
        hashMap.put("326223", "agd");
        hashMap.put("35", "agdsa");
        hashMap.put("3242", "ggdgd");


        hashMap.print();
        System.out.println(hashMap.size());
    }
}