package com.monitora.graphql.resolver.bank.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
      log.info("Upload file {}", environment);

        DefaultGraphQLServletContext context = environment.getContext();

        context.getFileParts().forEach(part -> {
            log.info("uploading {} , size {}", part.getSubmittedFileName(), part.getSize());
        });

        return UUID.randomUUID();
    }
}
