package com.monitora.graphql.domain.bank.input;

import lombok.Data;

@Data
public class CreateBankAccountInput {
    String agency;
    String number;
    int age;
}
