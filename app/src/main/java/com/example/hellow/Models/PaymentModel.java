package com.example.hellow.Models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentModel {
    private Drawable pay_image;
    private String pay_text;

    public PaymentModel(Drawable pay_image, String pay_text) {
        this.pay_image = pay_image;
        this.pay_text = pay_text;
    }

    public Drawable getPay_image() {
        return pay_image;
    }

    public void setPay_image(Drawable pay_image) {
        this.pay_image = pay_image;
    }

    public String getPay_text() {
        return pay_text;
    }

    public void setPay_text(String pay_text) {
        this.pay_text = pay_text;
    }
}
