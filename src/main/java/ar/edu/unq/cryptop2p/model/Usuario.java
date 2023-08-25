package ar.edu.unq.cryptop2p.model;


import java.io.Serializable;
import jakarta.persistence.*;



@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private Long id;

        @Column(nullable = false)
       private String nombre;

        @Column(nullable = false)
        private String apellido;

        @Column(nullable = false)
        private  String direccion ;

        @Column(nullable = false, unique = true)
        private  String  email;

        @Column
        private String cvu ;

        @Column
        private String direccioncriptoactivo ;

        public Usuario() {
        }


        public Usuario(
                Long id,
                String nombre,
                String apellido,
                String direccion,
                String email,
                String cvu,
                String direccioncriptoactivo ){
        this.id= id;
        this.nombre =nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.cvu = cvu;
        this.direccioncriptoactivo = direccioncriptoactivo;

                }



    }
