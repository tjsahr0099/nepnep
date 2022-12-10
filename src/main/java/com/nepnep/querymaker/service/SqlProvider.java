package com.nepnep.querymaker.service;

import org.apache.ibatis.jdbc.SQL;

public class SqlProvider {

    public String mySelect(){

        return new SQL(){{

            if(true) {
                SELECT("SEQ");
            }

            FROM("TBL_BOARD");
            WHERE("SEQ = 7");

        }}.toString();
    }


}
