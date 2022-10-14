package Test;

import Datos.EstudiantesYNotasDAO;
import Modelo.EstudianteYNotas;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        EstudiantesYNotasDAO estudianteDAO = new EstudiantesYNotasDAO();
        
        List<EstudianteYNotas> estudiantes = estudianteDAO.Seleccionar();

        for (EstudianteYNotas estudiante: estudiantes) {

            System.out.println(estudiante);

        }

        //INSERTAR
        EstudianteYNotas estudianteInsertar = new EstudianteYNotas("andres", "octavo", 4.6,
                3.3, 1.7);
        //estudianteDAO.Insertar(estudianteInsertar);

        //Borrar
        EstudianteYNotas estudianteBorrar = new EstudianteYNotas(2);
        //estudianteDAO.Borrar(estudianteBorrar);

        //Actualizar
        EstudianteYNotas estudianteActualizar = new EstudianteYNotas(4, "ete sech", "9-1",
                3.0, 5.0, 4.5);

        //estudianteDAO.Actualizar(estudianteActualizar);


    }

}
