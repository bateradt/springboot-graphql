package com.monitora.graphql.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Asset {
    UUID id;
}
