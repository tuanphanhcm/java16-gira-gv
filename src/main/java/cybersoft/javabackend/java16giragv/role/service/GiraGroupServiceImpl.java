package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giragv.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraGroupMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraGroup;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.repository.GiraGroupRepository;
import cybersoft.javabackend.java16giragv.role.repository.GiraRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class GiraGroupServiceImpl implements GiraGroupService {
    @Autowired
    private GiraGroupRepository repository;
    @Autowired
    private GiraRoleRepository roleRepository;

    @Override
    public List<GiraGroupDTO> findAllDto() {
        List<GiraGroup> groups = repository.findAll();

        return groups.stream()
                .map(GiraGroupMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public GiraGroupDTO createNewGroup(GiraGroupDTO dto) {
        GiraGroup group = GiraGroupMapper.INSTANCE.toModel(dto);
        GiraGroup newGroup = repository.save(group);
        return GiraGroupMapper.INSTANCE.toDTO(newGroup);
    }

    @Override
    public GiraGroupWithRolesDTO addRole(String groupId, String roleId) {
        GiraGroup group;
        GiraRole role;
        try {
            group = repository.getById(UUID.fromString(groupId));
            role = roleRepository.getById(UUID.fromString(roleId));
        } catch (EntityNotFoundException ex) {
            return null;
        }

        group.addRole(role);
        GiraGroup modifiedGroup = repository.save(group);

        return GiraGroupMapper.INSTANCE.toDtoWithRoles(modifiedGroup);
    }

    @Override
    public GiraGroupWithRolesDTO removeRole(String groupId, String roleId) {
        GiraGroup group;
        GiraRole role;
        try {
            group = repository.getById(UUID.fromString(groupId));
            role = roleRepository.getById(UUID.fromString(roleId));
        } catch (EntityNotFoundException ex) {
            return null;
        }

        group.removeRole(role);
        GiraGroup modifiedGroup = repository.save(group);

        return GiraGroupMapper.INSTANCE.toDtoWithRoles(modifiedGroup);
    }

    @Override
    public GiraGroupWithRolesDTO findById(String groupId) {
        GiraGroup group = repository.findGroupWithRolesByGroupId(UUID.fromString(groupId));
        return GiraGroupMapper.INSTANCE.toDtoWithRoles(group);
    }

}
