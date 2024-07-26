package devsaid.com.graphqldevsaid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "`user`")
@Builder
public class User extends BaseEntity{


    private String username;
    private String mail;


    @Enumerated(EnumType.STRING)
    private Role role;
}
