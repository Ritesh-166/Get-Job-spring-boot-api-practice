package com.Carrier.GetJoB.service.impl;

import com.Carrier.GetJoB.model.ApplicantModel;
import com.Carrier.GetJoB.model.RequestModel;
import com.Carrier.GetJoB.repository.ApplicantsRepository;
import com.Carrier.GetJoB.service.ApplicantService;
import com.Carrier.GetJoB.utils.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    ApplicantsRepository applicantsRepository;
    @Override
    public Long createApplicant(RequestModel requestModel) throws Exception {
        if(applicantsRepository.existsByEmail(requestModel.getEmail())){
            throw new Exception("The Applicant with Email :"+ requestModel.getEmail()+ " is already registered.");
        }
            ApplicantModel applicantModel=  applicantsRepository.save(ApplicantModel.builder()
                .id(requestModel.getId())
                .name(requestModel.getName())
                .email(requestModel.getEmail())
                .phoneNumber(requestModel.getPhoneNumber())
                .imageData(ImageUtils.stringToBytes(requestModel.getImageData())).build());
        return applicantModel.getId();
    }

    @Override
    public RequestModel getApplicantById(Long id) throws Exception {
        if (applicantsRepository.findById(id).isEmpty()){
            throw new Exception("the Applicant with id: "+ id +" don't exist");
        }
        Optional<ApplicantModel> applicantModel = applicantsRepository.findById(id);
        return RequestModel.builder()
                .id(id)
                .name(applicantModel.get().getName())
                .email(applicantModel.get().getEmail())
                .phoneNumber(applicantModel.get().getPhoneNumber())
                .imageData(ImageUtils.bytesToString(applicantModel.get().getImageData())).build();
    }
}
