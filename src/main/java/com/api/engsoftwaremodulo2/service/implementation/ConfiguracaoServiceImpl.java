package com.api.engsoftwaremodulo2.service.implementation;

import com.api.engsoftwaremodulo2.service.ConfiguracaoService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ConfiguracaoServiceImpl implements ConfiguracaoService {

    @SuppressWarnings("unchecked")
    @Override
    public String cadastrarEmail(String email) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(
                    Paths.get("src/main/resources/META-INF/user-configuration.json").toFile(), Map.class);

            map.put("email", email);
            mapper.writeValue(Paths.get("src/main/resources/META-INF/user-configuration.json").toFile(), map);
            return email;
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível cadastrar o email, houveram problemas de IO", e);
        }
    }
}
