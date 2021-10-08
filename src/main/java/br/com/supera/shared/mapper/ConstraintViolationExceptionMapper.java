package br.com.supera.shared.mapper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.supera.shared.ErrorResponse;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        int code = 400;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.code = code;

        String[] errorInfo = exception.getMessage().split(":");

        errorResponse.field = errorInfo[0];
        errorResponse.message = errorInfo[1].replaceFirst(" ", ""); //remove space at start of sentence

        return Response.status(code).entity(errorResponse).build();
    }

}

