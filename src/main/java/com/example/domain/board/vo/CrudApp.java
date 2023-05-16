package com.example.domain.board.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class CrudApp {

    private final int no;
    private final String title;
    private final String writer;
    private final String password;
    private final String contents;
    private final String id;
    private final Integer hit;
    private final String fileName;
    private final String regDate;

    public static CrudAppBuilder builder() {
        return new CrudAppBuilder();
    }

    public static class CrudAppBuilder {

        private int no;
        private String title;
        private String writer;
        private String password;
        private String contents;
        private String id;
        private Integer hit;
        private String fileName;
        private String date;

        CrudAppBuilder() {
        }

        public CrudAppBuilder no(int no) {
            this.no = no;
            return this;
        }

        public CrudAppBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CrudAppBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public CrudAppBuilder password(String password) {
            this.password = password;
            return this;
        }

        public CrudAppBuilder contents(String contents) {
            this.contents = contents;
            return this;
        }

        public CrudAppBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CrudAppBuilder hit(Integer hit) {
            this.hit = hit;
            return this;
        }

        public CrudAppBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public CrudAppBuilder date(String date) {
            this.date = date;
            return this;
        }

        public CrudApp build() {
            return new CrudApp(no, title, writer, password, contents, id, hit, fileName, date);
        }

        public String toString() {
            return "CrudApp.CrudAppBuilder(no=" + this.no + ", title=" + this.title + ", writer=" + this.writer
                + ", password=" + this.password + ", contents=" + this.contents + ", id=" + this.id + ", hit="
                + this.hit
                + ", fileName=" + this.fileName + ", date=" + this.date + ")";
        }
    }
}
