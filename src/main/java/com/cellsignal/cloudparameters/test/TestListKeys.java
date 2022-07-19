package com.cellsignal.cloudparameters.test;

import com.cellsignal.cloudparameters.api.ListApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.model.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.DescribeParametersRequest;
import software.amazon.awssdk.services.ssm.model.DescribeParametersResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListKeys {
    public static void main(String[] args) {
        String prefix = "/hgiu";
        Region awsRegion = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .region(awsRegion)
                .build();
        List<String> ret = new ArrayList<>();

        try {
            GetParametersByPathRequest getParametersRequest = GetParametersByPathRequest
                    .builder()
                    .path(prefix)
                    .recursive(true)
                    .build();

            GetParametersByPathResponse getParametersResponse = ssmClient.getParametersByPath(getParametersRequest);
            List<Parameter> params = getParametersResponse.parameters();
            Iterator<Parameter> parameterIterator = params.iterator();

            while (parameterIterator.hasNext()) {
                Parameter parameter = parameterIterator.next();
                System.out.println(parameter.name());
                //System.out.println(parametersList.description());
                ret.add(parameter.name());
            }

        } catch (SsmException e) {

            if (ret.size() == 0) {
                System.out.println("400 error");
        }
            System.out.println("500 error");
            //log.error("Couldn't serialize response for content type application/json", e);
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }


        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            System.out.println(ret);
            //return ResponseEntity.ok(ret);

    }
}