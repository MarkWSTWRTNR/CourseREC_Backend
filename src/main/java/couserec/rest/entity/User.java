package couserec.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    int id;
    private String cmuitaccountName;
    private String cmuitaccount;
    private String studentId;
    private String prenameId;
    private String prenameTH;
    private String prenameEN;
    private String firstnameTH;
    private String firstnameEN;
    private String lastnameTH;
    private String lastnameEN;
    private String organizationCode;
    private String organizationNameTH;
    private String organizationNameEN;
    private String itaccounttypeId;
    private String itaccounttypeTH;
    private String itaccounttypeEN;

}
