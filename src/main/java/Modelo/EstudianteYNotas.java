package Modelo;

import java.text.DecimalFormat;

public class EstudianteYNotas {

    DecimalFormat df = new DecimalFormat("#.0");

    private int idEstudiante;
    private String nombre;
    private String curso;
    private double nota1;
    private double nota2;
    private double nota3;
    private double notaFinal;

    public EstudianteYNotas(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public EstudianteYNotas(int idEstudiante, String nombre, String curso, double nota1, double nota2, double nota3)
            throws Exception {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaFinal = (nota1 + nota2 + nota3) / 3;

        if (nota1 < 1 || nota1 > 5){

            throw new Exception("Nota 1 no puede ser menor que 1 o mayor que 5");

        } else  if (nota2 < 1 || nota2 > 5){

            throw new Exception("Nota 2 no puede ser menor que 1 o mayor que 5");

        } else  if (nota3 < 1 || nota3 > 5){

            throw new Exception("Nota 3 no puede ser menor que 1 o mayor que 5");

        }else  if (notaFinal < 1 || notaFinal > 5){

            throw new Exception("La nota final no puede ser menor que 1 o mayor que 5");

        }
    }

    public EstudianteYNotas(int idEstudiante, String nombre, String curso, double nota1, double nota2,
                            double nota3, double notaFinal) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaFinal = notaFinal;
    }

    public EstudianteYNotas(String nombre, String curso, double nota1, double nota2, double nota3) throws Exception {
        this.nombre = nombre;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaFinal = (nota1 + nota2 + nota3) / 3;

        if (nota1 < 1 || nota1 > 5){

            throw new Exception("Nota 1 no puede ser menor que 1 o mayor que 5");

        } else  if (nota2 < 1 || nota2 > 5){

            throw new Exception("Nota 2 no puede ser menor que 1 o mayor que 5");

        } else  if (nota3 < 1 || nota3 > 5){

            throw new Exception("Nota 3 no puede ser menor que 1 o mayor que 5");

        }else  if (notaFinal < 1 || notaFinal > 5){

            throw new Exception("La nota final no puede ser menor que 1 o mayor que 5");

        }


    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return "Estudiante " + idEstudiante + " {" +
                ", nombre= '" + nombre + '\'' +
                ", curso= '" + curso + '\'' +
                ", nota1= " + nota1 +
                ", nota2= " + nota2 +
                ", nota3= " + nota3 +
                ", notaFinal= " + df.format(notaFinal) +
                '}';
    }
}
