package com.dqr.www.multitypestudy.home.bean;

public  class ECard {


        private int id;
        private int userId;
        private int iscompany;
        private int isintroduce;
        private int isproduct;
        private int isvideo;
        private int isimg;
        private int iscase;
        private long createdAt;
        private long updatedAt;
        private String icName;
        private int icType;
        private Object icImg;
        private int isshow;
        private int isdefault;
        private int isinfo;
        private int isresume;
        private int isrecruit;
        private int iscompanyinfo;
        private int iscompanyvideo;
        private int iscompanyimg;
        private Object icBgcolor;
        private String nice;
        private String cardId;
        private String uniqueid;
        private String avatar;
        private InfoBean info;
        private ComInfo comInfo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getIscompany() {
            return iscompany;
        }

        public void setIscompany(int iscompany) {
            this.iscompany = iscompany;
        }

        public int getIsintroduce() {
            return isintroduce;
        }

        public void setIsintroduce(int isintroduce) {
            this.isintroduce = isintroduce;
        }

        public int getIsproduct() {
            return isproduct;
        }

        public void setIsproduct(int isproduct) {
            this.isproduct = isproduct;
        }

        public int getIsvideo() {
            return isvideo;
        }

        public void setIsvideo(int isvideo) {
            this.isvideo = isvideo;
        }

        public int getIsimg() {
            return isimg;
        }

        public void setIsimg(int isimg) {
            this.isimg = isimg;
        }

        public int getIscase() {
            return iscase;
        }

        public void setIscase(int iscase) {
            this.iscase = iscase;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getIcName() {
            return icName;
        }

        public void setIcName(String icName) {
            this.icName = icName;
        }

        public int getIcType() {
            return icType;
        }

        public void setIcType(int icType) {
            this.icType = icType;
        }

        public Object getIcImg() {
            return icImg;
        }

        public void setIcImg(Object icImg) {
            this.icImg = icImg;
        }

        public int getIsshow() {
            return isshow;
        }

        public void setIsshow(int isshow) {
            this.isshow = isshow;
        }

        public int getIsdefault() {
            return isdefault;
        }

        public void setIsdefault(int isdefault) {
            this.isdefault = isdefault;
        }

        public int getIsinfo() {
            return isinfo;
        }

        public void setIsinfo(int isinfo) {
            this.isinfo = isinfo;
        }

        public int getIsresume() {
            return isresume;
        }

        public void setIsresume(int isresume) {
            this.isresume = isresume;
        }

        public int getIsrecruit() {
            return isrecruit;
        }

        public void setIsrecruit(int isrecruit) {
            this.isrecruit = isrecruit;
        }

        public int getIscompanyinfo() {
            return iscompanyinfo;
        }

        public void setIscompanyinfo(int iscompanyinfo) {
            this.iscompanyinfo = iscompanyinfo;
        }

        public int getIscompanyvideo() {
            return iscompanyvideo;
        }

        public void setIscompanyvideo(int iscompanyvideo) {
            this.iscompanyvideo = iscompanyvideo;
        }

        public int getIscompanyimg() {
            return iscompanyimg;
        }

        public void setIscompanyimg(int iscompanyimg) {
            this.iscompanyimg = iscompanyimg;
        }

        public Object getIcBgcolor() {
            return icBgcolor;
        }

        public void setIcBgcolor(Object icBgcolor) {
            this.icBgcolor = icBgcolor;
        }

        public String getNice() {
            return nice;
        }

        public void setNice(String nice) {
            this.nice = nice;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getUniqueid() {
            return uniqueid;
        }

        public void setUniqueid(String uniqueid) {
            this.uniqueid = uniqueid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public ComInfo getComInfo() {
            return comInfo;
        }

        public void setComInfo(ComInfo comInfo) {
            this.comInfo = comInfo;
        }

        public static class ComInfo{

            /**
             * id : null
             * userId : null
             * icId : 789
             * surname : hh
             * job :
             * company :
             * companyAddress :
             * companyBusiness :
             * companySize : null
             * contact :
             * phone :
             * qq :
             * wx :
             * email :
             * honour : null
             * description : null
             * need : null
             */

            private Object id;
            private Object userId;
            private int icId;
            private String surname;
            private String job;
            private String company;
            private String companyAddress;
            private String companyBusiness;
            private Object companySize;
            private String contact;
            private String phone;
            private String qq;
            private String wx;
            private String email;
            private Object honour;
            private Object description;
            private Object need;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public int getIcId() {
                return icId;
            }

            public void setIcId(int icId) {
                this.icId = icId;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getCompanyAddress() {
                return companyAddress;
            }

            public void setCompanyAddress(String companyAddress) {
                this.companyAddress = companyAddress;
            }

            public String getCompanyBusiness() {
                return companyBusiness;
            }

            public void setCompanyBusiness(String companyBusiness) {
                this.companyBusiness = companyBusiness;
            }

            public Object getCompanySize() {
                return companySize;
            }

            public void setCompanySize(Object companySize) {
                this.companySize = companySize;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getWx() {
                return wx;
            }

            public void setWx(String wx) {
                this.wx = wx;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getHonour() {
                return honour;
            }

            public void setHonour(Object honour) {
                this.honour = honour;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getNeed() {
                return need;
            }

            public void setNeed(Object need) {
                this.need = need;
            }
        }

        public static class InfoBean {
            /**
             * id : 178
             * userId : 16699
             * icId : 798
             * surname : 李阳
             * origo : 湖南
             * workplace : 长沙
             * high : 160
             * weight : 50
             * mariStatus : 0
             * contact : 13838386831
             * phone : 123456
             * qq : 54287897
             * wx : jdjfjz
             * email : ndjxndj@qq.com
             * description : 新区咯说一下
             */

            private int id;
            private int userId;
            private int icId;
            private String surname;
            private String origo;
            private String workplace;
            private int high;
            private int weight;
            private int mariStatus;
            private String contact;
            private String phone;
            private String qq;
            private String wx;
            private String email;
            private String description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getIcId() {
                return icId;
            }

            public void setIcId(int icId) {
                this.icId = icId;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getOrigo() {
                return origo;
            }

            public void setOrigo(String origo) {
                this.origo = origo;
            }

            public String getWorkplace() {
                return workplace;
            }

            public void setWorkplace(String workplace) {
                this.workplace = workplace;
            }

            public int getHigh() {
                return high;
            }

            public void setHigh(int high) {
                this.high = high;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getMariStatus() {
                return mariStatus;
            }

            public void setMariStatus(int mariStatus) {
                this.mariStatus = mariStatus;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getWx() {
                return wx;
            }

            public void setWx(String wx) {
                this.wx = wx;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }