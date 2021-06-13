package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="marks",catalog="gr")
public class Marks {
    private long id;
    private String mark;
    private String date;
    private Studentyi studentyi;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "mark", nullable = true, length = 45)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="NomerZachetki", nullable=false)
    public Studentyi getStudentyi() {
        return this.studentyi;
    }

    public void setStudentyi(Studentyi studentyi) {
        this.studentyi = studentyi;
    }

    @Column(name = "date", nullable = true, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}