package com.cellsignal.cloudparameters.delegate;

import com.cellsignal.cloudparameters.api.ListApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
@Service
public class ListApiDelegateImpl implements ListApiDelegate {
    @Override
    public ResponseEntity<List<String>> listParameters() {

        Region awsRegion = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(awsRegion)
                .build();
        List<String> ret = new ArrayList<>();

        try {
            DescribeParametersRequest describeRequest = DescribeParametersRequest.builder()
                    .build();
            DescribeParametersResponse describeResponse = ssmClient.describeParameters(describeRequest);

            List<ParameterMetadata> params = describeResponse.parameters();
            Iterator<ParameterMetadata> parameterIterator = params.iterator();

            while (parameterIterator.hasNext()) {
                ParameterMetadata parameterMetadata = parameterIterator.next();
                //System.out.println(parameterMetadata.name());
                //System.out.println(parameterMetadata.description());
                ret.add(parameterMetadata.name());
            }
        }
        catch (SsmException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println(ret);
        return ResponseEntity.ok(ret);
    }

    @Override
    public ResponseEntity<List<String>> listKeys(String prefix) {

        Region awsRegion = Region.US_EAST_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(awsRegion)
                .build();
        prefix = "";
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
                //System.out.println(parameter);
                //System.out.println(parametersList.description());
                ret.add(parameter.name());
            }
        }
        catch (SsmException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        System.out.println(ret);
        return  ResponseEntity.ok(ret);
    }
}
