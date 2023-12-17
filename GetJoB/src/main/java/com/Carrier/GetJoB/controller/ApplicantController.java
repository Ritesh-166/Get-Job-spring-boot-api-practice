package com.Carrier.GetJoB.controller;
import com.Carrier.GetJoB.model.RequestModel;
import com.Carrier.GetJoB.service.ApplicantService;
import com.Carrier.GetJoB.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/carrier")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping
    public String CreateApplicant(@RequestBody RequestModel requestModel) throws Exception {
        Long id = applicantService.createApplicant(requestModel);
        emailSenderService.sendEmail(requestModel.getEmail(), "Conformation Email of application received",
                "this to conformation that application has been received with email Id: "+ requestModel.getEmail()
                        + " with name: "+ requestModel.getName()+ " and registration ID : "+ id);
        return "New Applicant created";

    }

    @GetMapping("/{id}")
    public RequestModel getApplicantById(@PathVariable("id") Long id) throws Exception {
      return   applicantService.getApplicantById(id);
    }




}
