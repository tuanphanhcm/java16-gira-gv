package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.repository.GiraRoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Gira Role Service")
@SpringBootTest
class GiraRoleServiceTest {
    @Mock
    private GiraRoleRepository repository;

    @Mock
    private GiraRoleMapper mapper;

    @InjectMocks
    private GiraRoleService service = new GiraRoleServiceImpl();

    @Test
    void shouldMockCorrectly() {
        UUID roleId = UUID.randomUUID();
        GiraRole role = GiraRole.builder()
                .id(roleId)
                .code("TEST_ROLE")
                .description("Role for test")
                .build();

        when(repository.findById(roleId)).thenReturn(Optional.ofNullable(role));

        GiraRole actualRole = repository.findById(roleId).get();

        assertEquals(roleId, actualRole.getId());
        assertEquals("TEST_ROLE", actualRole.getCode());
        assertEquals("Role for test", actualRole.getDescription());
    }

    @DisplayName("should return empty list when no entity found")
    @Test
    void shouldReturnAllEntityCorrectlyWhenNoEntityFound() {
        when(repository.findAll()).thenReturn(List.of());

        List<GiraRoleDTO> roles = service.findAllEntity();

        assertEquals(0, roles.size());
    }

    @DisplayName("shound return correct DTO when there is only one entity found")
    @Test
    void shouldReturnCorrectDTOWhenOneEntityFound() {
        UUID roleId = UUID.randomUUID();
        GiraRole role = GiraRole.builder()
                .id(roleId)
                .code("TEST_ROLE")
                .description("Role for test")
                .build();

        GiraRoleDTO dto = GiraRoleDTO.builder()
                .id(roleId)
                .code("TEST_ROLE")
                .description("Role for test")
                .build();

        when(repository.findAll()).thenReturn(List.of(role));
        when(mapper.toGiraRoleDTO(role)).thenReturn(dto);

        List<GiraRoleDTO> actualRoles = service.findAllEntity();

        assertEquals(1, actualRoles.size());

        GiraRoleDTO actualRole = actualRoles.get(0);

        assertEquals(roleId, actualRole.getId());
        assertEquals("TEST_ROLE", actualRole.getCode());
        assertEquals("Role for test", actualRole.getDescription());
    }
}
