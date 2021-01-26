package com.monitora.graphql.resolver.bank.mutation;

import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Currency;
import com.monitora.graphql.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput input, DataFetchingEnvironment e) {
        log.info("Parameter createBankAccount {}", input);
        log.info("Parameter DataFetchingEnvironment {}", e);
        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.BRL).build();
    }
}
