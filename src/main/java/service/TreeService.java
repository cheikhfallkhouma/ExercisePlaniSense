package service;

import DTO.ArrondissementDTO;
import DTO.GenusDTO;

import java.util.List;

public interface TreeService {


    List<ArrondissementDTO> getTreeCountByArrondissement();

    List<GenusDTO> getTreeCountByGenus();
}
