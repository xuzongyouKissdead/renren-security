
package io.renren.common.exception;

import io.renren.common.Enums.ExceptionEnum;

/**
 * @author xuzongyou
 */
public class ServiceException extends ErrorCodeException {

    private static final long serialVersionUID = 4881464515416673811L;
    private ExceptionEnum exceptionEnum;
    private ServiceExceptionSpec serviceExceptionSpec;

    public ServiceException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getCode(), exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    /**
     * 不加密异常
     * @return
     */
    public ServiceExceptionSpec getSpec() {
        if (null == serviceExceptionSpec) {
            serviceExceptionSpec = new ServiceExceptionSpec(this.exceptionEnum);
        }
        return serviceExceptionSpec;
    }
}
