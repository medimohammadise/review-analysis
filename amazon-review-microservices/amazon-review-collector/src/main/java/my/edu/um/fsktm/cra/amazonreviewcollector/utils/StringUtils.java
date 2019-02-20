package my.edu.um.fsktm.cra.amazonreviewcollector.utils;

import org.joda.time.DateTime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String convertToDate(String dateWithAgoFormat) {
        if ("".equals(dateWithAgoFormat) || dateWithAgoFormat==null) return null;
        String patternString = "^(\\d+)\\s*(\\w+)\\s*ago";
        Pattern pattern = Pattern.compile(patternString);

        // Now create matcher object.
        Matcher m = pattern.matcher(dateWithAgoFormat);
        if (m.find()) {

            Integer monthOrDaysAgo = Integer.valueOf(m.group(1));
            String monthOrDay = m.group(2);
            switch (monthOrDay) {
                case "months":
                    return DateTime.now().minusMonths(monthOrDaysAgo).toString();

                case "days":
                    return DateTime.now().minusDays(monthOrDaysAgo).toString();
                case "years":
                    return DateTime.now().minusYears(monthOrDaysAgo).toString();
                case "weeks":
                    return DateTime.now().minusWeeks(monthOrDaysAgo).toString();
            }
        }

            return null;

    }
     public static void main(String[] args){
        System.out.println(convertToDate("2  days ago"));
     }

}


