package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Tripulante.
 */
@Entity
@Table(name = "tripulante")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tripulante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "apelidos", length = 255, nullable = false)
    private String apelidos;

    @NotNull
    @Pattern(regexp = "[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]")
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Lob
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @NotNull
    @Column(name = "foto_content_type", nullable = false)
    private String fotoContentType;

    @ManyToMany(mappedBy = "tripulantes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "origen", "destino", "avion", "piloto", "tripulantes" }, allowSetters = true)
    private Set<Vuelo> vuelos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Tripulante id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Tripulante nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelidos() {
        return this.apelidos;
    }

    public Tripulante apelidos(String apelidos) {
        this.setApelidos(apelidos);
        return this;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getDni() {
        return this.dni;
    }

    public Tripulante dni(String dni) {
        this.setDni(dni);
        return this;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public Tripulante direccion(String direccion) {
        this.setDireccion(direccion);
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public Tripulante email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return this.foto;
    }

    public Tripulante foto(byte[] foto) {
        this.setFoto(foto);
        return this;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoContentType() {
        return this.fotoContentType;
    }

    public Tripulante fotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
        return this;
    }

    public void setFotoContentType(String fotoContentType) {
        this.fotoContentType = fotoContentType;
    }

    public Set<Vuelo> getVuelos() {
        return this.vuelos;
    }

    public void setVuelos(Set<Vuelo> vuelos) {
        if (this.vuelos != null) {
            this.vuelos.forEach(i -> i.removeTripulantes(this));
        }
        if (vuelos != null) {
            vuelos.forEach(i -> i.addTripulantes(this));
        }
        this.vuelos = vuelos;
    }

    public Tripulante vuelos(Set<Vuelo> vuelos) {
        this.setVuelos(vuelos);
        return this;
    }

    public Tripulante addVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
        vuelo.getTripulantes().add(this);
        return this;
    }

    public Tripulante removeVuelo(Vuelo vuelo) {
        this.vuelos.remove(vuelo);
        vuelo.getTripulantes().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tripulante)) {
            return false;
        }
        return id != null && id.equals(((Tripulante) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Tripulante{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", apelidos='" + getApelidos() + "'" +
            ", dni='" + getDni() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", email='" + getEmail() + "'" +
            ", foto='" + getFoto() + "'" +
            ", fotoContentType='" + getFotoContentType() + "'" +
            "}";
    }
}
