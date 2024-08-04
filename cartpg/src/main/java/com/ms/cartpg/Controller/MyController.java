package com.ms.cartpg.Controller;


import com.ms.cartpg.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final DatabaseService databaseService;

    public MyController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/execute-procedure")
    public String executeProcedure() {
        databaseService.callCreateAndCopyDataRemote();
        return "Procedure executed successfully";
    }
}
