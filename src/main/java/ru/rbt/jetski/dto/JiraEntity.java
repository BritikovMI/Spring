package ru.rbt.jetski.dto;

import java.io.Serializable;

/**
 * Created by misha on 14.08.2018.
 */
public class JiraEntity<I extends Serializable> {
    private I id;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
