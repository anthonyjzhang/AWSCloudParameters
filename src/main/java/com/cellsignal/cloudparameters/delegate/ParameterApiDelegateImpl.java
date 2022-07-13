package com.cellsignal.cloudparameters.delegate;

import com.cellsignal.cloudparameters.api.ParameterApiDelegate;
import com.cellsignal.cloudparameters.configuration.model.InlineResponse200;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ssm.model.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Service
public class ParameterApiDelegateImpl implements ParameterApiDelegate {
<<<<<<< HEAD
=======
  
>>>>>>> 781ec6f1e8c0a2b07ddd04a49ad6445b5ee56c27
  @Override
  public ResponseEntity<InlineResponse200> getParameter(String key) {

        Region awsRegion = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(awsRegion)
                .build();
        String path = "/azhang/test/parameter";

        try{
            GetParameterRequest getParameterRequest = GetParameterRequest.builder()
                .name(path)
                .build();
            GetParameterResponse getParameterResponse = ssmClient.getParameter(getParameterRequest);
            System.out.println("The parameter value is: " + getParameterResponse.parameter().value());
        }
        catch (SsmException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}

