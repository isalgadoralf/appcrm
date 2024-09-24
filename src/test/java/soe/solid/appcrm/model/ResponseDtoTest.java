package soe.solid.appcrm.model;

import org.junit.jupiter.api.Test;

public class ResponseDtoTest {
    @Test
    void testEquals() {
        ResponseDto responseDto1 = new ResponseDto();
        responseDto1.setCodigo(1);
        responseDto1.setMensaje("mensaje");
        ResponseDto responseDto2 = new ResponseDto();
        responseDto2.setCodigo(1);
        responseDto2.setMensaje("mensaje");
        assert(responseDto1.equals(responseDto2));
    }
}
