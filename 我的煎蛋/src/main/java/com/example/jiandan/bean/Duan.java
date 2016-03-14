package com.example.jiandan.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/24.
 */
public class Duan {
    private String status;
    private int current_page;
    private int total_comments;
    private int page_count;
    private int count;
    private ArrayList<ItemsContent> comments;

    @Override
    public String toString() {
        return "Duan{" +
                "status='" + status + '\'' +
                ", current_page=" + current_page +
                ", total_comments=" + total_comments +
                ", page_count=" + page_count +
                ", count=" + count +
                ", comments=" + comments +
                '}';
    }

    public class ItemsContent{
               private String comment_author;
               private String comment_date;
               private String comment_date_gmt;
                private String comment_content;
                private int vote_positive;
                private int vote_negative;

        @Override
        public String toString() {
            return "ItemsContent{" +
                    "comment_author='" + comment_author + '\'' +
                    ", comment_date='" + comment_date + '\'' +
                    ", comment_date_gmt='" + comment_date_gmt + '\'' +
                    ", comment_content='" + comment_content + '\'' +
                    ", vote_positive=" + vote_positive +
                    ", vote_negative=" + vote_negative +
                    '}';
        }

        public String getComment_author() {
            return comment_author;
        }

        public void setComment_author(String comment_author) {
            this.comment_author = comment_author;
        }

        public String getComment_date() {
            return comment_date;
        }

        public void setComment_date(String comment_date) {
            this.comment_date = comment_date;
        }

        public String getComment_date_gmt() {
            return comment_date_gmt;
        }

        public void setComment_date_gmt(String comment_date_gmt) {
            this.comment_date_gmt = comment_date_gmt;
        }

        public String getComment_content() {
            return comment_content;
        }

        public void setComment_content(String comment_content) {
            this.comment_content = comment_content;
        }

        public int getVote_positive() {
            return vote_positive;
        }

        public void setVote_positive(int vote_positive) {
            this.vote_positive = vote_positive;
        }

        public int getVote_negative() {
            return vote_negative;
        }

        public void setVote_negative(int vote_negative) {
            this.vote_negative = vote_negative;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(int total_comments) {
        this.total_comments = total_comments;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<ItemsContent> getComments() {
        return comments;
    }

    public void setComments(ArrayList<ItemsContent> comments) {
        this.comments = comments;
    }
}
