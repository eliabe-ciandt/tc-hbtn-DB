package demo;

import entities.Aluno;
import entities.Curso;
import entities.MaterialCurso;
import entities.Professor;
import models.CursoModel;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class GestaoCursosMain {
    public static void main(String[] args) {
        CursoModel cursoModel = new CursoModel();

        Professor professor = new Professor("Henrique Madureira", "433418a", "henrique@gmail.com");
        Curso curso = new Curso();
        MaterialCurso materialCurso = new MaterialCurso("https://www.com.br", curso);

        curso.setProfessor(professor);
        curso.setNome("Curso de linguas nao estrangeiras");
        curso.setSigla("CLNE");

        Aluno aluno = new Aluno();
        aluno.setEmail("emaildoaluno@gmail.com");
        aluno.setMatricula("asdh12984");
        aluno.setNascimento(new Date(1998));
        aluno.setNomeCompleto("Fernando Rodovalho");

        Aluno aluno2 = new Aluno();
        aluno2.setEmail("emaildoaluno2@gmail.com");
        aluno2.setMatricula("asdh12985");
        aluno2.setNascimento(new Date(1997));
        aluno2.setNomeCompleto("Fernando Luis Rodovalho");

        Aluno aluno3 = new Aluno();
        aluno3.setEmail("emaildoaluno3@gmail.com");
        aluno3.setMatricula("asdh12986");
        aluno3.setNascimento(new Date(1995));
        aluno3.setNomeCompleto("Fernando Gilberto Rodovalho");

        Set<Aluno> alunos = new HashSet<>();
        alunos.add(aluno);
        alunos.add(aluno2);

        curso.setAlunos(alunos);
        curso.getAlunos().add(aluno3);

        cursoModel.create(curso);

    }
}
