package com.content.mgnt.controller;


import com.content.mgnt.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @GetMapping("/get")
    public String get() {
        return "Test123";
    }

    @PostMapping("/create")
    public String create(@RequestBody String onboardDoctorRequestDto) {
        return "create";
    }

    @PostMapping("/update")
    public String update(@RequestBody String onboardDoctorRequestDto) {
        return "update";
    }

    @GetMapping("/getTicketTypeById/{id}")
    public String getTicketTypeById(@PathVariable Long id) {
        return "getTicketTypeById "  + id;
    }
}
