package com.wizeline.techmentoring.explorecali.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TourRatingPk implements Serializable {
    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    public TourRatingPk() {

    }

    public TourRatingPk(Tour tour, Integer customerId) {
        this.tour = tour;
        this.customerId = customerId;
    }
}
