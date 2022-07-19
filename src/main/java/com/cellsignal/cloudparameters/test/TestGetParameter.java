package com.cellsignal.cloudparameters.test;

import com.cellsignal.cloudparameters.api.ParameterApiDelegate;
//import com.cellsignal.cloudparameters.configuration.model.InlineResponse200;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.model.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class TestGetParameter {
    public static void main(String[] args) {
        Region awsRegion = Region.US_EAST_1;
        String ret = null;
        String key = "/azhang/test/parameters";
        String check = null;
        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .region(awsRegion)
                .build();

        try {
            GetParameterRequest getParameterRequest = GetParameterRequest.builder()
                    .name(key)
                    .build();
            GetParameterResponse getParameterResponse = ssmClient.getParameter(getParameterRequest);
            check = getParameterResponse.parameter().value();
            //if (getParameterResponse.parameter().value()==""){

                //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //}
            ret = "The parameter value is: " + getParameterResponse.parameter().value();

        } catch (SsmException e) {
            if (check == null){
                System.out.println("400 error");
            }
            System.out.println("500 error");
            //log.error("Couldn't serialize response for content type application/json", e);
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        System.out.println(ret);
        //return ResponseEntity.ok(ret);
    }
}

