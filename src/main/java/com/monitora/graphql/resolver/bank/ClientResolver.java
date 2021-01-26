package com.monitora.graphql.resolver.bank;

import com.monitora.graphql.domain.bank.Asset;
import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

//    public DataFetcherResult<Client> client(BankAccount bankAccount) {
//        log.info("Request client data from bank account id {} ", bankAccount.getId());
//
//        return DataFetcherResult.<Client>newResult()
//                .data(Client.builder().id(UUID.randomUUID()).firstName("Cliente novo").lastName("Da Silva").build()).build();
////                .error(new GenericGraphQLError("Could not retrieve all data of client")).build();
//    }

    //irá executar uma nova thread para executar este serviço e ao finalizar irá retornar o valor
    //semelhando ao Promise ou async/wait do javascript
    public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Settings assets fro bank account id {}", bankAccount.getId());

                    return DataFetcherResult.<Client>newResult()
               .data(Client.builder().id(UUID.randomUUID()).firstName("Cliente novo").lastName("Da Silva").build()).build();

                },
                executorService
        );

    }
}
