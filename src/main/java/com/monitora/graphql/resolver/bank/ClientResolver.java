package com.monitora.graphql.resolver.bank;

import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Request client data from bank account id {} ", bankAccount.getId());

        return DataFetcherResult.<Client>newResult()
                .data(Client.builder().id(UUID.randomUUID()).firstName("Cliente novo").lastName("Da Silva").build())
                .error(new GenericGraphQLError("Could not retrieve all data of client")).build();
    }
}
