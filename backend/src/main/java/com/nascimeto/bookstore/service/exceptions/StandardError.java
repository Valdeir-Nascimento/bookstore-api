package com.nascimeto.bookstore.service.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StandardError {
    private Long timestamp;
    private Integer status;
    private String error;
}
