
package io.renren.common.exception;

import io.renren.common.Enums.ExceptionEnum;

/**
 * @author xuzongyou
 *
 */
public class ServiceExceptionSpec extends ErrorCodeException {

    private static final long serialVersionUID = 4881464515416673811L;

    public ServiceExceptionSpec(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }
}
