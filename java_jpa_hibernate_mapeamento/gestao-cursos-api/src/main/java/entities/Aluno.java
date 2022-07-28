package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeCompleto;
    private String matricula;
    private Date nascimento;
    private String email;
//    @ManyToMany
//    @JoinColumn(name = "curso_id", referencedColumnName = "id")
//    private Set<Curso> cursos;

    public Aluno() {}

    public long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Curso> getCurso() {
//        return cursos;
//    }
//
//    public void setCurso(Set<Curso> cursos) {
//        this.cursos = cursos;
//    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
//                ", curso=" + cursos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;

        Aluno aluno = (Aluno) o;

        if (getId() != aluno.getId()) return false;
        if (getNomeCompleto() != null ? !getNomeCompleto().equals(aluno.getNomeCompleto()) : aluno.getNomeCompleto() != null)
            return false;
        if (getMatricula() != null ? !getMatricula().equals(aluno.getMatricula()) : aluno.getMatricula() != null)
            return false;
        if (getNascimento() != null ? !getNascimento().equals(aluno.getNascimento()) : aluno.getNascimento() != null)
            return false;
        return getEmail() != null ? getEmail().equals(aluno.getEmail()) : aluno.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNomeCompleto() != null ? getNomeCompleto().hashCode() : 0);
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        result = 31 * result + (getNascimento() != null ? getNascimento().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
