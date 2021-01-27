package com.monitora.graphql.exceptions;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

//@Slf4j
//@Component
//public class CustomGraphqlExceptionHandler implements GraphQLErrorHandler {
//    @Override
//    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
//        log.error("CustomGraphqlExceptionHandler {}:", errors.toString());
//        for (GraphQLError e:errors) {
//            log.error("getErrorType {}:", e.getErrorType());
//            log.error("getMessage {}:", e.getMessage());
//            log.error("getExtensions {}:", e.getExtensions());
//            log.error("getLocations {}:", e.getLocations());
//            log.error("getPath {}:", e.getPath());
//            log.error("toSpecification {}:", e.toSpecification());
//            log.error("getClass {}:", e.getClass());
//            log.error("toString {}:", e.toString());
//        }
//
//        return errors;
//    }
//}
