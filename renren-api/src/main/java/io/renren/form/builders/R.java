package io.renren.form.builders;

import io.renren.form.response.BaseResponseEntity;

public class R <T>{
    private int code;

    private String message;

    private T data;

    public R() {
    }

    public R<T> code(int code) {
        this.code = code;
        return this;
    }

    public R<T> message(String message) {
        this.message = message;
        return this;
    }

    public R<T> data(T data) {
        this.data = data;
        return this;
    }

    public BaseResponseEntity<T> build() {
        BaseResponseEntity<T> result = new BaseResponseEntity<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.data);
        return result;
    }

    /*public H5ResponseEntity<T> buildH5() {
        H5ResponseEntity<T> result = new H5ResponseEntity<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.data);
        return result;
    }*/

    public static <T> BaseResponseEntity<T> success(T data) {
        return new R<T>().code(1).message("success").data(data).build();
    }

    public static <T> BaseResponseEntity<T> success(void aVoid) {
        return new R<T>().code(1).message("success").build();
    }
    public static <T> BaseResponseEntity<T> failed(String message) {
        return (new R()).code(0).message(message).build();
    }

   /* public static <T> H5ResponseEntity<T> successH5(T data) {
        return new R<T>().code(1).message("success").data(data).buildH5();
    }
*/
   /* public static <T> H5ResponseEntity<T> successH5() {

        return new R<T>().code(1).message("success").buildH5();
    }
*/
}
