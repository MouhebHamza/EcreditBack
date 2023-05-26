package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;
import com.gtiinfo.ecreditproject.Repositories.UserRepository;
import com.gtiinfo.ecreditproject.auth.AuthenticationService;
import com.gtiinfo.ecreditproject.dto.DemandeDTO;
import com.gtiinfo.ecreditproject.dto.UserDTO;
import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DemandesService {
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationService securityService;
    @Autowired
    ModelMapper modelMapper;

    public Demande saveDemande(UserDTO userDto){
        Demande demande = new Demande();
        User user = userRepository.findUserByEmail(userDto.getEmail());
        demande.setUser(user);
        return demandeRepository.save(demande);
    }

    public List<DemandeDTO> getDemandesOfUser(Long userId){
        List<Demande> demandeList= demandeRepository.findDemandeByUserOrderById(userRepository.findUserById(userId));
        List<DemandeDTO> demandeDtoList= new ArrayList<>();
        for (Demande demande :demandeList) {
            demandeDtoList.add(modelMapper.map(demande,DemandeDTO.class));
        }
        return demandeDtoList;
    }

    public List<Demande> getAllDemande(){
        return demandeRepository.findAllByOrderByIdDesc();
    }
}
