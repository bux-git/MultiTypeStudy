package com.dqr.www.multitypestudy.home.bean;

public  class LiveBean {
        private int bgResId;
        private String title;
        private String videoPath;


    public LiveBean(int bgResId, String title, String videoPath) {
        this.bgResId = bgResId;
        this.title = title;
        this.videoPath = videoPath;
    }

    public int getBgResId() {
            return bgResId;
        }

        public void setBgResId(int bgResId) {
            this.bgResId = bgResId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }
    }