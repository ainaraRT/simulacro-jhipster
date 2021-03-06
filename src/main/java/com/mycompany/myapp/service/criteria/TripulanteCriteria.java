package com.mycompany.myapp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.Tripulante} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.TripulanteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /tripulantes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class TripulanteCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nombre;

    private StringFilter apelidos;

    private StringFilter dni;

    private StringFilter direccion;

    private StringFilter email;

    private LongFilter vueloId;

    private Boolean distinct;

    public TripulanteCriteria() {}

    public TripulanteCriteria(TripulanteCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nombre = other.nombre == null ? null : other.nombre.copy();
        this.apelidos = other.apelidos == null ? null : other.apelidos.copy();
        this.dni = other.dni == null ? null : other.dni.copy();
        this.direccion = other.direccion == null ? null : other.direccion.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.vueloId = other.vueloId == null ? null : other.vueloId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public TripulanteCriteria copy() {
        return new TripulanteCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNombre() {
        return nombre;
    }

    public StringFilter nombre() {
        if (nombre == null) {
            nombre = new StringFilter();
        }
        return nombre;
    }

    public void setNombre(StringFilter nombre) {
        this.nombre = nombre;
    }

    public StringFilter getApelidos() {
        return apelidos;
    }

    public StringFilter apelidos() {
        if (apelidos == null) {
            apelidos = new StringFilter();
        }
        return apelidos;
    }

    public void setApelidos(StringFilter apelidos) {
        this.apelidos = apelidos;
    }

    public StringFilter getDni() {
        return dni;
    }

    public StringFilter dni() {
        if (dni == null) {
            dni = new StringFilter();
        }
        return dni;
    }

    public void setDni(StringFilter dni) {
        this.dni = dni;
    }

    public StringFilter getDireccion() {
        return direccion;
    }

    public StringFilter direccion() {
        if (direccion == null) {
            direccion = new StringFilter();
        }
        return direccion;
    }

    public void setDireccion(StringFilter direccion) {
        this.direccion = direccion;
    }

    public StringFilter getEmail() {
        return email;
    }

    public StringFilter email() {
        if (email == null) {
            email = new StringFilter();
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public LongFilter getVueloId() {
        return vueloId;
    }

    public LongFilter vueloId() {
        if (vueloId == null) {
            vueloId = new LongFilter();
        }
        return vueloId;
    }

    public void setVueloId(LongFilter vueloId) {
        this.vueloId = vueloId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TripulanteCriteria that = (TripulanteCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nombre, that.nombre) &&
            Objects.equals(apelidos, that.apelidos) &&
            Objects.equals(dni, that.dni) &&
            Objects.equals(direccion, that.direccion) &&
            Objects.equals(email, that.email) &&
            Objects.equals(vueloId, that.vueloId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apelidos, dni, direccion, email, vueloId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TripulanteCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nombre != null ? "nombre=" + nombre + ", " : "") +
            (apelidos != null ? "apelidos=" + apelidos + ", " : "") +
            (dni != null ? "dni=" + dni + ", " : "") +
            (direccion != null ? "direccion=" + direccion + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            (vueloId != null ? "vueloId=" + vueloId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
