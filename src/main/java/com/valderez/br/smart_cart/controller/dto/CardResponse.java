package com.valderez.br.smart_cart.controller.dto;

import com.valderez.br.smart_cart.domain.CardType;

public record CardResponse(CardType type, Double interestRate) {
}
