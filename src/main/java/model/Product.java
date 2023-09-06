package model;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private String id;
    private String name;
    private String price;
    private String amount;
    private String description;
    private String image;
    private String status;
    private String avaliacao;
    private List<String> images;
    private Timestamp inclusionDate;
    private List<String> imagePaths;

    public Product(){
        this.images = new ArrayList<>();
    }

    public Product(String id, String name, String price, String amount, String description, String image, String status, java.sql.Timestamp avaliacao, List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.image = image;
        this.status = status;
        this.images = images;
    }



  public Product(String id, String name, String price, String amount, List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.images = images;
    }




    public Timestamp getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(Timestamp inclusionDate) {
        this.inclusionDate = inclusionDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setInclusionDate(java.sql.Timestamp inclusionDate) {
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
}

