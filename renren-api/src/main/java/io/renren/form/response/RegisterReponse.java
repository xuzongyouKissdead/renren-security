package io.renren.form.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterReponse extends SessionResponse{

}
