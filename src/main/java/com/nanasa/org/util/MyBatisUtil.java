package com.nanasa.org.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Ujitha on 8/20/2016.
 */
@Component
public class MyBatisUtil {
    private static SqlSessionFactory factory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    private MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
