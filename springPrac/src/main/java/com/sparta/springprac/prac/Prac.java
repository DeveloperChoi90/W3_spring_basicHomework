package com.sparta.springprac.prac;

public class Prac {

    public static void main(String[] args) {

        Course course = new Course();

        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());

        course.setTitle("웹개발의 봄 스프링");
        course.setTutor("남병관");
        course.setDays(35);

        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());

    }

    public static class Course {
        public String title;
        public String tutor;
        public int days;

        // 이렇게 아무런 파라미터가 없는 생성자를 기본생성자 라고 부릅니다.
        public Course() {

        }

        public Course(String title, String tutor, int days) {
            // this 는 "이것" 이죠? 클래스 변수를 가리킵니다.
            this.title = title;
            this.tutor = tutor;
            this.days = days;
        }


        // Getter
        public String getTitle() {
            return title;
        }

        public String getTutor() {
            return tutor;
        }

        public int getDays() {
            return days;
        }

        // Setter

        public void setTitle(String title) {
            this.title = title;
        }

        public void setTutor(String tutor) {
            this.tutor = tutor;
        }

        public void setDays(int days) {
            this.days = days;
        }
    }

    public static class Tutor {
        //멤버변수
        private String name;
        private String bio;

        public Tutor() {
        }

        public Tutor(String name, String bio) {
            this.name = name;
            this.bio = bio;
        }

        // Getter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Setter
        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }
    }

}
