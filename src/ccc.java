package work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ccc {
    public static void main(String[] args) {
        String str[] = {
            "aaa.bbb.tokyo.japan",
            "bbb.tokyo.japan",
            "aaa.bbb.nagoya.japan",
            "aaa.bbb.osaka.japan",
        };

        List<String> list = new ArrayList<>();
        for(String row: str) {
            Pattern p = Pattern.compile(".*(.*)(\\..*)(\\..*)");
            Matcher m = p.matcher(row);
            m.matches();

            list.add(m.group(1) + m.group(2) + m.group(3));
            
        }

        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }

    }
}
