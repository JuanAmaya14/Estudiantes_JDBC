package Datos;

import Modelo.EstudianteYNotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static Datos.Conexion.close;
import static Datos.Conexion.getConnection;

public class EstudiantesYNotasDAO {

    DecimalFormat df = new DecimalFormat("#.0");

    private static final String SELECT = "SELECT * FROM estudianteynotas;";
    private static final String INSERT = "INSERT INTO estudianteynotas(NombreEstudiante, Curso, Nota1," +
            " Nota2, Nota3, NotaFinal) VALUE(?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM estudianteynotas WHERE idEstudiante = ?";
    private static final String UPDATE = "UPDATE estudianteynotas SET NombreEstudiante = ?, Curso = ?, Nota1 = ?," +
            " Nota2 = ?, Nota3 = ?, NotaFinal = ? WHERE idEstudiante = ?";

    public List<EstudianteYNotas> Seleccionar(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EstudianteYNotas estudianteYNotas = null;
        List<EstudianteYNotas> estudianteYNotasLista = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();

            while(rs.next()){

                int idEstudiante = rs.getInt("idEstudiante");
                String nombreEstudiante = rs.getString("NombreEstudiante");
                String curso = rs.getString("Curso");
                double nota1 = rs.getDouble("Nota1");
                double nota2 = rs.getDouble("Nota2");
                double nota3 = rs.getDouble("Nota3");
                double notaFinal = rs.getDouble("NotaFinal");

                estudianteYNotas = new EstudianteYNotas(idEstudiante, nombreEstudiante, curso, nota1, nota2, nota3, notaFinal);

                estudianteYNotasLista.add(estudianteYNotas);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {

            try {
                close(rs);
                close(pstmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }


        }


        return estudianteYNotasLista;
    }

    public int Insertar(EstudianteYNotas estudianteYNotas){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int insertado = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, estudianteYNotas.getNombre());
            pstmt.setString(2, estudianteYNotas.getCurso());
            pstmt.setDouble(3, estudianteYNotas.getNota1());
            pstmt.setDouble(4, estudianteYNotas.getNota2());
            pstmt.setDouble(5, estudianteYNotas.getNota3());
            pstmt.setDouble(6, estudianteYNotas.getNotaFinal());


            insertado = pstmt.executeUpdate();

            System.out.println("El estudiante fue registrado con exito");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {

            try {
                close(conn);
                close(pstmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return insertado;
    }

    public int Borrar(EstudianteYNotas estudianteYNotas){

        Connection conn = null;
        PreparedStatement pstmt = null;
        int borrado = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(DELETE);

            pstmt.setInt(1, estudianteYNotas.getIdEstudiante());

            borrado = pstmt.executeUpdate();

            System.out.println("El usuario fue borrado con exito");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {

            try {

                close(conn);
                close(pstmt);

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return borrado;
    }

    public int Actualizar (EstudianteYNotas estudianteYNotas){

        Connection conn = null;
        PreparedStatement pstmt = null;
        int actualizado = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, estudianteYNotas.getNombre());
            pstmt.setString(2, estudianteYNotas.getCurso());
            pstmt.setDouble(3, estudianteYNotas.getNota1());
            pstmt.setDouble(4, estudianteYNotas.getNota2());
            pstmt.setDouble(5, estudianteYNotas.getNota3());
            df.format(estudianteYNotas.getNotaFinal());
            pstmt.setDouble(6, estudianteYNotas.getNotaFinal());
            pstmt.setInt(7, estudianteYNotas.getIdEstudiante());

            actualizado = pstmt.executeUpdate();

            System.out.println("Ël estudiante fue actualizado exitosamente");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {

            try {
                close(conn);
                close(pstmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return actualizado;
    }

}
