package com.content.mgnt.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private int recId;
    private String loginId;
    private String sessionId;
    private String jwt;
    private boolean error;
    private List<Error> errorDetails;
}
