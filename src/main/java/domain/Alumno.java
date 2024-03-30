package domain;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
  private String nombre;
  private String apellido;
  private String email;
  private int legajo;
  private Set<Materia> materiasAprobadas = new HashSet<>();

  private Inscripcion inscripcion;

  public Alumno(String nombre, String apellido, String email, int legajo, Set<Materia> materiasAprobadas) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.legajo = legajo;
    this.materiasAprobadas = materiasAprobadas;
  }

  public Set<Materia> getMateriasAprobadas() {
    return materiasAprobadas;
  }


}
