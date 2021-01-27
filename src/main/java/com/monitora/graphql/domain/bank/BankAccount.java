package com.monitora.graphql.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
public class BankAccount {
    UUID id;
    Currency currency;
    Client client;
    Asset asset;
    ZonedDateTime createdAt;
    LocalDate createdOn;
}
