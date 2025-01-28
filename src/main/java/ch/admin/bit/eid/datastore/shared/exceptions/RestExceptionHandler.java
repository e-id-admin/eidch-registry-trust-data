/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.datastore.shared.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(
            final ResourceNotFoundException exception,
            final WebRequest request
    ) {
        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(exception.getMessage());

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(ResourceNotReadyException.class)
    protected ResponseEntity<Object> handleResourceNotReadyException(
            final ResourceNotReadyException exception,
            final WebRequest request
    ) {
        final ApiError apiError = new ApiError(HttpStatus.TOO_EARLY);
        apiError.setMessage(exception.getMessage());

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(final Exception exception, final WebRequest request) {
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        log.error("Detected unhandled exception.", exception);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
