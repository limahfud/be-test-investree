package me.mahfud.util.parser;

import me.mahfud.util.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseParser {

    private String json;

    protected BaseParser(String json) {
        this.json = json;
    }

    protected String getJsonValueString(String key) {
        String regExp = "\"" + key + "\":\"([^\"]*)\"";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) return matcher.group(1);

        return Constant.BLANK_STRING;
    }

    protected Double getJsonValueDouble(String key) {
        String regExp = "\"" + key + "\":([^,]*)";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) return Double.parseDouble(matcher.group(1));

        return 0D;
    }

    protected Integer getJsonValueInteger(String key) {
        String regExp = "\"" + key + "\":([^,]*)";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) return Integer.parseInt(matcher.group(1));

        return 0;
    }
}