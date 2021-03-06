package com.polarnemo.nuevoproyecto.be;

public class Curso {

    String nombreCurso, idProfesor;
    int nota1,nota2,nota3,nota4,notaFinal, inasistencias, cantClasesTotales;
    double promedioFinal, promedioInasistencias;
    boolean aprobado;

    public Curso() {
        this.nombreCurso = "Curso Navegacion";
        this.idProfesor = "t666";
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
        this.notaFinal = 0;
        this.inasistencias = 0;
        this.cantClasesTotales = 16;
        this.promedioFinal = ((this.nota1+this.nota2+this.nota3+this.nota4)/4+(this.notaFinal*2))/3;
        this.promedioInasistencias = this.inasistencias*100/this.cantClasesTotales;
        this.aprobado = false;
    }

    public Curso(String nombreCurso, String idProfesor, int nota1, int nota2, int nota3, int nota4,
                 int notaFinal, int inasistencias, int cantClasesTotales, boolean aprobado) {
        this.nombreCurso = nombreCurso;
        this.idProfesor = idProfesor;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.notaFinal = notaFinal;
        this.inasistencias = inasistencias;
        this.cantClasesTotales = cantClasesTotales;
        this.promedioFinal = ((this.nota1+this.nota2+this.nota3+this.nota4)/4+(this.notaFinal*2))/3;
        this.promedioInasistencias = this.inasistencias*100/this.cantClasesTotales;
        this.aprobado = aprobado;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public int getNota4() {
        return nota4;
    }

    public void setNota4(int nota4) {
        this.nota4 = nota4;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(int inasistencias) {
        this.inasistencias = inasistencias;
    }

    public int getCantClasesTotales() {
        return cantClasesTotales;
    }

    public void setCantClasesTotales(int cantClasesTotales) {
        this.cantClasesTotales = cantClasesTotales;
    }

    public double getPromedioFinal() {
        return ((this.nota1+this.nota2+this.nota3+this.nota4)/4+(this.notaFinal*2))/3;
    }

    public void setPromedioFinal(double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public double getPromedioInasistencias() {
        return this.inasistencias*100/this.cantClasesTotales;
    }

    public void setPromedioInasistencias(double promedioInasistencias) {
        this.promedioInasistencias = promedioInasistencias;
    }

    public boolean getAprobado() {
        if(((this.nota1+this.nota2+this.nota3+this.nota4)/4+(this.notaFinal*2))/3>=13.0) {
            return true;
        }else{
            return false;
        }
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
}
