package service;

import com.opencsv.exceptions.CsvValidationException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;



import Entities.Tree;
import Repository.TreeRepo;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CsvImportServiceImpl implements CsvImportService {

    private final TreeRepo treeRepository;

    @PostConstruct
    @Transactional
    /*public void importCsvData() throws IOException {
        String csvFilePath = "src/main/resources/les-arbres.csv";  // Chemin vers le fichier CSV
        //String csvFilePath = new ClassPathResource("les-arbres.csv").getFile().getAbsolutePath();
        int batchSize = 1000;
        List<Tree> trees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            reader.readNext(); // Ignorer la première ligne (en-tête)

            while ((line = reader.readNext()) != null) {
                Tree tree = new Tree();
                tree.setSpecies(line[0]);
                tree.setGenus(line[1]);
                tree.setCommonName(line[2]);
                tree.setArrondissement(line[3]);
                tree.setLatitude(Double.parseDouble(line[4]));
                tree.setLongitude(Double.parseDouble(line[5]));
                tree.setHeight(Double.parseDouble(line[6]));
                tree.setDiameter(Double.parseDouble(line[7]));
                // Mappez les autres colonnes ici...

                trees.add(tree);

                // Lorsque la taille du lot atteint la limite, enregistrez les données
                if (trees.size() == batchSize) {
                    treeRepository.saveAll(trees);
                    trees.clear();  // Vider la liste pour le prochain lot
                    System.out.println("données bien inséres!");
                }
            }

            // Enregistrez les éléments restants s'il y en a
            if (!trees.isEmpty()) {
                treeRepository.saveAll(trees);
            }

            System.out.println("Données CSV importées avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }*/

    public void importCsvData() {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/trees.csv"))) {
            reader.readNext(); // Ignorer l'en-tête

            String[] line;
            while ((line = reader.readNext()) != null) {
                Tree tree = new Tree();
                tree.setSpecies(line[0]);
                tree.setGenus(line[1]);
                tree.setCommonName(line[2]);
                tree.setArrondissement(line[3]);
                tree.setLatitude(Double.parseDouble(line[4]));
                tree.setLongitude(Double.parseDouble(line[5]));
                tree.setHeight(Double.parseDouble(line[6]));
                tree.setDiameter(Double.parseDouble(line[7]));

                treeRepository.save(tree); // Enregistrer chaque arbre individuellement
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'import : " + e.getMessage());
        }
    }

}
