package com.squaddois.centralerros.service;


import com.squaddois.centralerros.dto.LogDTO;
import com.squaddois.centralerros.mapper.LogMapper;
import com.squaddois.centralerros.entity.Log;
import com.squaddois.centralerros.repository.LogRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogDTO findLog(Long id) {
        return LogMapper.tologDTO(logRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Log not found", Log.class.getName())));
    }

    public List<LogDTO> findAllLogs() {
        return LogMapper.toListLogDTO(logRepository.findAll());
    }

    public void saveLog(LogDTO logDTO) {
        logRepository.save(LogMapper.toLog(logDTO));
    }

    public void updateLog(LogDTO logDTO) {
        logRepository.save(LogMapper.toLog(logDTO));
    }

    public void deleteLog(Long id) {
        LogDTO logDTO = findLog(id);
        logRepository.delete(LogMapper.toLog(logDTO));
    }
}
