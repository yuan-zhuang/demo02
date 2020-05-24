package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    public static void regular(String address){
        String regex = "(?<country>[^国]+国)(?<province>[^省]+省|.+自治区|.+市)(?<city>[^市]+市)" +
                       "(?<county>[^区]+区|.+县)(?<street>[^街]+街|.+乡)(?<others>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String country = null, province = null, city = null, county = null, street = null, others = null;
        while (m.find()){
            country = m.group("country");
            System.out.println(country);

            province = m.group("province");
            System.out.println(province);

            city = m.group("city");
            System.out.println(city);

            county = m.group("county");
            System.out.println(county);

            street = m.group("street");
            System.out.println(street);

            others = m.group("others");
            System.out.println(others);
        }
    }
}
