/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.membership;

/**
 *
 * @author MNCEDISI
 */
public class MemberShip 
{
    private String name;
    private String surname;
    private String idNo;
    private String gender;
    private String contract;
    private boolean personalTrainer;

    public MemberShip(String name, String surname, String idNo, String gender, String contract, boolean personalTrainer)
    {
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;
        this.gender = gender;
        this.contract = contract;
        this.personalTrainer = personalTrainer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getGender() {
        return gender;
    }

    public String getContract() {
        return contract;
    }

    public boolean isPersonalTrainer() {
        return personalTrainer;
    }

    @Override
    public String toString() 
    {
        String output = getName()+","+getSurname()+","+getIdNo()+","+getGender()+","+getContract()+","+isPersonalTrainer();
        return  output;
    }
     
}
