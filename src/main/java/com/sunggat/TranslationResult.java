package com.sunggat;

public class TranslationResult {
    private int code;
    private String lang;
    private String text;

    public TranslationResult(int code, String lang, String text) {
        this.code = code;
        this.lang = lang;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
