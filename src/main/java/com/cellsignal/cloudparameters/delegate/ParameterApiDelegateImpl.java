package com.cellsignal.cloudparameters.delegate;

import com.cellsignal.cloudparameters.api.ParameterApiDelegate;
//import com.cellsignal.cloudparameters.configuration.model.InlineResponse200;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.model.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Service
public class ParameterApiDelegateImpl implements ParameterApiDelegate {

    @Override
    public ResponseEntity<String> getParameter(String key) {

        Region awsRegion = Region.US_EAST_1;
        String ret;
        String checkValue = null;
        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .region(awsRegion)
                .build();
        String convert = key.replace("%2F", "/");

        try {
            GetParameterRequest getParameterRequest = GetParameterRequest.builder()
                    .name(convert)
                    .build();
            GetParameterResponse getParameterResponse = ssmClient.getParameter(getParameterRequest);
            checkValue = getParameterResponse.parameter().value();
            ret = "The parameter value is: " + getParameterResponse.parameter().value();
            System.out.println(ret);


        } catch (SsmException e) {
            if (checkValue == null) {
                System.out.println("400 error");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            System.out.println("500 error");
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);


        }
        return ResponseEntity.ok(ret);
    }
}
