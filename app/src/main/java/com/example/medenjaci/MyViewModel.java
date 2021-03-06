package com.example.medenjaci;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> users;
    MutableLiveData<User> user;
    MutableLiveData<String> nameProduct;
    MutableLiveData<Integer> imageProduct;
    MutableLiveData<String> priceProduct;
    MutableLiveData<String> descriptionProduct;
    MutableLiveData<String> toggle;

    public MyViewModel() {
        nameProduct = new MutableLiveData<>();
        imageProduct = new MutableLiveData<>();
        priceProduct = new MutableLiveData<>();
        descriptionProduct = new MutableLiveData<>();
        user = new MutableLiveData<>();
        toggle = new MutableLiveData<>();

        users = new MutableLiveData<ArrayList<User>>();
        ArrayList<User> list  = new ArrayList<>();
        users.setValue(list);
        embeddedUsers();

    }

    public void setToggle(String t){
        toggle.postValue(t);
    }

    public void setLoggedUser(User u){
        user.postValue(u);
    }

    public void addUser(User u){
        ArrayList<User> list=users.getValue();
        list.add(u);
        users.postValue(list);
    }

    public void embeddedUsers(){
        User user1 = new User("Nedeljko", "Jokic" ,"0644901952","Beograd","nedeljko","admin");
        User user2 = new User("Maja", "Majic","0691234567","Beograd Bulevar Kralja Aleksandra 92","maja","maja123");
        User user3 = new User("Ivan", "Ivanovic","0639876543", "Beograd Ustanicka 92/5","ivan","ivan123");
        addUser(user1);
        addUser(user2);
        addUser(user3);
    }

    public void mySetNameProduct(String name){
        nameProduct.postValue(name);
    }

    public void mySetPriceProduct(String price){
        priceProduct.postValue(price);
    }

    public void mySetImageProduct(int image){
        imageProduct.postValue(image);
    }

    public void mySetDescriptionProduct(String description){
        descriptionProduct.postValue(description);
    }









    public User getLoggedUser(){
        return user.getValue();
    }

    public MutableLiveData<ArrayList<User>> getUsers() {
        return users;
    }

    public void setUsers(MutableLiveData<ArrayList<User>> users) {
        this.users = users;
    }

    public void setAllUsers(ArrayList<User> list){
        this.users.postValue(list);
    }

    public MutableLiveData<String> getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(MutableLiveData<String> nameProduct) {
        this.nameProduct = nameProduct;
    }

    public MutableLiveData<Integer> getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(MutableLiveData<Integer> imageProduct) {
        this.imageProduct = imageProduct;
    }

    public MutableLiveData<String> getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(MutableLiveData<String> priceProduct) {
        this.priceProduct = priceProduct;
    }

    public MutableLiveData<String> getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(MutableLiveData<String> descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }
}
