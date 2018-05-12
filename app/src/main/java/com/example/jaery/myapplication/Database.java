package com.example.jaery.myapplication;

import android.provider.BaseColumns;


public final class Database {

    public static final class CreateDB implements BaseColumns{
        public static final String _TABLENAME = "Log";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +"CHAP"+" integer primary key, "
                        +"IND"+" integer);";
    }




}
