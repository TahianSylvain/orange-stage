package org.acme;
// package org.acme;

// import javax.persistence.Id;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.SequenceGenerator;


// @Entity
// public class OurPsql {
//     private Long id;
//     private String name;

//     @Id
//     @SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
//     @GeneratedValue(generator = "giftSeq")
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }
// }