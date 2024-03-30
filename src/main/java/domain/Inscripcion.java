package domain;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
  private boolean estaAprobada = false;
  private Set<Materia> materiasAInscribirse = new HashSet<>();

  public Inscripcion() {

  }

  public boolean aprobada() {
    return estaAprobada;
  }

  public void validarInscripcion(Alumno alumno) {
    materiasAInscribirse.forEach(materia -> {
      if (!alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas())) {
        throw new RuntimeException("No se puede inscribir a la materia " + materia.getNombre() + " porque no tiene las correlativas aprobadas");
      }
      else {
        estaAprobada = true;
      }
    });

  }
  public void agregarMateriaAInscripcion(Materia materia) {
    materiasAInscribirse.add(materia);
  }

  public Set<Materia> getMateriasAInscribirse() {
    return materiasAInscribirse;
  }
}
