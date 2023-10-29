package cyou.zhaojin.bean;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * @author Zhao JIN
 */
@XmlRootElement
public class Client implements Serializable {
    private String email;
    private String name;
    private String address;
    private String tel;
    private int amount;
    private int duration;
    private String description;
    private double income;
    private double spent;

    public Client() {}

    public Client(String email, String name, String address, String tel, int amount, int duration, String description, double income, double spent) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.amount = amount;
        this.duration = duration;
        this.description = description;
        this.income = income;
        this.spent = spent;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    @XmlElement
    public String getTel() {
        return tel;
    }

    @XmlElement
    public int getAmount() {
        return amount;
    }

    @XmlElement
    public int getDuration() {
        return duration;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @XmlElement
    public double getIncome() {
        return income;
    }

    @XmlElement
    public double getSpent() {
        return spent;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }
}
