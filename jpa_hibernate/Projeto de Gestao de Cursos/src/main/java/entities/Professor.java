package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeCompleto;
    private String matricula;
    private String email;

//    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
//    private Set<Curso> cursos;

    public Professor() {}

    public Professor(String nomeCompleto, String matricula, String email) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.email = email;
//        this.cursos = cursos;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Curso> getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(Set<Curso> cursos) {
//        this.cursos = cursos;
//    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
//                ", cursos=" + cursos +
                '}';
    }
}
