package com.monitora.graphql.domain.bank.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBankAccountInput {
    @NotBlank
    String agency;

    @NotBlank
    String number;

    int age;
}
