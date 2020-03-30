package people.cl.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import people.cl.Dto.ErrorDto;
import people.cl.exceptions.ApiExceptions;

@ConfigurationProperties(prefix = "errores")
@Component
@Setter
@Getter
public class ErroresConfiguration {
    private ErrorDto camposVacios;
    private ErrorDto camposNulos;
    private ErrorDto registroNoExiste;

    public ApiExceptions obtenerErrorDeNegocio(ErrorDto errorDto){
        return new ApiExceptions(errorDto.getCodigo(), errorDto.getMensaje());
    }
}
