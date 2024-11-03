package Repository;

import Entities.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepo extends JpaRepository<Tree, Integer> {
}
