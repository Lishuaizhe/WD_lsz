package com.lsz.wd_lsz.entiey.gouche_entity;

import java.util.List;

public class LBean_G {

    public String code;
    public String msg;
    public List<Cart> data;

    public class Cart {

        public boolean isChecked;//一级列表是否选中标志位

        public String sellerName;
        public String sellerid;
        public List<Product> list;

        public class Product {
            public boolean isProductChecked;//二级
            public String title;
            public String images;
            public double price;
            public String pid;
            public int pos;
            public int productNum =1;
        }
    }




}
