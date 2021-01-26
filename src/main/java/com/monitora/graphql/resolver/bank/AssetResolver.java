package com.monitora.graphql.resolver.bank;

import com.monitora.graphql.domain.bank.Asset;
import com.monitora.graphql.domain.bank.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class AssetResolver implements GraphQLResolver<BankAccount> {
    public static final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    //irá executar uma nova thread para executar este serviço e ao finalizar irá retornar o valor
    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Settings assets fro bank account id {}", bankAccount.getId());

                    return List.of(Asset.builder().id(UUID.randomUUID()).build(), Asset.builder().id(UUID.randomUUID()).build());
                },
                executorService
        );

    }
}
