package devsaid.com.graphqldevsaid.repository;

import devsaid.com.graphqldevsaid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User,Long> {
}
