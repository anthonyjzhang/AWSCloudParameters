package com.cellsignal.cloudparameters.delegate;


import com.cellsignal.cloudparameters.api.ListApiDelegate;
// import com.cellsignal.cloudparameters.configuration.model.StoreRequestType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.ssm.model.*;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.DescribeParametersRequest;
import software.amazon.awssdk.services.ssm.model.DescribeParametersResponse;
import software.amazon.awssdk.services.ssm.model.ParameterMetadata;
import software.amazon.awssdk.services.ssm.model.SsmException;

import java.util.Iterator;
import java.util.List;
import java.io.File;
@Service
public class ListApiDelegateImpl implements ListApiDelegate {


    @Override
    public ResponseEntity<List<String>> listParameters() {
        //File configFile = new File(System.getProperty("user.home"),".aws/credentials");
        //AwsCredentialsProvider awsCredentialsProvider = new ProfileCredentialsProvider();
        Region AWS_REGION = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(AWS_REGION)
                // .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
        try {
            DescribeParametersRequest describeRequest = DescribeParametersRequest.builder()
                    .maxResults(10)
                    .build();
            DescribeParametersResponse describeResponse = ssmClient.describeParameters(describeRequest);
            List<ParameterMetadata> params = describeResponse.parameters();

            Iterator<ParameterMetadata> parameterIterator = params.iterator();
            while (parameterIterator.hasNext()) {
                ParameterMetadata parameterMetadata = parameterIterator.next();
                System.out.println(parameterMetadata.name());
                System.out.println(parameterMetadata.description());
            }
        }
        catch (SsmException e) {
            e.getStackTrace();
        }

        return null; // return actual information

    }

    @Override
    public ResponseEntity<List<String>> listKeys() {

        Region AWS_REGION = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(AWS_REGION)
                // .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
        try {

        }
        catch (){

        }

        return null;
    }
}
