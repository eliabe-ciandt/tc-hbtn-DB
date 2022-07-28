package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Curso {

    @Id
    private long id;
    private String nome;
    private String sigla;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Alunos_Cursos", joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"))
    private Set<Aluno> alunos;

    public Curso() {}

    public Curso(String nome, String sigla, Professor professor) {
        this.nome = nome;
        this.sigla = sigla;
        this.professor = professor;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", professor=" + professor +
                '}';
    }
}
