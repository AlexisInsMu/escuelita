package personal;

public class person{
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Roles role;

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

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public Roles getRole(){
        return this.role;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRole(Roles role){
        this.role = role;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.name + "\nApellidos: " + this.lastName + "\nEmail: " + this.email + "\nRole: " + this.role;
    }
}

