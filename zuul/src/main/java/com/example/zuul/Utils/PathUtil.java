package com.example.zuul.Utils;

import org.springframework.util.AntPathMatcher;

public class PathUtil {

    private static AntPathMatcher matcher = new AntPathMatcher();
    public static boolean isPathMatch(String pattern, String path) {
        return matcher.match(pattern, path);
    }
}
