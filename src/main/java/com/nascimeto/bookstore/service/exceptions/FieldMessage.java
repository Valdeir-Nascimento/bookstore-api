package com.nascimeto.bookstore.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class FieldMessage implements Serializable {
    private String fieldName;
    private String message;

}
