package com.content.mgnt.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {

    private int recId;
    private String loginId;
    private boolean error;
    private List<Error> errorDetails;
}
