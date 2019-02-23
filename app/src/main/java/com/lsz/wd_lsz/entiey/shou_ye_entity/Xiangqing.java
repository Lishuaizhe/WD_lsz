package com.lsz.wd_lsz.entiey.shou_ye_entity;

public class Xiangqing {


    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * categoryId : 1001008001
         * categoryName : 手机
         * commentNum : 0
         * commodityId : 106
         * commodityName : 三星Galaxy S9+ 6GB+128GB版曲屏手机/指纹识别手机/拍照手机
         * describe : 全视曲面屏。虹膜识别 防尘防水
         * details : <div class="dc-img">
         <div class="dc-img-detail">
         <div class="img-6xx-bg">
         <img src="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/111/246b1e03-9707-45ad-b50d-1fe8c7a30100.jpg" class="J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/111/246b1e03-9707-45ad-b50d-1fe8c7a30100.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/134/4ce22f36-5504-43e4-af6e-831da14abd1a.jpg" class="J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/134/4ce22f36-5504-43e4-af6e-831da14abd1a.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/134/317c8f9e-92fd-4c17-90a7-e4449cf3d879.jpg" class="J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/134/317c8f9e-92fd-4c17-90a7-e4449cf3d879.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/74/0069d983-b4e1-4236-a469-0c96a2c8644c.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/14/9ff21ad0-25dc-4eda-ac8f-16a306220dfe.jpg">
         </div>
         <div class="img-6xx-bg">
         <img src="http://s2.vipstatic.com/img/share/blank.png" class="lazy J-mer-bigImg" data-original="http://a.vpimg2.com/upload/merchandise/pdcvis/137394/2018/0524/191/a1658c17-e33b-4ba3-9653-14c7c1022302.jpg">
         </div>
         </div>
         <div class="dc-img-con">
         </div>
         <div class="dc-txt-con">
         </div>
         </div>
         * picture : http://172.17.8.100/images/small/commodity/sjsm/sj/7/1.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/7/2.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/7/3.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/7/4.jpg,http://172.17.8.100/images/small/commodity/sjsm/sj/7/5.jpg
         * price : 6199
         * saleNum : 0
         * stock : 9999
         * weight : 1
         */

        private String categoryId;
        private String categoryName;
        private int commentNum;
        private int commodityId;
        private String commodityName;
        private String describe;
        private String details;
        private String picture;
        private int price;
        private int saleNum;
        private int stock;
        private int weight;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
