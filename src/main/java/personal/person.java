package personal;

public class person{
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Roles role;

    //Constructor
    public person(String name, String lastName, String email, String password, Roles role){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public person() {
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.role = Roles.ADMINISTRATIVO;
    }

    //Se obtiene el nombre de la persona
    public String getName(){
        return this.name;
    }

    //Se obtiene el apellido de la persona
    public String getLastName(){
        return this.lastName;
    }

    //Se obtiene el email de la persona
    public String getEmail(){
        return this.email;
    }

    //Se obtiene la contraseña de la persona
    public String getPassword(){
        return this.password;
    }

    //Se obtiene el rol de tipo Roles de la persona
    public Roles getRole(){
        return this.role;
    }

    //Se establece el nombre
    public void setName(String name){
        this.name = name;
    }

    //Se establce el apellido
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Se establece el email
    public void setEmail(String email){
        this.email = email;
    }

    //Se establce la contraseña
    public void setPassword(String password){
        this.password = password;
    }

    //Se establece el Rol
    public void setRole(Roles role){
        this.role = role;
    }

    //Se imprimen los datos de la persona en una cadena
    @Override
    public String toString(){
        return "Nombre: " + this.name + "\nApellidos: " + this.lastName + "\nEmail: " + this.email + "\nRole: " + this.role;
    }
}

