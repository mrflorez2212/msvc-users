package com.marco.springcloud.msvc.users.msvcusers.exceptions;

import com.marco.springcloud.msvc.users.msvcusers.model.dto.ErrorResponse;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException
    extends ResponseEntityExceptionHandler
{

  /**
   * @ExceptionHandler( ConstraintViolationException.class )
   * public ResponseEntity<List> validationErrorHandler( ConstraintViolationException ex )
   * {
   * final List<String> errorsList = new ArrayList<>( ex.getConstraintViolations().size() );
   * <p>
   * ex.getConstraintViolations().forEach( error -> errorsList.add( error.toString() ) );
   * <p>
   * return new ResponseEntity<>( errorsList, HttpStatus.BAD_REQUEST );
   * }
   **/


  @ExceptionHandler( value = NullPointerException.class )
  @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
  public ResponseEntity<ErrorResponse> handleNullPointerException( final NullPointerException nullPointerException )
  {
    return ResponseEntity.internalServerError().body( buildResponse( new Date(), "Doesn't found", nullPointerException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value() ) );
  }


  @ExceptionHandler( value = NotFoundException.class )
  @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
  public ResponseEntity<ErrorResponse> handleNotFoundException( final NotFoundException notFoundException )
  {
    return new ResponseEntity( buildResponse( new Date(), "Doesn't found", notFoundException.getMessage(), HttpStatus.NOT_FOUND.value() ), HttpStatus.NOT_FOUND );
  }


  @ExceptionHandler( value = BadRequestException.class )
  @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
  public ResponseEntity<ErrorResponse> handleBadRequestException( final BadRequestException badRequestException )
  {
    return new ResponseEntity( buildResponse( new Date(), "Doesn't exists", badRequestException.getMessage(), HttpStatus.NOT_FOUND.value() ), HttpStatus.NOT_FOUND );
  }


  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request )
  {

    Map<String, Object> body = new LinkedHashMap<>();
    Map<String, String> message = new LinkedHashMap<>();
    body.put( "timestamp", LocalDate.now() );
    body.put( "status", status.value() );

    Map<String, String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .collect( Collectors.toMap( FieldError::getField, FieldError::getDefaultMessage ) );

    body.put( "errors", errors );

    return new ResponseEntity<>( body, HttpStatus.BAD_REQUEST );
  }


  private ErrorResponse buildResponse( final Date date,
      final String message,
      final String detail,
      final int statusCode )
  {
    return ErrorResponse.builder().date( date ).message( message ).detail( detail ).statusCode( statusCode ).build();
  }
}

