package com.software.fitness.service;

import com.software.fitness.domain.Record;

import java.util.List;

public interface RecordService {

    static void staffInsertRecord(Object genRecord) {
    }

    Integer insertRecord(Record record);

    Integer deleteRecord(Record record);

    List<Record> getAllRecord();

    void staffInsertRecord(Record record);

    Integer memberInsertRecord(Record record);

}