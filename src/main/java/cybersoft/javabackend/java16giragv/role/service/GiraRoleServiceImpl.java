package cybersoft.javabackend.java16giragv.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.repository.GiraRoleRepository;

@Service
public class GiraRoleServiceImpl implements GiraRoleService {
	@Autowired
	private GiraRoleRepository repository;

	@Override
	public List<GiraRole> findAllEntity() {
		return repository.findAll();
	}

	@Override
	public GiraRole save(GiraRoleDTO dto) {
		// map dto to entity
		GiraRole role = GiraRoleMapper.INSTANCE.mapToEntity(dto);
		return repository.save(role);
	}

}
