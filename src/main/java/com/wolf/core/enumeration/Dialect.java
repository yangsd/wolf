package com.wolf.core.enumeration;

/**
 * Created by sdyang on 2016/10/29.
 */
public enum Dialect {

    MYSQL("MYSQL","MYSQL"), ORACLE("ORACLE", "ORACLE"),DB2("DB2","DB2"),SQLSERVER("SQLSERVER","SQLSERVER");

    private String key;
    private String value;

    private Dialect(String key, String value) {
       this.key = key;
        this.value = value;
    }

    // 普通方法
    public static String getValue(String key) {
        for (Dialect c : Dialect.values()) {
            if (c.getKey().equals(key)) {
                return c.value;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
