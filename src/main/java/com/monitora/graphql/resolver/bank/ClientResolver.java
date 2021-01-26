package com.monitora.graphql.resolver.bank;

import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Client;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Request client data from bank account id {} ", bankAccount.getId());

        return Client.builder().id(UUID.randomUUID()).firstName("Cliente novo").lastName("Da Silva").build();

    }

}
