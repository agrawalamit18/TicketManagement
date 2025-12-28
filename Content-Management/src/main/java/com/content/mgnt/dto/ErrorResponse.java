package com.content.mgnt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private ZonedDateTime timestamp;

    private Integer statusCode;
    private boolean error;
    private List<Error> errorDetails;


    public static ErrorResponse createInstance() {
        return new ErrorResponse();
    }

    public ErrorResponse addMessage(String fieldName, String message) {
        if (this.errorDetails == null) {
            this.errorDetails = new ArrayList<Error>();
        }
        this.errorDetails.add(new Error(fieldName, message));
        return this;
    }
}
