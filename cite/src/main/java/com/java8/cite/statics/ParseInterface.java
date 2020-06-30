package com.java8.cite.statics;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
@FunctionalInterface
public interface ParseInterface {

    /**
     * 把string转换成int
     * @param str
     * @return
     */
    int parseString(String str);
}
