package io.renren.form.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseEntity<T> {
    @ApiModelProperty(value = "return code defined by api protocol", required = true)
    @JsonProperty
    @NotNull
    private int code;

    @ApiModelProperty(value = "readable message corresponding to the return code", required = true)
    @JsonProperty
    @NotNull
    private String message;

    @ApiModelProperty(value = "data returned to client, in JSON format", required = false)
    @JsonProperty
    @Valid
    private T data;

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseResponseEntity<T> other = (BaseResponseEntity<T>) o;

        return Objects.equals(this.getCode(), other.getCode())
                && Objects.equals(this.getMessage(), other.getMessage())
                && Objects.equals(this.getData(), other.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getCode(),
                this.getData(),
                this.getMessage());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("code", this.getCode())
                .add("message", this.getMessage())
                .add("data", this.getData());
    }
}
