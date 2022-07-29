package cybersoft.javabackend.java16giragv.user.controller;

import cybersoft.javabackend.java16giragv.common.util.ResponseHelper;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserWithRolesDTO;
import cybersoft.javabackend.java16giragv.user.service.GiraUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class GiraUserController {
    @Autowired
    private GiraUserService service;

    @GetMapping("{username}/roles")
    public Object findRoleByUsername(@PathVariable("username") String username) {
        List<GiraUserRolesDTO> userRoles = service.findUserWithRolesByUsername(username);

        if (userRoles == null) {
            return ResponseHelper.getErrorResponse("Username is not existed.", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(userRoles, HttpStatus.OK);
    }

    @GetMapping("{username}/roles-by-join-query")
    public Object findRolesByUsernameUsingJoin(@PathVariable("username") String username) {
        GiraUserWithRolesDTO user = service.findUserWithRolesByUsernameUsingJoin(username);

        if (user == null) {
            return ResponseHelper.getErrorResponse("Username is not existed.", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(user, HttpStatus.OK);
    }

    @PostMapping
    public Object createNewUser(@RequestBody @Valid GiraUserDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);

        GiraUserDTO newUser = service.createNewUser(dto);

        return ResponseHelper.getResponse(newUser, HttpStatus.CREATED);
    }
}
