package com.smoothstack.common.models;

import javax.persistence.*;

@Entity
@Table(name = "table_name")
public class SampleModel {

    // MySQL generates its own IDs with AUTO_INCREMENT
    // which requires GenerationType.IDENTITY
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sample_column")
    private Integer sampleColumn;

    // Parameterless constructor is for JPA
    protected SampleModel() {}

    // Public constructor is for developer use
    public SampleModel(Integer sampleColumn) {
        this.sampleColumn = sampleColumn;
    }

    @Override
    public String toString() {
        return String.format(
                "SampleColumn{ id=%d, sampleColumn='%d' }",
                id, sampleColumn);
    }

    public Integer getId() {
        return id;
    }

    public Integer getSampleColumn() {
        return sampleColumn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSampleColumn(Integer sampleColumn) {
        this.sampleColumn = sampleColumn;
    }
}
