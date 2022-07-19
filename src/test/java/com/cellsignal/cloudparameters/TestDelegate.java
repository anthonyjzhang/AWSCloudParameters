package com.cellsignal.cloudparameters;

//import com.cellsignal.cloudparameters.configuration.model.InlineResponse200;
import com.cellsignal.cloudparameters.delegate.ParameterApiDelegateImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class TestDelegate {
    //@Test
    void hello(){
        System.out.println("hi");
        Assertions.assertTrue(true);
        ParameterApiDelegateImpl cut = new ParameterApiDelegateImpl();
        ResponseEntity<String> output = cut.getParameter("/azhang/test/parameter");
        Assertions.assertNotNull(output);
    };

}
