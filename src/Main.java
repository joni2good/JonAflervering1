import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> emptyListInt = new ArrayList<>();
        ArrayList<String> emptyListStr = new ArrayList<>();
        Set<String> emptySetStr = new HashSet();

        ArrayList<String> listStr1 = new ArrayList<>(Arrays.asList("abcdefg", "deafg", "hij", "even", "a", "a", "a", "a"));
        ArrayList<String> listStr2 = new ArrayList<>(Arrays.asList("abcdefg", "deafg", "hij", "even", "a", "a"));
        ArrayList<Integer> listInt = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 4, 5, 5));

        Set<String> setStr = new HashSet();
        Map<String, String> mapStr1 = new HashMap<>();

        for (int i = 1; i <= 5; i++){
            mapStr1.put("'" + i + "'", "'" + i + "'");
        }

        for (String string : listStr1) {
            setStr.add(string);
        }

        System.out.println(averageVowels(listStr2));
        System.out.println(averageVowels(emptyListStr) + "\n");

        System.out.println(countUnique(listInt));
        System.out.println(countUnique(emptyListInt) + "\n");

        System.out.println(maxLength(setStr));
        System.out.println(maxLength(emptySetStr) + "\n");

        setStr.forEach(System.out::println);
        removeEvenLength(setStr);
        System.out.println();
        setStr.forEach(System.out::println);
        System.out.println();

        System.out.println(contains3(listStr1));
        System.out.println(contains3(listStr2) + "\n");

        System.out.println(isUnique(mapStr1));
        System.out.println(mapStr1);
        mapStr1.put("'6'", "'1'");
        System.out.println(isUnique(mapStr1));
        System.out.println(mapStr1);
    }

    //Chapter 10 exercise 1
    public static double averageVowels(ArrayList<String> list){
        int totalVowels = 0;
        for (String word: list) {
            for (int i = 0; i < word.length(); i++){
                switch (word.charAt(i)){
                    case 'a' :
                    case 'e' :
                    case 'i' :
                    case 'o' :
                    case 'u' : totalVowels++;
                }
            }
        }
        return (double) totalVowels/ list.size();
    }

    //Chapter 11 exercise 6
    public static int countUnique(List<Integer> list){
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : list) {
            numSet.add(num);
        }
        return numSet.size();
    }

    //Chapter 11 exercise 8
    public static int maxLength(Set<String> setStr){
        int longestStr = 0;
        String str1;

        Iterator<String> iterator = setStr.iterator();

        while (iterator.hasNext()){
            str1 = iterator.next();
            if (str1.length() > longestStr){
                longestStr = str1.length();
            }
        }
        return longestStr;
    }

    //Chapter 11 exercise 10
    public static void removeEvenLength(Set<String> setStr){
        String str1;
        Iterator<String> iterator = setStr.iterator();
        List<String> strToRem = new ArrayList<>();

        while (iterator.hasNext()){
            str1 = iterator.next();
            if (str1.length() % 2 == 0){
                strToRem.add(str1);
            }
        }

        //fjernes i seperat loop for at undgå ConcurrentModificationException
        for (String stringToRem : strToRem) {
            setStr.remove(stringToRem);
        }
    }

    //Chapter 11 exercise 12
    public static boolean contains3(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        int amount = 0;
        for (String str : list) {
            amount = 0;
            if (map.containsKey(str)){
                amount = map.get(str) + 1;
            }
            map.put(str, amount);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3){
                return true;
            }
        }
        return false;
    }

    //Chapter 11 exercise 13
    public static boolean isUnique(Map<String, String> map){
        Set<String> valueSet = new HashSet<>(map.values());

        if (map.size() == valueSet.size()){
            return true;
        }
        return false;
    }

    //CodingBat øvelse mapBully, har også lavet dem inde på CodingBat
    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.containsKey("a")){
            if(map.containsKey("b")){
                map.replace("b", map.get("a"));
                map.replace("a", "");
            }else{
                map.put("b", map.get("a"));
                map.replace("a", "");
            }
            return map;
        }
        return map;
    }

    //CodingBat øvelse mapAB, har også lavet dem inde på CodingBat
    public Map<String, String> mapAB(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b")){
            String tempStr = map.get("a") + map.get("b");
            map.put("ab", tempStr);
            return map;
        }
        return map;
    }
}