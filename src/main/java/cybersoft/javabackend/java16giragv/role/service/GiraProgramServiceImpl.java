package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giragv.role.mapper.GiraProgramMapper;
import cybersoft.javabackend.java16giragv.role.model.GiraProgram;
import cybersoft.javabackend.java16giragv.role.repository.GiraProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiraProgramServiceImpl implements GiraProgramService {
    @Autowired
    private GiraProgramRepository repository;

    @Override
    public GiraProgramDTO save(GiraProgramDTO dto) {
        GiraProgram model = GiraProgramMapper.INSTANCE.toModel(dto);

        GiraProgram createdProgram = repository.save(model);

        return GiraProgramMapper.INSTANCE.toDTO(createdProgram);
    }

    @Override
    public List<GiraProgramDTO> findAllPrograms() {
        List<GiraProgram> programs = repository.findAll();
        return programs.stream()
                .map(program -> GiraProgramMapper.INSTANCE.toDTO(program))
                .collect(Collectors.toList());
    }

}
