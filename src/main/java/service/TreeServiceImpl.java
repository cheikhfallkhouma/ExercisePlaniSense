package service;

import DTO.*;
import Entities.Tree;
import Repository.TreeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.TreeService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TreeServiceImpl implements TreeService {

    private final TreeRepo treeRepo;

    public List<ArrondissementDTO> getTreeCountByArrondissement() {
        return treeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Tree::getArrondissement, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new ArrondissementDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(ArrondissementDTO::getArrondissement))
                .collect(Collectors.toList());
    }

    public List<GenusDTO> getTreeCountByGenus() {
        return treeRepo.findAll().stream()
                .collect(Collectors.groupingBy(Tree::getGenus, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new GenusDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(GenusDTO::getGenus))
                .collect(Collectors.toList());
    }
}
