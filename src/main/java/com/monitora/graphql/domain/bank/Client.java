package com.monitora.graphql.domain.bank;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Setter
@Builder
public class Client {
    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;
//    Client client;
}
