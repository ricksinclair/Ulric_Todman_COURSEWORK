package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.ProcessingFee;

public interface ProcessingFeeDao {

    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    void updateProcessingFee(ProcessingFee processingFee);

    ProcessingFee getProcessingFee(String productType);

    void deleteProcessingFee(String productType);

}
