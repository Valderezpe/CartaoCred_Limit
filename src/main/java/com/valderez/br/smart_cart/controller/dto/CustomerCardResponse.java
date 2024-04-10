package com.valderez.br.smart_cart.controller.dto;

import java.util.List;

public record CustomerCardResponse(String customer, List<CardResponse> cards) {
}
