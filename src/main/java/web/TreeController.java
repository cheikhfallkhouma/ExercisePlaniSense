package web;

import DTO.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TreeServiceImpl;

import java.util.List;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/trees")
public class TreeController {

    private static TreeServiceImpl treeServiceImpl;

    @GetMapping("/arrondissements")
    public ResponseEntity<List<ArrondissementDTO>> getTreeCountByArrondissement() {
        List<ArrondissementDTO> list = treeServiceImpl.getTreeCountByArrondissement();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/genus")
//    public ResponseEntity<List<GenusDTO>> getTreeCountByGenus() {
//        List<GenusDTO> list = treeServiceImpl.getTreeCountByGenus();
//        return ResponseEntity.ok(list);
//    }

    public List<GenusDTO> getTreeCountByGenus() {
        List<GenusDTO> list = treeServiceImpl.getTreeCountByGenus();
        return list;
    }
}
