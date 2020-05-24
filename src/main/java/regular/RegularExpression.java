package regular;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression{

    public static void main(String[] args) {
        String[] placeList = {"中华人民共和国江苏省南京市栖霞区仙林大学城紫金D-506","中华人民共和国上海市上海市青浦区香花桥镇",
                              "中华人民共和国宁夏回族自治区银川市银川县","中华人民共和国河南省信阳市淮滨县城关镇时代新城4单元6号"};
        for(String place: placeList){
            System.out.println(regular(place));
        }
    }

    public static List<Map<String, String>> regular(String address){
        String regex = "(?<country>[^国]+国)(?<province>[^省]+省|.+自治区|.+市)(?<city>[^市]+市)" +
                       "(?<county>[^县]+县|.+区|)?(?<town>[^区]+区|.+镇|.+街|.+城)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String country = null,province = null,city = null,county = null,town = null,village = null;
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        while (m.find()){
            map = new LinkedHashMap<String, String>();
            country = m.group("country");
            map.put("country",country == null?"": country.trim());
            province = m.group("province");
            System.out.println(province);
            map.put("province",province == null?"": province.trim());
            city = m.group("city");
            map.put("city",city == null?"": city.trim());
            county = m.group("county");
            map.put("county",county == null?"": county.trim());
            town = m.group("town");
            map.put("town",town == null?"": town.trim());
            village = m.group("village");
            map.put("village",village == null?"": village.trim());
            list.add(map);

        }
        return list;
    }
}
