package com.fatec.lab.eng.subme.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fatec.lab.eng.subme.dto.AuthorizationDTO;
import com.fatec.lab.eng.subme.dto.UserDTO;
import com.fatec.lab.eng.subme.entities.UserEntity;
import com.fatec.lab.eng.subme.repositories.CompanyRepository;
import com.fatec.lab.eng.subme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public ResponseEntity<?> validateLogon(UserDTO userDTO){
        if (userRepository.existsByUsername(userDTO.getUsername())){
            UserEntity user = userRepository.findByUsername(userDTO.getUsername()).get();
            if (userDTO.getPassword().equals(user.getPassword())) return ResponseEntity.ok()
                    .body(generateJWT((companyRepository.findByUserEntity(user)).getId()));
        }
        return ResponseEntity.badRequest().body("Não encontrado");
    }

    public AuthorizationDTO generateJWT(Long id){
        Algorithm algorithmHS = Algorithm.HMAC256("secret");
        Map<String, Object> payload = new HashMap<>();
        payload.put("companyId", id);
        AuthorizationDTO token = new AuthorizationDTO(JWT.create().withPayload(payload).sign(algorithmHS));
        return token;
    }
}
