package cybersoft.javabackend.java16giragv.role.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giragv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraGroupMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraGroup;
import cybersoft.javabackend.java16giragv.role.repository.GiraGroupRepository;

@Service
public class GiraGroupServiceImpl implements GiraGroupService {
	@Autowired
	private GiraGroupRepository repository;

	@Override
	public List<GiraGroupDTO> findAllDto() {
		List<GiraGroup> groups = repository.findAll();
		List<GiraGroupDTO> dtos = groups.stream()
				.map(t -> GiraGroupMapper.INSTANCE.toDTO(t))
				.collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public GiraGroupDTO createNewGroup(GiraGroupDTO dto) {
		GiraGroup group = GiraGroupMapper.INSTANCE.toModel(dto);
		GiraGroup newGroup = repository.save(group);
		return GiraGroupMapper.INSTANCE.toDTO(newGroup);
	}

}
