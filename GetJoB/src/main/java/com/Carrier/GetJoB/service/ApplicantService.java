package com.Carrier.GetJoB.service;

import com.Carrier.GetJoB.model.RequestModel;

public interface ApplicantService {
    public Long createApplicant(RequestModel requestModel) throws Exception;
    public RequestModel getApplicantById(Long id) throws Exception;

}
