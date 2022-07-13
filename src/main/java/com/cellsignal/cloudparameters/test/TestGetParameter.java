package com.cellsignal.cloudparameters.test;

import com.cellsignal.cloudparameters.api.ParameterApiDelegate;
import com.cellsignal.cloudparameters.configuration.model.InlineResponse200;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.services.ssm.model.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class TestGetParameter {
    public static void main(String[] args) {
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
            //log.error("Couldn't serialize response for content type application/json", e);
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

