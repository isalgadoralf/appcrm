package soe.solid.appcrm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private int codigo;
    private String mensaje;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ResponseDto responseDto = (ResponseDto) obj;
        return responseDto.getCodigo() == getCodigo() && responseDto.getMensaje().equals(getMensaje());
    }
}
