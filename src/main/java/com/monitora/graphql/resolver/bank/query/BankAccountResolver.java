package com.monitora.graphql.resolver.bank.query;

import com.monitora.graphql.connection.CursorUtil;
import com.monitora.graphql.domain.bank.BankAccount;
import com.monitora.graphql.domain.bank.Client;
import com.monitora.graphql.domain.bank.Currency;
import com.monitora.graphql.repository.BankAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountResolver implements GraphQLQueryResolver {
    private final BankAccountRepository bankAccountRepository;
    private final CursorUtil cursorUtil;

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        
        //pegar quais os campos o usuário selecionou na query
        log.info("Fields in query selector {}", environment.getSelectionSet().getFields());

        List<String> requestedField = environment.getSelectionSet().getFields().stream().map(SelectedField::getName).collect(Collectors.toUnmodifiableList());

        log.info("Requested fields {}", requestedField);

        if (environment.getSelectionSet().contains("client/firstName")) {
            log.info("Client solicited the field 'firstName'");
        }

//        throw new RuntimeException("Cant connect to the postgresql on AWS: select f, a from bankAccount");
//        throw new GraphQLException("Erro ao buscar dados do BankAccount");

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

    public Connection<BankAccount> bankAccounts(int first, @Nullable String cursor) {
        List<Edge<BankAccount>> edges = getBankAccounts(cursor)
                .stream()
                .map(bankAccount -> new DefaultEdge<>(bankAccount,
                        cursorUtil.createCursorWith(bankAccount.getId())))
                .limit(first)
                .collect(Collectors.toUnmodifiableList());

        var pageInfo = new DefaultPageInfo(
                cursorUtil.getFirstCursorFrom(edges),
                cursorUtil.getLastCursorFrom(edges),
                cursor != null,
                edges.size() >= first);

        return new DefaultConnection<>(edges, pageInfo);
    }

    public List<BankAccount> getBankAccounts(String cursor) {
        if (cursor == null) {
            return bankAccountRepository.getBankAccounts();
        }
        return bankAccountRepository.getBankAccountsAfter(cursorUtil.decode(cursor));
    }
}
