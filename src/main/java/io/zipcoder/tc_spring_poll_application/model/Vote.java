//package io.zipcoder.tc_spring_poll_application.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "vote")
//public class Vote {
//    @Id
//    @GeneratedValue
//    @Column(name = "VOTE_ID")
//     Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "OPTION_ID")
//     Option option;
//
////    public Vote() {}
////    public Vote(Option option) {
////        this.option = option;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Option getOption() {
//        return option;
//    }
//
//    public void setOption(Option option) {
//        this.option = option;
//    }
//}
