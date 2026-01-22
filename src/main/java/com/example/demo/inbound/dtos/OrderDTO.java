package com.example.demo.inbound.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Requisição para criar pedido")
public class OrderDTO {


    @Schema(description = "ID do cliente", example = "123")
    @NotEmpty(message = "clientId is required.")
    private String clientId;

    @Schema(description = "Identificador do Item", example = "TENIS_NNK")
    @NotEmpty(message = "itemRef is required.")
    private String itemRef;

    @Schema(description = "Quantidade do Item", example = "10")
    @Min(value = 1, message = "The minimum quantity is 1.")
    private Integer quantity;

    @Schema(description = "Valor do Produto", example = "123")
    @Min(value = 1, message = "The minimum price is 1.")
    private BigDecimal price;

    @Schema(description = "Data de Pagamento", example = "2026-01-22T12:04:45.276Z")
    @NotNull(message = "paymentDate is required.")
    private LocalDateTime paymentDate;

    @Schema(description = "Tipo de Pagamento", example = "DEBIT_CARD")
    @NotNull(message = "paymentType is required.")
    private String paymentType;
}
