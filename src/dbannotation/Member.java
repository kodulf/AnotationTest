package dbannotation;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)//set value = 30, if we just set this, it can be use shortcut like this.
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30,constrains = @Constrains(primaryKey = true))
    String handle;

    static int memberCount;

    public String getHandle(){
        return handle;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return handle;
    }
}
