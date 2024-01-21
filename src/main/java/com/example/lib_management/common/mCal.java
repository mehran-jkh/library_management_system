package com.example.lib_management.common;

import java.sql.Timestamp;

public class mCal {
    public static Timestamp getCurrentDateTime()
    {
        return new Timestamp(new java.util.Date().getTime());
    }


}
