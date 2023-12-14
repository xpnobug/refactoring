
package com.kdg.refactoring.kdgcommon.core.constant;

import cn.hutool.core.text.StrPool;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字符串相关常量
 * @author 86136
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringConstants implements StrPool {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 空格
     */
    public static final String SPACE = " ";

    /**
     * 分号
     */
    public static final String SEMICOLON = ";";

    /**
     * 星号
     */
    public static final String ASTERISK = "*";

    /**
     * 问号
     */
    public static final String QUESTION_MARK = "?";

    /**
     * 中文逗号
     */
    public static final String CHINESE_COMMA = "，";
}
