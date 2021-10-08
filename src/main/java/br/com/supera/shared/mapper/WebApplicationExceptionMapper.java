package br.com.supera.shared.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.supera.shared.ErrorResponse;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        int code = exception.getResponse().getStatus();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.code = code;

        if (exception.getMessage() != null)
            errorResponse.message = exception.getMessage();

        return Response.status(code).entity(errorResponse).build();
    }

}

