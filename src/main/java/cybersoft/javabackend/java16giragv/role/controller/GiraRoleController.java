package cybersoft.javabackend.java16giragv.role.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16giragv.common.util.ResponseHelper;
import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.service.GiraRoleService;

@RestController
@RequestMapping("api/v1/roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object findAllRoles() {
		List<GiraRoleDTO> roles = service.findAllEntity();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/{role-id}")
	public Object findRoleById (@PathVariable("role-id") String id) {
		GiraRole role = service.findById(id);
		
		if (role == null) {
			return ResponseHelper.getErrorResponse("Role is not existed.", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseHelper.getResponse(role, HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleDTO dto, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors()
					.stream().map(t -> t.getDefaultMessage()).collect(Collectors.toList())
					, HttpStatus.BAD_REQUEST);
		}
		
		GiraRole role = service.save(dto);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
	
	@PutMapping("/{role-id}")
	public Object updateRole(@PathVariable("role-id") String id, 
							@RequestBody @Valid GiraRoleDTO dto,
							BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		GiraRole updatedRole = service.update(UUID.fromString(id), dto);
		
		if (updatedRole == null) {
			return ResponseHelper.getErrorResponse("Role code is used.", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseHelper.getResponse(updatedRole, HttpStatus.OK);
	}
}
