package com.squaddois.centralerros.mapper;

import com.squaddois.centralerros.dto.ErrorDTO;
import com.squaddois.centralerros.dto.ErrorReducedDTO;
import com.squaddois.centralerros.entity.Error;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorMapper {

    private ErrorMapper(){
        super();
    }

    public static ErrorDTO toErrorDTO(Error error) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setId(error.getId());
        errorDTO.setDetails(error.getDetails());
        errorDTO.setEnvironment(error.getEnvironment());
        errorDTO.setErrorType(error.getErrorType());
        errorDTO.setHostname(error.getHostname());
        errorDTO.setTitle(error.getTitle());
        errorDTO.setCreatedAt(error.getCreatedAt());
        errorDTO.setArchived(error.getArchived());
        return errorDTO;
    }
    public static Error toError(ErrorDTO errorDTO) {
        Error error = new Error();
        error.setId(errorDTO.getId());
        error.setDetails(errorDTO.getDetails());
        error.setEnvironment(errorDTO.getEnvironment());
        error.setErrorType(errorDTO.getErrorType());
        error.setHostname(errorDTO.getHostname());
        error.setTitle(errorDTO.getTitle());
        error.setCreatedAt(errorDTO.getCreatedAt());
        error.setArchived(errorDTO.getArchived());
        return error;
    }

    public static ErrorReducedDTO toErrorReducedDTO(Error error) {
        ErrorReducedDTO errorReducedDTO = new ErrorReducedDTO();
        errorReducedDTO.setId(error.getId());
        errorReducedDTO.setErrorType(error.getErrorType());
        errorReducedDTO.setTitle(error.getTitle());
        errorReducedDTO.setCreatedAt(error.getCreatedAt());
        return errorReducedDTO;
    }
    public static Error fromReducedDTOtoError(ErrorReducedDTO errorReducedDTO) {
        Error error = new Error();
        error.setId(errorReducedDTO.getId());
        error.setErrorType(errorReducedDTO.getErrorType());
        error.setTitle(errorReducedDTO.getTitle());
        error.setCreatedAt(errorReducedDTO.getCreatedAt());
        return error;
    }

    public static List<ErrorDTO> toListErrorDTO(List<Error> errors) {
        return errors.stream().map(ErrorMapper::toErrorDTO).collect(Collectors.toList());
    }

    public static List<Error> toListErrors(List<ErrorDTO> errorDTOS) {
        return errorDTOS.stream().map(ErrorMapper::toError).collect(Collectors.toList());
    }

    public static List<ErrorReducedDTO> toListErrorReducedDTO(List<Error> errors) {
        return errors.stream().map(ErrorMapper::toErrorReducedDTO).collect(Collectors.toList());
    }

    public static List<Error> fromReducedDTOtoListErrors(List<ErrorReducedDTO> errorDTOS) {
        return errorDTOS.stream().map(ErrorMapper::fromReducedDTOtoError).collect(Collectors.toList());
    }
}
