package com.content.mgnt.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String errorCode;
    private String errorMessage;
}
