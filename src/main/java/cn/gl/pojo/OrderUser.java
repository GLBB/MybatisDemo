package cn.gl.pojo;

// 一对一映射 第一种方法
public class OrderUser extends Order{
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
