package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "institutions")
@ToString
@Getter
@Setter
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name may not be empty")
    private String name;

    @NotBlank(message = "Description may not be empty")
    @Size(min = 10, max = 80, message = "Description must be between 10 and 80 characters long")
    private String description;
}
