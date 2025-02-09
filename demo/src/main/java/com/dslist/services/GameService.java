package com.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslist.dto.GameDTO;
import com.dslist.dto.GameMinDTO;
import com.dslist.entities.Game;
import com.dslist.projections.GameMinProjection;
import com.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    @Transactional (readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    //Adicionar tratamento de exceções
    @Transactional (readOnly = true)
    public GameDTO findById(long id){
        Game result = gameRepository.findById(id).get();
        GameDTO resDTO = new GameDTO(result);
        return resDTO;
    }

    @Transactional (readOnly = true)
    public List<GameMinDTO> findByList(long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
