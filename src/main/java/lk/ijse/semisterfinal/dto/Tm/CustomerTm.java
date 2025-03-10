package lk.ijse.semisterfinal.dto.Tm;

import lombok.Getter;

@Getter
public class CustomerTm {
    private String id;
    private String name;
    private String address;
    private String tel;
    private String payment;

    public CustomerTm(String txtCustId, String txtCustName, String txtCustAddress, String txtCustMobile, String txtCustPayment) {
        this.id = txtCustId;
        this.name = txtCustName;
        this.address = txtCustAddress;
        this.tel = txtCustMobile;
        this.payment = txtCustPayment;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CustomerTm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
