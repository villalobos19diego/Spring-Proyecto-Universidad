package org.villalobos503developer.springproyectouniversidad.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.villalobos503developer.springproyectouniversidad.model.Direccion;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pabellones")
public class Pabellon  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_pabellon",unique = true,nullable = false)
    private String nombre;
    @Column(name = "metros_cuadrados")
    private Double mts2;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @OneToMany(
            mappedBy = "pabellon",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties("pabellon")
    private Set<Aula>aulas;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "depto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;



    @PrePersist
    public void antesDePersistir(){
        this.fechaAlta=LocalDate.now();
    }

    @PreUpdate
    public void antesDeUpdate(){
        this.fechaModificacion=LocalDate.now();
    }

    public Pabellon(Integer id, String nombre, Double mts2, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.mts2 = mts2;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                ", nombre: " + nombre +
                ", mts2: " + mts2 +
                ", fechaAlta: " + fechaAlta +
                ", fechaModificacion: " + fechaModificacion ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return Objects.equals(id, pabellon.id) && Objects.equals(nombre, pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
