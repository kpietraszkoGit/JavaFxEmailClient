package com.barosanu.view;

/**
 * Created by DELL on 2020-06-01.
 */
public enum FontSize {
    SMALL,
    MEDIUM,
    BIG;

    public static String getCssPath(FontSize fontSize){
        switch (fontSize) {
            case MEDIUM:
                return "css/fontMedium.css";
            case BIG:
                return "css/fontBig.css";
            case SMALL:
                return "css/fontSmall.css";
            default:
                return null;
        }
    }
}
