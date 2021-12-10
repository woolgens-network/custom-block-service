package net.woolgens.custom.block.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Provider
public class CustomBlockExceptionMapper implements ExceptionMapper<CustomBlockException> {

    @Override
    public Response toResponse(CustomBlockException exception) {
        return Response.status(exception.getStatus()).entity(new CustomBlockExceptionResponse(exception.getStatus(), exception.getMessage())).build();
    }
}
