package com.mad.madproject.util;

import java.util.List;

public class Convertor {
    public Convertor(){}

    public String convertListToString(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strings.size(); i++) {
            stringBuilder.append(strings.get(i));
            if (i != strings.size() - 1) stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
