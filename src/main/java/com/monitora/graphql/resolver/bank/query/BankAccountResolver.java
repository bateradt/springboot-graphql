package com.monitora.graphql.resolver.bank.query;

import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Client;
import com.monitora.graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Retrieve bank account ID {}", id);

        List<String> list = new ArrayList<>();

        list.add("MeioA");

        Client clientA = Client.builder().id(UUID.randomUUID()).firstName("Cliente A").middleNames(list).lastName("Nome finalA").build();

        list.clear();
        list.add("MeioB");

        Client clientB = Client.builder().id(UUID.randomUUID()).firstName("Cliente B").middleNames(list).lastName("Nome finalB").client(clientA).build();

        clientA.setClient(clientB);

        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).build();
    }
}
