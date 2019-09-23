package domain;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {

    public static void main(String[] args) {
        
        // String river = "Mississippi";
        
        String html = "<div class=\"image\"><img src=\"http://cdn.posh24.se/images/:profile/01003e4111da42c23be8cb0d79494db3e\" alt=\"Madonna\"/></div>";
        
        Pattern p = Pattern.compile("src=\"(.*?)\"");
        Matcher m = p.matcher(html);
        
        while (m.find()) {
            System.out.println(m.group(1));
        }
        
        p = Pattern.compile("alt=\"(.*?)\"");
        m = p.matcher(html);
        
        while (m.find()) {
            System.out.println(m.group(1));
        }
        
        // String[] splitString = myString.split("s");
        // String riverPart = river.substring(1,5);
        // System.out.println(riverPart);
    }
}