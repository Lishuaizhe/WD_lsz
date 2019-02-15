package com.lsz.wd_lsz.entiey;

import java.util.List;

public class Shouye {


    public String msg;
    public String code;
    public DataBean data;


    public static class DataBean {
        public MiaoshaBean miaosha;
        public TuijianBean tuijian;
        public TuijianBean.ListBeanX.BannerBean banner;
        public TuijianBean.ListBeanX.FenleiBean fenlei;


        public static class MiaoshaBean {

            public String name;
            public int time;
            public List<ListBean> list;

            public static class ListBean {

                public double bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public int itemtype;
                public int pid;
                public double price;
                public int pscid;
                public int salenum;
                public int sellerid;
                public String subhead;
                public String title;


            }
        }

        public static class TuijianBean {

            public String name;
            public List<ListBeanX> list;


            public static class ListBeanX {


                public double bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public int itemtype;
                public int pid;
                public double price;
                public int pscid;
                public int salenum;
                public int sellerid;
                public String subhead;
                public String title;


                public static class BannerBean {

                    public int aid;
                    public String createtime;
                    public String icon;
                    public Object productId;
                    public String title;
                    public int type;
                    public String url;

                }

                public static class FenleiBean {

                    public int cid;
                    public String createtime;
                    public String icon;
                    public int ishome;
                    public String name;


                }
            }
        }
    }
}

