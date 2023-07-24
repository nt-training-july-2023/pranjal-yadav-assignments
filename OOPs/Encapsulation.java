
class Emplyee{
    String name;
    int empNo;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Emplyee e = new Emplyee();
        e.setName("Pranjal");
        e.setEmpNo(555);
        e.setEmail("pranjal@gmail.com");
        System.out.println(e.getName());
        System.out.println(e.getEmpNo());
        System.out.println(e.getEmail());
    }
}
