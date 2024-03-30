import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Alumno;
import domain.Materia;
import domain.Inscripcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

public class InscripcionTest {

  private Materia matematica;
  private Materia fisica;
  private Materia quimica;
  private Materia programacion;
  private Materia algoritmos;
  private Alumno alumno;
  private Alumno alumno2;
  private Inscripcion inscripcion;

  @BeforeEach
  public void setUp() {
    matematica = new Materia("Matematica", new HashSet<>());
    fisica = new Materia("Fisica", Set.of(matematica));
    quimica = new Materia("Quimica", Set.of(fisica));

    programacion = new Materia("Programacion", Set.of(matematica, fisica, quimica));
    algoritmos = new Materia("Algoritmos", Set.of(programacion));

    //Creo un alumno de prueba
    alumno = new Alumno("Juan", "Perez", "nenolz", 1234, Set.of(matematica, fisica, quimica));
    alumno2 = new Alumno("Juan", "Perez", "nenolz", 1234, new HashSet<>());
    inscripcion = new Inscripcion();
  }

  @Test
  public void testInscribirAlumnoConCorrelativasAprobadas() {
    //Creo una inscripcion de prueba
    inscripcion.agregarMateriaAInscripcion(programacion);
    inscripcion.validarInscripcion(alumno);

    assertTrue(inscripcion.aprobada());


}

@Test
public void testInscribirAlumnoSinCorrelativasAprobadas() {
  //Creo una inscripcion de prueba
  inscripcion.agregarMateriaAInscripcion(programacion);
  try {
    inscripcion.validarInscripcion(alumno2);
  } catch (RuntimeException e) {
    assertEquals("No se puede inscribir a la materia Programacion porque no tiene las correlativas aprobadas", e.getMessage());
  }

}

@Test
public void testInscribirAlumnoConCorrelativasAprobadasYNoAprobadas() {
    //Creo una inscripcion de prueba
    inscripcion.agregarMateriaAInscripcion(algoritmos);
  try {
    inscripcion.validarInscripcion(alumno);
  } catch (RuntimeException e) {
    assertEquals("No se puede inscribir a la materia Algoritmos porque no tiene las correlativas aprobadas", e.getMessage());
  }
  }
@Test
 public void testMateriasAInscribirse() {
    inscripcion.agregarMateriaAInscripcion(programacion);
    inscripcion.agregarMateriaAInscripcion(algoritmos);

    Set<Materia> materias = new HashSet<>();
    materias.add(programacion);
    materias.add(algoritmos);

    assertEquals(materias, inscripcion.getMateriasAInscribirse());
  }
@Test
  public void testMateriasAprobadasPorAlumno(){
  Set<Materia> materiasAprobadas = new HashSet<>();
  materiasAprobadas.add(matematica);
  materiasAprobadas.add(fisica);
  materiasAprobadas.add(quimica);
  assertEquals(materiasAprobadas, alumno.getMateriasAprobadas());
  }
}


