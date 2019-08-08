package scala.demo.java.com.heyanwei.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

        String source = "32a343@24ddddd3243@";
        String regex = ".*?@";
        System.out.println(match(source,regex));
        String replacement = "replacement";
        System.out.println(replace(source,regex,replacement));

        System.out.println(group(source,regex,0));
        System.out.println(group(source,regex,1));
        System.out.println(group(source,regex,2));

    }

    /**
     * 是否匹配到某个正则表达式
     * @param source
     * @param regex
     * @return
     */
    public static boolean match(String source,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher.find();
    }

    public static String replace(String source,String regex,String replacement){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher.replaceAll(replacement);

    }

    public static Object group(String source,String regex,int index){
        Matcher matcher = Pattern.compile(regex).matcher(source);
        if(matcher.find()){
            String group = matcher.group(index);
            String s = matcher.group();
            return group;
        }
        return null;
    }
}
