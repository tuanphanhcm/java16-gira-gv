package cybersoft.javabackend.java16giragv.role.controller;

import cybersoft.javabackend.java16giragv.common.util.ResponseHelper;
import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giragv.role.service.GiraProgramService;
import cybersoft.javabackend.java16giragv.security.authorization.GiraProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/programs")
public class GiraProgramController {
    @Autowired
    private GiraProgramService service;

    @GiraProgram("findAllPrograms")
    @GetMapping
    public Object findAllPrograms() {
        List<GiraProgramDTO> programs = service.findAllPrograms();
        return ResponseHelper.getResponse(programs, HttpStatus.OK);
    }

    @GiraProgram("createNewProgram")
    @PostMapping
    public Object saveProgram(@RequestBody @Valid GiraProgramDTO dto,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
        }

        GiraProgramDTO createdProgram = service.save(dto);

        return ResponseHelper.getResponse(createdProgram, HttpStatus.CREATED);
    }
}
