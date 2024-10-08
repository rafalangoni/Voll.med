package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.address.Address;

@Table(name = "patients")
@Entity(name = "Patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode (of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Boolean active;

    @Embedded
    private Address address;

    public Patient(PatientRegistrationData data) {
        this.active = true;
        this.email = data.email();
        this.name = data.name();
        this.phone = data.phone();;
        this.cpf = data.cpf();
        this.address = new Address(data.address());
    }
}
