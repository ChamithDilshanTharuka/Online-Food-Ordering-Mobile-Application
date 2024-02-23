package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaItem implements Parcelable {
    private int imageResource;
    private String name;
    private String description;
    private double price;

    public PizzaItem(String name, String description, double price, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
    }

    protected PizzaItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        imageResource = in.readInt();
    }

    public static final Creator<PizzaItem> CREATOR = new Creator<PizzaItem>() {
        @Override
        public PizzaItem createFromParcel(Parcel in) {
            return new PizzaItem(in);
        }

        @Override
        public PizzaItem[] newArray(int size) {
            return new PizzaItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeInt(imageResource);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public String toString() {
        return "PizzaItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageResource=" + imageResource +
                '}';
    }

}

