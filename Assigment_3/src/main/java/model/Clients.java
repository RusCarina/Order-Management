package model;

public class Clients {
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;

    /**
     * clients
     */
    public Clients(){

    }

    /**
     * @param id i
     * @param name n
     * @param address a
     * @param email e
     * @param age a
     */
    public Clients(int id, String name, String address, String email, int age){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.age=age;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id i
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name n
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return addr
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address a
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email e
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age a
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return str
     */
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age
                + "]";
    }


}
