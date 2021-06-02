package com.nascimeto.bookstore.service.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();
    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public void addErros(String fieldName, String message) {
        this.erros.add(new FieldMessage(fieldName, message));
    }
}
