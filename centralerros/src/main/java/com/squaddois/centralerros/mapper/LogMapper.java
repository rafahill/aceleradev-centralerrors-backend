package com.squaddois.centralerros.mapper;

import com.squaddois.centralerros.dto.LogDTO;
import com.squaddois.centralerros.entity.Log;

import java.util.List;
import java.util.stream.Collectors;

public class LogMapper {
    private LogMapper(){
        super();
    }

    public static LogDTO tologDTO(Log log) {
        LogDTO logDTO = new LogDTO();
        logDTO.setId(log.getId());
        logDTO.setIp(log.getIp());
        logDTO.setCreatedAt(log.getCreatedAt());
        logDTO.setDescription(log.getDescription());
        return logDTO;
    }
    public static Log toLog(LogDTO logDTO) {
        Log log = new Log();
        log.setId(logDTO.getId());
        log.setIp(logDTO.getIp());
        log.setCreatedAt(logDTO.getCreatedAt());
        log.setDescription(logDTO.getDescription());
        return log;
    }

    public static List<LogDTO> toListLogDTO(List<Log> logs) {
        return logs.stream().map(LogMapper::tologDTO).collect(Collectors.toList());
    }

    public static List<Log> toListLogs(List<LogDTO> logDTOS) {
        return logDTOS.stream().map(LogMapper::toLog).collect(Collectors.toList());
    }
}
