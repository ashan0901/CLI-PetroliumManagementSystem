
class employee {
    //employee management attributes
    private int eID;
    private String eName;
    private String ePhoneNumber;
    private String eEmail;
    private int eSalary;

    employee(int eID, String eName, String ePhoneNumber, String eEmail, int eSalary){
        this.eID=eID;
        this.eName=eName;
        this.ePhoneNumber=ePhoneNumber;
        this.eEmail=eEmail;
        this.eSalary=eSalary;
    }

    //getters
    public int getEID(){
        return eID;
    }

    public String getEName(){
        return eName;
    }

    public String getEPhoneNumber(){
        return ePhoneNumber;
    }

    public String getEEmail(){
        return eEmail;
    }

    public int getESalary(){
        return eSalary;
    }

    public String toString(){
        return eID+" "+eName+" "+ePhoneNumber+" "+eEmail+" "+eSalary;
    }


}

