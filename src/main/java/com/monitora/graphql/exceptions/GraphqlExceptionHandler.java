package com.monitora.graphql.exceptions;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(RuntimeException e) {
        log.error("RuntimeException {}", e.getMessage());
        return new ThrowableGraphQLError(e, "Internal server error");
    }

    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ThrowableGraphQLError handle(FileSizeLimitExceededException e) {
        return new ThrowableGraphQLError(e, "The field file exceeds its maximum permitted size of 2097152 bytes.");
    }
}
