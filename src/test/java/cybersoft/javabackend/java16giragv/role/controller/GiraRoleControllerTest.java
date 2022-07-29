package cybersoft.javabackend.java16giragv.role.controller;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import cybersoft.javabackend.java16giragv.role.service.GiraRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GiraRoleControllerTest {
    @MockBean
    private GiraRoleService giraRoleService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void mockSecurity() {

    }

    @Test
    public void shouldReturn403WhenNoUser() throws Exception {
        mockMvc.perform(get("/api/v1/roles"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @WithMockUser(value = "admin")
    @Test
    public void shouldReturnEmptyListRoles() throws Exception {
        when(giraRoleService.findAllEntity()).thenReturn(List.of());

        mockMvc.perform(get("/api/v1/roles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @WithMockUser("admin")
    @Test
    public void shouldReturnRoles() throws Exception {
        when(giraRoleService.findAllEntity()).thenReturn(List.of(
                GiraRoleDTO.builder()
                        .id(UUID.fromString("f1ec75f6-1bf2-48ce-a85d-8422cb90d095"))
                        .code("ROLE_READ")
                        .description("Can read information of role module")
                        .build()
        ));

        String returnPayload = "[{\"id\":\"f1ec75f6-1bf2-48ce-a85d-8422cb90d095\",\"code\":\"ROLE_READ\",\"description\":\"Can read information of role module\"}]";
        mockMvc.perform(get("/api/v1/roles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(returnPayload));
    }

    @WithMockUser
    @Test
    public void shouldNotFoundRoleWithUnexistedId() throws Exception {
        String roleId = UUID.randomUUID().toString();
        when(giraRoleService.findById(roleId)).thenReturn(null);

        mockMvc.perform(get("/api/v1/roles/" + roleId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Role is not existed.")));
    }

    @WithMockUser
    @Test
    public void shouldFindRoleSucessfullyWithExistedId() throws Exception {
        String roleId = "f1ec75f6-1bf2-48ce-a85d-8422cb90d095";
        GiraRole role = GiraRole.builder()
                .id(UUID.fromString(roleId))
                .code("ROLE_READ")
                .description("Can read information of role module")
                .build();

        when(giraRoleService.findById(roleId)).thenReturn(role);

        String roleJson = "{\"id\":\"f1ec75f6-1bf2-48ce-a85d-8422cb90d095\",\"version\":0,\"createdAt\":null,\"createdBy\":null,\"lastModifiedAt\":null,\"lastModifiedBy\":null,\"code\":\"ROLE_READ\",\"description\":\"Can read information of role module\"}";

        mockMvc.perform(get("/api/v1/roles/" + roleId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(roleJson)));
    }
}
