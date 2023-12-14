
package com.kdg.refactoring.kdgcommon.core.exception;

import lombok.NoArgsConstructor;

/**
 * 自定义异常基类
 *
 * @author Charles7c
 * @since 1.0.0
 */
@NoArgsConstructor
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
