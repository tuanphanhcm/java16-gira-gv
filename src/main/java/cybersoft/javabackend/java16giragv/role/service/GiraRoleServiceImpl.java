package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.repository.GiraRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiraRoleServiceImpl implements GiraRoleService {
    @Autowired
    private GiraRoleRepository repository;

    @Override
    public List<GiraRoleDTO> findAllEntity() {
        List<GiraRole> roles = repository.findAll();
        return roles.stream()
                .map(GiraRoleMapper.INSTANCE::toGiraRoleDTO)
                .toList();
    }

    @Override
    public GiraRole save(GiraRoleDTO dto) {
        // map dto to entity
        GiraRole role = GiraRoleMapper.INSTANCE.mapToEntity(dto);
        return repository.save(role);
    }

    @Override
    public GiraRole update(UUID id, @Valid GiraRoleDTO dto) {
        Optional<GiraRole> roleOpt = repository.findById(id);

        if (roleOpt.isEmpty()) {
            return null;
        }

        GiraRole currentRole = roleOpt.get();

        // check if role code is changed
        if (!currentRole.getCode().equals(dto.getCode())) {
            // check if new role code is used?
            Optional<GiraRole> existedRole = repository.findByCode(dto.getCode());
            if (existedRole.isPresent())
                return null;

            currentRole.setCode(dto.getCode());
        }

        currentRole.setDescription(dto.getDescription());

        return repository.save(currentRole);
    }

    @Override
    public GiraRole findById(String id) {
        Optional<GiraRole> roleOpt = repository.findById(UUID.fromString(id));

        return roleOpt.orElse(null);
    }

}
