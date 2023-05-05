package com.notify.NotifyEgerton.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(min = 5, message = "*Your title must have at least 5 characters")
    @NotEmpty(message = "*Please provide title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_community")
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_group")
    private Groups group;

}
